package org.zerock.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public interface KakaoService {
	public String getAccessToken (String authorize_code) ;
	public HashMap<String, Object> getUserInfo(String access_Token);
}
