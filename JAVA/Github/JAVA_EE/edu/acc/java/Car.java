package edu.acc.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class Car {
	@Id                           // use field annotations
	@GeneratedValue
    private long id;

	@Column(nullable=false, length=20)  // add some field constraints
	private String vin = "123-FGR-00009";
	
	@Temporal(TemporalType.DATE)  // only want date portion
	private Date manufacture_date = new Date();
	
	@Transient
	private int planet_origin = 6;  // should not see this in DB
    
	@Enumerated(EnumType.STRING)  // save the enum String itself
    Color color = Color.WHITE;  

    @Lob                             // use a CLOB
    private String marketing_blurb;  // 2K marketing verbiage (too big for VARCHAR)
    
	@ManyToOne
	private Person owner;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Part> part_ids = new ArrayList<>();
	
    @Version
	protected Integer version;
	
	public Car() {}
	
	public Car(Color color, Person owner, String vin) {
		this.color = color;
		this.owner = owner;
		this.vin = vin;
		this.marketing_blurb = "Great " + color + " car! Blah blah";
		
	}
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Date getManufacture_date() {
		return manufacture_date;
	}

	public void setManufacture_date(Date manufacture_date) {
		this.manufacture_date = manufacture_date;
	}

	public int getPlanet_origin() {
		return planet_origin;
	}

	public void setPlanet_origin(int planet_origin) {
		this.planet_origin = planet_origin;
	}

	public String getMarketing_blurb() {
		return marketing_blurb;
	}

	public void setMarketing_blurb(String marketing_blurb) {
		this.marketing_blurb = marketing_blurb;
	}

	public List<Part> getPart_ids() {
		return part_ids;
	}

	public void setPart_ids(List<Part> part_ids) {
		this.part_ids = part_ids;
	}
	
	public void add_part(Part part_id) {
		part_ids.add(part_id);
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public String getModel() {
		return vin;
	}
	public void setModel(String model) {
		this.vin = model;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + " owner=" + owner.getFirst() + " " + owner.getLast() 
				+ ", vin=" + vin + ", manufacture_date="
				+ manufacture_date + ", planet_origin=" + planet_origin
				+ ", color=" + color + ", marketing_blurb=" + marketing_blurb
				+ ", part_ids=" + get_parts() + ", version="
				+ version + "]";
	}

	public String get_parts() {
		if (part_ids.isEmpty()) 
			return "None";
		String parts_list = "";
		for (Part part : this.part_ids) {
			parts_list += part.getPart_name() + " ";
		}
	    return parts_list;	
	}
}