package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    
//    @Select("select sysdate()")
//    public String getTime();  // �޼��� ��ȣ () �߰�
	
//    @Select("select * from board")
//    public String getBoard();
	
	public String getTime(); 
	public String getBoard();
	
}
