package com.zjl.mybatisplusstudy.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import jdk.nashorn.internal.objects.Global;

import java.util.HashMap;
import java.util.Map;

public class MyGenerator {
    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator();

        // set freemarker engine
        generator.setTemplateEngine(new FreemarkerTemplateEngine());

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"\\src\\main\\java");
        globalConfig.setAuthor("zjl");
        globalConfig.setOpen(false);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybaits?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("000000");

        //指定自定义模板路径, 位置：/resources/templates/entity2.java.ftl(或者是.vm)
        //注意不要带上.ftl(或者是.vm), 会根据使用的模板引擎自动识别
//        TemplateConfig templateConfig = new TemplateConfig()
//                .setEntity("templates/entity2.java");
        //配置自定义模板
//        generator.setTemplate(templateConfig);

//        InjectionConfig injectionConfig = new InjectionConfig() {
//            //自定义属性注入:abc
//            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
//            @Override
//            public void initMap() {
//                Map<String, Object> map = new HashMap<>();
//                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                this.setMap(map);
//            }
//        };
        //配置自定义属性注入
//        generator.setCfg(injectionConfig);

        generator.execute();



    }
}
