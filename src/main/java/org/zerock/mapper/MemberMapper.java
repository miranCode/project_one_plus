package org.zerock.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.dto.MemberDTO;

public interface MemberMapper {
	
	// �������̽����� ����� �߻�޼ҵ常 ����. 
	// �߻� �޼ҵ带 ���� controller ���� 
	public MemberDTO login(MemberDTO mdto);
	
	public int join(MemberDTO mdto);
	
	public int idCheck(@Param("id") String id);
	
	public boolean selectId(String id);

}
