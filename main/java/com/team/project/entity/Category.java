package com.team.project.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
	`category_no`	NUMBER(8)	NOT NULL,
	`category_p`	NUMBER(8)	NOT NULL,
	`category_name`	VARCHAR2(100)	NULL
*/

@Entity
@Table
public class Category {
	@Id
	private int categoryNo;
	private int categoryP;
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
	
	
	@Override
	public int hashCode() {
		return Objects.hash(categoryName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(categoryName, other.categoryName);
	}

	
}
