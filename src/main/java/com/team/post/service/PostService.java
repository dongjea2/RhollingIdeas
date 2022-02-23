package com.team.post.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.post.entity.Post;
import com.team.post.repository.PostRepository;
import com.team.project.entity.Project;
import com.team.project.repository.ProjectRepository;
import com.team.user.entity.Customer;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	@Autowired
	private ProjectRepository projectrepo;
	
	public List<Post> findByProject(Project projectNo){
		return repository.findByProject(projectNo);
	}
	
	public Post postwrite(Post p) {
		Post post = new Post();
		
//		Project prodno = projectrepo.findByProjectNo(p.getProject().getProjectNo());

//		Project prodno = new Project();
//		prodno.setProjectNo(p.getProject().getProjectNo());
//		prodno.setEndDate(new Date());
		
		post.setProject(p.getProject());
		
		post.setMaker(p.getMaker());
		
		post.setPostNo(p.getPostNo());
		post.setPostContent(p.getPostContent());
		post.setPostDate(p.getPostDate());
		
		
		return repository.save(post);
	}
}
