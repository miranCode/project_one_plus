package org.zerock.service;

import java.util.List;

import org.zerock.dto.BoardVO;

public interface BoardService {
	
	public void register(BoardVO board);
	
	public BoardVO get(Long idx);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long idx);
	
	public List<BoardVO> getList();
	
	public boolean verifyPassword(String idx, String password);
}
