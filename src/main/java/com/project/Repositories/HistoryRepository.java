package com.project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Models.HistoryModel;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryModel,Integer>{

	List<HistoryModel> findAllByUserId(int userId);

}
