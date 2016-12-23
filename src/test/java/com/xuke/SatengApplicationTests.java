package com.xuke;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuke.dao.UserDao;
import com.xuke.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SatengApplicationTests {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void contextLoads() throws JsonProcessingException {
		User user = new User();
		ObjectMapper mapper = new ObjectMapper();
		user.initDate();
		User u = userDao.save(user);
		System.out.println("####" + mapper.writeValueAsString(u));
	}

}
