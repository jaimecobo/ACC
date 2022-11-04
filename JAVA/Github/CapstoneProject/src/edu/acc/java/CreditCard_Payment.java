package edu.acc.java;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CreditCard_Payment implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_CreditCard_Payment;
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	private Reservation reservation;
	private CreditCard creditCard;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date payment_Date;
	private String verification_Number;
	private double amount;
	
	
	protected CreditCard_Payment() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected CreditCard_Payment(Customer customer, Reservation reservation, CreditCard creditCard, Date payment_Date,
			String verification_Number, double amount) {
		super();
		this.customer = customer;
		this.reservation = reservation;
		this.creditCard = creditCard;
		this.payment_Date = payment_Date;
		this.verification_Number = verification_Number;
		this.amount = amount;
	}


	protected long getId_CreditCard_Payment() {
		return id_CreditCard_Payment;
	}


	protected void setId_CreditCard_Payment(long id_CreditCard_Payment) {
		this.id_CreditCard_Payment = id_CreditCard_Payment;
	}


	protected Customer getCustomer() {
		return customer;
	}


	protected void setCustomer(Customer customer) {
		this.customer = customer;
	}


	protected Reservation getReservation() {
		return reservation;
	}


	protected void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	protected CreditCard getCreditCard() {
		return creditCard;
	}


	protected void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}


	protected Date getPayment_Date() {
		return payment_Date;
	}


	protected void setPayment_Date(Date payment_Date) {
		this.payment_Date = payment_Date;
	}


	protected String getVerification_Number() {
		return verification_Number;
	}


	protected void setVerification_Number(String verification_Number) {
		this.verification_Number = verification_Number;
	}


	protected double getAmount() {
		return amount;
	}


	protected void setAmount(double amount) {
		this.amount = amount;
	}
	
}
