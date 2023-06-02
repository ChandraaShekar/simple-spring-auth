package com.csr.simpleauth;


import com.csr.simpleauth.registery.UserRegistery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SimpleAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleAuthApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRegistery userRegistery) {
		return args -> {
			System.out.println(userRegistery.findAll());
		};
	}

}
