package edu.acc.java;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Customer;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;					//TODO Encryption
	private String address;
	private String email;
	@Enumerated(EnumType.STRING)
	private Document_Type document_Type;		//{PASSPORT, DRIVER_LICENSE, ID_CARD, OTHER}
	private String document_Number;
	private String phoneNumber;
	private String company_Name;
	private String origin_Nationality;
	private String occupation;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date birthday;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date account_Creation_Date;
	
	
	protected Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

