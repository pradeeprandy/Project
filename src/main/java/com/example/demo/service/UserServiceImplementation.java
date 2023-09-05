package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;

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

	@Override
	public List<User> getUsers() {

		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserId(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			throw new ResourceNotFoundException("User", "id", id);
		}

	}

	@Override
	public User updateUserId(User user, int userid) {
		User userId = userRepository.findById(userid)
				.orElseThrow(() -> new ResourceNotFoundException("employee", "id", user));

		userId.setProductName(user.getProductName());
		userId.setProductCode(user.getProductCode());
		userId.setProductCategory(user.getProductCategory());
		userId.setProductMetatype(user.getProductMetatype());
		


		userRepository.save(userId);
		return user;
	}

	@Override
	public void deleteUser(int id) {

		userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

		userRepository.deleteById(id);
	}

	@Override
	public String saveImage(MultipartFile file,String img) {
		User user =new User();
		user.setProduct_image(img);
		userRepository.save(user);
		return "Image Saved in DB";
	}

	@Override
	public User getJsonId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
