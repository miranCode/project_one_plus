package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zerock.dto.NaverLoginDTO;
import org.zerock.mapper.NaverLoginMapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NaverLoginService {
    private final String CLIENT_ID = "TICibqjysaSLJr8S4yhO";
    private final String CLIENT_SECRET = "RQC6fBVZCl";
    private final String REDIRECT_URI = "http://localhost:8080/naver/callback";
    private final String STATE = "RANDOM_STATE_STRING";

    @Autowired
    private NaverLoginMapper naverLoginMapper;

    // 네이버 로그인 URL 생성
    public String getAuthorizationUrl() {
        return String.format(
                "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=%s&redirect_uri=%s&state=%s",
                CLIENT_ID, REDIRECT_URI, STATE
        );
    }

    // 액세스 토큰 발급
    public String getAccessToken(String code, String state) {
        String tokenUrl = String.format(
                "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id=%s&client_secret=%s&code=%s&state=%s",
                CLIENT_ID, CLIENT_SECRET, code, state
        );
        RestTemplate restTemplate = new RestTemplate();

        try {
            String response = restTemplate.getForObject(tokenUrl, String.class);
            JsonNode jsonNode = new ObjectMapper().readTree(response);
            return jsonNode.get("access_token").asText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get access token", e);
        }
    }

    // 사용자 정보 조회
    public NaverLoginDTO getUserInfo(String accessToken) {
        String userInfoUrl = "https://openapi.naver.com/v1/nid/me";
        RestTemplate restTemplate = new RestTemplate();

        try {
            String response = restTemplate.getForObject(userInfoUrl + "?access_token=" + accessToken, String.class);
            System.out.println("Naver API response: " + response);

            // 응답을 파싱하여 DTO 생성
            NaverLoginDTO userInfo = parseNaverResponse(response);
            System.out.println("Parsed NaverLoginDTO: " + userInfo);

            // DTO를 이용해 로그인 프로세스 처리
            boolean result = processNaverLogin(userInfo);
            System.out.println("Process result: " + result);

            return userInfo;
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve user info", e);
        }
    }

    // 네이버 API 응답 파싱
    private NaverLoginDTO parseNaverResponse(String jsonResponse) {
        try {
            JsonNode rootNode = new ObjectMapper().readTree(jsonResponse);
            JsonNode responseNode = rootNode.get("response");

            if (responseNode == null) {
                throw new RuntimeException("Invalid response: 'response' node is missing.");
            }

            NaverLoginDTO dto = new NaverLoginDTO();
            dto.setId(responseNode.path("id").asText(null));
            dto.setEmail(responseNode.path("email").asText(null));
            dto.setPhoneNum(responseNode.path("mobile").asText(null));
            dto.setName(responseNode.path("name").asText(null));
            dto.setBirthday(responseNode.path("birthday").asText(null));
            dto.setBirthyear(responseNode.path("birthyear").asText(null));
            dto.setRegidate(responseNode.path("regidate").asText(null));

            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Error parsing Naver API response", e);
        }
    }

    public boolean processNaverLogin(NaverLoginDTO loginfo) {
        try {
            if (loginfo.getId() == null || loginfo.getEmail() == null) {
                throw new RuntimeException("ID or Email is null. ID: " + loginfo.getId() + ", Email: " + loginfo.getEmail());
            }

            NaverLoginDTO existingUser = naverLoginMapper.selectNaverMemberById(loginfo.getId());

            if (existingUser == null) {
                naverLoginMapper.insertNaverMember(loginfo);
                System.out.println("Inserted new user: " + loginfo);
            } else {
                naverLoginMapper.updateNaverMember(loginfo);
                System.out.println("Updated existing user: " + loginfo);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
