package com.team.project.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.OrderSpecifier;
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

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EntityManager em;
	
	private QCategory category = QCategory.category;
	private QProject project = QProject.project;
	private QProjectChange projectChange= QProjectChange.projectChange;
	private QCustomer customer = QCustomer.customer;
	private QInterest interest = QInterest.interest;
	
	public List<Project> findByRequestData(RequestDataSelector rds){
		JPAQueryFactory query = new JPAQueryFactory(em);
		
		return query
					.select(project)
					.from(project)
					.where( eqCategory(rds.getCategory())
							,onGoing(rds.getOngoing())
							,editorPick(rds.getEditorPick())
							,achiveRate(rds.getAchiveRate()))
					.orderBy(sort(rds.getSort()))
					.limit(rds.getLimit())
					.fetch();
	}
	


	//BooleanExpressions
	//1.
	private BooleanExpression eqCategory(int categoryNo) {
		if(categoryNo == 0) {
		log.info("[RDS]Not Select categoryNo");
			return null;
		}
		log.info("[RDS]categoryNo : "+categoryNo);
		return category.categoryNo.eq(categoryNo);
	}

	//2.
	private BooleanExpression onGoing (String onGoing) {
		if(onGoing =="onGoing") {
			log.info("[RDS]onGoing");
			return projectChange.projectStatus.eq("승인")
					.and(project.startDate.before(new Date())
					.and(project.endDate.after(new Date())));
		}
		
		if(onGoing =="confirm") {
			log.info("[RDS]confirm");
			return projectChange.projectStatus.eq("승인")
					.and(project.endDate.before(new Date()))
					.and(projectChange.sumPrice.gt(project.targetPrice));
		}
		
		if(onGoing =="preLaunch") {
			log.info("[RDS]preLaunch");
			return projectChange.projectStatus.eq("승인")
					.and(project.startDate.after(new Date()));
		}
		log.info("[RDS]Not Select OnGoing");
		return null;
	}
	
	//3.
	private BooleanExpression editorPick(int editorPick) {
		if(editorPick == 1) {
			log.info("[RDS]editorPick");
			return project.editorPick.eq("1");

		}
		log.info("[RDS]Not Select editorPick");
		return null;
	}
	
	//4.
	private BooleanExpression achiveRate(int achiveRate) {
		final int RATE_LESS_THAN_75 =1;
		final int RATE_BETWEEN_75_AND_100=2;
		final int RATE_MORE_THAN_100 =1;

		if( achiveRate == RATE_LESS_THAN_75) {
			log.info("[RDS]RATE_LESS_THAN_75");
			return projectChange.sumPrice.divide(project.targetPrice).lt(0.75);
		}
		if( achiveRate == RATE_BETWEEN_75_AND_100) {
			log.info("[RDS]RATE_BETWEEN_75_AND_100");
			return projectChange.sumPrice.divide(project.targetPrice).between(0.75, 1.00);
		}
		if( achiveRate == RATE_MORE_THAN_100) {
			log.info("[RDS]RATE_MORE_THAN_100");
			return projectChange.sumPrice.divide(project.targetPrice).gt(1.00);
			
		}
		
		log.info("[RDS]Not Select AchiveRate");
		return null;
	}
	
	
	//orderBy
	/**
	 * 
	 * @param sort("likeCnt")
	 * @return
	 */
	private OrderSpecifier<?> sort(String sort) {
	
		if(sort == "likeCnt") {
			log.info("[RDS]likeCnt");
			return projectChange.projectLikeCnt.desc();
		}
		
		if(sort=="supportCnt"){
			log.info("[RDS]supportCnt");
			return projectChange.supportCnt.desc();
			
		}
		
		if(sort=="sumPrice"){
			log.info("[RDS]sumPrice");
			return projectChange.sumPrice.desc();
			
		}
		
		if(sort=="newRelease") {
			log.info("[RDS]newRelease");
			return project.startDate.desc();
			
		}
			
		if(sort=="endCome") {
			log.info("[RDS]endCome");
			return project.endDate.desc();
			
		}
		
			
		log.info("[RDS]Not Select Sort");
		return project.projectNo.asc();
	}
}