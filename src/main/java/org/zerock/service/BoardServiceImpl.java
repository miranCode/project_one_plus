package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.dto.BoardVO;
import org.zerock.mapper.BoardMapper;


@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) { 
		System.out.println("register....." + board);
	
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long idx) {
		System.out.println("get......." + idx);
		return mapper.read(idx);
	}

	@Override
	public boolean modify(BoardVO board) {
		System.out.println("modify......." + board);
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long idx) {
		System.out.println("remove........" + idx);
		return mapper.delete(idx) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		System.out.println("getList.................");
		return mapper.getList();
	}
}