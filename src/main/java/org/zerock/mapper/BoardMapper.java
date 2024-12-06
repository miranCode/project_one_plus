package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

import org.zerock.dto.BoardVO;

public interface BoardMapper {
	//@Select("select * from board where idx > 0 ")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long idx);
	
	public int delete(Long idx);
	
	public int update(BoardVO board);
}
