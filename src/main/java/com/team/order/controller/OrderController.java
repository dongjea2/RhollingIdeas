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
	public Object orderReward(@RequestBody Order order) {
		Map<String, Object> returnMap = new HashMap<>();
		final int LOGINED_USERNO = 1;
		
		order.setOrderResult("진행중");

		if( LOGINED_USERNO != order.getOrderUser().getUserNo()) {
			returnMap.put("status", 0);
			returnMap.put("msg", "구매 실패, 다시 로그인 해주세요");
			return returnMap;
		} 
		
		try {
			service.add(order);
			returnMap.put("status", 1);
			returnMap.put("msg", "구매 성공");

		} catch (FindException e) {
			returnMap.put("status", 0);
			returnMap.put("msg", "구매 실패, 잘못된 상품 정보");
		}
			return returnMap;
	}
	
}
