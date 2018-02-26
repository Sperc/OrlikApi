package com.sosnowka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BookingApplication {
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public String getDirecotryPath(){
		return "./src/main/resources/static/";
	}

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}
}
