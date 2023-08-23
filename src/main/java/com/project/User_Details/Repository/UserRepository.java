package com.project.User_Details.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.User_Details.Model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer>{
}
