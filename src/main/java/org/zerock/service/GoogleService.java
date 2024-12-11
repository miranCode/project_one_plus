package org.zerock.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.zerock.dto.GoogleMemberDTO;

@Service
public interface GoogleService {
	public String getAccessToken (String authorize_code) ;
	public HashMap<String, Object> getUserInfo(String access_Token);
	public boolean saveUser(HashMap<String, Object> userInfo);
	public GoogleMemberDTO findUserByGoogleId(String googleId);
	//push
}
