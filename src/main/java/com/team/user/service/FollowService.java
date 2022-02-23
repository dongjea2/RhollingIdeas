package com.team.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.user.entity.Customer;
import com.team.user.entity.Follow;
import com.team.user.repository.FollowRepository;

@Service
public class FollowService {
	@Autowired
	private FollowRepository repository;
	
	public List<Follow> following(Customer c) {
		return repository.findByUserNo(c);
	}
	
	public List<Follow> followers(Customer c) {
		return repository.findByFollow(c);
	}
}
