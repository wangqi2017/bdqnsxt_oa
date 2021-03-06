package com.bdqnsxt.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@EnableTransactionManagement(order = 10)
@MapperScan("com.bdqnsxt.oa.dao")
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableScheduling
public class OaApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(OaApplication.class);
	}

	@Bean
	public RequestContextListener requestContextListener(){
		return new RequestContextListener();
	}

	public static void main(String[] args) {
		SpringApplication.run(OaApplication.class, args);
	}

}
