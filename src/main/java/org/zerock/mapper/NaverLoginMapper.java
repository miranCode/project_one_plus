package org.zerock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.dto.MemberDTO;

@Mapper
public interface NaverLoginMapper {

	public void insertNaverMember(MemberDTO mdto);

	public MemberDTO selectNaverMemberById(String id);

	public MemberDTO updateNaverMember(MemberDTO mdto);

	public void deleteNaverMember(String id);
}
