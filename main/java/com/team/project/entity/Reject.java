package com.team.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
	`project_no`	NUMBER(8)	NOT NULL,
	`reject_reason`	VARCHAR2(100)	NULL
*/

@Entity
@Table
public class Reject {
	@Id
	@OneToOne
	@JoinColumn(name = "project_no")
	private Project project;

	private String rejectReason;
	
	public Reject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reject(Project project, String rejectReason) {
		super();
		this.project = project;
		this.rejectReason = rejectReason;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
}