package com.team.order.entity;

import java.util.Date;

import com.team.project.entity.Reward;
import com.team.user.entity.Address;
import com.team.user.entity.Card;

public class OrderDTO {
	private int	orderNo;
	private Date orderDate;
	private int	totalPrice;
	private String orderResult;
	
	private AddressDTO	address;
	private CardDTO card;
	
	private Reward reward;
	
	public OrderDTO() {
		this.address = new AddressDTO();
		this.card= new CardDTO();
	}
	
	
	public void entityToDTO(Order order) {
		this.orderNo =order.getOrderNo();
		this.orderDate =order.getOrderDate();
		this.totalPrice =order.getTotalPrice();
		this.orderResult =order.getOrderResult();
		this.reward =order.getReward();
		
		
		//변역
		address.entityToDTO(order.getAddress());
		this.card.entityToDTO(order.getCard());
	}



	public int getOrderNo() {
		return orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public String getOrderResult() {
		return orderResult;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public CardDTO getCard() {
		return card;
	}

	public Reward getReward() {
		return reward;
	}
	
	
	
	
    public static class AddressDTO{
    	int addressNo;
    	String receiverName;
    	int receiverZipcode;
    	String receiverAddress;
		String receiverAddressDetailed;
		String receiverPhone;
		String defaultAddress;
		
		
		public void entityToDTO(Address a) {

			this.addressNo = a.getAddressNo();
			this.receiverName = a.getReceiverName();
			this.receiverZipcode = a.getReceiverZipcode();
			this.receiverAddress = a.getReceiverAddress();
			this.receiverAddressDetailed = a.getReceiverAddressDetailed();
			this.receiverPhone = a.getReceiverPhone();
			this.defaultAddress = a.getDefaultAddress();
		}

		public int getAddressNo() {
			return addressNo;
		}

		public String getReceiverName() {
			return receiverName;
		}

		public int getReceiverZipcode() {
			return receiverZipcode;
		}

		public String getReceiverAddress() {
			return receiverAddress;
		}

		public String getReceiverAddressDetailed() {
			return receiverAddressDetailed;
		}

		public String getReceiverPhone() {
			return receiverPhone;
		}

		public String getDefaultAddress() {
			return defaultAddress;
		}
		
		
		
    }
	
	
    public static class CardDTO {
        int cardNo;
        String cardNum;
        Date cardValidDate;
        String cardPwd;
        String cardOwnerBirth;
        String defaultCard;
			

			
		public void entityToDTO(Card card) {
			this.cardNo = card.getCardNo();
			this.cardNum = card.getCardNum();
			this.cardValidDate = card.getCardValidDate();
			this.cardPwd = card.getCardPwd();
			this.cardOwnerBirth = card.getCardOwnerBirth();
			this.defaultCard = card.getDefaultCard();
		}



		public int getCardNo() {
			return cardNo;
		}



		public String getCardNum() {
			return cardNum;
		}



		public Date getCardValidDate() {
			return cardValidDate;
		}



		public String getCardPwd() {
			return cardPwd;
		}



		public String getCardOwnerBirth() {
			return cardOwnerBirth;
		}



		public String getDefaultCard() {
			return defaultCard;
		}
		
		
        
        
        
    }
}
