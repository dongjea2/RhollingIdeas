package com.team.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.team.project.entity.Project;
import com.team.project.entity.ProjectChange;

public interface ProjectChangeRepository extends CrudRepository<ProjectChange, Integer> {
	ProjectChange findByProjectNo(int id);
}
