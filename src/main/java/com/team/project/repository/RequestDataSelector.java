package com.team.project.repository;

public class RequestDataSelector {

	int category; //service쪽에서 카테고리 null 값받으면 String값 "all" 넣어서 전달
	int editorPick;
	String ongoing;
	int achiveRate;
	String sort;
	String rowCount;
	String loginedUserNo;
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getOngoing() {
		return ongoing;
	}
	public void setOngoing(String ongoing) {
		this.ongoing = ongoing;
	}


	public int getEditorPick() {
		return editorPick;
	}
	public void setEditorPick(int editorPick) {
		this.editorPick = editorPick;
	}
	

	public int getAchiveRate() {
		return achiveRate;
	}
	public void setAchiveRate(int achiveRate) {
		this.achiveRate = achiveRate;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getRowCount() {
		return rowCount;
	}
	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}
	public String getLoginedUserNo() {
		return loginedUserNo;
	}
	public void setLoginedUserNo(String loginedUserNo) {
		this.loginedUserNo = loginedUserNo;
	}
	
}
