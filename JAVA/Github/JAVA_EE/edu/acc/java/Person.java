package edu.acc.java;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Person {
	
	@Id
	@GeneratedValue  // note default strategy is GenerationType.AUTO
	private long id;

	private String first;
	private String last;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date birthday;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Car> cars_owned = new ArrayList<Car>();
	
	@Version
	protected Integer version;
	
	public Person() {
	}
	
	public Person(String first, String last, Date birthday) {
		this();
		this.first = first;
		this.last = last;
		this.birthday = birthday;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public List<Car> getCars_owned() {
		return cars_owned;
	}
	public void setCars_owned(List<Car> cars_owned) {
		this.cars_owned = cars_owned;
	}
	public void add_cars_owned(Car car) {
		this.cars_owned.add(car);
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", first=" + first + ", last=" + last
				+ ", birthday=" + birthday + ", cars_owned=" + get_cars_owned()
				+ ", version=" + version + "]";
	}
	
	public String get_cars_owned() {
		if (cars_owned.isEmpty()) 
			return "None";
		String car_list = "";
		for (Car car : this.cars_owned) {
			car_list += car.getVin() + " ";
		}
	    return car_list;	
	}

}