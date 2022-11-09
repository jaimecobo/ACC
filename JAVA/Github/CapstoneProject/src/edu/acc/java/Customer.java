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
	
	protected Customer(String firstName, String lastName, String userName, String password, String address,
			String email, Document_Type document_Type, String document_Number, String phoneNumber, String company_Name,
			String origin_Nationality, String occupation, Date birthday, Date account_Creation_Date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.email = email;
		this.document_Type = document_Type;
		this.document_Number = document_Number;
		this.phoneNumber = phoneNumber;
		this.company_Name = company_Name;
		this.origin_Nationality = origin_Nationality;
		this.occupation = occupation;
		this.birthday = birthday;
		this.account_Creation_Date = account_Creation_Date;
	}

}

