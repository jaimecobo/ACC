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
	
}
