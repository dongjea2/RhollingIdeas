package com.team.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.user.repository.FollowRepository;

@Service
public class FollowService {
	@Autowired
	private FollowRepository repository;
}
