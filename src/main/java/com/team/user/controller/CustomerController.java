package com.team.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.user.entity.Customer;
import com.team.user.service.CustomerService;

@RestController
//@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@RequestMapping("/login")
	public Object login(@RequestBody Customer c, HttpSession session) {
		session.removeAttribute("loginInfo");
		Map<String, Object> returnMap = new HashMap<>();
		Customer c2 = service.login(c.getUserId(), c.getUserPwd());
		if(c2==null) {
			returnMap.put("status", 0);
			returnMap.put("msg", "로그인 실패. 아이디나 비밀번호를 확인해주세요");
		} else { //아이디와 비밀번호가 db와 일치
			if(c2.getUserStatus().equals("0")) { //회원정보는 일치하지만 계정탈퇴상태
				returnMap.put("status", 2);
				returnMap.put("msg", "탈퇴한 계정입니다");
			} else {
				//백 세션
				session.setAttribute("loginInfo", c2);
				//프론트 세션
				returnMap.put("status", 1);
				returnMap.put("loginedId", c2.getUserId());
				returnMap.put("userNo", c2.getUserNo());
				returnMap.put("userUrl", c2.getUserUrl());
				returnMap.put("userName", c2.getUserName());
			}
		}
		return returnMap;
	}
	@RequestMapping("/logout")
	public void logout(HttpSession session) {
		session.removeAttribute("loginInfo");
		session.invalidate();
	}
	@RequestMapping("/iddupchk")
	public Object iddupchk(@RequestBody Customer c) {
		Map<String, Object> returnMap = new HashMap<>();
		Customer c2 = service.findByUserId(c.getUserId());
		if(c2 != null) {
			returnMap.put("status", 0);
			returnMap.put("msg", "이미 존재하는 아이디입니다");
		} else {
			returnMap.put("status", 1);
			returnMap.put("msg", "사용할 수 있는 아이디입니다");
		}
		return returnMap;
	}
	
	@PostMapping("/signup")
	public Object signup(@RequestBody Customer c) {
		Map<String, Object> returnMap = new HashMap<>();
		Customer c2 = service.findByUserId(c.getUserId());
		if(c2 == null) {
			service.signup(c.getUserName(), c.getUserId(), c.getUserPwd());
			returnMap.put("status", 1);
			returnMap.put("msg", "가입성공");
		} else {
			returnMap.put("status", 0);
			returnMap.put("msg", "가입실패");
		}
		return returnMap;
	}
}
