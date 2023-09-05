package com.example.demo.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("api/users")
public class Usercontroller {

    // upload image RestApi 
	@PostMapping("/upload-image")
	public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(file.getName());
		System.out.println(file);
		String img=Base64.getEncoder().encodeToString(file.getBytes());
		System.out.println("Base64:: "+img);
		return userService.saveImage(file,img);
	}

	private UserService userService;
	

	public Usercontroller(UserService userService) {
		super();
		this.userService = userService;
	}

	/*// create user Rest API in Json format
	@PostMapping
	public ResponseEntity<User> saveUsers(@RequestBody User users) {
		return new ResponseEntity<User>(userService.saveUsers(users), HttpStatusCode.valueOf(101));

	}*/
	
	// create user Rest API in Json format
		@PostMapping
		public ResponseEntity<User> saveUsers(@RequestBody String reqData) {
			User users=new User();
			System.out.println(reqData);
			JSONObject obj=new JSONObject(reqData);
			System.out.println(obj.getString("productName"));
			System.out.println(obj.getString("productCode"));
			System.out.println(obj.getString("productCategory"));
			System.out.println(obj.getJSONObject("jsonColumn"));
			
			users.setProductName(obj.getString("productName"));
			users.setProductCode(obj.getString("productCode"));
			users.setProductCategory(obj.getString("productCategory"));
			users.setJsonColumn(obj.getJSONObject("jsonColumn").toString());			
			
			
			return new ResponseEntity<User>(userService.saveUsers(users), HttpStatusCode.valueOf(101));

		}

	// Get User Rest API in json format
	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();

	}

	// get User Particular id in Json Format
	@GetMapping("{id}")
	public ResponseEntity<User> getUserId(@PathVariable("id") int userId) {
		return new ResponseEntity<User>(userService.getUserId(userId), HttpStatus.OK);

	}
	
//	// get User Particular Json in Mysql
//	@GetMapping("{id}")a
//		public ResponseEntity<User> getJsonId(@PathVariable("id") int userId) {
//			return new ResponseEntity<User>(userService.getUserId(userId), HttpStatus.OK);
//
//		}
	
	
//	 @GetMapping("/jsonColumn")
//	    public List<User> getAllJsonData() {
//	        return UserRepository.findAll();
//	    }

	// Update User Particular id using Json Format
	@PutMapping("{id}")
	public ResponseEntity<User> updateUserId(@PathVariable("id") int id, @RequestBody User user) {

		return new ResponseEntity<User>(userService.updateUserId(user, id), HttpStatus.OK);

	}

	// delete user particular id using json format
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {

		userService.deleteUser(id);

		return new ResponseEntity<String>("deleted succesfully", HttpStatus.OK);

	}

}
