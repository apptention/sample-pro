package kr.co.hta.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.hta.board.dao.BoardDao;
import kr.co.hta.board.exception.SimpleBoardException;
import kr.co.hta.board.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired 
	@Qualifier("boardDaoIbatisImpl")
	//@Qualifier("boardDaoImpl")
	private BoardDao boardDao;
	
	@Override
	public List<Board> getBoards() {
		return boardDao.getBoards();
	}

	@Override
	public void addBoard(Board board) {
		boardDao.addBoard(board);
	}

	@Override
	public Board getBoardByNo(int boardNo) {
		Board board = boardDao.getBoardByNo(boardNo);
		
		if(board == null) {
			throw new SimpleBoardException("해당 게시글이 존재하지 않습니다.");
		}
		
		return board;
	}

	@Override
	public void deleteBoardByNo(int boardNo, String userNick) {
		Board board = getBoardByNo(boardNo);

		if(!userNick.equals(board.getNick())) {
			throw new SimpleBoardException("해당 게시글에 대한 삭제 권한이 없습니다.");
		}
		
		boardDao.deleteBoardByNo(boardNo);
	}

}