package edu.acc.java;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Item {

	public Item() {
	}

	public Item(String name, int count) {
		this.name = name;
		this.count = count;
	}

	@Id
	@GeneratedValue
	Long id;
	String name;
	Integer count;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}