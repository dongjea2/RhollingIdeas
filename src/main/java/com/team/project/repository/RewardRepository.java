package com.team.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.team.project.entity.Reward;

public interface RewardRepository extends CrudRepository<Reward, Integer> {
	Reward findByRewardNo(int rewardNo);
}
