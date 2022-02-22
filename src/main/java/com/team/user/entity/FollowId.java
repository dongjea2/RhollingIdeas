package com.team.user.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class FollowId implements Serializable{
	private int userNo;
	private int follow;
	
	public FollowId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FollowId(int userNo, int follow) {
		super();
		this.userNo = userNo;
		this.follow = follow;
	}
	
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getFollow() {
		return follow;
	}
	public void setFollow(int follow) {
		this.follow = follow;
	}
	@Override
	public int hashCode() {
		return Objects.hash(follow, userNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FollowId other = (FollowId) obj;
		return Objects.equals(follow, other.follow) && Objects.equals(userNo, other.userNo);
	}
}
