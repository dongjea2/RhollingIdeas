package com.team.interest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InterestRepositoryTest {
	@Autowired
	private InterestRepository repository;
	@Test
	void testFindAll() {
		repository.findAll();
	}

}
