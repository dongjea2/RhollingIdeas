package com.team.user.dto;

import com.team.order.entity.Order;

public class ProfileOrderDTO {
	private int orderNo;
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
	
	public void entityToDTO(Order o) {
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
	

	public boolean isCheckLike() {
		return checkLike;
	}


	public void setCheckLike(boolean checkLike) {
		this.checkLike = checkLike;
	}
	
	public int getOrderNo() {
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
