package org.zerock.mapper;

import org.zerock.dto.MemberDTO;

public interface MemberMapper {
	
	// �������̽����� ����� �߻�޼ҵ常 ����. 
	// �߻� �޼ҵ带 ���� controller ���� 
	public MemberDTO login(MemberDTO mdto);
}
