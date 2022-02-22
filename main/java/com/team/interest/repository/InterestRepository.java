package com.team.interest.repository;

import org.springframework.data.repository.CrudRepository;

import com.team.interest.entity.Interest;
import com.team.interest.entity.InterestId;

public interface InterestRepository extends CrudRepository<Interest, InterestId> {

}
