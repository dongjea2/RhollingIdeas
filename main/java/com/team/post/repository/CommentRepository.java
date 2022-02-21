package com.team.post.repository;

import org.springframework.data.repository.CrudRepository;

import com.team.post.entity.Comments;

public interface CommentRepository extends CrudRepository<Comments, Integer> {

}
