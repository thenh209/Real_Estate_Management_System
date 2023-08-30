package com.project.Services;

import java.util.List; 
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.project.Models.PropModel;
import com.project.Repositories.PropRepository;

@Service
public class PropService {
	
	@Autowired
	PropRepository pr;
	
	public PropModel saveinfo(PropModel pm)
	{
		return pr.save(pm);
	}
	
	public PropModel getPropById(int id) {
		Optional<PropModel> propOptional = pr.findById(id);
        return propOptional.orElse(null);
	}
	
	public String changeinfobyid(int id,PropModel um)
	{
		if(pr.existsById(id))
		{
			pr.saveAndFlush(um);
			return "Updated";
		}
		else
		{
			return "Enter Valid Id";
		}
	}
	
	public String deleteid(int id)
	{
		if(pr.existsById(id))
		{
			pr.deleteById(id);
			return "Deleted";
		}
		else
		{
			return "Enter Valid Id";
		}
	}
	
	public List<PropModel> getPages(int pno, int psize, String field)
	{
		Sort ord = Sort.by(Sort.DEFAULT_DIRECTION,field);
		Page<PropModel> b = pr.findAll(PageRequest.of(pno, psize,ord));
		return b.getContent();
		
	}
}
