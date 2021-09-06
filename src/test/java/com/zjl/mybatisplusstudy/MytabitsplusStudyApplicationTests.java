package com.zjl.mybatisplusstudy;

import com.zjl.mybatisplusstudy.entity.User;
import com.zjl.mybatisplusstudy.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
class MytabitsplusStudyApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelect(){
		System.out.println("------------ selectAll method test -------------");
		List<User> users = userMapper.selectList(null);
		Assert.assertEquals(5,users.size());
		users.forEach(System.out::println);

	}

	@Test
	void contextLoads() {
	}



}
