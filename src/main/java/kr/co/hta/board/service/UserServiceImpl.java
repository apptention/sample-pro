package kr.co.hta.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.co.hta.board.dao.UserDao;
import kr.co.hta.board.exception.SimpleBoardException;
import kr.co.hta.board.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDaoIbatisImpl")
	//@Qualifier("userDaoImpl")
	private UserDao userDao;

	@Override
	public void addNewUser(User user) {
		User result = userDao.getUserById(user.getId());
		if(result != null) {
			throw new SimpleBoardException("아이디가 존재합니다.");
		}
		userDao.addUser(user);
	}

	@Override
	public User login(String id, String pwd) {
		User user = userDao.getUserById(id);
		if(user == null)
			return null;
		
		if(!user.getPwd().equals(pwd))
			return null;
			
		return user;
	}
	
}