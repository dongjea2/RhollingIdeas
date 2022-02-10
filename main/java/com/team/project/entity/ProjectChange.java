package com.team.project.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "project_change")
public class ProjectChange {

	@Id
	@OneToOne
	@JoinColumn(name = "project_no")
	private Project	project;

	private int		supportCnt;
	private String	projectStatus;
	private int		sumPrice;
	private int		projectLikeCnt;
	
	
	public ProjectChange() {     
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectChange(Project project, int supportCnt, String projectStatus, int sumPrice, int projectLikeCnt) {
		super();
		this.project = project;
		this.supportCnt = supportCnt;
		this.projectStatus = projectStatus;
		this.sumPrice = sumPrice;
		this.projectLikeCnt = projectLikeCnt;
	}
	public Project getProjectNo() {
		return project;
	}
	public void setProjectNo(Project project) {
		this.project = project;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(project);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectChange other = (ProjectChange) obj;
		return Objects.equals(project, other.project);
	}


	
	
}
