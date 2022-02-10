package com.team.user.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
	`following` NUMBER(8) NOT NULL, 
	`user_no` NUMBER(8) NOT NULL
*/
@Entity
@Table(name="follow")
public class Follow { //hashcode, equals 생성 필요
	@Id
	@ManyToOne
	@JoinColumn(name = "user_no")
	private List<Customer> userNo;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "user_no", columnDefinition = "following")
	private List<Customer> follow;

	public List<Customer> getUserNo() {
		return userNo;
	}

	public void setUserNo(List<Customer> userNo) {
		this.userNo = userNo;
	}

	public List<Customer> getFollow() {
		return follow;
	}

	public void setFollow(List<Customer> follow) {
		this.follow = follow;
	}
	
	
}
