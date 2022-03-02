package com.team.user.dto;

import com.team.order.entity.Order;
import com.team.project.entity.Project;

public class ProfileProjectDTO {
	private Integer orderNo;
	private int projectNo;
	private String projectImage;
	private String longTitle;
	private String projectBrief;
	private int achiveRate;
	
	private String categoryName;
	
	private String makerName;
	
	private int sumPrice;
	
	private String projectStatus;
	
	private boolean checkLike;
	
	public void orderEntityToDTO(Order o) {
		this.orderNo = o.getOrderNo();
		this.projectNo = o.getProject().getProjectNo();
		this.projectImage = o.getProject().getProjectImage();
		this.longTitle = o.getProject().getLongTitle();
		this.projectBrief = o.getProject().getProjectBrief();
		this.achiveRate = o.getProject().getAchiveRate();
		this.categoryName = o.getProject().getCategory().getCategoryName();
		this.makerName = o.getProject().getMaker().getUserName();
		this.sumPrice = o.getProject().getProjectChange().getSumPrice();
		this.projectStatus = o.getProject().getProjectChange().getProjectStatus();
	}
	
	public void projectEntityToDTO(Project p) {
		this.projectNo = p.getProjectNo();
		this.projectImage = p.getProjectImage();
		this.longTitle = p.getLongTitle();
		this.projectBrief = p.getProjectBrief();
		this.achiveRate = p.getAchiveRate();
		this.categoryName = p.getCategory().getCategoryName();
		this.makerName = p.getMaker().getUserName();
		this.sumPrice = p.getProjectChange().getSumPrice();
	}

	public boolean isCheckLike() {
		return checkLike;
	}


	public void setCheckLike(boolean checkLike) {
		this.checkLike = checkLike;
	}
	
	public Integer getOrderNo() {
		return orderNo;
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

	public String getMakerName() {
		return makerName;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public String getProjectStatus() {
		return projectStatus;
	}
	
}
