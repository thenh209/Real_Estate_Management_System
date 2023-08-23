package com.project.User_Details.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.User_Details.Model.UserModel;
import com.project.User_Details.Service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping("adduser")
	public UserModel add(@RequestBody  UserModel u)
	{
		return us.saveinfo(u);
	}
	
	@GetMapping("getuser")
	public ResponseEntity<UserModel> show(@RequestParam int id) {
	    UserModel user = us.getUserById(id);
	    
	    if (user != null) {
	        return new ResponseEntity<>(user,HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("updateuser")
	public String modifybyid(@RequestParam int id,@RequestBody UserModel um)
	{
		return us.changeinfobyid(id,um);	
	}
	
	@DeleteMapping("deleteuser")
	public String deleteMyParamId(@RequestParam int id)
	{
		return (us.deleteid(id)); 
	}
}
