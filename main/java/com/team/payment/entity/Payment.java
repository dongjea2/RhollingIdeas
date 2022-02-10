package com.team.payment.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.team.project.entity.Project;
import com.team.project.entity.Reward;
import com.team.user.entity.Address;
import com.team.user.entity.Card;
import com.team.user.entity.Customer;

/*
	`payment_no`	NUMBER(8)	NOT NULL,
	`user_no`	NUMBER(8)	NOT NULL,
	`payment_date`	DATE	NULL,
	`extra_price`	NUMBER(8)	NULL,
	`total_price`	NUMBER(8)	NULL,
	`payment_result`	VARCHAR2(10)	NULL,
	`address_no`	NUMBER(8)	NOT NULL,
	`card_no`	NUMBER(8)	NOT NULL,
	`reward_no`	NUMBER(8)	NOT NULL,
	`project_no`	NUMBER(8)	NOT NULL

*/
@Entity
@Table(name="payment")
public class Payment implements Serializable{ //테이블 or 컬럼 이름 수정
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_no")
	private int	paymentNo;
	
	@ManyToOne
	@JoinColumn(name = "user_no")
	private Customer orderUser;
	
	@CreationTimestamp
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@Column(name = "extra_price")
	private int	extraPrice;
	
	@Column(name = "total_price")
	private int	totalPrice;
	
	@Column(name = "payment_result")
	private String paymentResult;
	
	@ManyToOne
	@JoinColumn(name = "address_no")
	private Address	address;
	
	@ManyToOne
	@JoinColumn(name = "card_no")
	private Card card;
	
	@ManyToOne
	@JoinColumn(name = "project_no")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "reward_no")
	private Reward reward;
	

	public int getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}

	public Customer getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(Customer orderUser) {
		this.orderUser = orderUser;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getExtraPrice() {
		return extraPrice;
	}

	public void setExtraPrice(int extraPrice) {
		this.extraPrice = extraPrice;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentResult() {
		return paymentResult;
	}

	public void setPaymentResult(String paymentResult) {
		this.paymentResult = paymentResult;
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
		return Objects.hash(paymentNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return paymentNo == other.paymentNo;
	}
}
