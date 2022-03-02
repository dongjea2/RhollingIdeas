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
import com.team.project.repository.QueryRepository;
import com.team.user.dto.FollowDTO;
import com.team.user.dto.ProfileDTO;
import com.team.user.dto.ProfileFollowDTO;
import com.team.user.dto.ProfileIntroDTO;
import com.team.user.dto.ProfileProjectDTO;
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
	@Autowired
	private QueryRepository queryRepository;
	
	/**
	 * userUrl로 유저정보 찾기
	 * @param userUrl
	 * @return 유저정보
	 */
	public ProfileIntroDTO findProfileByUserUrl(String userUrl, Customer customer) {
		Customer c = customerRepository.findByUserUrl(userUrl);
		ProfileIntroDTO dto = new ProfileIntroDTO();
		dto.entityToDTO(c);
		
		List<Project> pList = queryRepository.findByMakerAndApprovalStatus(c);
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
		
		List<Project> pList = queryRepository.findByMakerAndApprovalStatus(c);
		List<Follow> followerList = followRepository.findByFollow(c);
		List<Follow> followingList = followRepository.findByUserNo(c);
		
		dto.setCreatedProjectCnt(pList.size());
		dto.setFollowerCnt(followerList.size());
		dto.setFollowingCnt(followingList.size());
		
		dto.setFollowCheck(false);
		
		return dto;
	}
	
	public ProfileDTO findProfileOrder(Customer c) {
		List<ProfileProjectDTO> orderList = new ArrayList<>();
		
		List<Order> oList = orderRepository.findByOrderUser(c);
		
		for(Order o: oList) {
			ProfileProjectDTO pdto = new ProfileProjectDTO();
			pdto.orderEntityToDTO(o);
			
			if(interestRepository.findByLikeProjectAndLikeUser(o.getProject(), c) != null) {
				pdto.setCheckLike(true);
			}else{
				pdto.setCheckLike(false);
			}
			orderList.add(pdto);
		}
		
		List<Project> pList = queryRepository.findByMakerAndApprovalStatus(c);
		List<Follow> followerList = followRepository.findByFollow(c);
		List<Follow> followingList = followRepository.findByUserNo(c);
		
		ProfileDTO dto = new ProfileDTO();
		dto.entityToDTO(c);
		dto.setProjects(orderList);
		dto.setOrderProjectCnt(orderList.size());
		dto.setCreatedProjectCnt(pList.size());
		dto.setFollowerCnt(followerList.size());
		dto.setFollowingCnt(followingList.size());
		
		return dto;
	}
	
	/**
	 * 로그인 했을때 프로필페이지의 올린 프로젝트 조회
	 * @param userUrl 프로필 당사자
	 * @param c 프로필 조회 유저(로그인한)
	 * @return
	 */
	public Object findProfileCreated(String userUrl, Customer c) {
		Customer customer = customerRepository.findByUserUrl(userUrl);
		List<ProfileProjectDTO> projectList = new ArrayList<>();
		
		List<Project> pList = queryRepository.findByMakerAndApprovalStatus(customer);
		for(Project p: pList) {
			ProfileProjectDTO pdto = new ProfileProjectDTO();
			pdto.projectEntityToDTO(p);
			if(interestRepository.findByLikeProjectAndLikeUser(p, c) != null) {
				pdto.setCheckLike(true);
			}else{
				pdto.setCheckLike(false);
			}
			projectList.add(pdto);
		}
		
		List<Order> orderList = orderRepository.findByOrderUser(customer);
		List<Follow> followerList = followRepository.findByFollow(customer);
		List<Follow> followingList = followRepository.findByUserNo(customer);
		
		ProfileDTO dto = new ProfileDTO();
		dto.entityToDTO(customer);
		dto.setProjects(projectList);
		dto.setOrderProjectCnt(orderList.size());
		dto.setCreatedProjectCnt(projectList.size());
		dto.setFollowerCnt(followerList.size());
		dto.setFollowingCnt(followingList.size());
		
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
	 * 로그인 안했을 때 프로필페이지의 올린 프로젝트 조회
	 * @param userUrl 프로필 당사자
	 * @return
	 */
	public Object findProfileCreated(String userUrl) {
		Customer customer = customerRepository.findByUserUrl(userUrl);
		List<ProfileProjectDTO> projectList = new ArrayList<>();
		
		List<Project> pList = queryRepository.findByMakerAndApprovalStatus(customer);
		for(Project p: pList) {
			ProfileProjectDTO pdto = new ProfileProjectDTO();
			pdto.projectEntityToDTO(p);
			pdto.setCheckLike(false);
			projectList.add(pdto);
		}
		
		List<Order> orderList = orderRepository.findByOrderUser(customer);
		List<Follow> followerList = followRepository.findByFollow(customer);
		List<Follow> followingList = followRepository.findByUserNo(customer);
		
		ProfileDTO dto = new ProfileDTO();
		dto.entityToDTO(customer);
		dto.setProjects(projectList);
		dto.setOrderProjectCnt(orderList.size());
		dto.setCreatedProjectCnt(projectList.size());
		dto.setFollowerCnt(followerList.size());
		dto.setFollowingCnt(followingList.size());
		dto.setFollowCheck(false);

		return dto;
	}
	
	/**
	 * 로그인 했을때 프로필페이지의 팔로워 조회
	 * @param userUrl 프로필 당사자
	 * @param c 프로필 조회 유저(로그인한)
	 * @return
	 */
	public Object findProfileFollower(String userUrl, Customer c) {
		Customer customer = customerRepository.findByUserUrl(userUrl);
		List<FollowDTO> followerList = new ArrayList<>();
		
		List<Follow> fList = followRepository.findByFollow(customer);
		for(Follow f : fList) {
			FollowDTO dto = new FollowDTO();
			dto.entityToDTOFollower(f);
			
			//내가 팔로우하는지 확인한다.
			FollowId id = new FollowId();
			id.setUserNo(c.getUserNo());
			id.setFollow(f.getUserNo().getUserNo());
			Optional<Follow> checkF = followRepository.findById(id);
			if(checkF.isPresent()) {
				dto.setFollowCheck(true);
			}else {
				dto.setFollowCheck(false);
			}
			//팔로워 카운트
			Customer c1 = new Customer();
			c1.setUserNo(f.getUserNo().getUserNo());
			List<Follow> fCnt = followRepository.findByFollow(c1);
			dto.setFollowerCnt(fCnt.size());
			
			//올린프로젝트 카운트
			List<Project> pList = queryRepository.findByMakerAndApprovalStatus(c1);
			dto.setCreatedCnt(pList.size());
			
			followerList.add(dto);
		}
		List<Order> orderList = orderRepository.findByOrderUser(customer);
		List<Project> projectList = queryRepository.findByMakerAndApprovalStatus(customer);
		List<Follow> followingList = followRepository.findByUserNo(customer);
		
		ProfileFollowDTO dto = new ProfileFollowDTO();
		dto.entityToDTO(customer);
		dto.setFollows(followerList);
		dto.setOrderProjectCnt(orderList.size());
		dto.setCreatedProjectCnt(projectList.size());
		dto.setFollowerCnt(followerList.size());
		dto.setFollowingCnt(followingList.size());
		
		//내가 팔로우 하고 있는지 체크
		FollowId id = new FollowId();
		id.setUserNo(c.getUserNo());
		id.setFollow(customer.getUserNo());
		Optional<Follow> checkF = followRepository.findById(id);
		
		if(checkF.isPresent()) {
			dto.setFollowCheck(true);
		}else {
			dto.setFollowCheck(false);
		}
		return dto;
	}
	
	/**
	 * 로그인 안했을 때 프로필페이지의 팔로워 조회
	 * @param userUrl 프로필 당사자
	 * @return
	 */
	public Object findProfileFollower(String userUrl) {
		Customer customer = customerRepository.findByUserUrl(userUrl);
		List<FollowDTO> followerList = new ArrayList<>();
		
		List<Follow> fList = followRepository.findByFollow(customer);
		for(Follow f : fList) {
			FollowDTO dto = new FollowDTO();
			dto.entityToDTOFollower(f);
			
			dto.setFollowCheck(false);
			
			//팔로워 카운트
			Customer c1 = new Customer();
			c1.setUserNo(f.getUserNo().getUserNo());
			List<Follow> fCnt = followRepository.findByFollow(c1);
			dto.setFollowerCnt(fCnt.size());
			
			//올린프로젝트 카운트
			List<Project> pList = queryRepository.findByMakerAndApprovalStatus(c1);
			dto.setCreatedCnt(pList.size());
			
			followerList.add(dto);
		}
		List<Order> orderList = orderRepository.findByOrderUser(customer);
		List<Project> projectList = queryRepository.findByMakerAndApprovalStatus(customer);
		List<Follow> followingList = followRepository.findByUserNo(customer);
		
		ProfileFollowDTO dto = new ProfileFollowDTO();
		dto.entityToDTO(customer);
		dto.setFollows(followerList);
		dto.setOrderProjectCnt(orderList.size());
		dto.setCreatedProjectCnt(projectList.size());
		dto.setFollowerCnt(followerList.size());
		dto.setFollowingCnt(followingList.size());
		dto.setFollowCheck(false);
		
		return dto;
	}
	
	/**
	 * 로그인 했을때 프로필페이지의 팔로잉 조회
	 * @param userUrl 프로필 당사자
	 * @param c 프로필 조회 유저(로그인한)
	 * @return
	 */
	public Object findProfilefollowing(String userUrl, Customer c) {
		Customer customer = customerRepository.findByUserUrl(userUrl);
		List<FollowDTO> followingList = new ArrayList<>();
		
		List<Follow> fList = followRepository.findByUserNo(customer);
		for(Follow f : fList) {
			FollowDTO dto = new FollowDTO();
			dto.entityToDTOFollowing(f);
			
			//내가 팔로우하는지 확인한다.
			FollowId id = new FollowId();
			id.setUserNo(c.getUserNo());
			id.setFollow(f.getFollow().getUserNo());
			Optional<Follow> checkF = followRepository.findById(id);
			if(checkF.isPresent()) {
				dto.setFollowCheck(true);
			}else {
				dto.setFollowCheck(false);
			}
			
			//팔로워 카운트
			Customer c1 = new Customer();
			c1.setUserNo(f.getFollow().getUserNo());
			List<Follow> fCnt = followRepository.findByFollow(c1);
			dto.setFollowerCnt(fCnt.size());
			
			//올린프로젝트 카운트
			List<Project> pList = queryRepository.findByMakerAndApprovalStatus(c1);
			dto.setCreatedCnt(pList.size());
			
			followingList.add(dto);
		}
		List<Order> orderList = orderRepository.findByOrderUser(customer);
		List<Project> projectList = queryRepository.findByMakerAndApprovalStatus(customer);
		List<Follow> followerList = followRepository.findByFollow(customer);
		
		ProfileFollowDTO dto = new ProfileFollowDTO();
		dto.entityToDTO(customer);
		dto.setFollows(followingList);
		dto.setOrderProjectCnt(orderList.size());
		dto.setCreatedProjectCnt(projectList.size());
		dto.setFollowerCnt(followerList.size());
		dto.setFollowingCnt(followingList.size());
		
		//내가 팔로우 하고 있는지 체크
		FollowId id = new FollowId();
		id.setUserNo(c.getUserNo());
		id.setFollow(customer.getUserNo());
		Optional<Follow> checkF = followRepository.findById(id);
		
		if(checkF.isPresent()) {
			dto.setFollowCheck(true);
		}else {
			dto.setFollowCheck(false);
		}
		
		return dto;
	}
	
	/**
	 * 로그인 안했을 때 프로필페이지의 팔로잉 조회
	 * @param userUrl 프로필 당사자
	 * @return
	 */
	public Object findProfilefollowing(String userUrl) {
		Customer customer = customerRepository.findByUserUrl(userUrl);
		List<FollowDTO> followingList = new ArrayList<>();
		
		List<Follow> fList = followRepository.findByUserNo(customer);
		for(Follow f : fList) {
			FollowDTO dto = new FollowDTO();
			dto.entityToDTOFollowing(f);
			
			dto.setFollowCheck(false);
			
			//팔로워 카운트
			Customer c1 = new Customer();
			c1.setUserNo(f.getFollow().getUserNo());
			List<Follow> fCnt = followRepository.findByFollow(c1);
			dto.setFollowerCnt(fCnt.size());
			
			//올린프로젝트 카운트
			List<Project> pList = queryRepository.findByMakerAndApprovalStatus(c1);
			dto.setCreatedCnt(pList.size());
			
			followingList.add(dto);
		}
		List<Order> orderList = orderRepository.findByOrderUser(customer);
		List<Project> projectList = queryRepository.findByMakerAndApprovalStatus(customer);
		List<Follow> followerList = followRepository.findByFollow(customer);
		
		ProfileFollowDTO dto = new ProfileFollowDTO();
		dto.entityToDTO(customer);
		dto.setFollows(followingList);
		dto.setOrderProjectCnt(orderList.size());
		dto.setCreatedProjectCnt(projectList.size());
		dto.setFollowerCnt(followerList.size());
		dto.setFollowingCnt(followingList.size());
		dto.setFollowCheck(false);
		
		return dto;
	}
}
