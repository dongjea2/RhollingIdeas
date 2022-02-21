package com.team.order.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.order.repository.OrderRepository;

@SpringBootTest
class OrderRepositoryTest {
	
	@Autowired
	private OrderRepository repository;
	
	@Test
	void testFind() {
		repository.findAll();
	}
}
