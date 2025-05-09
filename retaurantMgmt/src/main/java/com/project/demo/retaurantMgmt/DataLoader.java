package com.project.demo.retaurantMgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.demo.retaurantMgmt.model.UserAccount;
import com.project.demo.retaurantMgmt.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new UserAccount("admin", "{noop}admin123", "ROLE_ADMIN"));
		userRepository.save(new UserAccount("user", "{noop}user123", "ROLE_USER"));
		System.out.println("Default users loaded!");
	}
}
