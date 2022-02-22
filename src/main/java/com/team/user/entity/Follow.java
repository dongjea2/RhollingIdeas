package com.team.user.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
	`following` NUMBER(8) NOT NULL, 
	`user_no` NUMBER(8) NOT NULL
*/
@Entity
@Table(name="follow")
@IdClass(FollowId.class)
public class Follow { //hashcode, equals 생성 필요
	
	@Id
	@ManyToOne
//	@JoinColumn(name = "user_no")
	@JoinColumn(name = "user_no")
	private Customer userNo;
	
	@Id
	@ManyToOne
//	@JoinColumn(name = "user_no", columnDefinition = "follow")
	@JoinColumn(name = "follow")
	private Customer follow;

	public Customer getUserNo() {
		return userNo;
	}

	public void setUserNo(Customer userNo) {
		this.userNo = userNo;
	}

	public Customer getFollow() {
		return follow;
	}

	public void setFollow(Customer follow) {
		this.follow = follow;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(follow, userNo);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Follow other = (Follow) obj;
//		return Objects.equals(follow, other.follow) && Objects.equals(userNo, other.userNo);
//	}
}
