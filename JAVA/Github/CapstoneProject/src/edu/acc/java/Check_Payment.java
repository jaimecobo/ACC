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
public class Check_Payment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Check_Payment;
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	private Reservation reservation;
	private int check_Number;
	private String check_Bank;
	private String check_Name;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date check_Date;
	private double amount;
	
	
	protected Check_Payment() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected Check_Payment(Customer customer, Reservation reservation, int check_Number, String check_Bank,
			String check_Name, Date check_Date, double amount) {
		super();
		this.customer = customer;
		this.reservation = reservation;
		this.check_Number = check_Number;
		this.check_Bank = check_Bank;
		this.check_Name = check_Name;
		this.check_Date = check_Date;
		this.amount = amount;
	}

}
