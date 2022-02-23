package com.team.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.post.entity.Post;
import com.team.post.service.PostService;
import com.team.project.entity.Project;

@RestController
@RequestMapping("/projectdetail")
public class PostController {

	@Autowired
	private PostService service;
	
	@GetMapping("/post/{projectNo}")
	public Object post(@PathVariable(name = "projectNo")int projectNo) {
		
		Project project = new Project();
		project.setProjectNo(projectNo);
		
		return service.findByProject(project);
	}
	
	@PostMapping("/post")
	public Object postwrite(@RequestBody Post p) {
		
		System.out.println(p.getPostContent());
		System.out.println(p.getProject().getProjectNo());
		System.out.println(p.getMaker().getUserNo());
		
		return service.postwrite(p);
	}
	
	
}
