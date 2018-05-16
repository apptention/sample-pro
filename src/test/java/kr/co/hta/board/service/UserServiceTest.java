package kr.co.hta.board.service;

import static org.junit.Assert.*;
import java.util.Date;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import kr.co.hta.board.exception.SimpleBoardException;
import kr.co.hta.board.vo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/META-INF/spring/test-root-context.xml")
@Transactional
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	public void testConfig() {
		assertThat(userService, notNullValue());
	}
	
	@Test
	public void testAddNewUser() {
		User user = new User();
		user.setId("lee");
		user.setPwd("zxcv1234");
		user.setNick("이순신");
		user.setCreateDate(new Date());
		
		userService.addNewUser(user);
		
		User result = userService.login(user.getId(), user.getPwd());
		assertThat(result, notNullValue());
	}
	
	@Test(expected=SimpleBoardException.class)
	public void testDuplicateUserAdd() {
		User user = new User();
		user.setId("hong");
		user.setPwd("zxcv1234");
		user.setNick("홍길동");
		user.setCreateDate(new Date());
		
		userService.addNewUser(user);
	}
	
}
