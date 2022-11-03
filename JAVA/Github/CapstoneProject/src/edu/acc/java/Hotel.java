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

}
