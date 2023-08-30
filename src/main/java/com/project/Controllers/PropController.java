package com.project.Controllers;

import java.util.List; 

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
import com.project.Models.PropModel;
import com.project.Services.PropService;

@RestController
public class PropController {

	@Autowired
	PropService ps;
	
	@PostMapping("addProperty")
	public PropModel add(@RequestBody  PropModel pm)
	{
		return ps.saveinfo(pm);
	}
	
	@GetMapping("getProperty")
	public ResponseEntity<PropModel> show(@RequestParam int id) {
	    PropModel prop = ps.getPropById(id);
	    
	    if (prop != null) {
	        return new ResponseEntity<>(prop,HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@PutMapping("updateProperty")
	public String modifybyid(@RequestParam int id,@RequestBody PropModel um)
	{
		return ps.changeinfobyid(id,um);	
	}
	
	@DeleteMapping("deleteProperty")
	public String deleteMyParamId(@RequestParam int id)
	{
		return (ps.deleteid(id)); 
	}
	
	@GetMapping("sortPageForProperty")
	public List<PropModel> sortPages(@RequestParam(value = "pNo") int pNo, @RequestParam(value = "pSize") int pSize,@RequestParam(value = "field") String field)
	{
		return ps.getPages(pNo, pSize, field);
	}
}
