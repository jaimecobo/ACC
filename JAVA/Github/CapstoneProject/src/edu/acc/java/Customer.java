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


	protected long getId_Customer() {
		return id_Customer;
	}


	protected void setId_Customer(long id_Customer) {
		this.id_Customer = id_Customer;
	}


	protected String getFirstName() {
		return firstName;
	}


	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	protected String getLastName() {
		return lastName;
	}


	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected String getUserName() {
		return userName;
	}

	protected void setUserName(String userName) {
		this.userName = userName;
	}

	protected String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	protected String getAddress() {
		return address;
	}


	protected void setAddress(String address) {
		this.address = address;
	}


	protected String getEmail() {
		return email;
	}


	protected void setEmail(String email) {
		this.email = email;
	}

	@Enumerated(EnumType.STRING)
	protected Document_Type getDocument_Type() {
		return document_Type;
	}


	protected void setDocument_Type(Document_Type document_Type) {
		this.document_Type = document_Type;
	}


	protected String getDocument_Number() {
		return document_Number;
	}


	protected void setDocument_Number(String document_Number) {
		this.document_Number = document_Number;
	}


	protected String getPhoneNumber() {
		return phoneNumber;
	}


	protected void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	protected String getCompany_Name() {
		return company_Name;
	}


	protected void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}


	protected String getOrigin_Nationality() {
		return origin_Nationality;
	}


	protected void setOrigin_Nationality(String origin_Nationality) {
		this.origin_Nationality = origin_Nationality;
	}


	protected String getOccupation() {
		return occupation;
	}


	protected void setOccupation(String occupation) {
		this.occupation = occupation;
	}


	protected Date getBirthday() {
		return birthday;
	}


	protected void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	protected Date getAccount_Creation_Date() {
		return account_Creation_Date;
	}


	protected void setAccount_Creation_Date(Date account_Creation_Date) {
		this.account_Creation_Date = account_Creation_Date;
	}
	
}

