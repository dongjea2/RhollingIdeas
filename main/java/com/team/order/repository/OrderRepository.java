package com.team.order.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team.order.entity.Order;
import com.team.user.entity.Customer;

public interface OrderRepository extends CrudRepository<Order, Integer> {
	/**
	 * 유저번호가 가지고 있는 주문정보를 반환한다
	 * @param c 유저객체
	 * @return 주문정보객체들
	 */
	public List<Order> findByOrderUser(Customer c);

}
