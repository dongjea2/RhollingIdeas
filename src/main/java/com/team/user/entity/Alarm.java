package com.team.user.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

//DB제약조건 설정도 안되어 있음. 알람 구현시 DB부터 설정
public class Alarm {
	
	private int	alarmNo         ;
	private Customer	userNo      ;
	private String	alarmContent;
	private Date	alarmDate   ;
	private String	alarmRead   ;
	public Alarm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alarm(int alarmNo, Customer userNo, String alarmContent, Date alarmDate, String alarmRead) {
		super();
		this.alarmNo = alarmNo;
		this.userNo = userNo;
		this.alarmContent = alarmContent;
		this.alarmDate = alarmDate;
		this.alarmRead = alarmRead;
	}
	public int getAlarmNo() {
		return alarmNo;
	}
	public void setAlarmNo(int alarmNo) {
		this.alarmNo = alarmNo;
	}
	public Customer getUserNo() {
		return userNo;
	}
	public void setUserNo(Customer userNo) {
		this.userNo = userNo;
	}
	public String getAlarmContent() {
		return alarmContent;
	}
	public void setAlarmContent(String alarmContent) {
		this.alarmContent = alarmContent;
	}
	public Date getAlarmDate() {
		return alarmDate;
	}
	public void setAlarmDate(Date alarmDate) {
		this.alarmDate = alarmDate;
	}
	public String getAlarmRead() {
		return alarmRead;
	}
	public void setAlarmRead(String alarmRead) {
		this.alarmRead = alarmRead;
	}
	
	
}
