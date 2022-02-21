package com.team.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.exception.FindException;
import com.team.user.entity.Customer;
import com.team.user.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	public Customer login(String userId, String userPwd) {
		Customer c = customerRepo.findByUserId(userId);
		if(c!=null && c.getUserPwd().equals(userPwd)) {
			return c;
		}
		return null;
	}
}
