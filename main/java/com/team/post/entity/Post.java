package com.team.post.entity;


import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import com.fasterxml.jackson.annotation.JsonFormat;


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
	@JoinColumn(name="porject_no")
	private Project	project;
	
	@CreationTimestamp
	@Column(name="post_date")
	private Date	postDate;
	
	@Column(name="post_content")
	private String	postContent;
	
	@ManyToOne
	@JoinColumn(name="user_no")
	private Customer maker;
	
//	@OneToMany
//	private List<Comments> comments;
	
			
}
