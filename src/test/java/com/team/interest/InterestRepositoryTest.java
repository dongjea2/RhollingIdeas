package com.team.interest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.interest.repository.InterestRepository;
import com.team.project.entity.Project;
import com.team.user.entity.Customer;

@SpringBootTest
class InterestRepositoryTest {
	@Autowired
	private InterestRepository repository;
	@Test
	void testFindAll() {
		repository.findAll();
	}
	@Test
	void testFindInterest() {
		Customer c = new Customer();
		c.setUserNo(1);
		repository.findByLikeUserAndInterestAlarm(c, "A");
	}
	
	@Test
	void findByPK() {
		Customer c = new Customer();
		c.setUserNo(1);
		Project p = new Project();
		p.setProjectNo(4);
		
		repository.findByLikeProjectAndLikeUser(p, c);
		
	}
}
