package edu.acc.java;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CreditCard implements Serializable{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id_CreditCard;
		@ManyToOne(cascade = CascadeType.ALL)
		private Customer customer;
		@Enumerated(EnumType.STRING)
		private CreditCardType cardType;		//{VISA, MASTERCARD, AMERICAN_EXPRESS, DISCOVER, OTHER}
		private String name;
		private String number;
		private int ccv;	
		private int zipCode;
		
		
		protected CreditCard() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		

		protected CreditCard(Customer customer, CreditCardType cardType, String name, String number, int ccv,
				int zipCode) {
			super();
			this.customer = customer;
			this.cardType = cardType;
			this.name = name;
			this.number = number;
			this.ccv = ccv;
			this.zipCode = zipCode;
		}


		protected long getId_CreditCard() {
			return id_CreditCard;
		}


		protected void setId_CreditCard(long id_CreditCard) {
			this.id_CreditCard = id_CreditCard;
		}
		
		protected Customer getCustomer() {
			return customer;
		}

		protected void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Enumerated(EnumType.STRING)
		protected CreditCardType getCardType() {
			return cardType;
		}

		protected void setCardType(CreditCardType cardType) {
			this.cardType = cardType;
		}


		protected String getName() {
			return name;
		}


		protected void setName(String name) {
			this.name = name;
		}


		protected String getNumber() {
			return number;
		}


		protected void setNumber(String number) {
			this.number = number;
		}


		protected int getCcv() {
			return ccv;
		}


		protected void setCcv(int ccv) {
			this.ccv = ccv;
		}


		protected int getZipCode() {
			return zipCode;
		}


		protected void setZipCode(int zipCode) {
			this.zipCode = zipCode;
		}
	
}
