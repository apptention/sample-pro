package kr.co.hta.board.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import kr.co.hta.board.vo.Board;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/META-INF/spring/test-root-context.xml")
public class BoardServiceTest {

	@Autowired
	BoardService boardService;
	
	@Before
	public void beforeClass() {
		System.out.println("asdasd");
	}
	
	@Test
	public void testAddBoard() {
		
		Board board = new Board();
		board.setTitle("홍3");
		board.setNick("hong");
		board.setContents("홍홍");
		
		boardService.addBoard(board);
	}
	
	@Test(expected=Exception.class)
	public void testAddNullTitleBoard() {
		
		Board board = new Board();
		board.setNick("hong");
		board.setContents("홍홍");
		
		boardService.addBoard(board);
		
	}
	
	@Test(expected=Exception.class)
	public void testAddNullNickBoard() {

		Board board = new Board();
		board.setTitle("홍3");
		board.setContents("홍홍");
		
		boardService.addBoard(board);
		
	}
	
	@Test(expected=Exception.class)
	public void testAddNullContentsBoard() {
		
		Board board = new Board();
		board.setTitle("홍3");
		board.setNick("hong");
		
		boardService.addBoard(board);
	}
	
	@Test
	public void testGetBoard() {
		
		int existBoardNo = 157;
		
		Board board = boardService.getBoardByNo(existBoardNo);
		assertThat(board, notNullValue());
	}
	
	@Test
	public void testGetNonexistentBoard() {
		
		int nonexistentBoardNo = -1;
		
		Board board = boardService.getBoardByNo(nonexistentBoardNo);
		assertThat(board, nullValue());
	}
	
	@Test
	public void testGetAllBoards() {
		
		int realSize = 5;
		
		List<Board> result = boardService.getBoards();
		assertThat(result, notNullValue());
		assertEquals(realSize, result.size());
	}
	
	@Test
	public void testDeleteBoard() {
		
		
		
	}
	
	@Test
	public void testDeleteNonexistentBoard() {
		
		
		
	}
	
}