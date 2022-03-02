package com.team.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.interest.repository.InterestRepository;
import com.team.order.entity.Order;
import com.team.order.repository.OrderRepository;
import com.team.project.entity.Project;
import com.team.project.repository.ProjectRepository;
import com.team.user.dto.ProfileIntroDTO;
import com.team.user.dto.ProfileOrderDTO;
import com.team.user.entity.Customer;
import com.team.user.entity.Follow;
import com.team.user.entity.FollowId;
import com.team.user.repository.CustomerRepository;
import com.team.user.repository.FollowRepository;

@Service
public class ProfileService {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private FollowRepository followRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private InterestRepository interestRepository;
	
	/**
	 * userUrl로 유저정보 찾기
	 * @param userUrl
	 * @return 유저정보
	 */
	public ProfileIntroDTO findProfileByUserUrl(String userUrl, Customer customer) {
		Customer c = customerRepository.findByUserUrl(userUrl);
		ProfileIntroDTO dto = new ProfileIntroDTO();
		dto.entityToDTO(c);
		
		List<Project> pList = projectRepository.findByMaker(c);
		List<Follow> followerList = followRepository.findByFollow(c);
		List<Follow> followingList = followRepository.findByUserNo(c);
		List<Order> orderList = orderRepository.findByOrderUser(c);
		
		dto.setCreatedProjectCnt(pList.size());
		dto.setFollowerCnt(followerList.size());
		dto.setFollowingCnt(followingList.size());
		dto.setOrderProjectCnt(orderList.size());
		
		//내가 팔로우 하고 있는지 체크
		FollowId id = new FollowId();
		id.setUserNo(customer.getUserNo());
		id.setFollow(c.getUserNo());
		Optional<Follow> checkF = followRepository.findById(id);

		if(checkF.isPresent()) {
			dto.setFollowCheck(true);
		}else {
			dto.setFollowCheck(false);
		}
		
		return dto;
	}
	/**
	 * 로그인 안했을 때 프로필 조회
	 * @param userUrl
	 * @return
	 */
	public ProfileIntroDTO findProfileByUserUrl(String userUrl) {
		Customer c = customerRepository.findByUserUrl(userUrl);
		ProfileIntroDTO dto = new ProfileIntroDTO();
		dto.entityToDTO(c);
		
		List<Project> pList = projectRepository.findByMaker(c);
		List<Follow> followerList = followRepository.findByFollow(c);
		List<Follow> followingList = followRepository.findByUserNo(c);
		List<Order> orderList = orderRepository.findByOrderUser(c);
		
		dto.setCreatedProjectCnt(pList.size());
		dto.setFollowerCnt(followerList.size());
		dto.setFollowingCnt(followingList.size());
		
		dto.setFollowCheck(false);
		
		return dto;
	}
	
	public Object findProfileOrder(Customer c) {
		Map<String, Object> returnMap = new HashMap<>();
		List<ProfileOrderDTO> list = new ArrayList<>();
		
		List<Order> orderList = orderRepository.findByOrderUser(c);
		
		for(Order o: orderList) {
			ProfileOrderDTO dto = new ProfileOrderDTO();
			dto.entityToDTO(o);
			
			if(interestRepository.findByLikeProjectAndLikeUser(o.getProject(), c) != null) {
				dto.setCheckLike(true);
			}else{
				dto.setCheckLike(false);
			}
			list.add(dto);
		}
		
		List<Project> pList = projectRepository.findByMaker(c);
		List<Follow> followerList = followRepository.findByFollow(c);
		List<Follow> followingList = followRepository.findByUserNo(c);
		
		returnMap.put("userNo", c.getUserNo());
		returnMap.put("userImage", c.getUserImage());
		returnMap.put("userName", c.getUserName());
		returnMap.put("orders", list);
		returnMap.put("createdProjectCnt", pList.size());
		returnMap.put("followerCnt", followerList.size());
		returnMap.put("followingCnt", followingList.size());
		
		return returnMap;
	}
}
