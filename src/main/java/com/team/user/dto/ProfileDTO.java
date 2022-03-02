package com.team.user.dto;

import java.util.List;

import com.team.user.entity.Customer;

public class ProfileDTO {
	private int userNo;
	private String userImage;
	private String userName;
	
	private List<ProfileProjectDTO> projects;
	
	private int orderProjectCnt;
	private int createdProjectCnt;
	private int followerCnt;
	private int followingCnt;
	
	private boolean followCheck;
	
	public void entityToDTO(Customer c) {
		this.userNo = c.getUserNo();
		this.userImage = c.getUserImage();
		this.userName = c.getUserName();
	}
	
	public boolean isFollowCheck() {
		return followCheck;
	}
	public void setFollowCheck(boolean followCheck) {
		this.followCheck = followCheck;
	}
	public int getOrderProjectCnt() {
		return orderProjectCnt;
	}
	public void setOrderProjectCnt(int orderProjectCnt) {
		this.orderProjectCnt = orderProjectCnt;
	}
	public int getCreatedProjectCnt() {
		return createdProjectCnt;
	}
	public void setCreatedProjectCnt(int createdProjectCnt) {
		this.createdProjectCnt = createdProjectCnt;
	}
	public int getFollowerCnt() {
		return followerCnt;
	}
	public void setFollowerCnt(int followerCnt) {
		this.followerCnt = followerCnt;
	}
	public int getFollowingCnt() {
		return followingCnt;
	}
	public void setFollowingCnt(int followingCnt) {
		this.followingCnt = followingCnt;
	}
	public int getUserNo() {
		return userNo;
	}
	public String getUserImage() {
		return userImage;
	}
	public String getUserName() {
		return userName;
	}
	public List<ProfileProjectDTO> getProjects() {
		return projects;
	}
	public void setProjects(List<ProfileProjectDTO> projects) {
		this.projects = projects;
	}
}
