package com.bitc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class AppServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(AppServer2Application.class, args);
	}

}
