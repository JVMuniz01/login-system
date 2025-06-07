package com.loginSystem.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.loginSystem.entity.User;
import com.loginSystem.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("TestConfig RUNNING");
		User u1 = new User(null, "joaovmr", "j040vmr@gmail.com", "joao0159753");
		User u2 = new User(null, "divaldinho", "edervalg@gmail.com", "divalgay2424");
		User u3 = new User(null, "davirochabc", "davirochabc@gmail.com", "eu4mor0l4");
		User u4 = new User(null, "lmessi", "lionelamc@gmail.com", "goatofalltime");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
		
	}
}
