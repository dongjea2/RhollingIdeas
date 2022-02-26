package com.team.project.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.team.project.entity.Category;
import com.team.project.entity.Project;
import com.team.project.entity.ProjectChange;
import com.team.project.entity.Reward;
import com.team.user.entity.Customer;

public class ProjectDTO {
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
	private long remainDayCnt;   
	private int achiveRate;

	private boolean loginedUserProjectInterest; 
	
	private ProjectChange projectChange;
	private Category category;
	private Customer maker;
	private List<RewardDTO> reward;
	
	
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

		this.remainDayCnt = p.getRemainingDays();
		this.achiveRate = p.getAchiveRate();
		this.reward = new ArrayList<>();

		for(Reward r :p.getReward()) {
			RewardDTO dto = new RewardDTO();
			dto.entityToDTO(r);
			this.reward.add(dto);
		}
		
	}
	
	
	public boolean isLoginedUserProjectInterest() {
		return loginedUserProjectInterest;
	}
	public void setLoginedUserProjectInterest(boolean loginedUserProjectInterest) {
		this.loginedUserProjectInterest = loginedUserProjectInterest;
	}


	public void setReward(List<RewardDTO> reward) {
		this.reward = reward;
	}


	public int getProjectNo() {
		return projectNo;
	}


	public long getRemainDayCnt() {
		return remainDayCnt;
	}


	public int getAchiveRate() {
		return achiveRate;
	}


	public List<RewardDTO> getReward() {
		return reward;
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
