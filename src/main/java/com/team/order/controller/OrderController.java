package com.team.order.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team.exception.FindException;
import com.team.order.entity.Order;
import com.team.order.service.OrderService;
import com.team.user.entity.Customer;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;
	
	@GetMapping("/orderlist")
	public Object orderlist(HttpSession session) throws FindException {
//		Customer c = (Customer)session.getAttribute("userId");
		Customer c = new Customer();
		c.setUserNo(1);
		
		List<Order> list = service.myOrderProjects(c.getUserNo());
		return list;
	}
	
	@PostMapping("/order")
	public Object orderReward(@RequestBody Order order) {
		Map<String, Object> returnMap = new HashMap<>();
		
		order.setOrderResult("진행중");

		if( 1 != order.getOrderUser().getUserNo()) {
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
