package com.team.post.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


/*
	`post_no`	NUMBER(8)	NOT NULL,
	`project_no`	NUMBER(8)	NOT NULL,
	`post_content`	VARCHAR2(100)	NULL,
	`post_date`	DATE	NULL,
	`user_no`	NUMBER(8)	NOT NULL
*/
@Entity(name="post")
@Table
public class Post {
	@Column(name="post_no")
	private int	postNo;
	
	@ManyToOne
	@JoinColumn(name="porject_no")
	private Project	project;
	@Column(name="post_date")
	@JsonFormat(pattern = "yy/MM/dd", timezone = "Asia/Seoul")
	private Date	postDate;
	@Column(name="post_content")
	private String	postContent;
	@ManyToOne
	@JoinColumn(name="user_no")
	private Customer maker;
//	@OneToMany
//	@JoinColumn(name="")
//	private List<Comments> comments;
	
			
}
