package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    
//    @Select("select sysdate()")
//    public String getTime();  // 메서드 괄호 () 추가
	
//    @Select("select * from board")
//    public String getBoard();
	
	public String getTime(); 
	public String getBoard();
	
}
