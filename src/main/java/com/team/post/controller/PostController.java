package com.team.post.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.post.entity.Post;
import com.team.post.service.PostService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/projectdetail")
public class PostController {

	@Autowired
	private PostService service;
	
	@GetMapping("/post/{}")
	public Object post(@RequestBody Post p) {
	
		return service.findByProject(p.getProject());
	}
}
