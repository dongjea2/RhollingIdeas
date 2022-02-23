package com.team.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.project.entity.Reward;
import com.team.project.repository.ProjectRepository;
import com.team.project.repository.RewardRepository;

@Service
public class ProjectService {
	
	@Autowired
	private RewardRepository rewardRepository;

	@Autowired
	private ProjectRepository projectRepository;
	
	public Reward findByRewardNo(int rewardNo) {
		return rewardRepository.findByRewardNo(rewardNo);
	}

}
