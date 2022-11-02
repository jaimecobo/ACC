package edu.acc.java;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Room implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int room_Number;
	@Enumerated(EnumType.STRING)
	private RoomType type;
	private double base_Price;
	private String description;
	private boolean availability;
	
	
	protected Room() {
		super();
		// TODO Auto-generated constructor stub
	}

}
