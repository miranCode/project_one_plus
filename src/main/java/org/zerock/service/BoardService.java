package org.zerock.service;

import java.util.List;

import org.zerock.dto.BoardVO;
import org.zerock.dto.Criteria;

public interface BoardService {
	
	public void register(BoardVO board);
	
	public BoardVO get(Long idx);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long idx);
	
	//public List<BoardVO> getList();
	
	public List<BoardVO> getList(Criteria cri);
	
	public boolean verifyPassword(String idx, String password);
	
	public int getTotal(Criteria cri);
	
	public void visitCount(Long idx);
	
}
