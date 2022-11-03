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


	public long getHotel_Id() {
		return hotel_Id;
	}


	public void setHotel_Id(long hotel_Id) {
		this.hotel_Id = hotel_Id;
	}


	public String getHotel_Name() {
		return hotel_Name;
	}


	public void setHotel_Name(String hotel_tName) {
		this.hotel_Name = hotel_tName;
	}


	public String getHotel_Address() {
		return hotel_Address;
	}


	public void setHotel_Address(String hotel_Address) {
		this.hotel_Address = hotel_Address;
	}


	public String getHotel_Email() {
		return hotel_Email;
	}


	public void setHotel_Email(String hotel_Email) {
		this.hotel_Email = hotel_Email;
	}


	public String getHotel_Description() {
		return hotel_Description;
	}


	public void setHotel_Description(String hotel_Description) {
		this.hotel_Description = hotel_Description;
	}


	public int getHotel_Type() {
		return hotel_Type;
	}


	public void setHotel_Type(int hotel_Type) {
		this.hotel_Type = hotel_Type;
	}


	public int getNum_Of_floors() {
		return num_Of_floors;
	}


	public void setNum_Of_floors(int num_Of_floors) {
		this.num_Of_floors = num_Of_floors;
	}


	public int getNum_Of_Rooms() {
		return num_Of_Rooms;
	}


	public void setNum_Of_Rooms(int num_Of_Rooms) {
		this.num_Of_Rooms = num_Of_Rooms;
	}
	
}
