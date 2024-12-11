package org.zerock.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.zerock.dto.GoogleMemberDTO;
import org.zerock.dto.MemberDTO;

@Service
public interface GoogleService {
	public String getAccessToken (String authorize_code) ;
	public HashMap<String, Object> getUserInfo(String access_Token);
	public boolean saveUser(HashMap<String, Object> userInfo);
	public MemberDTO findUserByGoogleId(String googleId);
	//push
}
