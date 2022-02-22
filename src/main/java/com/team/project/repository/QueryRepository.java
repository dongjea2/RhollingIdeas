package com.team.project.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.sound.sampled.Port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.team.interest.entity.QInterest;
import com.team.project.entity.Project;
import com.team.project.entity.QCategory;
import com.team.project.entity.QProject;
import com.team.project.entity.QProjectChange;
import com.team.user.entity.QCustomer;



@Repository
public class QueryRepository {
	@Autowired
	EntityManager em;
	
	QCategory category = QCategory.category;
	QProject project = QProject.project;
	QProjectChange projectChange= QProjectChange.projectChange;
	QCustomer customer = QCustomer.customer;
	QInterest interest = QInterest.interest;
	
	public List<Project> findByRequestData(RequestDataSelector rds){
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		List<Project> pros = query
						.select(project)
						.from(project)
						.where(eqCategory(rds.category)
								,onGoing(rds.ongoing)
								,editorPick(rds.editorPick)
								,achiveRate(rds.achiveRate))
						.fetch();
		return pros;
			
	}
	

	private BooleanExpression eqCategory(int categoryNo) {
		if(categoryNo == 0) {
			return null;
		}
		return category.categoryNo.eq(categoryNo);
	}


	private BooleanExpression onGoing (String onGoing) {
		if(onGoing =="onGoing") {
			return projectChange.projectStatus.eq("승인")
					.and(project.startDate.before(new Date())
					.and(project.endDate.after(new Date())));
		}
		
		if(onGoing =="confirm") {
			return projectChange.projectStatus.eq("승인")
					.and(project.endDate.before(new Date()))
					.and(projectChange.sumPrice.gt(project.targetPrice));
		}
		
		if(onGoing =="prelaunching") {
			return projectChange.projectStatus.eq("승인")
					.and(project.startDate.after(new Date()));
		}
		return null;
	}
	
	
	private BooleanExpression editorPick(int editorPick) {
		if(editorPick == 1) {
			return project.editorPick.eq("1");

		}
		return null;
	}
	
	private BooleanExpression achiveRate(int achiveRate) {
		final int RATE_LESS_THAN_75 =1;
		final int RATE_BETWEEN_75_AND_100=2;
		final int RATE_MORE_THAN_100 =1;

		if( achiveRate == RATE_LESS_THAN_75) {
			return projectChange.sumPrice.divide(project.targetPrice).lt(0.75);
		}
		if( achiveRate == RATE_BETWEEN_75_AND_100) {
			return projectChange.sumPrice.divide(project.targetPrice).between(0.75, 1.00);
		}
		if( achiveRate == RATE_MORE_THAN_100) {
			return projectChange.sumPrice.divide(project.targetPrice).gt(1.00);
			
		}
		
		return null;
	}
	
	private BooleanExpression sort(String sort) {
		//마감임박 프로젝트 일수 ex) 10 = 마감10일전
		final int ENDCOME_DATE= 10;	
		//프로젝트 시작 후 14일까지 신규프로젝트로 취급  //
		final int PUBLISHED_MIN_DAY= 14;
		
		if(sort == "popular") {
		}
		
		if(sort=="pledges"){
			
		}
		
		if(sort=="amount"){
			
		}
		
		if(sort=="publishedAt") {
			
		}
			
		if(sort=="endcome") {
			
		}
		
		if(sort=="startDate") {
			
		}
		
		if(sort=="endDate") {
			
		}

		return null;
	}
}