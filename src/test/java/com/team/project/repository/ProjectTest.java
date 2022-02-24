package com.team.project.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team.project.entity.Project;
import com.team.project.entity.ProjectChange;
import com.team.project.entity.QCategory;
import com.team.user.entity.Customer;

@SpringBootTest
public class ProjectTest {
	
	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	ProjectChangeRepository projectChangeRepository;
	
	//좋아요 + 1 추가
	@Test
	public void Test1() {
		ProjectChange pc = projectChangeRepository.findByProjectNo(1);
		System.out.println("프로젝트pc 번호 :"+pc.getProjectNo());
		
		pc.setProjectLikeCnt(pc.getProjectLikeCnt()+1);
		projectChangeRepository.save(pc);
	}

	@Test
	public void Test2() {
		Project p = projectRepository.findByProjectNo(1);
		p.setProjectBrief("테스트코드 3입니다. Fethc");
		
		p.getProjectChange().setProjectLikeCnt(400);
		
	
		projectRepository.save(p);
		
		
		
	}

	
	
	
	//프로젝트(고정) 내용수정
	@Test
	public void Test3() {
		ProjectChange pc = projectChangeRepository.findByProjectNo(1);
		System.out.println("프로젝트pc 번호 :"+pc.getProjectNo());

		//프로젝트 체인지의 프로젝트를 가져옴
		Project p = pc.getProject();
		
		//가져온 프로젝트의 설명을 수정
		p.setProjectBrief("테스트체크입니다.");
		System.out.println("테스트 설명값 : "+p.getProjectBrief());

		pc.setProject(p);
		p.setProjectChange(pc); 

		projectChangeRepository.save(pc);
	}
	
	@Autowired
	EntityManager em;
	
	QCategory c = QCategory.category;
	
	@Test
	public void queryDSL(){
		
		JPAQueryFactory query = new JPAQueryFactory(em);

		
	
		query.select(c)
				.from(c)
				.where(c.categoryNo.gt(5))
				.fetch();

		query.selectFrom(c)
				.where(cate(2))
				.fetch();
		
    }
	
	public BooleanExpression cate(int a) {
		if (a==1) {
			return c.categoryNo.gt(5);
		}else if(a==2) {
			return c.categoryNo.gt(10);
		}
		return null;
	}
	
	@Test
	public void testCreatedProject() {
		Customer c = new Customer();
		c.setUserNo(1);
		
		projectRepository.findByMaker(c);
	}

}
