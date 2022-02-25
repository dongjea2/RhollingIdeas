package com.team.project.entity;

import java.util.Date;

import com.team.user.entity.Customer;

public class ProjectLiteDTO {
	private int		projectNo     ;   
	private String	longTitle     ;   
	private String	projectBrief  ;   
	private String	editorPick    ;   
	private String	projectImage  ;   
	private Integer	targetPrice   ;   
	private Date	startDate     ;   
	private Date	endDate       ;   
	private String	shortTitle    ;   
	private String	projectContent;   
	private String	projectUrl    ;   

	private boolean loginedUserProjectInterest; 
	
	private ProjectChange projectChange;
	private Category category;
	private Customer maker;
	
	
	public void entityToDTO(Project p) {
		this.projectNo = p.getProjectNo();
		this.longTitle= p.getLongTitle();
		this.projectBrief= p.getProjectBrief();
		this.editorPick= p.getEditorPick();
		this.projectImage= p.getProjectImage();
		this.targetPrice= p.getTargetPrice();
		this.startDate= p.getStartDate ();
		this.endDate= p.getEndDate ();
		this.shortTitle= p.getShortTitle();
		this.projectContent= p.getProjectContent();
		this.projectUrl= p.getProjectUrl();

		this.projectChange= p.getProjectChange();
		this.category= p.getCategory();
		this.maker= p.getMaker ();
	}


	public int getProjectNo() {
		return projectNo;
	}


	public String getLongTitle() {
		return longTitle;
	}


	public String getProjectBrief() {
		return projectBrief;
	}


	public String getEditorPick() {
		return editorPick;
	}


	public String getProjectImage() {
		return projectImage;
	}


	public Integer getTargetPrice() {
		return targetPrice;
	}


	public Date getStartDate() {
		return startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public String getShortTitle() {
		return shortTitle;
	}


	public String getProjectContent() {
		return projectContent;
	}


	public String getProjectUrl() {
		return projectUrl;
	}


	public boolean isLoginedUserProjectInterest() {
		return loginedUserProjectInterest;
	}


	public ProjectChange getProjectChange() {
		return projectChange;
	}


	public Category getCategory() {
		return category;
	}


	public Customer getMaker() {
		return maker;
	}
	
	
}
