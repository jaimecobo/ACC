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


	protected Room(int room_Number, RoomType type, double base_Price, String description, boolean availability) {
		super();
		this.room_Number = room_Number;
		this.type = type;
		this.base_Price = base_Price;
		this.description = description;
		this.availability = availability;
	}


	protected int getRoom_Number() {
		return room_Number;
	}


	protected void setRoom_Number(int room_Number) {
		this.room_Number = room_Number;
	}


	protected RoomType getType() {
		return type;
	}


	protected void setType(RoomType type) {
		this.type = type;
	}


	protected double getBase_Price() {
		return base_Price;
	}


	protected void setBase_Price(double base_Price) {
		this.base_Price = base_Price;
	}


	protected String getDescription() {
		return description;
	}


	protected void setDescription(String description) {
		this.description = description;
	}


	protected boolean isAvailability() {
		return availability;
	}


	protected void setAvailability(boolean availability) {
		this.availability = availability;
	}

}
