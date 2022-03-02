package com.team.interest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.interest.dto.InterestDTO;
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
	
	/**
	 * 관심프로젝트페이지의 좋아한 프로젝트 리스트 출력
	 * @param c 로그인한 유저 객체
	 * @return 유저의 I 프로젝트 리스트
	 */
	public Object myInterestProjects(Customer c) {
		Map<String, Object> returnMap = new HashMap<>();
		List<InterestDTO> list = new ArrayList<>();
		List<Interest> iList = repository.findByLikeUserAndInterestAlarm(c, "I");
		
		for(Interest i : iList) {
			InterestDTO dto = new InterestDTO();
			dto.entityToDTO(i);
			list.add(dto);
		}
		List<Interest> aList = repository.findByLikeUserAndInterestAlarm(c, "A");
		
		returnMap.put("iProject", list);
		returnMap.put("aProjectCnt", aList.size());
		
		return returnMap;
	}
	
	/**
	 * 관심프로젝트페이지의 알림신청 프로젝트 리스트 출력
	 * @param c 로그인한 유저 객체
	 * @return 유저의 A 프로젝트 리스트
	 */
	public Object myAlarmProjects(Customer c) {
		Map<String, Object> returnMap = new HashMap<>();
		List<InterestDTO> list = new ArrayList<>();
		List<Interest> aList = repository.findByLikeUserAndInterestAlarm(c, "A");
		
		for(Interest a : aList) {
			InterestDTO dto = new InterestDTO();
			dto.entityToDTO(a);
			list.add(dto);
		}
		List<Interest> iList = repository.findByLikeUserAndInterestAlarm(c, "I");
		
		returnMap.put("aProject", list);
		returnMap.put("iProjectCnt", iList.size());
		
		return returnMap;
	}
	

	public boolean addInterest(Interest interest, Customer sessionCustomer) {
		Project findedProject = null;
		Optional<Project> p = projectRepository.findById(interest.getLikeProject().getProjectNo());
		if(p.isPresent()) {
			 findedProject= p.get();
		}else {
			return false;
		}

		//1.check "I" or "A" [interst_aram(column)]
		//a. Funding Started
		if(findedProject.isProjectFundingStarted()){
			interest.setInterestAlarm("I");
		//b. Funding Not Started
		} else {
			interest.setInterestAlarm("A");
		}

		//프론트 로그인 유저와 백엔드 로그인 유저 검증
		if( sessionCustomer.getUserNo() == interest.getLikeUser().getUserNo()) {
			repository.save(interest);
			return true;
		}
		return false;
	}
	
	public boolean deleteInterest(Interest interest, Customer sessionCustomer) {
		//프론트 로그인 유저와 백엔드 로그인 유저 검증
		if( sessionCustomer.getUserNo() == interest.getLikeUser().getUserNo()) {
			repository.delete(interest);
			return true;
		}
		return false;
	}
}
