package com.team.interest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.exception.FindException;
import com.team.interest.entity.Interest;
import com.team.interest.service.InterestService;
import com.team.user.entity.Customer;

@RestController
public class InterestController {
	@Autowired
	private InterestService service;
	
	@GetMapping("/interestlist")
	public List<Interest> interestlist(HttpSession session) {
//		Customer c = (Customer)session.getAttribute("userId");
		Customer c = new Customer();
		c.setUserNo(1);
		
		List<Interest> list = service.myInterestProjects(c);
		return list;
	}
	
	@GetMapping("/prelaunchedlist")
	public List<Interest> prelaunchedlist(HttpSession session) {
//		Customer c = (Customer)session.getAttribute("userId");
		Customer c = new Customer();
		c.setUserNo(1);
		
		List<Interest> list = service.myAlarmProjects(c);
		return list;
	}
}
