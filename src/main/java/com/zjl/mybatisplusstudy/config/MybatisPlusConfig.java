package com.zjl.mybatisplusstudy.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(value = {PaginationInnerInterceptor.class})
public class MybatisPlusConfig {

    //最新版写法 参考    https://baomidou.com/guide/page.html
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor innerInterceptor = new MybatisPlusInterceptor();
        innerInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return innerInterceptor;
    }
}
