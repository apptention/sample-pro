package kr.co.hta.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.hta.board.vo.Board;

@Repository
@SuppressWarnings({"unchecked", "deprecation"})
public class BoardDaoIbatisImpl implements BoardDao {

	@Autowired
	private SqlMapClientTemplate template;
	
	@Override
	public void addBoard(Board board) {
		template.insert("board.addBoard");
	}
	
	@Override
	public List<Board> getBoards() {
		return template.queryForList("board.getBoards");
	}

	@Override
	public Board getBoardByNo(int boardNo) {
		return (Board) template.queryForObject("board.getBoardByNo", boardNo);
	}

	@Override
	public void deleteBoardByNo(int boardNo) {
		template.delete("board.deleteBoardByNo", boardNo);
	}

}
