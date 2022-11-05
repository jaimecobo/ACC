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
public class Cash_Payment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Cash_Payment;
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	private Reservation reservation;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date payment_Date;
	private double amount;
	
	
	protected Cash_Payment() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected Cash_Payment(Customer customer, Reservation reservation, Date payment_Date, double amount) {
		super();
		this.customer = customer;
		this.reservation = reservation;
		this.payment_Date = payment_Date;
		this.amount = amount;
	}


	protected long getId_Cash_Payment() {
		return id_Cash_Payment;
	}


	protected void setId_Cash_Payment(long id_Cash_Payment) {
		this.id_Cash_Payment = id_Cash_Payment;
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


	protected Date getPayment_Date() {
		return payment_Date;
	}


	protected void setPayment_Date(Date payment_Date) {
		this.payment_Date = payment_Date;
	}


	protected double getAmount() {
		return amount;
	}


	protected void setAmount(double amount) {
		this.amount = amount;
	}
	
}
