package com.user.data.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.user.data.UserRepo.UserRepository;
import com.user.data.record.*;
@RestController
public class UserController {
	
	@Autowired    
	private UserRepository userRepository;

	@RequestMapping("/")    
	public List<Userdata> getallUser()
	{
		List<Userdata>userRecords = new ArrayList<>();    
		userRepository.findAll().forEach(userRecords::add);    
		return userRecords;
	}
	@PostMapping("/add-user")
	public void addUser(@RequestBody Userdata userdata)
	{
		userRepository.save(userdata); 
	}
}
