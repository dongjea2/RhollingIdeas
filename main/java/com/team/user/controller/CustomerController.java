package com.team.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.user.entity.Customer;
import com.team.user.service.CustomerService;

@RestController
//@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/login")
	public Object login(@RequestBody Customer customer) {
		System.out.println(customer);
		Map<String, Object> returnMap = new HashMap<>();
		Customer c = service.login(customer.getUserId(), customer.getUserPwd());
		if(c==null) {
			returnMap.put("status", 0);
			returnMap.put("msg", "로그인 실패. 아이디나 비밀번호를 확인해주세요");
		} else { //아이디와 비밀번호가 db와 일치
			if(c.getUserStatus().equals("0")) { //회원정보는 일치하지만 계정탈퇴상태
				returnMap.put("status", 2);
				returnMap.put("msg", "탈퇴한 계정입니다");
			} else {
				returnMap.put("status", 1);
			}
		}
		return returnMap;
	}
}
