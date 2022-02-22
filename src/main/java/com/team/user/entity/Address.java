package com.team.user.entity;

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
 	`address_no`	NUMBER(8)	NOT NULL,
	`user_no`	NUMBER(8)	NOT NULL,
	`receiver_name`	VARCHAR2(20)	NULL,
	`receiver_zipcode`	NUMBER(8)	NULL,
	`receiver_address`	VARCHAR2(50)	NULL,
	`receiver_address_detailed`	VARCHAR2(50)	NULL,
	`receiver_phone`	VARCHAR2(20)	NULL,
	`default_address`	CHAR(1)	NULL
*/
@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressNo;
	@ManyToOne
	@JoinColumn(name = "user_no")
	private Customer user;
	@Column(nullable=false)
	private String receiverName;
	@Column(nullable=false)
	private int receiverZipcode;
	@Column(nullable=false)
	private String receiverAddress;
	private String receiverAddressDetailed;
	private String receiverPhone;
	@Column(nullable=false)
	private String defaultAddress;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Address(int addressNo, Customer user, String receiverName, int receiverZipcode, String receiverAddress,
			String receiverAddressDetailed, String receiverPhone, String defaultAddress) {
		super();
		this.addressNo = addressNo;
		this.user = user;
		this.receiverName = receiverName;
		this.receiverZipcode = receiverZipcode;
		this.receiverAddress = receiverAddress;
		this.receiverAddressDetailed = receiverAddressDetailed;
		this.receiverPhone = receiverPhone;
		this.defaultAddress = defaultAddress;
	}
	public Address(Customer user, String receiverName, int receiverZipcode, String receiverAddress,
			String receiverAddressDetailed, String receiverPhone, String defaultAddress) {
		super();
		this.user = user;
		this.receiverName = receiverName;
		this.receiverZipcode = receiverZipcode;
		this.receiverAddress = receiverAddress;
		this.receiverAddressDetailed = receiverAddressDetailed;
		this.receiverPhone = receiverPhone;
		this.defaultAddress = defaultAddress;
	}
	public Address(int addressNo, String defaultAddress) {
		this.addressNo = addressNo;
		this.defaultAddress = defaultAddress;
	}
	public int getAddressNo() {
		return addressNo;
	}
	public void setAddressNo(int addressNo) {
		this.addressNo = addressNo;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public int getReceiverZipcode() {
		return receiverZipcode;
	}
	public void setReceiverZipcode(int receiverZipcode) {
		this.receiverZipcode = receiverZipcode;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverAddressDetailed() {
		return receiverAddressDetailed;
	}
	public void setReceiverAddressDetailed(String receiverAddressDetailed) {
		this.receiverAddressDetailed = receiverAddressDetailed;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(String defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return addressNo == other.addressNo;
	}
	
	
	
	
	
}
