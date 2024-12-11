package org.zerock.mapper;

import org.zerock.dto.MemberDTO;

public interface KakaoMapper {
	
	public int klogin(MemberDTO mdto);
	public MemberDTO kloginGo(MemberDTO mdto);
	public int kjoin(MemberDTO mdto);

}
