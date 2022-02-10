package com.team.user.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;



/*
	`user_no`	NUMBER(8)	NOT NULL,
	`user_role`	VARCHAR2(10)	NULL,
	`user_id`	VARCHAR2(30)	NULL,
	`user_image`	VARCHAR2(100)	NULL,
	`user_name`	VARCHAR2(20)	NULL,
	`user_pwd`	VARCHAR2(20)	NULL,
	`user_phone`	VARCHAR2(20)	NULL,
	`user_introduction`	VARCHAR2(100)	NULL,
	`user_website`	VARCHAR2(100)	NULL,
	`user_url`	VARCHAR2(100)	NULL,
	`user_privacy`	CHAR(1)	NULL,
	`message_alarm_check`	CHAR(1)	NULL,
	`updates_alarm_check`	CHAR(1)	NULL,
	`follow_alarm_check`	CHAR(1)	NULL,
	`marketing_alarm_check`	CHAR(1)	NULL,
	`user_signup_date`	DATE	NULL,
	`user_status`	VARCHAR2(10)	NULL,
*/

@Entity
@Table(name="customer")
@DynamicInsert //insert시 null인 필드 제외(?) DB에서 설정한 default값이 들어가도록
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	userNo;
	@Column(nullable=false)
	private String	userRole;
	@Column(unique=true, nullable=false)
	private String	userId;
	@Column(nullable=false)
	private String	userName;
	@Column(nullable=false)
	private String	userPwd;
	@CreationTimestamp
	private Date	userSignupDate;
	private String	userStatus; //DB에서 default '1'
	private String	userImage; // DB에서 defulat 'files/user_image/default.png' ec2 경로설정 필요                  
	private String	userPhone;                   
	private String	userIntroduction;            
	private String	userWebsite;
	private String	userUrl; // DB에서 default설정 필요.                     
		                                         
	public Customer() {                              
		super();                                  
		// TODO Auto-generated constructor stub   
	}


	public Customer(int userNo, String userRole, String userId, String userName, String userPwd, Date userSignupDate,
			String userStatus, String userImage, String userPhone, String userIntroduction, String userWebsite,
			String userUrl) {
		super();
		this.userNo = userNo;
		this.userRole = userRole;
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userSignupDate = userSignupDate;
		this.userStatus = userStatus;
		this.userImage = userImage;
		this.userPhone = userPhone;
		this.userIntroduction = userIntroduction;
		this.userWebsite = userWebsite;
		this.userUrl = userUrl;
	}
	public Customer(String userName, String userId, String userPwd) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Date getUserSignupDate() {
		return userSignupDate;
	}

	public void setUserSignupDate(Date userSignupDate) {
		this.userSignupDate = userSignupDate;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserIntroduction() {
		return userIntroduction;
	}

	public void setUserIntroduction(String userIntroduction) {
		this.userIntroduction = userIntroduction;
	}

	public String getUserWebsite() {
		return userWebsite;
	}

	public void setUserWebsite(String userWebsite) {
		this.userWebsite = userWebsite;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}


	@Override
	public int hashCode() {
		return Objects.hash(userNo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return userNo == other.userNo;
	}	
	
	
}
