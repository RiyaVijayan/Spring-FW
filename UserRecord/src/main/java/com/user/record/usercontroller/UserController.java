package com.user.record.usercontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.record.userbean.*;
import com.user.record.userdao.*;
import com.user.record.userexception.UserNotFound;
@RestController
public class UserController {

	@Autowired
	private UserDao dao;
	
	@GetMapping("/users")  
	public List<User> getallUsers()  
	{  
	return dao.findAll();  
	}  
	
	@GetMapping("/users/{id}")  
	public User getUser(@PathVariable ("id") int id)  
	{  
	User get=dao.findOne(id);
	if(get==null)    
		throw new UserNotFound("id: "+ id);  
	return get;  
	}  
	
	@PostMapping("/users")  
	public User createUser(@RequestBody User users)  
	{  
	dao.save(users);
	return users;
	}  
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable("id") int id)
	{
		User del = dao.delete(id);
		if(del==null)
			throw new UserNotFound("id: "+ id);
		else
			return "User deleted";
	
	}
	
	
}
