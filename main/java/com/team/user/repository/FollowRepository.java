package com.team.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.team.user.entity.Customer;
import com.team.user.entity.Follow;

public interface FollowRepository extends CrudRepository<Follow, Customer> {

}
