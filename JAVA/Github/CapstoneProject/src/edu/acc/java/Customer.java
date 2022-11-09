package edu.acc.java;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
}

