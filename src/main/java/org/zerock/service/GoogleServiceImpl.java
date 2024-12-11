package org.zerock.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.dto.GoogleMemberDTO;
import org.zerock.dto.GoogleOAuthDTO;
import org.zerock.mapper.GoogleMapper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//push
@Service
public class GoogleServiceImpl implements GoogleService {

	@Autowired
	private GoogleMapper mapper;
	
	@Override
	public String getAccessToken(String authorizeCode) {
	    String accessToken = null;
	    String refreshToken = null;
	    String reqURL = "https://oauth2.googleapis.com/token";
	    
	    GoogleOAuthDTO credentials = mapper.getGoogleCredentials();
        String clientId = credentials.getClientId();
        String clientSecret = credentials.getClientSecret();
	    
	    try {
	        URL url = new URL(reqURL);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("POST");
	        conn.setDoOutput(true);
	        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

	        // 요청 파라미터 설정
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	        StringBuilder sb = new StringBuilder();
	        sb.append("grant_type=authorization_code");
	        sb.append("&client_id=").append(clientId); // 클라이언트 ID
	        sb.append("&client_secret=").append(clientSecret); // 클라이언트 Secret
	        sb.append("&redirect_uri=http://localhost:8080/google/userinfo"); // 리다이렉트 URI
	        sb.append("&code=").append(authorizeCode); // 사용자 인증 코드
	        bw.write(sb.toString());
	        bw.flush();

	        int responseCode = conn.getResponseCode();
	        System.out.println("Response Code: " + responseCode);

	        if (responseCode == HttpURLConnection.HTTP_OK) {
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line;
	            String result = "";
	            while ((line = br.readLine()) != null) {
	                result += line;
	            }
	            System.out.println("Response Body: " + result);

	            // JSON 파싱
	            JsonElement element = JsonParser.parseString(result);
	            if (element.getAsJsonObject().has("access_token")) {
	                accessToken = element.getAsJsonObject().get("access_token").getAsString();
	            }
	            if (element.getAsJsonObject().has("refresh_token")) {
	                refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
	            }

	            System.out.println("Access Token: " + accessToken);
	            System.out.println("Refresh Token: " + refreshToken);

	            br.close();
	        } else {
	            System.out.println("Error Response Code: " + responseCode);
	        }
	        bw.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    if (accessToken == null) {
	        throw new RuntimeException("Access Token is null. Check the API response.");
	    }
	    return accessToken;
	}

    @Override
    public HashMap<String, Object> getUserInfo(String accessToken) {
        HashMap<String, Object> userInfo = new HashMap<>();
        String reqURL = "https://www.googleapis.com/oauth2/v2/userinfo";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String result = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            // JSON 파싱
            JsonElement element = JsonParser.parseString(result);
            JsonObject jsonObject = element.getAsJsonObject();

            // 사용자 정보 저장
            userInfo.put("id", jsonObject.has("id") ? jsonObject.get("id").getAsString() : "Unknown");
            userInfo.put("email", jsonObject.has("email") ? jsonObject.get("email").getAsString() : "Not Provided");
            userInfo.put("name", jsonObject.has("name") ? jsonObject.get("name").getAsString() : "Unknown");
            userInfo.put("picture", jsonObject.has("picture") ? jsonObject.get("picture").getAsString() : "No Picture");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    public boolean saveUser(HashMap<String, Object> userInfo) {
        String googleId = (String) userInfo.get("id");
        String name = (String) userInfo.get("name");
        String email = (String) userInfo.get("email");

        // DTO 생성
        GoogleMemberDTO googledto = new GoogleMemberDTO(googleId, name, email);

        // Mapper를 통해 DB에서 google_id로 사용자 조회
        GoogleMemberDTO existingUser = mapper.findUserByGoogleId(googleId);

        if (existingUser == null) {
            // google_id가 없으면 새 사용자 등록
            mapper.insertUser(googledto);
            return true; // 새 사용자 등록 완료
        } else {
            // google_id가 존재하면 이메일과 이름을 비교
            if (existingUser.getEmail().equals(email) && existingUser.getName().equals(name)) {
                // 이름과 이메일이 일치하면 로그인 성공
                return true; // 로그인 성공
            } else {
                // 이메일이나 이름이 일치하지 않으면 로그인 실패
                return false; // 로그인 실패
            }
        }
    }
    
    @Override
    public GoogleMemberDTO findUserByGoogleId(String googleId) {
        // DB에서 googleId로 사용자 조회
        return mapper.findUserByGoogleId(googleId);
    }
}