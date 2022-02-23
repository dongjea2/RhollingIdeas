package com.team.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.team.project.entity.Reward;
import com.team.project.service.ProjectService;

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

	@GetMapping("/mainpage")
	public Object mainpage() {
		Map<String, Object> returnMap = new HashMap<>();


		return returnMap;
	}
	
	
	
	
}
