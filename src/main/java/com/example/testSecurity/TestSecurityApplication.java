package com.example.testSecurity;

import com.example.testSecurity.role.domain.Role;
import com.example.testSecurity.user.domain.User;
import com.example.testSecurity.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class TestSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSecurityApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null,"Marcos Corona","marcos","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Andrea Camilo","andrea","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Shiara CC","shiara","1234",new ArrayList<>()));
			userService.saveUser(new User(null,"Yan CC","yan","1234",new ArrayList<>()));

			userService.addRoleToUser("yan","ROLE_USER");
			userService.addRoleToUser("shiara","ROLE_MANAGER");
			userService.addRoleToUser("marcos","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("andrea","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("andrea","ROLE_USER");
			userService.addRoleToUser("andrea","ROLE_ADMIN");

		};
	}
}
