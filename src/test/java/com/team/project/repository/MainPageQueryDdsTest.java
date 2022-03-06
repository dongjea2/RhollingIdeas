package com.team.project.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team.project.entity.Project;


@SpringBootTest
public class MainPageQueryDdsTest {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	@Autowired
	QueryRepository qr;

	RequestDataSelector rds;


	//TODO:: 이넘 사용한 거 적용시키기
	//1.신규 프로젝트
	@Test
	public void newRelease() {
		rds = new RequestDataSelector();
		rds.setOngoing("onGoing");

		
		getNames(qr.findByRequestData(rds));
		
	}

	//2. 공개 예정 프로젝트
	@Test
	public void preLaunch() {
		rds = new RequestDataSelector();
		rds.setOngoing("preLaunch");
		rds.setSort("likeCnt");
		
		getNames(qr.findByRequestData(rds));
		
	}

	
	//3. 마감임박 프로젝트
	@Test
	public void endCome() {
		rds = new RequestDataSelector();
		rds.setOngoing("onGoing");
		rds.setSort("endCome");
		
		getNames(qr.findByRequestData(rds));
		
	}
	
	
	//4. 인기 프로젝트
	@Test
	public void popular() {
		rds = new RequestDataSelector();
		rds.setOngoing("onGoing");
		rds.setSort("likeCnt");
		
		getNames(qr.findByRequestData(rds));
		
	}
	
	
	//5. 주목할만한  프로젝트
	@Test
	public void attention() {
		rds = new RequestDataSelector();
		rds.setOngoing("onGoing");
		rds.setAchiveRate();
		
		getNames(qr.findByRequestData(rds));
		
	}
	
	
	public void getNames(List<Project> list) {
		for(Project p : list) {
			//log.info("제목: "+p.getLongTitle());
			System.out.println("제목 : "+p.getLongTitle());
		}
	}
}
