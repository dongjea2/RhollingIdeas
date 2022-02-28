package com.team.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.exception.FindException;
import com.team.order.entity.Order;
import com.team.order.entity.OrderDTO;
import com.team.order.service.OrderService;
import com.team.user.entity.Customer;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;
	
	@GetMapping("/orderlist")
	public Object orderlist(HttpSession session) throws FindException {
		Customer c = (Customer)session.getAttribute("loginInfo");
		
		if(c != null) {
			List<OrderDTO> list = service.myOrderProjects(c);	
			return list;
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//TODO: 나중에 세션에서 유저NO읽어오기
	@PostMapping("/order")
	public Object orderReward(@RequestBody Order order, HttpSession s) {
		Customer loginUser =(Customer)s.getAttribute("loginInfo");
		if(loginUser == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Map<String, Object> returnMap = new HashMap<>();
		System.out.println("카드번호"+order.getCard().getCardNum());
		System.out.println("주소:"+order.getAddress().getAddressNo());

		if( loginUser.getUserNo() != order.getOrderUser().getUserNo()) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		
		try {
			order.setOrderResult("진행중");
			service.add(order);
		} catch (FindException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		returnMap.put("status", 1);
		returnMap.put("msg", "구매 성공");
		return returnMap;
	}
	
}
