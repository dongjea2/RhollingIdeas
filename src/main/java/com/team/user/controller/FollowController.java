package com.team.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.user.entity.Customer;
import com.team.user.entity.Follow;
import com.team.user.service.FollowService;

@RestController
@RequestMapping("/following")
public class FollowController {
	@Autowired
	private FollowService service;
	
	@GetMapping("")
	public List<Follow> following(HttpSession session) {
		//Customer c = (Customer)session.getAttribute("loginInfo");
		Customer c = new Customer();
		c.setUserNo(1);
		
//		if(c != null) {
//
//		}
		List<Follow> list = service.following(c);
		return list;
	}
	
	@GetMapping("/followers")
	public List<Follow> followers(HttpSession session) {
		Customer c = new Customer();
		c.setUserNo(1);
		
		List<Follow> list = service.followers(c);
		return list;
	}
}
