package com.team.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
	`project_no`	NUMBER(8)	NOT NULL,
	`support_cnt`	NUMBER(8)	NULL,
	`project_status`	VARCHAR2(10)	NULL,
	`sum_price`	NUMBER(8)	NULL,
	`project_like_cnt`	NUMBER(8)	NULL
*/

@Entity
@Table
public class ProjectChange {
	@Id
	@OneToOne
	@JoinColumn(name = "project_no")
	private Project	projectNo    ;
	private int	supportCnt       ;
	private String	projectStatus;
	private int	sumPrice         ;
	private int	projectLikeCnt   ;
	public ProjectChange() {     
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectChange(Project projectNo, int supportCnt, String projectStatus, int sumPrice, int projectLikeCnt) {
		super();
		this.projectNo = projectNo;
		this.supportCnt = supportCnt;
		this.projectStatus = projectStatus;
		this.sumPrice = sumPrice;
		this.projectLikeCnt = projectLikeCnt;
	}
	public Project getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(Project projectNo) {
		this.projectNo = projectNo;
	}
	public int getSupportCnt() {
		return supportCnt;
	}
	public void setSupportCnt(int supportCnt) {
		this.supportCnt = supportCnt;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public int getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}
	public int getProjectLikeCnt() {
		return projectLikeCnt;
	}
	public void setProjectLikeCnt(int projectLikeCnt) {
		this.projectLikeCnt = projectLikeCnt;
	}

	
	
}
