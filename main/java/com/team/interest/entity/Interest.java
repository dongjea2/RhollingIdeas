package com.team.interest.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.team.project.entity.Project;
import com.team.user.entity.Customer;

@Entity
@Table(name="interest")
public class Interest implements Serializable{
	@Id
	@ManyToOne
	@JoinColumn(name = "project_no")
	private Project	likeProject;
	@Id
	@ManyToOne
	@JoinColumn(name = "user_no")
	private Customer	likeUser;
	private String	interestAlarm;
	public Project getLikeProject() {
		return likeProject;
	}
	public void setLikeProject(Project likeProject) {
		this.likeProject = likeProject;
	}
	public Customer getLikeUser() {
		return likeUser;
	}
	public void setLikeUser(Customer likeUser) {
		this.likeUser = likeUser;
	}
	public String getInterestAlarm() {
		return interestAlarm;
	}
	public void setInterestAlarm(String interestAlarm) {
		this.interestAlarm = interestAlarm;
	}
	@Override
	public int hashCode() {
		return Objects.hash(likeProject, likeUser);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interest other = (Interest) obj;
		return Objects.equals(likeProject, other.likeProject) && Objects.equals(likeUser, other.likeUser);
	}
	
	
}
