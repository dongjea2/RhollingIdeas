package com.team.interest.dto;

import com.team.interest.entity.Interest;
import com.team.project.entity.Project;

/**
 * 관심 프로젝트 페이지 조회하기 위한 dto
 */
public class InterestDTO {
	private int projectNo;
	private String projectImage;
	private String longTitle;
	private String projectBrief;
	private int achiveRate;
	
	private String categoryName;
	
	private String userName;
	
	private int sumPrice;
	
	private String interestAlarm;
	
	public void entityToDTO(Interest i) {
		this.projectNo = i.getLikeProject().getProjectNo();
		this.projectImage = i.getLikeProject().getProjectImage();
		this.longTitle = i.getLikeProject().getLongTitle();
		this.projectBrief = i.getLikeProject().getProjectBrief();
		this.achiveRate = i.getLikeProject().getAchiveRate();
		this.categoryName = i.getLikeProject().getCategory().getCategoryName();
		this.userName = i.getLikeProject().getMaker().getUserName();
		this.sumPrice = i.getLikeProject().getProjectChange().getSumPrice();
		this.interestAlarm = i.getInterestAlarm();
	}
	
	public int getProjectNo() {
		return projectNo;
	}

	public String getProjectImage() {
		return projectImage;
	}

	public String getLongTitle() {
		return longTitle;
	}

	public String getProjectBrief() {
		return projectBrief;
	}

	public int getAchiveRate() {
		return achiveRate;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String getUserName() {
		return userName;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public String getInterestAlarm() {
		return interestAlarm;
	}
	
}
