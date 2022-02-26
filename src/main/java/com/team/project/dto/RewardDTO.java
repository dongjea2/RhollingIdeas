package com.team.project.dto;

import com.team.project.entity.Reward;

public class RewardDTO {

	private int	rewardNo          ;
	private int	rewardPrice       ;
	private String	rewardName    ;
	private Integer	deliverDate   ;
	private Integer	rewardNum     ;
	private int	rewardSalesCnt    ;
	private String	itemName      ;
	private String	deliverSelect ;
	
	public void entityToDTO(Reward r ) {
		this.rewardNo = r.getRewardNo();
		this.rewardPrice = r.getRewardPrice();
		this.rewardName = r.getRewardName();
		this.deliverDate = r.getDeliverDate();
		this.rewardNum = r.getRewardNum();
		this.rewardSalesCnt = r.getRewardSalesCnt();
		this.itemName = r.getItemName();
		this.deliverSelect = r.getDeliverSelect();
	}



	public int getRewardNo() {
		return rewardNo;
	}
	public int getRewardPrice() {
		return rewardPrice;
	}
	public String getRewardName() {
		return rewardName;
	}
	public Integer getDeliverDate() {
		return deliverDate;
	}
	public Integer getRewardNum() {
		return rewardNum;
	}
	public int getRewardSalesCnt() {
		return rewardSalesCnt;
	}
	public String getItemName() {
		return itemName;
	}
	public String getDeliverSelect() {
		return deliverSelect;
	}
	
	
}
