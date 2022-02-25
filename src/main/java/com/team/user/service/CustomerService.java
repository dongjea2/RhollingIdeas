package com.team.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.user.entity.Customer;
import com.team.user.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	public Customer findByUserNo(int userNo) {
		return customerRepo.findByUserNo(userNo);
	}
	
	public Customer findByUserId(String userId) {
		return customerRepo.findByUserId(userId);
	}
	
	public Customer login(String userId, String userPwd) {
		Customer c = customerRepo.findByUserId(userId);
		if(c!=null && c.getUserPwd().equals(userPwd)) {
			return c;
		}
		return null;
	}
	
	public void signup(String userName, String userId, String userPwd) {
		Customer c2 = new Customer(userName, userId, userPwd);
		customerRepo.save(c2);
	}
	
	public void profileSet(Customer customer) {
		customerRepo.save(customer);
	}

	/**
	 * userUrl로 유저정보 찾기
	 * @param userUrl
	 * @return 유저정보
	 */
	public Customer findByUserUrl(String userUrl) {
		return customerRepo.findByUserUrl(userUrl);
	}
}
