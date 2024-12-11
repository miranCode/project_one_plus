package org.zerock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zerock.dto.GoogleMemberDTO;
import org.zerock.dto.GoogleOAuthDTO;

@Mapper
public interface GoogleMapper {
	@Select("SELECT * FROM api_key")
	GoogleOAuthDTO getGoogleCredentials();
	
	GoogleMemberDTO findUserByGoogleId(String googleId);
	
	void insertUser(GoogleMemberDTO googledto);
	//push
}
