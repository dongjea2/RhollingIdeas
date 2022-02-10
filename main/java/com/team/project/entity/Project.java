package com.team.project.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.team.user.entity.Customer;



@Entity
@Table(name = "project")
public class Project {
	@Id //시퀀스 설정해줘야함
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int		projectNo     ;   
	private String	longTitle     ;   
	private String	projectBrief  ;   
	private String	editorPick    ;   
	private String	projectImage  ;   
	private int		targetPrice   ;   
	private Date	startDate     ;   
	private Date	endDate       ;   
	private String	shortTitle    ;   
	private String	projectContent;   
	private String	projectUrl    ;   

	//좋아요 상태 (로그인 유저가 이프로젝트가 좋아요 일시 true)
	@Transient
	private boolean loginedUserProjectInterest=false; 



	//JOINED TABLE
	@OneToOne(mappedBy = "project")	  
	//저장 시 projectChange에 setProject해야함(관계의 주인 ProjectChange)
	private ProjectChange projectChange;

	@ManyToOne
	@JoinColumn(name = "category_no")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "user_no")
	private Customer maker;
	
	@OneToMany(mappedBy = "project")
	//저장 시 Reward에 setProject해야함
	//프로젝트 삭제시 리워드도 자동삭제
	private List<Reward> reward;
	                                  

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Project(int projectNo,  String longTitle, String projectBrief,
			String editorPick, String projectImage, int targetPrice, Date startDate, Date endDate, String shortTitle,
			String projectContent, String projectUrl) {
		super();
		this.projectNo = projectNo;
		this.longTitle = longTitle;
		this.projectBrief = projectBrief;
		this.editorPick = editorPick;
		this.projectImage = projectImage;
		this.targetPrice = targetPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.shortTitle = shortTitle;
		this.projectContent = projectContent;
		this.projectUrl = projectUrl;
	}

	

	public int getProjectNo() {
		return projectNo;
	}



	public Customer getMaker() {
		return maker;
	}


	public void setMaker(Customer maker) {
		this.maker = maker;
	}


	public String getRemainingDays() {
		Date endDate=this.getEndDate();
		Date sysDate = new Date();
		
		long diffDay = (endDate.getTime() - sysDate.getTime()) /(24*60*60*1000);
		
		if(diffDay>=0) {
			return diffDay+"일 남음";
		}
		
		else {
			return Math.abs(diffDay)+"일 지남";
		}
	}

	public int getAchiveRate() {
		double achiveRate = this.getProjectChange().getSumPrice() / (double)this.getTargetPrice()  *100; 
		System.out.println((int)achiveRate);
		return (int)achiveRate;
	}

	public boolean isLoginedUserProjectInterest() {
		return loginedUserProjectInterest;
	}


	public void setLoginedUserProjectInterest(boolean loginedUserProjectInterestState) {
		this.loginedUserProjectInterest= loginedUserProjectInterestState;
	}




	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}




	public ProjectChange getProjectChange() {
		return projectChange;
	}


	public void setProjectChange(ProjectChange projectChange) {
		this.projectChange = projectChange;
	}


	public List<Reward> getReward() {
		return reward;
	}


	public void setReward(List<Reward> reward) {
		this.reward = reward;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}




	public String getLongTitle() {
		return longTitle;
	}


	public void setLongTitle(String longTitle) {
		this.longTitle = longTitle;
	}


	public String getProjectBrief() {
		return projectBrief;
	}


	public void setProjectBrief(String projectBrief) {
		this.projectBrief = projectBrief;
	}


	public String getEditorPick() {
		return editorPick;
	}


	public void setEditorPick(String editorPick) {
		this.editorPick = editorPick;
	}


	public String getProjectImage() {
		return projectImage;
	}


	public void setProjectImage(String projectImage) {
		this.projectImage = projectImage;
	}


	public int getTargetPrice() {
		return targetPrice;
	}


	public void setTargetPrice(int targetPrice) {
		this.targetPrice = targetPrice;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getShortTitle() {
		return shortTitle;
	}


	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}


	public String getProjectContent() {
		return projectContent;
	}


	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}


	public String getProjectUrl() {
		return projectUrl;
	}


	public void setProjectUrl(String projectUrl) {
		this.projectUrl = projectUrl;
	}


	@Override
	public int hashCode() {
		return Objects.hash(projectNo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return projectNo == other.projectNo;
	}


	
	
}
