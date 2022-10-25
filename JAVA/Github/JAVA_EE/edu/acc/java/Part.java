package edu.acc.java;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Part {
	
	protected Part() {
	}

	public Part(String part_name, List<Supplier> suppliers) {
		this.part_name = part_name;
		this.suppliers = suppliers;
	}

	@Id
	@GeneratedValue
	private long id;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Car>  part_of = new ArrayList<>();
	
	private String part_name = "Unknown Part";
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Car> getPart_of() {
		return part_of;
	}

	public void setPart_of(List<Car> part_of) {
		this.part_of = part_of;
	}

	public void add_car(Car car) {
		part_of.add(car);
	}
	public String getPart_name() {
		return part_name;
	}

	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public void addSupplier(Supplier supplier) {
		suppliers.add(supplier);
	}

	@Override
	public String toString() {
		return "Part [id=" + id + ", part_of=" + get_cars() + ", part_name="
				+ part_name + ", suppliers=" + get_suppliers() + "]";
	}

	public String get_suppliers() {
		if (suppliers.isEmpty()) 
			return "None";
		String supplier_list = "";
		for (Supplier supplier : this.suppliers) {
			supplier_list += supplier.getCompany_name() + " ";
		}
	    return supplier_list;	
	}

	public String get_cars() {
		if (part_of.isEmpty()) 
			return "None";
		String car_list = "";
		for (Car car : this.part_of) {
			car_list += car.getVin() + " ";
		}
	    return car_list;	
	}
}