package com.user.record.userdao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.user.record.userbean.User;
@Component
public class UserDao {

	private static int userCount=6;
	public static List<User> user = new ArrayList<>();
	
	static
	{
		user.add(new User(101,"Solaman","solu@gmail.com",32));
		user.add(new User(102,"Basheer","bashii@hotmail.com",21));
		user.add(new User(103,"Vincy","vincy12@yahoo.com",40));
		user.add(new User(104,"Sravya","sravyasavi@gmail.com",18));
		user.add(new User(105,"ShajiYousaf","shajiy@gmail.com",66));
		user.add(new User(106,"ArunJose","arun67@yahoo.com",31));
	}
	
	public List<User> findAll()  
	{  
	return user;  
	}
	
	public User findOne(int id)  
	{  
	for(User users:user)  
	{  
	if(users.getId()==id)  
	return users;  
	}  
	return null;  
	}  
	
	public User save(User users)  
	{  
	if(users.getId()==0)  
	{   
	users.setId(++userCount);  
	}  
	user.add(users);  
	return users;  
	}  
	  
	public User delete(int id)
	{
		Iterator<User> it =user.iterator();
		while(it.hasNext())
		{
			User delete = it.next();
			if(delete.getId()==id)
			{
				it.remove();
				return delete; 
			}
			
		}
		return null;
	}
}
