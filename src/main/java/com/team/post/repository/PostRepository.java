package com.team.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.team.post.entity.Post;
import com.team.project.entity.Project;

public interface PostRepository extends CrudRepository<Post, Integer> {
	
	public List<Post> findByProject(Project projectNo);
	
}
