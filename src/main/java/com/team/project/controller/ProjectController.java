package com.team.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.project.entity.Category;
import com.team.project.entity.Project;
import com.team.project.entity.ProjectDTO;
import com.team.project.entity.Reward;
import com.team.project.service.ProjectService;
import com.team.user.entity.Customer;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	@GetMapping("/reward/{rewardNo}")
	public Object reward(@PathVariable int rewardNo) {
		Reward reward= service.findByRewardNo(rewardNo);
		Map<String, Object> returnMap = new HashMap<>();

		if(reward ==null) {
			returnMap.put("status", 2);
			returnMap.put("msg", "없는 게시물");
			return returnMap;
		}

		return reward;
	}
	
	/*
	 * @GetMapping("/rewardlist/{projectNo}") public Object
	 * rewardlist(@PathVariable(name = "projectNo")int projectNo){
	 * 
	 * Project project = new Project(); project.setProjectNo(projectNo);
	 * 
	 * return service.findByProjectNo(project); }
	 */
	
	//DTO사용 코드
	@GetMapping("/project/{projectNo}")
	public Object getProject(@PathVariable(name = "projectNo")int projectNo) {
		ProjectDTO project = new ProjectDTO();
		project.entityToDTO(service.findByProjectNo(projectNo));
		project.setLoginedUserProjectInterest(true);
		
		return project;
	}
	
	
	
	

	@GetMapping("/mainpage")
	public Object mainpage() {
		Map<String, Object> returnMap = new HashMap<>();


		return returnMap;
	}

	@PostMapping("/projectwrite")
	public Object projectwrite(Project p) {
		return service.save(p);
	}

	
	@GetMapping("/created")
	public List<Project> createdprojects() {
		//Customer c = (Customer)session.getAttribute("loginInfo");
		Customer c = new Customer();
		c.setUserNo(1);
		
//		if(c != null) {
//
//		}
				
		List<Project> list = service.createdProject(c);
		
		return list;
	}
	
	@GetMapping("/category")
	public List<Category> categorylist(){
		List<Category> category = service.findAllCategory();
		return category;
	}
	
	
}
