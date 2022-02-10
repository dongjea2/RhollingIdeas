package com.team.user.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
	`card_no`	NUMBER(8)	NOT NULL,
	`user_no2`	NUMBER(8)	NOT NULL,
	`card_num`	VARCHAR2(20)	NULL,
	`card_valid_date`	DATE	NULL,
	`card_pwd`	VARCHAR2(4)	NULL,
	`card_owner_birth`	VARCHAR2(20)	NULL,
	`default_card`	CHAR(1)	NULL
*/
@Entity
@Table(name="card")
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	cardNo;
	@ManyToOne
	@JoinColumn(name = "user_no")
	private Customer	user; 
	@Column(nullable=false)
	private String	cardNum;
	@Column(nullable=false)
	private Date	cardValidDate ;
	@Column(nullable=false)
	private String	cardPwd;
	@Column(nullable=false)
	private String	cardOwnerBirth;
	@Column(nullable=false)
	private String	defaultCard;
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Card(int cardNo, Customer user, String cardNum, Date cardValidDate, String cardPwd, String cardOwnerBirth,
			String defaultCard) {
		super();
		this.cardNo = cardNo;
		this.user = user;
		this.cardNum = cardNum;
		this.cardValidDate = cardValidDate;
		this.cardPwd = cardPwd;
		this.cardOwnerBirth = cardOwnerBirth;
		this.defaultCard = defaultCard;
	}
	public Card(Customer user, String cardNum, Date cardValidDate, String cardPwd, String cardOwnerBirth,
			String defaultCard) {
		super();
		this.user = user;
		this.cardNum = cardNum;
		this.cardValidDate = cardValidDate;
		this.cardPwd = cardPwd;
		this.cardOwnerBirth = cardOwnerBirth;
		this.defaultCard = defaultCard;
	}
	public Card(int cardNo, String defaultCard) {
		super();
		this.cardNo = cardNo;
		this.defaultCard = defaultCard;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public Date getCardValidDate() {
		return cardValidDate;
	}
	public void setCardValidDate(Date cardValidDate) {
		this.cardValidDate = cardValidDate;
	}
	public String getCardPwd() {
		return cardPwd;
	}
	public void setCardPwd(String cardPwd) {
		this.cardPwd = cardPwd;
	}
	public String getCardOwnerBirth() {
		return cardOwnerBirth;
	}
	public void setCardOwnerBirth(String cardOwnerBirth) {
		this.cardOwnerBirth = cardOwnerBirth;
	}
	public String getDefaultCard() {
		return defaultCard;
	}
	public void setDefaultCard(String defaultCard) {
		this.defaultCard = defaultCard;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cardNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return cardNo == other.cardNo;
	}
	
	
}                                 
