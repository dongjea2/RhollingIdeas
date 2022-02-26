package com.team.interest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.interest.entity.Interest;
import com.team.interest.repository.InterestRepository;
import com.team.project.entity.Project;
import com.team.project.repository.ProjectRepository;
import com.team.user.entity.Customer;

@Service
public class InterestService {
	
	@Autowired
	private InterestRepository repository;

	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Interest> myInterestProjects(Customer c) {
		return repository.findByLikeUserAndInterestAlarm(c, "I");
	}
	
	public List<Interest> myAlarmProjects(Customer c) {
		return repository.findByLikeUserAndInterestAlarm(c, "A");
	}
	

	public boolean addInterest(Interest interest) {
		//백엔드 쪽 로그인된 유저
		Customer sessionCustomer = new Customer();
		sessionCustomer.setUserNo(1);
		

		//1.check "I" or "A" [interst_aram(column)]
		Optional<Project> p = projectRepository.findById(interest.getLikeProject().getProjectNo());
		if(p.isPresent()) {
			Project findedProject= p.get();

			//a. Funding Started
			if(findedProject.isProjectFundingStarted()){
				interest.setInterestAlarm("I");
			//b. Funding Not Started
			} else {
				interest.setInterestAlarm("A");
			}
		}


				//프론트 로그인 유저와 백엔드 로그인 유저 검증
		if( sessionCustomer.getUserNo() == interest.getLikeUser().getUserNo()) {
			repository.save(interest);
			return true;
		}
		return false;
	}
	
	public boolean deleteInterest(Interest interest) {
		//백엔드 쪽 로그인된 유저
		Customer sessionCustomer = new Customer();
		sessionCustomer.setUserNo(1);
		
		//프론트 로그인 유저와 백엔드 로그인 유저 검증
		if( sessionCustomer.getUserNo() == interest.getLikeUser().getUserNo()) {
			repository.delete(interest);
			return true;
		}
		return false;
	}
}
