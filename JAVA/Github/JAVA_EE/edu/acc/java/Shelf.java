package edu.acc.java;

import java.util.List;
import javax.persistence.*;

@Entity
public class Shelf {
	
	public Shelf() {}
	public Shelf(String location, List items) {
		this.location = location;
		this.items = items;
	}
@Id
@GeneratedValue
Long id;

String location;

@OneToMany(cascade=CascadeType.ALL)
List<Item> items;

}