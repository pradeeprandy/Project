package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.User;

public interface UserService {
	
	

	// save the data
	User saveUsers(User users);

	// retrieve the all the users
	List<User> getUsers();
	
	// retrive the particular id from user 
	User getUserId(int id);
	
	//retrieve the particular json in mysql
	User getJsonId(int id);
	
	//Update the particular id from the user
	User updateUserId(User user,int userid);
	
	//delete the user
	void deleteUser(int id);

	String saveImage(MultipartFile file,String img);

}
