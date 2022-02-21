package com.team.user.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.user.entity.Customer;
import com.team.user.entity.Follow;
import com.team.user.entity.FollowId;

@SpringBootTest
class FollowRepositoryTest {
	
	@Autowired
	private FollowRepository repository;
	
	@Test
	void testFindAll() {
		System.out.println("repository.findAll().toString(): "+repository.findAll().toString());
	}

	@Test
	void testFindById() {
		FollowId id = new FollowId();
		id.setUserNo(1);
		id.setFollow(2);
		
		repository.findById(id);
	}
	
	@Test
	void testFindByUserNo() {
		Customer c3 = new Customer();
		c3.setUserNo(3);
		
		repository.findByUserNo(c3);
	}
	
	@Test
	void testSave() {
		Customer c1 = new Customer();
		c1.setUserNo(1);
		
		Customer c2 = new Customer();
		c2.setUserNo(2);
		
		Follow follow = new Follow();
		follow.setUserNo(c1);
		follow.setFollow(c2);
		
		repository.save(follow);
	}
}
