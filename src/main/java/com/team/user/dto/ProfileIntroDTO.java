package com.team.user.dto;

import com.team.user.entity.Customer;

public class ProfileIntroDTO {
	private int userNo;
	private String userId;
	private String userName;
	private String userImage;
	private String userIntroduction;
	private String userUrl;
	
	private int orderProjectCnt;
	private int createdProjectCnt;
	private int followerCnt;
	private int followingCnt;
	
	private boolean followCheck;
	
	public void entityToDTO(Customer c) {
		this.userNo = c.getUserNo();
		this.userId = c.getUserId();
		this.userName = c.getUserName();
		this.userImage = c.getUserImage();
		this.userIntroduction = c.getUserIntroduction();
		this.userUrl = c.getUserUrl();
	}

	public void setOrderProjectCnt(int orderProjectCnt) {
		this.orderProjectCnt = orderProjectCnt;
	}
	public void setCreatedProjectCnt(int createdProjectCnt) {
		this.createdProjectCnt = createdProjectCnt;
	}
	public void setFollowerCnt(int followerCnt) {
		this.followerCnt = followerCnt;
	}
	public void setFollowingCnt(int followingCnt) {
		this.followingCnt = followingCnt;
	}
	
	public boolean isFollowCheck() {
		return followCheck;
	}

	public void setFollowCheck(boolean followCheck) {
		this.followCheck = followCheck;
	}

	public int getUserNo() {
		return userNo;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserImage() {
		return userImage;
	}
	public String getUserIntroduction() {
		return userIntroduction;
	}
	public String getUserUrl() {
		return userUrl;
	}
	public int getOrderProjectCnt() {
		return orderProjectCnt;
	}
	public int getCreatedProjectCnt() {
		return createdProjectCnt;
	}
	public int getFollowerCnt() {
		return followerCnt;
	}
	public int getFollowingCnt() {
		return followingCnt;
	}
}
