package com.team.user.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.team.user.entity.Customer;
import com.team.user.entity.Follow;
import com.team.user.entity.FollowId;

public interface FollowRepository extends CrudRepository<Follow, FollowId> {

	public List<Follow> findByUserNo(Customer c);

	public List<Follow> findByFollow(Customer c);

}
