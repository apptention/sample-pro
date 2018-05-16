package kr.co.hta.board.dao;

import kr.co.hta.board.vo.User;

public interface UserDao {

	void addUser(User user);
	
	User getUserById(String id);
	
}