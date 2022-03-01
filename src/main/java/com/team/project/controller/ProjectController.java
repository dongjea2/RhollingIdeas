package com.team.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.project.dto.CreatedProjectDTO;
import com.team.project.dto.ProjectDTO;
import com.team.project.entity.Category;
import com.team.project.entity.Project;
import com.team.project.entity.Reward;
import com.team.project.repository.RequestDataSelector;
import com.team.project.service.ProjectService;
import com.team.user.entity.Customer;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

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
	

	//DTO사용 코드
	@GetMapping("/project/{projectNo}")
	public Object getProject(@PathVariable(name = "projectNo")int projectNo, HttpSession s) {
		return service.findByProjectNo(projectNo, (Customer)s.getAttribute("loginInfo"));
	}

	@PostMapping("/discover")
	public Object discover(HttpSession s, @RequestBody RequestDataSelector rds) {
		return service.findByRDS(rds, (Customer)s.getAttribute("loginInfo"));
	}
	
	
	@GetMapping("/mainpage")
	public Object mainpage(HttpSession s) {
		Map<String, Object> returnMap = new HashMap<>();
		RequestDataSelector rds = new RequestDataSelector();
		rds.setLimit(8);
		returnMap.put("attention", service.findByRDS(rds, (Customer)s.getAttribute("loginInfo")));
		rds.setLimit(3);
		returnMap.put("advertise", service.findByRDS(rds, (Customer)s.getAttribute("loginInfo")));

		return returnMap;
	}

	@PostMapping("/projectwrite")
	public Object projectwrite(Project p) {
		return service.save(p);
	}

	
	@GetMapping("/created")
	public Object createdprojects(HttpSession session) {
		Customer c = (Customer)session.getAttribute("loginInfo");
//		Customer c = new Customer();
//		c.setUserNo(1);
		
		if(c != null) {
			List<CreatedProjectDTO> list = service.createdProject(c);
			return list;
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/category")
	public List<Category> categorylist(){
		List<Category> category = service.findAllCategory();
		return category;
	}
	

}
