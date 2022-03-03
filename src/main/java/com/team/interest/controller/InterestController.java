package com.team.interest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Object interestlist(HttpSession session) {
		Customer c = (Customer)session.getAttribute("loginInfo");
		
		if(c != null) {
			return service.findInterestProjects(c);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/prelaunchedlist")
	public Object prelaunchedlist(HttpSession session) {
		Customer c = (Customer)session.getAttribute("loginInfo");
		
		if(c != null) {
			return service.findAlarmProjects(c);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/interest")
	public Object addInterest(@RequestBody Interest interest ,HttpSession s) {
		Map<String, Object> returnMap = new HashMap<>();

		if(service.addInterest(interest,(Customer) s.getAttribute("loginInfo"))) {
			returnMap.put("status", 1);
			returnMap.put("msg", "좋아요 추가 성공");
			return returnMap;
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/interest")
	public Object deleteInterest(@RequestBody Interest interest , HttpSession s) {
		Map<String, Object> returnMap = new HashMap<>();
		
		if(service.deleteInterest(interest, (Customer)s.getAttribute("loginInfo"))) {
			returnMap.put("status", 1);
			returnMap.put("msg", "좋아요 삭제 성공");
			return returnMap;
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
