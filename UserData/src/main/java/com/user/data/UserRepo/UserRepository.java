package com.user.data.UserRepo;

import org.springframework.data.repository.CrudRepository;

import com.user.data.record.Userdata;

public interface UserRepository extends CrudRepository<Userdata,String> {

	
}
