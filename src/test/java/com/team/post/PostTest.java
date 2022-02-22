package com.team.post;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.post.entity.Post;
import com.team.post.repository.PostRepository;
import com.team.project.entity.Project;
import com.team.project.entity.ProjectChange;
import com.team.user.entity.Customer;

@SpringBootTest
class PostTest {

	@Autowired
	PostRepository PostRepository;
	
	@Test
	void testAdd() {
		Post post = new Post(); 
		
		Project project = new Project();
		project.setProjectNo(1);
		
		Customer maker = new Customer();
		maker.setUserNo(1);
		
		post.setPostNo(2);
		post.setPostContent("내용");
		
		post.setProject(project);
		post.setMaker(maker);
		
		PostRepository.save(post);
	}
	
	@Test
	void testfind() {
		PostRepository.findAll();
	}
	
	@Test
	void testfindbypjno() {
		
		Project project = new Project();
		project.setProjectNo(1);
		
		PostRepository.findByProject(project);
	}
	
	
	

}
