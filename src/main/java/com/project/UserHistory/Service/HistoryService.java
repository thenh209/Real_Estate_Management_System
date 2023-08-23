package com.project.UserHistory.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.UserHistory.Model.HistoryModel;
import com.project.UserHistory.Repository.HistoryRepository;

@Service
public class HistoryService {

	@Autowired
	HistoryRepository hr;
	
	public HistoryModel saveinfo(HistoryModel hm)
	{
		return hr.save(hm);
	}
	
	public List<HistoryModel> getHistoryByUserId(int userId) {
        return hr.findAllByUserId(userId);
    }
}
