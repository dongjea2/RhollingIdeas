package com.team.order.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.project.entity.Project;
import com.team.project.entity.Reward;
import com.team.user.entity.Address;
import com.team.user.entity.Card;
import com.team.user.entity.Customer;

/*
	`order_no`	NUMBER(8)	NOT NULL,
	`user_no`	NUMBER(8)	NOT NULL,
	`order_date`	DATE	NULL,
	`extra_price`	NUMBER(8)	NULL,
	`total_price`	NUMBER(8)	NULL,
	`order_result`	VARCHAR2(10)	NULL,
	`address_no`	NUMBER(8)	NOT NULL,
	`card_no`	NUMBER(8)	NOT NULL,
	`reward_no`	NUMBER(8)	NOT NULL,
	`project_no`	NUMBER(8)	NOT NULL

*/
@Entity
@Table(name="orders")
public class Order{ //테이블 or 컬럼 이름 수정
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_no")
	private int	orderNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_no")
	@JsonIgnore
	private Customer orderUser;
	
	@CreationTimestamp
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "extra_price")
	private Integer	extraPrice;
	
	@Column(name = "total_price")
	private int	totalPrice;
	
	@Column(name = "order_result")
	private String orderResult;
	
	@ManyToOne
	@JoinColumn(name = "address_no")
	private Address	address;
	
	@ManyToOne
	@JoinColumn(name = "card_no")
	private Card card;
	
	@ManyToOne
	@JoinColumn(name = "project_no")
	@JsonIgnore
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "reward_no")
	private Reward reward;
	

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public Customer getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(Customer orderUser) {
		this.orderUser = orderUser;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getExtraPrice() {
		return extraPrice;
	}

	public void setExtraPrice(Integer extraPrice) {
		this.extraPrice = extraPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderResult() {
		return orderResult;
	}

	public void setOrderResult(String orderResult) {
		this.orderResult = orderResult;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return orderNo == other.orderNo;
	}
}
