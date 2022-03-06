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
import com.team.user.entity.Customer;
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
	
	public List<Project> findByMakerAndApprovalStatus(Customer c){
		JPAQueryFactory query = new JPAQueryFactory(em);
		return query
				.select(project)
				.from(project)
				.where(project.maker.userNo.eq(c.getUserNo())
						,project.projectChange.projectStatus.eq("승인"))
				.fetch();
	}
	
	public List<Project> findByRequestData(RequestDataSelector rds){
		JPAQueryFactory query = new JPAQueryFactory(em);
		

		//1. RDS에 맞춰서 프로젝트 리턴
		if(rds.getSearchWords() == null) {
			return query
					.select(project)
					.from(project)
					.where( eqCategory(rds.getCategory())
							, progressState(rds.getProgressState())
							,editorPick(rds.isEditorPick())
							, achieveRate(rds.getAchiveRate())
							,project.projectChange.projectStatus.contains("승인"))
					.orderBy(sort(rds.getSort()))
					.limit(rds.getLimit())
					.fetch();
		}
		
		
		//2.검색 기능(SearchWords에 값이 들어 있을시 )
			return query
					.select(project)
					.from(project)
					.where( eqCategory(rds.getCategory())
							,project.longTitle.contains(rds.getSearchWords()),
							project.projectChange.projectStatus.contains("승인"))
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
	enum ProjectProgressState {
		none, onGoing,confirm, preLaunch
	}

	private BooleanExpression progressState(ProjectProgressState state) {
		if(state == state.none) {
			log.info("[RDS]Not Select editorPick");
			return null;
		}

		if( state== state.onGoing) {
			log.info("[RDS]onGoing");
			return projectChange.projectStatus.eq("승인")
					.and(project.startDate.before(new Date())
					.and(project.endDate.after(new Date())));
		}
		
		if(state == state.confirm) {
			log.info("[RDS]confirm");
			return projectChange.projectStatus.eq("승인")
					.and(project.endDate.before(new Date()))
					.and(projectChange.sumPrice.gt(project.targetPrice));
		}
		
		if(state == state.preLaunch){
			log.info("[RDS]preLaunch");
			return projectChange.projectStatus.eq("승인")
					.and(project.startDate.after(new Date()));
		}
		log.warn("[RDS]ProgeressState [erro]");
		return null;
	}

	//3.
	private BooleanExpression editorPick(boolean isEditorPicked) {
		if(isEditorPicked) {
			log.info("[RDS]editorPick");
			return project.editorPick.eq("1");

		}
		log.info("[RDS]Not Select editorPick");
		return null;
	}

	enum ArchiveRate{

	}
	
	//4.
	enum ProjectAchiveRate {
		rateLessThan75
		,rateBetween75And100
		,rateMoreThan100
	}
	private BooleanExpression achieveRate(ProjectAchiveRate achiveRate) {
		final int RATE_LESS_THAN_75 =1;
		final int RATE_BETWEEN_75_AND_100=2;
		final int RATE_MORE_THAN_100 =3;

		if( achiveRate == achiveRate.rateLessThan75) {
			log.info("[RDS]RATE_LESS_THAN_75");
			return projectChange.sumPrice.divide(project.targetPrice).lt(0.75);
		}
		if( achiveRate == achiveRate.rateBetween75And100) {
			log.info("[RDS]RATE_BETWEEN_75_AND_100");
			return projectChange.sumPrice.divide(project.targetPrice).between(0.75, 1.00);
		}
		if( achiveRate == achiveRate.rateMoreThan100) {
			log.info("[RDS]RATE_MORE_THAN_100");
			return projectChange.sumPrice.divide(project.targetPrice).gt(1.00);
			
		}
		
		log.warn("[RDS]Not Select AchiveRate");
		return null;
	}
	
	
	//4.orderBy
	enum ProjectSort {
		none,
		likeCount,
		supportCount,
		sumPrice,
		startDate,
		endDate
	}
	private OrderSpecifier<?> sort(ProjectSort sort) {
		if(sort ==sort.none) {
			log.info("[RDS]Not Select Sort");
			return project.projectNo.asc();
		}
	
		if(sort== sort.likeCount) {
			log.info("[RDS]likeCnt");
			return projectChange.projectLikeCnt.desc();
		}
		
		if(sort == sort.supportCount){
			log.info("[RDS]supportCnt");
			return projectChange.supportCnt.desc();
			
		}
		
		if(sort == sort.sumPrice){
			log.info("[RDS]sumPrice");
			return projectChange.sumPrice.desc();
			
		}
		
		if(sort == sort.startDate) {
			log.info("[RDS]newRelease");
			return project.startDate.desc();
			
		}
			
		if(sort == sort.endDate) {
			log.info("[RDS]endCome");
			return project.endDate.desc();
			
		}
		
		log.info("[RDS]Not Select Sort");
		return project.projectNo.asc();
			
	}
}