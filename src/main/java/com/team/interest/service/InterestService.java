package com.team.interest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.interest.entity.Interest;
import com.team.interest.repository.InterestRepository;
import com.team.user.entity.Customer;

@Service
public class InterestService {
	
	@Autowired
	private InterestRepository repository;
	
	public List<Interest> myInterestProjects(Customer c) {
		return repository.findByLikeUserAndInterestAlarm(c, "I");
	}
	
	public List<Interest> myAlarmProjects(Customer c) {
		return repository.findByLikeUserAndInterestAlarm(c, "A");
	}
}
