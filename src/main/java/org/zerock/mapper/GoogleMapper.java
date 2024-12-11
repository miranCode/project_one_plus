package org.zerock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.zerock.dto.GoogleMemberDTO;
import org.zerock.dto.GoogleOAuthDTO;
import org.zerock.dto.MemberDTO;

@Mapper
public interface GoogleMapper {
	@Select("SELECT * FROM api_key")
	GoogleOAuthDTO getGoogleCredentials();
	
	MemberDTO findUserByGoogleId(String googleId);
	
	void insertUser(MemberDTO googledto);
	//push
}
