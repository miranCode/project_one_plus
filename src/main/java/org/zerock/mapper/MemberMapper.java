package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.dto.MemberDTO;

public interface MemberMapper {
	
	// 인터페이스에는 상수와 추상메소드만 들어간다. 
	// 추상 메소드를 통해 controller 연결 
	public MemberDTO login(MemberDTO mdto);
	
	public int join(MemberDTO mdto);
	
	public int idCheck(@Param("id") String id);
	
	public boolean selectId(String id);

}
