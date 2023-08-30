package com.project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Models.PropModel;

@Repository
public interface PropRepository extends JpaRepository<PropModel,Integer>{


}
