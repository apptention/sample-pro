package kr.co.hta.board.dao;

import java.util.List;

import kr.co.hta.board.vo.Board;

public interface BoardDao {

	void addBoard(Board board);
	
	List<Board> getBoards();
	
	Board getBoardByNo(int boardNo);

	void deleteBoardByNo(int boardNo);
	
}