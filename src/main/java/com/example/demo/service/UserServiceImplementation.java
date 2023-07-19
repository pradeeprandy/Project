package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

@Service
public class UserServiceImplementation implements UserService {

	private UserRepository userRepository;

	// like autowired annotation because single construvtor take it as
	// autowired annotations in this line.
	public UserServiceImplementation(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUsers(User users) {
		return userRepository.save(users);
	}

}
