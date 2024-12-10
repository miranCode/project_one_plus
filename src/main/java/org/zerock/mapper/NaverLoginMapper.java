package org.zerock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.dto.NaverLoginDTO;

@Mapper
public interface NaverLoginMapper {

    // 네이버 회원 정보를 DB에 삽입
    void insertNaverMember(NaverLoginDTO naverLoginDTO);

    // 네이버 회원 정보 조회
    NaverLoginDTO selectNaverMemberById(String id);

    // 네이버 회원 정보 수정
    void updateNaverMember(NaverLoginDTO naverLoginDTO);

    // 네이버 회원 정보 삭제
    void deleteNaverMember(String id);
}
