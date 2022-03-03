package com.bitc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		
		commonsMultipartResolver.setDefaultEncoding("UTF-8");
		
		commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024);//5MB
		
		return commonsMultipartResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").
//		addResourceLocations("file:///" + System.getProperty("user.home")+"/images/");//업로드된 절대 경로 - 윈도우
		addResourceLocations("file:" + System.getProperty("user.home")+"/images/");//업로드된 절대 경로 - 리눅스
		
	}
}