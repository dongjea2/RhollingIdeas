package com.team.post.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.post.entity.Post;
import com.team.post.repository.PostRepository;
import com.team.project.entity.Project;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Iterable<Post> findAll(){
		return repository.findAll();
	}
	
	public List<Post> findByProject(Project projectNo){
		return repository.findByProject(projectNo);
	}
	
}
