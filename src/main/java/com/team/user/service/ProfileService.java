package com.team.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.order.entity.Order;
import com.team.order.repository.OrderRepository;
import com.team.project.entity.Project;
import com.team.project.repository.ProjectRepository;
import com.team.user.dto.ProfileIntroDTO;
import com.team.user.entity.Customer;
import com.team.user.entity.Follow;
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
	
	/**
	 * userUrl로 유저정보 찾기
	 * @param userUrl
	 * @return 유저정보
	 */
	public ProfileIntroDTO findByUserUrl(String userUrl) {
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
		
		return dto;
	}
}
