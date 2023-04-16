package com.nyist.sims;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SimsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimsApplication.class, args);
	}

}
