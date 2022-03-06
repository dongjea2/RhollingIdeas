package com.team.project.repository;

public class RequestDataSelector {

	private int category; //service쪽에서 카테고리 null 값받으면 String값 "all" 넣어서 전달
	private boolean editorPick;
	private QueryRepository.ProjectProgressState progressState;
	private QueryRepository.ProjectAchiveRate achiveRate;
	private QueryRepository.ProjectSort sort;
	private int rowCount;
	private String loginedUserNo;
	private int limit = 100;
	private String searchWords;

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public boolean isEditorPick() {
		return editorPick;
	}

	public void setEditorPick(boolean editorPick) {
		this.editorPick = editorPick;
	}

	public QueryRepository.ProjectProgressState getProgressState() {
		return progressState;
	}

	public void setProgressState(QueryRepository.ProjectProgressState progressState) {
		this.progressState = progressState;
	}

	public QueryRepository.ProjectAchiveRate getAchiveRate() {
		return achiveRate;
	}

	public void setAchiveRate(QueryRepository.ProjectAchiveRate achiveRate) {
		this.achiveRate = achiveRate;
	}

	public QueryRepository.ProjectSort getSort() {
		return sort;
	}

	public void setSort(QueryRepository.ProjectSort sort) {
		this.sort = sort;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public String getLoginedUserNo() {
		return loginedUserNo;
	}

	public void setLoginedUserNo(String loginedUserNo) {
		this.loginedUserNo = loginedUserNo;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getSearchWords() {
		return searchWords;
	}

	public void setSearchWords(String searchWords) {
		this.searchWords = searchWords;
	}
}
