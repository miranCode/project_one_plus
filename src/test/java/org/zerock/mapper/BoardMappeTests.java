package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dto.BoardVO;
import org.zerock.dto.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMappeTests {
	@Autowired
	private BoardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> System.out.println(board));
//	}
////	
//	@Test
//	public void testInsert() {
//		
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 테스트하는 글1");
//		board.setContent("새로 테스트하는 내용1");
//		board.setName("새로운 테스터1");
//		board.setEmail("새로운 테스터의 이메일1");
//		board.setPass("4321");
//		
//		mapper.insert(board);
//		
//		System.out.println(board);
//	}
//	
//	@Test
//	public void testInsertSelectKey() {
//		
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 테스트하는 글2 select key");
//		board.setContent("새로 테스트하는 내용2 select key");
//		board.setName("새로운 테스터2");
//		board.setEmail("새로운 테스터의 이메일2");
//		board.setPass("8282");
//		
//		mapper.insertSelectKey(board);
//		
//		System.out.println(board);
//	}
//	
//	@Test
//	public void testRead() {
//		BoardVO board = mapper.read(5L);
//		System.out.println(board);
//	}
//	
//	@Test
//	public void testDelete() {
//		System.out.println("DELETE COUNT: " + mapper.delete(3L));
//	}
	
//	@Test
//	public void testUpdate() {
//		
//		BoardVO board = new BoardVO();
//		
//		board.setIdx(2L);
//		board.setPass("1234");
//		board.setTitle("수정된 제목");
//		board.setContent("수정된 내용");
//		board.setOfile("기존의 파일");
//		board.setSfile("새로운 파일");
//		
//		int count = mapper.update(board);
//		System.out.println("UPDATE COUNT : " + count);
//	}
	
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(10);
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> System.out.println(board.getIdx()));
	}
}
