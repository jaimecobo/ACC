package edu.acc.java;

import java.io.Serializable;

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

}
