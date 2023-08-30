package com.project.Services;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.Models.UserModel;
import com.project.Repositories.UserRepository;

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
	
	public List<UserModel> getPages(int pno, int psize, String field)
	{
		Sort ord = Sort.by(Sort.DEFAULT_DIRECTION,field);
		Page<UserModel> b = ur.findAll(PageRequest.of(pno, psize,ord));
		return b.getContent();
		
	}
	
	public List<UserModel> getdetails(int id){
		return ur.getInfo(id);
	}
}
