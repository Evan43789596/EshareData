package com.eshareframework.esharedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * 创建整体项目的启动类
 * 启动项目的方式：
 * 1.运行此类即可。
 * 2.添加到Tomcat中发布使用也可。
 */
@ComponentScan(basePackages={"com.eshareframework.esharedata"}) // 扫描该包路径下的所有spring组件
@EnableJpaRepositories("com.eshareframework.esharedata.dao") // JPA扫描该包路径下的Repositorie
@EntityScan("com.eshareframework.esharedata.bean") // 扫描实体类
@SpringBootApplication
@EnableScheduling
public class SpringbootEshareDataApplication {


    
  public static void main(String[] args) { 
	  
    SpringApplication.run(SpringbootEshareDataApplication.class, args);
  }  

}
