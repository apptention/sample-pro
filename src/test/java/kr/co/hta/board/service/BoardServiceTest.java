package kr.co.hta.board.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.co.hta.board.exception.SimpleBoardException;
import kr.co.hta.board.vo.Board;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/META-INF/spring/test-root-context.xml")
public class BoardServiceTest {

	@Autowired
	private BoardService boardService;
	
	public void testAddBoard() {
		Board board = new Board();
		board.setTitle("홍3");
		board.setNick("hong");
		board.setContents("홍홍");
		
		boardService.addBoard(board);
	}
	
	@Test(expected=DataIntegrityViolationException.class)
	public void testAddBoardWithoutTitle() {
		Board board = new Board();
		board.setNick("hong");
		board.setContents("홍홍");
		
		boardService.addBoard(board);
	}
	
	@Test(expected=DataIntegrityViolationException.class)
	public void testAddBoardWithoutNick() {
		Board board = new Board();
		board.setTitle("홍3");
		board.setContents("홍홍");
		
		boardService.addBoard(board);
	}
	
	@Test(expected=DataIntegrityViolationException.class)
	public void testAddBoardWithoutContents() {
		Board board = new Board();
		board.setTitle("홍3");
		board.setNick("hong");
		
		boardService.addBoard(board);
	}
	
	@Test(expected=SimpleBoardException.class)
	public void testGetNonexistentBoard() {
		Board board = boardService.getBoardByNo(-1);
		assertThat(board, nullValue());
	}
	
	@Test
	public void testGetAllBoards() {
		List<Board> result = boardService.getBoards();
		assertThat(result, notNullValue());
		assertEquals(5, result.size());
	}
	
	@Test
	public void testGetBoard() {
		Board board = boardService.getBoardByNo(157);
		assertThat(board, notNullValue());
	}
	
	@Test(expected=SimpleBoardException.class)
	public void testDeleteNonexistentBoard() {
		boardService.deleteBoardByNo(-1, "hong");
	}
	
	@Test(expected=SimpleBoardException.class)
	public void testDeleteBoardAuthority() {
		boardService.deleteBoardByNo(157, "kim");
	}
	
	@Test
	public void testDeleteBoard() {
		boardService.deleteBoardByNo(157, "hong");
	}
	
}