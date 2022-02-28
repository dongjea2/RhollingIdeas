package com.team.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.team.user.dto.ProfileIntroDTO;
import com.team.user.service.ProfileService;

@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@GetMapping("/profile/{userUrl}")
	public ProfileIntroDTO profile(@PathVariable String userUrl) {
		ProfileIntroDTO dto = service.findByUserUrl(userUrl);
		return dto;
	}

}
