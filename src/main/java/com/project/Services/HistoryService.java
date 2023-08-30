package com.project.Services;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.Models.HistoryModel;
import com.project.Repositories.HistoryRepository;

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
	
	public List<HistoryModel> getPages(int pno, int psize, String field)
	{
		Sort ord = Sort.by(Sort.DEFAULT_DIRECTION,field);
		Page<HistoryModel> b = hr.findAll(PageRequest.of(pno, psize,ord));
		return b.getContent();
		
	}
}
