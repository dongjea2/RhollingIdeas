package com.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.reposiroty.CategoryRepository;

@SpringBootTest
public class Test {

	
	@Autowired
	CategoryRepository cr;
	
	
	@org.junit.jupiter.api.Test
	public void t1() {
		cr.findAll();
	}

}
