package edu.acc.java;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Supplier {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String company_name;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Part part_supplied;
	
	protected Supplier() {
	}

	public Supplier(String name) {
		this.company_name = name;
	}

	public Supplier(String name, Part part) {
		this(name);
		this.part_supplied = part;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public Part getPart_name() {
		return part_supplied;
	}

	public void setPart_name(Part part_name) {
		this.part_supplied= part_name;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", company_name=" + company_name
				+ ", part_supplied=" + part_supplied.getPart_name() + "]";
	}

}