package org.zerock.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zerock.dto.MemberDTO;
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

    public String getAuthorizationUrl() {
        return String.format(
                "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=%s&redirect_uri=%s&state=%s",
                CLIENT_ID, REDIRECT_URI, STATE
        );
    }

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


    public MemberDTO getUserInfo(String accessToken) {
        String userInfoUrl = "https://openapi.naver.com/v1/nid/me";
        RestTemplate restTemplate = new RestTemplate();
        int idcheck = 0;
        
        try {
            String response = restTemplate.getForObject(userInfoUrl + "?access_token=" + accessToken, String.class);
            System.out.println("Naver API response: " + response);

            MemberDTO userInfo = parseNaverResponse(response);
            System.out.println("Parsed NaverLoginDTO: " + userInfo);
            
            boolean result = processNaverLogin(userInfo);
            System.out.println("Process result: " + result);

            return userInfo;
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve user info", e);
        }
    }

    public MemberDTO parseNaverResponse(String jsonResponse) {
        try {
            JsonNode rootNode = new ObjectMapper().readTree(jsonResponse);
            JsonNode responseNode = rootNode.get("response");

            if (responseNode == null) {
                throw new RuntimeException("Invalid response: 'response' node is missing.");
            }

            String birthYear = responseNode.path("birthyear").asText(null);
            String birthDay = responseNode.path("birthday").asText(null);
            
            if (birthYear != null && birthDay != null) {
                // 날짜 형식으로 문자열 결합 (예: "1990-12-15")
                String birthDateStr = birthYear + "-" + birthDay;

                try {
                    // SimpleDateFormat을 사용하여 문자열을 Date로 변환
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthDate = dateFormat.parse(birthDateStr);
                    
                    MemberDTO dto = new MemberDTO();
                    
                    dto.setId(responseNode.path("id").asText(null));
                    dto.setEmail(responseNode.path("email").asText(null));
                    dto.setPhone_num(responseNode.path("mobile").asText(null));
                    dto.setUname(responseNode.path("name").asText(null));
                    return dto;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
           
        } catch (Exception e) {
            throw new RuntimeException("Error parsing Naver API response", e);
        }
		return null;
    }

    // 기존 사용자가 있는지 확인
    public boolean processNaverLogin(MemberDTO loginfo) {
        try {
            if (loginfo.getId() == null || loginfo.getEmail() == null) {
                throw new RuntimeException("ID or Email is null. ID: " + loginfo.getId() + ", Email: " + loginfo.getEmail());
            }

            MemberDTO neverid = naverLoginMapper.selectNaverMemberById(loginfo.getId());
            System.out.println("네이버 아이디" + neverid);

            if (neverid == null) {
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
