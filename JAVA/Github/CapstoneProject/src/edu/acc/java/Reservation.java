package edu.acc.java;

import java.io.Serializable;
//import java.util.Date;

//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

//@Entity
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Reservation;
////	@ManyToOne(cascade = CascadeType.ALL)
	private int id_Customer;
////	@ManyToMany(cascade = CascadeType.ALL)
	private Room room_Number;
//	@Temporal(value = TemporalType.TIMESTAMP)
	private String entry_Date;
//	@Temporal(value = TemporalType.TIMESTAMP)
	private String departure_Date;
	private double initial_Payment;
	private double balance;
	private String status;
	
	
	protected Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected Reservation(long id_Reservation, int id_Customer, String entry_Date, String departure_Date, double balance, String status) {
		super();
		this.id_Customer = id_Customer;
		this.entry_Date = entry_Date;
		this.departure_Date = departure_Date;
		this.balance = balance;
		this.status = status;
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
	

	public long getId_Reservation() {
		return id_Reservation;
	}


	public void setId_Reservation(long id_Reservation) {
		this.id_Reservation = id_Reservation;
	}


	public int getId_Customer() {
		return id_Customer;
	}


	public void setId_Customer(int id_Customer) {
		this.id_Customer = id_Customer;
	}


	public Room getRoom_Number() {
		return room_Number;
	}


	public void setRoom_Number(Room room_Number) {
		this.room_Number = room_Number;
	}


	public String getEntry_Date() {
		return entry_Date;
	}


	public void setEntry_Date(String entry_Date) {
		this.entry_Date = entry_Date;
	}


	public String getDeparture_Date() {
		return departure_Date;
	}


	public void setDeparture_Date(String departure_Date) {
		this.departure_Date = departure_Date;
	}


	public double getInitial_Payment() {
		return initial_Payment;
	}


	public void setInitial_Payment(double initial_Payment) {
		this.initial_Payment = initial_Payment;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
