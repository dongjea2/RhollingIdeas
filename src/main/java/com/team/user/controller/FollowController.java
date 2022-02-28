package com.team.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.user.dto.FollowDTO;
import com.team.user.entity.Customer;
import com.team.user.entity.Follow;
import com.team.user.service.FollowService;

@RestController
//@RequestMapping("/following")
public class FollowController {
	@Autowired
	private FollowService service;
	
	@GetMapping("/following")
	public Object following(HttpSession session) {
		Customer c = (Customer) session.getAttribute("loginInfo");
		
		if(c != null) {
			return service.following(c);

		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/followers")
	public Object followers(HttpSession session) {
		Customer c = (Customer) session.getAttribute("loginInfo");
		
		if(c != null) {
			return service.followers(c);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * 팔로우 되어있는지 확인해서 삭제, 저장
	 * @param f
	 */
	@PostMapping("/editfollow")
	public void editfollow(@RequestBody Follow f) {
		if(service.checkFollow(f) == true) {
			service.deleteFollow(f);
		}else {
			service.saveFollow(f);
		}
	}
}
