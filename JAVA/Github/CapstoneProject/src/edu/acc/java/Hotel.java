package edu.acc.java;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long hotel_Id;
	private String hotel_Name;
	private String hotel_Address;
	private String hotel_Email;
	private String hotel_Description;
	private int hotel_Type; 		//1=Hotel; 2=Hostel; 3=Motel; 4=House
	private int num_Of_floors;
	private int num_Of_Rooms;
	
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Hotel(String hotel_Name, String hotel_Address, String hotel_Email,
			String hotel_Description, int hotel_Type, int num_Of_floors, int num_Of_Rooms) {
		super();
		this.hotel_Name = hotel_Name;
		this.hotel_Address = hotel_Address;
		this.hotel_Email = hotel_Email;
		this.hotel_Description = hotel_Description;
		this.hotel_Type = hotel_Type;
		this.num_Of_floors = num_Of_floors;
		this.num_Of_Rooms = num_Of_Rooms;
	}
	
}
