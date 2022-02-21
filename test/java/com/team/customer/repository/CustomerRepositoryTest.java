package com.team.customer.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.user.entity.Customer;
import com.team.user.repository.CustomerRepository;

@SpringBootTest
class CustomerRepositoryTest {

	@Autowired
	CustomerRepository repo;
	
	@Test
	void testFind() {
		//repo.findAll();
		//repo.findById(2);
		//repo.findByUserNo(1);
		Customer c = repo.findByUserId("id1");
		System.out.println(c.getUserPwd());
	}
	
	@Test
	void testUpdate() {
		//repo.findAll();
		Optional<Customer> optC = repo.findById(1);
		if(optC.isPresent()) {
			Customer c = optC.get();
			c.setUserName("류하정(수정)");
			repo.save(c);
		}
	}
	
	@Test
	void testSave() {
		Customer c = new Customer();
		c.setUserId("testId");
		c.setUserName("테스터");
		c.setUserPwd("pwd");
		c.setUserUrl("testUrl");
		repo.save(c);
	}
	
	@Test
	void testDelete() {
		repo.deleteById(38);
	}

}
