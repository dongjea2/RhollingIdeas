package com.team.project.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.project.service.ProjectService;

@SpringBootTest
public class RewardTest {
	
	@Autowired
	ProjectService projectService;
	
	@Test
	public void rewardTest() {
		projectService.findByRewardNo(1);
	}

}
