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
import org.zerock.dto.MemberDTO;
import org.zerock.mapper.GoogleMapper;
import org.zerock.mapper.MemberMapper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//push
@Service
public class GoogleServiceImpl implements GoogleService {

	@Autowired
	private GoogleMapper mapper;
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public String getAccessToken(String authorizeCode) {
		System.out.println("돌아감?");
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

	        // �슂泥� �뙆�씪誘명꽣 �꽕�젙
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	        StringBuilder sb = new StringBuilder();
	        sb.append("grant_type=authorization_code");
	        sb.append("&client_id=").append(clientId); // �겢�씪�씠�뼵�듃 ID
	        sb.append("&client_secret=").append(clientSecret); // �겢�씪�씠�뼵�듃 Secret
	        sb.append("&redirect_uri=http://localhost:8080/google/userinfo"); // 由щ떎�씠�젆�듃 URI
	        sb.append("&code=").append(authorizeCode); // �궗�슜�옄 �씤利� 肄붾뱶
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

	            // JSON �뙆�떛
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

            // JSON �뙆�떛
            JsonElement element = JsonParser.parseString(result);
            JsonObject jsonObject = element.getAsJsonObject();

            // �궗�슜�옄 �젙蹂� ���옣
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

        // DTO �깮�꽦
        //GoogleMemberDTO googledto = new GoogleMemberDTO(googleId, name, email);
        MemberDTO memberdto = new MemberDTO();
        
        memberdto.setId(googleId); // Google ID瑜� ���옣
        memberdto.setUname(name); // �궗�슜�옄 �씠由� ���옣
        memberdto.setEmail(email); // �씠硫붿씪 ���옣
        memberdto.setKind("援ш�"); // �궗�슜�옄 醫낅쪟 (援ш�) ���옣
        // Mapper瑜� �넻�빐 DB�뿉�꽌 google_id濡� �궗�슜�옄 議고쉶
        MemberDTO existingUser = mapper.findUserByGoogleId(googleId);

        if (existingUser == null) {
            // google_id媛� �뾾�쑝硫� �깉 �궗�슜�옄 �벑濡�
            mapper.insertUser(memberdto);
            return true; // �깉 �궗�슜�옄 �벑濡� �셿猷�
        } else {
            // google_id媛� 議댁옱�븯硫� �씠硫붿씪怨� �씠由꾩쓣 鍮꾧탳
            if (existingUser.getEmail().equals(email) && existingUser.getUname().equals(name)) {
                // �씠由꾧낵 �씠硫붿씪�씠 �씪移섑븯硫� 濡쒓렇�씤 �꽦怨�
                return true; // 濡쒓렇�씤 �꽦怨�
            } else {
                // �씠硫붿씪�씠�굹 �씠由꾩씠 �씪移섑븯吏� �븡�쑝硫� 濡쒓렇�씤 �떎�뙣
                return false; // 濡쒓렇�씤 �떎�뙣
            }
        }
    }
    
    @Override
    public MemberDTO findUserByGoogleId(String googleId) {
        // DB�뿉�꽌 googleId濡� �궗�슜�옄 議고쉶
        return mapper.findUserByGoogleId(googleId);
    }
}