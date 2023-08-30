package com.project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Models.UserModel;
import com.project.Services.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService us;
	
	@PostMapping("addUser")
	public UserModel add(@RequestBody  UserModel u)
	{
		return us.saveinfo(u);
	}
	
	@GetMapping("getUser")
	public ResponseEntity<UserModel> showByUserId(@RequestParam int id) {
	    UserModel user = us.getUserById(id);
	    
	    if (user != null) {
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	
	@PutMapping("updateUser")
	public String modifybyid(@RequestParam int id,@RequestBody UserModel um)
	{
		return us.changeinfobyid(id,um);	
	}
	
	@DeleteMapping("deleteUser")
	public String deleteMyParamId(@RequestParam int id)
	{
		return (us.deleteid(id)); 
	}
	
	@GetMapping("sortPageForUser")
	public List<UserModel> sortPages(@RequestParam(value = "pNo") int pNo, @RequestParam(value = "pSize") int pSize,@RequestParam(value = "field") String field)
	{
		return us.getPages(pNo, pSize, field);
	}
	
	@GetMapping("/queryForUser/{id}")
	public List<UserModel> display(@PathVariable int id){
		return us.getdetails(id);
	}
}
