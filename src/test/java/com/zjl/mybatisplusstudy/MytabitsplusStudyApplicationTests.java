package com.zjl.mybatisplusstudy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjl.mybatisplusstudy.entity.User;
import com.zjl.mybatisplusstudy.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.*;

@SpringBootTest
class MytabitsplusStudyApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelect(){
//		User user = userMapper.selectById(1L);
//		System.out.println(user);

//		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//		queryWrapper.eq("name","zjl20");
////		queryWrapper.like("name","zjl");
//		User user1 = userMapper.selectOne(queryWrapper);//如果查询条件返回多条，会抛异常org.apache.ibatis.exceptions.TooManyResultsException
//		System.out.println(user1);

//		List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 5));
//		users.forEach(System.out::println);

//		System.out.println("------------ selectAll method test -------------");
//		List<User> users = userMapper.selectList(null);
////		Assert.assertEquals(5,users.size());
//		users.forEach(System.out::println);
//
//		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
////		queryWrapper.inSql("name","Tom,jack"); ??
//		queryWrapper.like("name","2");
//		System.out.println("------------ select By QueryWrapper method test -------------");
//		userMapper.selectList(queryWrapper).forEach(System.out::println);

//		Map<String,Object> map =new HashMap<>();
//		map.put("age","20");
//		userMapper.selectByMap(map).forEach(System.out::println);


//		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
//////		queryWrapper.inSql("name","Tom,jack"); ??
//		queryWrapper.like("name","2");
//		userMapper.selectMaps(queryWrapper).forEach(System.out::println);

//		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
//////		queryWrapper.inSql("name","Tom,jack"); ??
//		queryWrapper.select("name").like("name","2");
//		//// 根据 Wrapper 条件，查询全部记录。注意： 只返回第一个字段的值
//		userMapper.selectObjs(queryWrapper).forEach(System.out::println);

		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
		queryWrapper.like("name","zjl");
		IPage<User> page=new Page<>(1,10);
//		page.setCurrent(2);
//		page.setSize(5);
//		IPage<User> pageResult = userMapper.selectPage(page, queryWrapper);
		IPage<User> pageResult = userMapper.selectPage(page, null);
		System.out.println(pageResult.getPages()); // 10
		System.out.println(pageResult.getCurrent());// 1
		System.out.println(pageResult.getRecords());
		System.out.println(pageResult.getSize()); //10
		System.out.println(pageResult.getTotal()); // 100
//		pageResult.getRecords().forEach(System.out::println);

		//原来的page对象
		System.out.println("原来的page对象：");
		System.out.println(page.getPages()); // 10
		System.out.println(page.getCurrent());// 1
		System.out.println(page.getRecords());
		System.out.println(page.getSize()); //10
		System.out.println(page.getTotal()); // 100

		System.out.println("总数为："+userMapper.selectCount(queryWrapper));

	}

	@Test
	public void testInsertAndDelete(){
//		System.out.println("------------ save method test -------------");
//		User user = new User();
//		user.setAge(1);
//		user.setEmail("mm@qq.com");
//		user.setName("zjl");
//
//		int insert = userMapper.insert(user);
//		System.out.println(insert);
//
//		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
//		System.out.println("------------ delete by queryWapper  method test -------------");
//		queryWrapper.eq("name","zjl");
//		userMapper.delete(queryWrapper);
//		System.out.println("------------ delete batch  method test -------------");
//		int i = userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
//		System.out.println(i);

//		int j = userMapper.deleteById(4);
//		System.out.println(j);

		Map<String,Object> map=new HashMap<>();
		map.put("id","5");
		int k = userMapper.deleteByMap(map);

	}

	@Test
	public void testUpdate(){
		User user = new User();
//		user.setId(1L);
		user.setAge(66);
		user.setEmail("qq@qq.com");
//		user.setName("zjltestupdate");
//		int update = userMapper.updateById(user);
//		System.out.println(update);

		QueryWrapper<User> queryWrapper=new QueryWrapper<>();
		queryWrapper.in("id",6L,7L,8L);
		int update = userMapper.update(user, queryWrapper);
		//user的id没有更新
		System.out.println(update);
	}

	@Test
	void generatorTestUsers() {
		Random random=new Random();
		for (int i = 0; i < 100; i++) {
			User user = new User();
			user.setId(Long.valueOf(i));
			user.setAge(random.nextInt(100));
			user.setEmail("mm"+i+"@qq.com");
			user.setName("zjl"+i);
			userMapper.insert(user);
		}
	}



}
