package com.project.Property_Details.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Property_Details.Model.PropModel;
import com.project.Property_Details.Repository.PropRepository;
import com.project.UserHistory.Model.HistoryModel;

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
	public List<PropModel> getPropertyByOwnerId(int id) {
        return pr.findAllByOwnerId(id);
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
}
