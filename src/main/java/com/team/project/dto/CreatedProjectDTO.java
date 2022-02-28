package com.team.project.dto;

import com.team.project.entity.Project;

public class CreatedProjectDTO {
	private int projectNo;
	private int userNo;
	private String projectImage;
	private String longTitle;
	private String shortTitle;
	
	private String projectStatus;
	
	private String rejectReason;
	
	public void entityToDTO(Project p) {
		this.projectNo = p.getProjectNo();
		this.userNo = p.getMaker().getUserNo();
		this.projectImage = p.getProjectImage();
		this.longTitle = p.getLongTitle();
		this.shortTitle = p.getShortTitle();
		this.projectStatus = p.getProjectChange().getProjectStatus();
	}
	
	public int getProjectNo() {
		return projectNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public String getProjectImage() {
		return projectImage;
	}

	public String getLongTitle() {
		return longTitle;
	}

	public String getShortTitle() {
		return shortTitle;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	
}
