package com.project.User_Details.Service;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.User_Details.Model.UserModel;
import com.project.User_Details.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository ur;
	
	public UserModel saveinfo(UserModel um)
	{
		return ur.save(um);
	}
	
	public UserModel getUserById(int id) {
		Optional<UserModel> userOptional = ur.findById(id);
        return userOptional.orElse(null);
	}
	
	public String changeinfobyid(int id,UserModel um)
	{
		if(ur.existsById(id))
		{
			ur.saveAndFlush(um);
			return "Updated";
		}
		else
		{
			return "Enter Valid Id";
		}
	}
	
	public String deleteid(int id)
	{
		if(ur.existsById(id))
		{
			ur.deleteById(id);
			return "Deleted";
		}
		else
		{
			return "Enter Valid Id";
		}
	}
}
