package org.zerock.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class KakaoServiceImpl implements KakaoService {

    @Override
    public String getAccessToken(String authorize_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("charset", "utf-8");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=558503d359c98d21606dc6d90c6795aa"); // ������ �߱޹��� key
            sb.append("&redirect_uri=http://localhost:8080/auth/kakao/callback"); // ������ ������ �ּ�
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);
            JsonElement element = JsonParser.parseString(result);  // Gson 2.8.6 �̻󿡼��� �̷��� �����ؾ� �մϴ�.
            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();
            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return access_Token;  // access_token�� ��ȯ�մϴ�.
    }
    
    @Override
    public HashMap<String, Object> getUserInfo(String access_Token) {
        HashMap<String, Object> userInfo = new HashMap<>();
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + access_Token);
            //conn.setRequestProperty("charset", "utf-8");
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line = "";
            String result = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            // JSON �Ľ�
            JsonElement element = JsonParser.parseString(result);

            // Null üũ �� JsonObject�� ��ȯ ���� ���� üũ
            if (element.isJsonObject()) {
                JsonObject jsonObject = element.getAsJsonObject();

                // "properties"�� "kakao_account" �ʵ尡 �����ϴ��� Ȯ��
                JsonObject properties = jsonObject.has("properties") ? jsonObject.getAsJsonObject("properties") : null;
                JsonObject kakao_account = jsonObject.has("kakao_account") ? jsonObject.getAsJsonObject("kakao_account") : null;

                // 'nickname'�� 'email'�� ������ �� null üũ
                String nickname = (properties != null && properties.has("nickname")) ? properties.get("nickname").getAsString() : "Unknown";
                String email = (kakao_account != null && kakao_account.has("email")) ? kakao_account.get("email").getAsString() : "Not Provided";

                // ����� ���� ����
                userInfo.put("nickname", nickname);
                userInfo.put("email", email);
                userInfo.put("id", jsonObject.has("id") ? jsonObject.get("id").getAsString() : "Unknown");
                userInfo.put("connected_at", jsonObject.has("connected_at") ? jsonObject.get("connected_at").getAsString() : "Unknown");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInfo;
    }


}
