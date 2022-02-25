package com.team.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.project.entity.Category;
import com.team.project.entity.Project;
import com.team.project.entity.Reward;
import com.team.project.repository.CategoryRepository;
import com.team.project.repository.ProjectRepository;
import com.team.project.repository.RewardRepository;
import com.team.user.entity.Customer;

@Service
public class ProjectService {
	
	@Autowired
	private RewardRepository rewardRepository;

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Reward findByRewardNo(int rewardNo) {
		return rewardRepository.findByRewardNo(rewardNo);
	}
	
	//public List<Reward> findByProjectNo(Project p) {
	//	return rewardRepository.findByProject(p);
	//}
	
	
	public Project findByProjectNo(int projectNo) {
		return projectRepository.findByProjectNo(projectNo);
	}
	
	/**
	 * 로그인한 유저가 만든 프로젝트 리스트를 반환한다
	 * @param c 프로젝트 만든 유저 객체
	 * @return 프로젝트리스트
	 */
	public List<Project> createdProject(Customer c) {
		return projectRepository.findByMaker(c);
	}
	
	public List<Category> findAllCategory() {
		return (List<Category>) categoryRepository.findAll();
	}

	public Object save(Project p) {
		// TODO Auto-generated method stub
		return projectRepository.save(p);
	}
}
