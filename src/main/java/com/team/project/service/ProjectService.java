package com.team.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.interest.repository.InterestRepository;
import com.team.project.dto.CreatedProjectDTO;
import com.team.project.dto.ProjectDTO;
import com.team.project.entity.Category;
import com.team.project.entity.Project;
import com.team.project.entity.Reward;
import com.team.project.repository.CategoryRepository;
import com.team.project.repository.ProjectRepository;
import com.team.project.repository.QueryRepository;
import com.team.project.repository.RequestDataSelector;
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
	@Autowired
	private InterestRepository interestRepository;
	@Autowired
	private QueryRepository queryRepository;
	
	Customer loginedUser;
	
	public ProjectService() {
		final int LOGINED_USER_NO= 1;
		loginedUser = new Customer();
		loginedUser.setUserNo(LOGINED_USER_NO);
	}

	public ProjectDTO findByProjectNo(int projectNo,Customer c) {

		ProjectDTO dto = new ProjectDTO();
		Project p =projectRepository.findByProjectNo(projectNo);
		
		//check User interest(로그인 안되있으면 조회도 안되게 수정할것)
		if(isLoginedUserThisProjectInterested(p,c)) {
			dto.setLoginedUserProjectInterest(true);
		}
		
		dto.entityToDTO(p);
		return dto;
	}
	


	public List<ProjectDTO> findByRDS(RequestDataSelector rds, Customer c ) {

		List<ProjectDTO> dtoList = new ArrayList<ProjectDTO>();
		List<Project> list =queryRepository.findByRequestData(rds);
		
		for(Project p : list) {
			ProjectDTO dto = new ProjectDTO();
			dto.entityToDTO(p);
			dto.setReward(null);

			if(isLoginedUserThisProjectInterested(p,c)) {
				dto.setLoginedUserProjectInterest(true);
			}
			dtoList.add(dto);
		}

		return dtoList;
	}
	
	//로그인한 유저가 좋아한 프로젝트 찾기
	private boolean isLoginedUserThisProjectInterested(Project p, Customer loginedUser) {
		if (interestRepository.findByLikeProjectAndLikeUser(p,loginedUser) == null) {
			return false;
		}
		return true;
	}

	public Reward findByRewardNo(int rewardNo) {
		return rewardRepository.findByRewardNo(rewardNo);
	}
	
	/**
	 * 로그인한 유저가 만든 프로젝트 리스트를 반환한다
	 * @param c 프로젝트 만든 유저 객체
	 * @return 프로젝트리스트
	 */
	public List<CreatedProjectDTO> createdProject(Customer c) {
		List<CreatedProjectDTO> list = new ArrayList<>();
		List<Project> pList = projectRepository.findByMaker(c);
		for(Project p : pList) {
			CreatedProjectDTO dto = new CreatedProjectDTO();
			dto.entityToDTO(p);
			list.add(dto);
		}
		return list;
//		return projectRepository.findByMaker(c);
	}
	
	public List<Category> findAllCategory() {
		return (List<Category>) categoryRepository.findAll();
	}

	public Object save(Project p) {
		// TODO Auto-generated method stub
		return projectRepository.save(p);
	}
}
