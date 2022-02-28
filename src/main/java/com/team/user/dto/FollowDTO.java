package com.team.user.dto;

import com.team.user.entity.Follow;

/**
 * 나를, 내가 팔로우한 유저들을 조회하기 위한 dto
 */
public class FollowDTO {
	private int userNo;
	private String userImage;
	private String userUrl;
	private String userName;
	private String userIntroduction;
	
	//조회하는 유저의 팔로워 수
	private int followerCnt;
	//올린 프로젝트
	private int createdCnt;
	
	//나를 팔로우하고 있는 사람을 내가 팔로우하는지 확인하여 팔로우하고 있으면 true
	private boolean followCheck;
	
	//내가 팔로우한 유저
	public void entityToDTOFollowing(Follow f) {
		this.userNo = f.getFollow().getUserNo();
		this.userImage = f.getFollow().getUserImage();
		this.userUrl = f.getFollow().getUserUrl();
		this.userName = f.getFollow().getUserName();
		this.userIntroduction = f.getFollow().getUserIntroduction();
	}
	
	//나를 팔로우한 유저
	public void entityToDTOFollower(Follow f) {
		this.userNo = f.getUserNo().getUserNo();
		this.userImage = f.getUserNo().getUserImage();
		this.userUrl = f.getUserNo().getUserUrl();
		this.userName = f.getUserNo().getUserName();
		this.userIntroduction = f.getUserNo().getUserIntroduction();
	}
	
	public int getFollowerCnt() {
		return followerCnt;
	}
	public void setFollowerCnt(int followerCnt) {
		this.followerCnt = followerCnt;
	}
	public int getCreatedCnt() {
		return createdCnt;
	}
	public void setCreatedCnt(int createdCnt) {
		this.createdCnt = createdCnt;
	}
	public int getUserNo() {
		return userNo;
	}
	public String getUserImage() {
		return userImage;
	}
	public String getUserUrl() {
		return userUrl;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserIntroduction() {
		return userIntroduction;
	}

	public boolean isFollowCheck() {
		return followCheck;
	}

	public void setFollowCheck(boolean followCheck) {
		this.followCheck = followCheck;
	}
	
}
