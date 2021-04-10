package com.mainul.HomePro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class HomeProApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeProApplication.class, args);
	}

}
