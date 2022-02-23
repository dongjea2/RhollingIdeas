package com.team.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.exception.FindException;
import com.team.order.entity.Order;
import com.team.order.repository.OrderRepository;
import com.team.user.entity.Customer;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	/**
	 * 주문정보를 추가한다
	 * @param order 주문객체
	 * @throws FindException
	 */
	public void add(Order order) throws FindException {
		repository.save(order);
	}
	
	/**
	 * 주문번호를 통해 주문정보를 불러온다
	 * @param order_no 주문번호
	 * @return 주문정보
	 * @throws FindException
	 */
	public Order findByOrderNo(int order_no) throws FindException {
		try {
			Optional<Order> optP = repository.findById(order_no);
			Order p = new Order();
			if(optP.isPresent()) {
				p = optP.get();
				return p;
			}
			throw new FindException();
		} catch(Exception e) {
			throw new FindException("주문번호에 해당하는 주문정보를 불러오는데 실패했습니다.");
		}
	}
	
	/**
	 * 사용자가 주문한 목록을 반환한다
	 * @param userNo 유저번호
	 * @return 주문한 목록들
	 * @throws FindException
	 */
	public List<Order> myOrderProjects(int userNo) throws FindException{
		Customer c = new Customer();
		c.setUserNo(userNo);
		
		List<Order> orders = new ArrayList<>();
		orders = repository.findByOrderUser(c);
		return orders;
	}
}
