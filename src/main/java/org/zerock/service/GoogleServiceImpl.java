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
		System.out.println("�룎�븘媛�?");
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

	        // 占쎌뒄筌ｏ옙 占쎈솁占쎌뵬沃섎챸苑� 占쎄퐬占쎌젟
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	        StringBuilder sb = new StringBuilder();
	        sb.append("grant_type=authorization_code");
	        sb.append("&client_id=").append(clientId); // 占쎄깻占쎌뵬占쎌뵠占쎈섧占쎈뱜 ID
	        sb.append("&client_secret=").append(clientSecret); // 占쎄깻占쎌뵬占쎌뵠占쎈섧占쎈뱜 Secret
	        sb.append("&redirect_uri=http://localhost:8080/google/userinfo"); // �뵳�됰뼄占쎌뵠占쎌젂占쎈뱜 URI
	        sb.append("&code=").append(authorizeCode); // 占쎄텢占쎌뒠占쎌쁽 占쎌뵥筌앾옙 �굜遺얜굡
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

	            // JSON 占쎈솁占쎈뼓
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

            // JSON 占쎈솁占쎈뼓
            JsonElement element = JsonParser.parseString(result);
            JsonObject jsonObject = element.getAsJsonObject();

            // 占쎄텢占쎌뒠占쎌쁽 占쎌젟癰귨옙 占쏙옙占쎌삢
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

        // DTO 占쎄문占쎄쉐
        //GoogleMemberDTO googledto = new GoogleMemberDTO(googleId, name, email);
        MemberDTO memberdto = new MemberDTO();
        
        memberdto.setId(googleId); // Google ID�몴占� 占쏙옙占쎌삢
        memberdto.setUname(name); // 占쎄텢占쎌뒠占쎌쁽 占쎌뵠�뵳占� 占쏙옙占쎌삢
        memberdto.setEmail(email); // 占쎌뵠筌롫뗄�뵬 占쏙옙占쎌삢
        memberdto.setKind("구글"); // 占쎄텢占쎌뒠占쎌쁽 �넫�굝履� (�뤃�덌옙) 占쏙옙占쎌삢
        // Mapper�몴占� 占쎈꽰占쎈퉸 DB占쎈퓠占쎄퐣 google_id嚥∽옙 占쎄텢占쎌뒠占쎌쁽 鈺곌퀬�돳
        MemberDTO existingUser = mapper.findUserByGoogleId(googleId);

        if (existingUser == null) {
            // google_id揶쏉옙 占쎈씨占쎌몵筌롳옙 占쎄퉱 占쎄텢占쎌뒠占쎌쁽 占쎈쾻嚥∽옙
            mapper.insertUser(memberdto);
            return true; // 占쎄퉱 占쎄텢占쎌뒠占쎌쁽 占쎈쾻嚥∽옙 占쎌끏�뙴占�
        } else {
            // google_id揶쏉옙 鈺곕똻�삺占쎈릭筌롳옙 占쎌뵠筌롫뗄�뵬�⑨옙 占쎌뵠�뵳袁⑹뱽 �뜮袁㏉꺍
            if (existingUser.getId().equals(googleId)) {
                // 占쎌뵠�뵳袁㏓궢 占쎌뵠筌롫뗄�뵬占쎌뵠 占쎌뵬燁살꼹釉�筌롳옙 嚥≪뮄�젃占쎌뵥 占쎄쉐�⑨옙
                return true; // 嚥≪뮄�젃占쎌뵥 占쎄쉐�⑨옙
            } else {
                // 占쎌뵠筌롫뗄�뵬占쎌뵠占쎄돌 占쎌뵠�뵳袁⑹뵠 占쎌뵬燁살꼹釉�筌욑옙 占쎈륫占쎌몵筌롳옙 嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭
                return false; // 嚥≪뮄�젃占쎌뵥 占쎈뼄占쎈솭
            }
        }
    }
    
    @Override
    public MemberDTO findUserByGoogleId(String googleId) {
        // DB占쎈퓠占쎄퐣 googleId嚥∽옙 占쎄텢占쎌뒠占쎌쁽 鈺곌퀬�돳
        return mapper.findUserByGoogleId(googleId);
    }
}