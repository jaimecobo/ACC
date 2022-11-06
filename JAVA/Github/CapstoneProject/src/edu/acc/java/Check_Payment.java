package edu.acc.java;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
}
