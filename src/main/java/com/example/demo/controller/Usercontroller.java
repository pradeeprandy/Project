package com.example.demo.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("api/users")
public class Usercontroller {

//	@GetMapping("")
//	public String homePage() {
//		return "index";
//	}

	private UserService userService;

	public Usercontroller(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// create user Rest API 
		@PostMapping
		public ResponseEntity<User> saveUsers(@RequestBody User users){
			return new ResponseEntity<User>(userService.saveUsers(users), HttpStatusCode.valueOf(101));
			
		}

}
