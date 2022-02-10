package com.team.post.entity;



import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;




/*
	`comment_no`	NUMBER(8)	NOT NULL,
	`post_no`	NUMBER(8)	NOT NULL,
	`comment_content`	VARCHAR2(100)	NULL,
	`comment_date`	DATE	NULL,
	`user_no`	NUMBER(8)	NOT NULL
*/

@Entity(name="comment")
@Table
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentNo;
	
	@ManyToOne
	@JoinColumn(name="post_no")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="user_no")
	private Customer maker;
	
	@Column(name="comment_content")
	private String commentContent;
	
	@CreationTimestamp
	@Column(name="comment_date")
	private Date commentDate;
	
	
		
	
}
