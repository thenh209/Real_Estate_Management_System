package com.project.Property_Details.Controller;

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

import com.project.Property_Details.Model.PropModel;
import com.project.Property_Details.Service.PropService;
import com.project.UserHistory.Model.HistoryModel;

@RestController
public class PropController {

	@Autowired
	PropService ps;
	
	@PostMapping("addproperty")
	public PropModel add(@RequestBody  PropModel pm)
	{
		return ps.saveinfo(pm);
	}
	
	@GetMapping("getproperty")
	public ResponseEntity<PropModel> show(@RequestParam int id) {
	    PropModel prop = ps.getPropById(id);
	    
	    if (prop != null) {
	        return new ResponseEntity<>(prop,HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@GetMapping("getPropertyByUserId")
    public ResponseEntity<List<PropModel>> showprop(@RequestParam int id) {
        List<PropModel> list = ps.getPropertyByOwnerId(id);
        
        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	@PutMapping("updateproperty")
	public String modifybyid(@RequestParam int id,@RequestBody PropModel um)
	{
		return ps.changeinfobyid(id,um);	
	}
	
	@DeleteMapping("deleteproperty")
	public String deleteMyParamId(@RequestParam int id)
	{
		return (ps.deleteid(id)); 
	}
}
