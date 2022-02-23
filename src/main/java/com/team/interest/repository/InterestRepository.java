package com.team.interest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team.interest.entity.Interest;
import com.team.interest.entity.InterestId;
import com.team.user.entity.Customer;

public interface InterestRepository extends CrudRepository<Interest, InterestId> {

	public List<Interest> findByLikeUserAndInterestAlarm(Customer c, String iOrA);
}
