package com.team.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.project.entity.Project;
import com.team.project.repository.ProjectRepository;
import com.team.project.repository.QueryRepository;
import com.team.user.dto.FollowDTO;
import com.team.user.entity.Customer;
import com.team.user.entity.Follow;
import com.team.user.entity.FollowId;
import com.team.user.repository.FollowRepository;

@Service
public class FollowService {
	@Autowired
	private FollowRepository repository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private QueryRepository queryRepository;
	
	/**
	 * 내가 팔로우하고 있는 사람들을 조회한다
	 * @param c
	 * @return
	 */
	public Object following(Customer c) {
		Map<String, Object> returnMap = new HashMap<>();
		List<FollowDTO> list = new ArrayList<>();
		List<Follow> fList = repository.findByUserNo(c);
		
		for(Follow f : fList) {
			FollowDTO dto = new FollowDTO();
			dto.entityToDTOFollowing(f);
			dto.setFollowCheck(true);
			
			//팔로워 카운트
			Customer c1 = new Customer();
			c1.setUserNo(f.getFollow().getUserNo());
			List<Follow> fCnt = repository.findByFollow(c1);
			dto.setFollowerCnt(fCnt.size());
			
			//올린프로젝트 카운트
			List<Project> pList = queryRepository.findByMakerAndApprovalStatus(c1);
			dto.setCreatedCnt(pList.size());
			
			list.add(dto);
		}
		List<Follow> followerList = repository.findByFollow(c);
		
		returnMap.put("following", list);
		returnMap.put("followerCnt", followerList.size());
		
		return returnMap;
	}
	
	/**
	 * 나를 팔로우하고 있는 사람들을 조회한다
	 * @param c
	 * @return
	 */
	public Object followers(Customer c) {
		Map<String, Object> returnMap = new HashMap<>();
		List<FollowDTO> list = new ArrayList<>();
		List<Follow> fList = repository.findByFollow(c);
		
		for(Follow f : fList) {
			FollowDTO dto = new FollowDTO();
			dto.entityToDTOFollower(f);
			
			//나를 팔로우하고 있는 사람을 내가 팔로우하는지 확인한다.
			FollowId id = new FollowId();
			id.setUserNo(f.getFollow().getUserNo());
			id.setFollow(f.getUserNo().getUserNo());
			Optional<Follow> checkF = repository.findById(id);
			if(checkF.isPresent()) {
				dto.setFollowCheck(true);
			}else {
				dto.setFollowCheck(false);
			}
			
			//팔로워 카운트
			Customer c1 = new Customer();
			c1.setUserNo(f.getUserNo().getUserNo());
			List<Follow> fCnt = repository.findByFollow(c1);
			dto.setFollowerCnt(fCnt.size());
			
			//올린프로젝트 카운트
			List<Project> pList = queryRepository.findByMakerAndApprovalStatus(c1);
			dto.setCreatedCnt(pList.size());
			
			list.add(dto);
		}
		List<Follow> followingList = repository.findByUserNo(c);
		
		returnMap.put("followers", list);
		returnMap.put("followingCnt", followingList.size());
		
		return returnMap;
	}
	
	/**
	 * follow데이터 추가
	 * @param f follow객체
	 */
	public void saveFollow(Follow f) {
		repository.save(f);
	}
	
	public void deleteFollow(Follow f) {
		repository.delete(f);
	}
	
	/**
	 * follow데이터가 존재하는지 확인
	 * @param f
	 * @return true일 경우 이미 팔로우하고 있고 false일 경우 팔로우데이터 없음
	 */
	public Boolean checkFollow(Follow f) {
		FollowId id = new FollowId();
		id.setUserNo(f.getUserNo().getUserNo());
		id.setFollow(f.getFollow().getUserNo());
		Optional<Follow> follow = repository.findById(id);
		if(follow.isPresent()) {
			return true;
		}
		return false;
		
	}
}
