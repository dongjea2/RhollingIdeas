package com.team.interest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.team.interest.entity.Interest;
import com.team.interest.entity.InterestId;
import com.team.project.entity.Project;
import com.team.user.entity.Customer;

public interface InterestRepository extends CrudRepository<Interest, InterestId> {

	public List<Interest> findByLikeUserAndInterestAlarm(Customer c, String iOrA);
	public Interest findByLikeProjectAndLikeUser(Project p , Customer c);
}
