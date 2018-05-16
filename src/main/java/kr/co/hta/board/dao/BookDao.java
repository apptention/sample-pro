package kr.co.hta.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.hta.board.vo.Book;
import kr.co.hta.board.vo.Criteria;

@Repository
public interface BookDao {
	
	List<Book> searchBooks(Criteria c);
	
	List<Book> test();
	
}