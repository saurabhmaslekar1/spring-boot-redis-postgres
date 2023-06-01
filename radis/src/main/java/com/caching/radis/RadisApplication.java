package com.caching.radis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RadisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadisApplication.class, args);
	}

}
