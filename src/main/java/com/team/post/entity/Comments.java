package com.team.post.entity;



import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.team.user.entity.Customer;




/*
	`comment_no`	NUMBER(8)	NOT NULL,
	`post_no`	NUMBER(8)	NOT NULL,
	`comment_content`	VARCHAR2(100)	NULL,
	`comment_date`	DATE	NULL,
	`user_no`	NUMBER(8)	NOT NULL
*/

@Entity
@Table(name="comment")
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="post_no")
	@JsonIgnore
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="user_no")
	private Customer maker;
	
	@Column(name="comment_content")
	private String commentContent;
	
	@CreationTimestamp
	@Column(name="comment_date")
	private Date commentDate;

	
	
	@Override
	public int hashCode() {
		return Objects.hash(commentNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comments other = (Comments) obj;
		return commentNo == other.commentNo;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Customer getMaker() {
		return maker;
	}

	public void setMaker(Customer maker) {
		this.maker = maker;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
		
	
}
