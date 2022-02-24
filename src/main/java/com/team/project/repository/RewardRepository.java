package com.team.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team.project.entity.Project;
import com.team.project.entity.Reward;

public interface RewardRepository extends CrudRepository<Reward, Integer> {
	Reward findByRewardNo(int rewardNo);
	
	List<Reward> findByProject(Project p);
}
