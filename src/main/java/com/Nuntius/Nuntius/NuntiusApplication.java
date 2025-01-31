package com.Nuntius.Nuntius;

import com.Nuntius.Nuntius.model.User;
import com.Nuntius.Nuntius.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class NuntiusApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NuntiusApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setUser_id("U123");
		user.setName("John Doe");
		user.setEmail("johndoe@example.com");
		user.setPhoneNo(1234567890);
		user.setCreatedAt(LocalDateTime.now());
		userRepository.save(user);


		User user1 = new User();
		user1.setUser_id("U124");
		user1.setName("Jane Smith");
		user1.setEmail("janesmith@example.com");
		user1.setPhoneNo(987654321);
		user1.setCreatedAt(LocalDateTime.now());
		userRepository.save(user1);


	}
}
