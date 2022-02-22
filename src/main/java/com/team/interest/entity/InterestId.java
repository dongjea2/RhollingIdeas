package com.team.interest.entity;

import java.io.Serializable;
import java.util.Objects;

public class InterestId implements Serializable{
	private int likeProject;
	private int likeUser;
	public InterestId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InterestId(int likeProject, int likeUser) {
		super();
		this.likeProject = likeProject;
		this.likeUser = likeUser;
	}
	public int getLikeProject() {
		return likeProject;
	}
	public void setLikeProject(int likeProject) {
		this.likeProject = likeProject;
	}
	public int getLikeUser() {
		return likeUser;
	}
	public void setLikeUser(int likeUser) {
		this.likeUser = likeUser;
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
		InterestId other = (InterestId) obj;
		return likeProject == other.likeProject && likeUser == other.likeUser;
	}
}
