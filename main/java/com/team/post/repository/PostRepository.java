package com.team.post.repository;

import org.springframework.data.repository.CrudRepository;

import com.team.post.entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
