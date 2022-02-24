package com.team.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.user.entity.Customer;
import com.team.user.entity.Follow;
import com.team.user.entity.FollowId;
import com.team.user.repository.FollowRepository;

@Service
public class FollowService {
	@Autowired
	private FollowRepository repository;
	
	/**
	 * 내가 팔로우하고 있는 사람들을 조회한다
	 * @param c
	 * @return
	 */
	public List<Follow> following(Customer c) {
		return repository.findByUserNo(c);
	}
	
	/**
	 * 나를 팔로우하고 있는 사람들을 조회한다
	 * @param c
	 * @return
	 */
	public List<Follow> followers(Customer c) {
		return repository.findByFollow(c);
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
