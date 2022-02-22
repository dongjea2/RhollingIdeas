package com.team.post.entity;


import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import com.team.project.entity.Project;
import com.team.user.entity.Customer;


/*
	`post_no`	NUMBER(8)	NOT NULL,
	`project_no`	NUMBER(8)	NOT NULL,
	`post_content`	VARCHAR2(100)	NULL,
	`post_date`	DATE	NULL,
	`user_no`	NUMBER(8)	NOT NULL
*/

@Entity
@Table(name="post")
@DynamicInsert	
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	postNo;
	
	@ManyToOne
	@JoinColumn(name="project_no")
	private Project	project;
	
	@CreationTimestamp
	@Column(name="post_date")
	private Date	postDate;
	
	@Column(name="post_content")
	private String	postContent;
	
	
	//level 1 게시글 level 2 댓글
	
	@ManyToOne
	@JoinColumn(name="user_no")
	private Customer maker;
	
	@OneToMany(cascade = CascadeType.ALL
			,  fetch = FetchType.LAZY)
	@JoinColumn(name="post_no")
	private List<Comments> comments;


	
	
	@Override
	public int hashCode() {
		return Objects.hash(postNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return postNo == other.postNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Customer getMaker() {
		return maker;
	}

	public void setMaker(Customer maker) {
		this.maker = maker;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	
	
	
}
