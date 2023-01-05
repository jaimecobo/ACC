package edu.acc.java;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Reservation;
	@ManyToOne(cascade = CascadeType.ALL)
	private int id_Customer;
	@ManyToMany(cascade = CascadeType.ALL)
	private Room room_Number;
	@Temporal(value = TemporalType.TIMESTAMP)
	private String entry_Date;
	@Temporal(value = TemporalType.TIMESTAMP)
	private String departure_Date;
	private double initial_Payment;
	private double balance;
	private String status;
	
	

	protected Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	

//	protected Reservation(Customer id_Customer, Room room_Number, Date entry_Date, Date departure_Date,
//			double initial_Payment) {
//		super();
//		this.id_Customer = id_Customer;
//		this.room_Number = room_Number;
//		this.entry_Date = entry_Date;
//		this.departure_Date = departure_Date;
//		this.initial_Payment = initial_Payment;
//	}
	
}
