package com.team.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team.project.entity.Project;
import com.team.user.entity.Customer;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
	Project findByProjectNo(int id);

	List<Project> findByMaker(Customer c);
	
}
