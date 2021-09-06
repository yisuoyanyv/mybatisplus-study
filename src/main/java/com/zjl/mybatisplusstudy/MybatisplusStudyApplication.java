package com.zjl.mybatisplusstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zjl.mybatisplusstudy.mapper")
public class MybatisplusStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisplusStudyApplication.class, args);
	}

}
