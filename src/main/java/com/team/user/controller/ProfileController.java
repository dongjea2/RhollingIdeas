package com.team.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.user.dto.ProfileIntroDTO;
import com.team.user.dto.ProfileOrderDTO;
import com.team.user.entity.Customer;
import com.team.user.service.ProfileService;

@RestController
@RequestMapping("/profile")
public class ProfileController {
	
	@Autowired
	private ProfileService service;
	
	@GetMapping("/{userUrl}")
	public ProfileIntroDTO profile(@PathVariable String userUrl, HttpSession session) {
		Customer c = (Customer)session.getAttribute("loginInfo");
		if(c != null) {
			ProfileIntroDTO dto = service.findProfileByUserUrl(userUrl, c);
			return dto;
		}else {
			ProfileIntroDTO dto = service.findProfileByUserUrl(userUrl);
			return dto;
		}
	}
	
	@GetMapping("/order")
	public Object profileorder(HttpSession session) {
		Customer c = (Customer)session.getAttribute("loginInfo");
		if(c != null) {
			return service.findProfileOrder(c);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
}
