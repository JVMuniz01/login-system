package com.loginSystem.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.loginSystem.entity.User;
import com.loginSystem.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("TestConfig RUNNING - CRUD working");
		User u1 = new User(null, "joaovmr", "j040vmr@gmail.com", passwordEncoder.encode("joao0159753"));
		User u2 = new User(null, "divaldinho", "edervalg@gmail.com", passwordEncoder.encode("divalgay2424"));
		User u3 = new User(null, "davirochabc", "davirochabc@gmail.com", passwordEncoder.encode("eu4mor0l4"));
		User u4 = new User(null, "lmessi", "lionelamc@gmail.com", passwordEncoder.encode("goatofalltime"));
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
			
	}
}
