package kr.co.hta.board.service;

import kr.co.hta.board.vo.User;

public interface UserService {

	User login(String id, String pwd);
	
	void addNewUser(User user);
	
}
