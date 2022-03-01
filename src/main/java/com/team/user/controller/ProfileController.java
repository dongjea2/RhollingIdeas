package com.team.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.team.user.dto.ProfileIntroDTO;
import com.team.user.entity.Customer;
import com.team.user.service.ProfileService;

@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@GetMapping("/profile/{userUrl}")
	public ProfileIntroDTO profile(@PathVariable String userUrl, HttpSession session) {
		Customer c = (Customer)session.getAttribute("loginInfo");
		
		ProfileIntroDTO dto = service.findByUserUrl(userUrl, c);
		return dto;
	}

}
