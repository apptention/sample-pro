package kr.co.hta.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.co.hta.board.vo.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate template;
	
	private RowMapper<User> userMapper = new RowMapper<User>() {
		
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("user_id"));
			user.setPwd(rs.getString("user_pwd"));
			user.setNick(rs.getString("user_nick"));
			user.setCreateDate(rs.getDate("create_date"));
			return user;
		}
	};

	@Override
	public void addUser(User user) {
		String sql = "insert into simple_board_user (user_id, user_pwd, user_nick) values (?, ?, ?) ";
		template.update(sql, user.getId(), user.getPwd(), user.getNick());
	}

	@Override
	public User getUserById(String id) {
		String sql = "select * from simple_board_user where user_id = ? ";
		List<User> user = template.query(sql, userMapper, id);
		if(user.isEmpty()) {
			return null;
		}
		return user.get(0);
	}
	
}