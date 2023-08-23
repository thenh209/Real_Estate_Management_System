package com.project.UserHistory.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.project.UserHistory.Model.HistoryModel;
import com.project.UserHistory.Service.HistoryService;

@RestController
public class HistoryController {

	@Autowired
	HistoryService hs;
	
	@PostMapping("addhistory")
	public HistoryModel add(@RequestBody  HistoryModel hm)
	{
		return hs.saveinfo(hm);
	}
	
	@GetMapping("gethistory")
    public ResponseEntity<List<HistoryModel>> show(@RequestParam int id) {
        List<HistoryModel> historyList = hs.getHistoryByUserId(id);
        
        if (!historyList.isEmpty()) {
            return new ResponseEntity<>(historyList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
