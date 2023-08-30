package com.project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.project.Models.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer>{
	@Query(value="select * from user_details where user_id=:id",nativeQuery=true)
	public List<UserModel> getInfo(@Param("id") int id);
	
}
