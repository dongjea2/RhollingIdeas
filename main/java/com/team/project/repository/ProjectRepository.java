package com.team.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.team.project.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
	Project findByProjectNo(int id);
}
