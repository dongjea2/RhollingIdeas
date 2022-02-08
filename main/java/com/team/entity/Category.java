package com.team.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class Category{
	@Id
	@Column(name = "CATEGORY_NO")
	private int categoryNo;
	@Column(name = "CATEGORY_P")
	private int categoryP;
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int categoryNo, int categoryP, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryP = categoryP;
		this.categoryName = categoryName;
	}
	
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public int getCategoryP() {
		return categoryP;
	}
	public void setCategoryP(int categoryP) {
		this.categoryP = categoryP;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
