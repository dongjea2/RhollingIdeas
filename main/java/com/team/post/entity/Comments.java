package com.team.post.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	@Column(name="comment_no")
	private int commentNo;
	@ManyToOne
	@JoinColumn(name="post_no")
	private Post post;
	@ManyToOne
	@JoinColumn(name="user_no")
	private Customer maker;
	@Column(name="comment_content")
	private String commentContent;
	@Column(name="comment_date")
	@JsonFormat(pattern = "yy/MM/dd", timezone = "Asia/Seoul")
	private Date commentDate;
	
		
	
}
