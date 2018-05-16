package kr.co.hta.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.hta.board.vo.User;

@Repository
@SuppressWarnings("deprecation")
public class UserDaoIbatisImpl implements UserDao {


	@Autowired
	private SqlMapClientTemplate template;
	

	@Override
	public void addUser(User user) {
		template.insert("user.addUser", user);
	}

	@Override
	public User getUserById(String id) {
		return (User) template.queryForObject("user.getUserById", id);
	}

}