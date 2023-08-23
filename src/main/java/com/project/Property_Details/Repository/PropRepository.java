package com.project.Property_Details.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.Property_Details.Model.PropModel;

@Repository
public interface PropRepository extends JpaRepository<PropModel,Integer>{

	List<PropModel> findAllByOwnerId(int id);

}
