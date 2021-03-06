package com.team.project.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
	`reward_no`	NUMBER(8)	NOT NULL,
	`project_no`	NUMBER(8)	NOT NULL,
	`reward_price`	NUMBER(8)	NULL,
	`reward_name`	VARCHAR2(200)	NULL,
	`deliver_date`	DATE->NUMBER(4)	NULL,
	`reward_num`	NUMBER(4)	NULL,
	`reward_sales_cnt`	NUMBER(8)	NULL,
	`item_name`	VARCHAR2(300)	NULL,
	`deliver_select`	CHAR(1)	NULL
*/


@Entity
@Table
public class Reward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	rewardNo          ;
	
	@ManyToOne
	@JoinColumn(name = "project_no")
	private Project	project       ;

	private int	rewardPrice       ;
	private String	rewardName    ;
	private Integer	deliverDate       ;
	private Integer	rewardNum         ;
	private int	rewardSalesCnt    ;
	private String	itemName      ;
	private String	deliverSelect ;
	public Reward() {
		super();
	}
	
	public Reward(int rewardNo, Project projectNo, int rewardPrice, String rewardName, Integer deliverDate, Integer rewardNum,
			int rewardSalesCnt, String itemName, String deliverSelect) {
		super();
		this.rewardNo = rewardNo;
		this.project = projectNo;
		this.rewardPrice = rewardPrice;
		this.rewardName = rewardName;
		this.deliverDate = deliverDate;
		this.rewardNum = rewardNum;
		this.rewardSalesCnt = rewardSalesCnt;
		this.itemName = itemName;
		this.deliverSelect = deliverSelect;
	}
	
	public int getRewardNo() {
		return rewardNo;
	}
	public void setRewardNo(int rewardNo) {
		this.rewardNo = rewardNo;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public int getRewardPrice() {
		return rewardPrice;
	}
	public void setRewardPrice(int rewardPrice) {
		this.rewardPrice = rewardPrice;
	}
	public String getRewardName() {
		return rewardName;
	}
	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}
	public Integer getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(Integer deliverDate) {
		this.deliverDate = deliverDate;
	}
	public Integer getRewardNum() {
		return rewardNum;
	}
	public void setRewardNum(Integer rewardNum) {
		this.rewardNum = rewardNum;
	}
	public int getRewardSalesCnt() {
		return rewardSalesCnt;
	}
	public void setRewardSalesCnt(int rewardSalesCnt) {
		this.rewardSalesCnt = rewardSalesCnt;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDeliverSelect() {
		return deliverSelect;
	}
	public void setDeliverSelect(String deliverSelect) {
		this.deliverSelect = deliverSelect;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rewardNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reward other = (Reward) obj;
		return rewardNo == other.rewardNo;
	}



	
	
}
