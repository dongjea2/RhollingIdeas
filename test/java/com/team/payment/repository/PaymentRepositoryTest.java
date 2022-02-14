package com.team.payment.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentRepositoryTest {
	
	@Autowired
	private PaymentRepository repository;
	
	@Test
	void testFind() {
		repository.findAll();
	}
}
