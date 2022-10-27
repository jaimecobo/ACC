package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletJEEfinalProject")
public class ServletJEEfinalProject extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletJEEfinalProject() {
		super();
	}

	/**
	 * Final Project JavaEE
	 * 
	 * 1) Create the following entities marked up with JPA annotations:
	 * 
	 *    Car: 
	 *       id (auto incrementing PK)
	 *       vin (not null, max length 20)
	 *       manufacture_date (DATE)
	 *       transient planet_origin
	 *       enum color with 3 values
	 *       marketing blurb (2000 char max)
	 *       owner (M-1 to Person)
	 *       part_ids (M-M to Part)
	 *       
	 *  2) Part:
	 *       id (auto incrementing PK)
	 *       part_of (M-M to Car)
	 *       part_name
	 *       suppliers (1-M to Supplier) 
	 *       
	 *  3) Person:
	 *       id (auto incrementing PK)
	 *       first
	 *       last
	 *       birthday (TIMESTAMP)
	 *       cars_owned (1-M to Car)
	 *       
	 *  4) Supplier:
	 *       id (auto incrementing PK)
	 *       company_name
	 *       part_supplied (M-1 to Part)
	 *       
	 *  In a servlet, create at least 2 Persons, Cars, Parts, Suppliers and persist to the DB. 
	 *  Verify all the tables were created and relationships are correct with MySQL Workbench or equiv.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JPA related entity test servlet
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.println("JEE Final Project");

		Person person1, person2, person3;
        Car car1, car2, car3, car4;
		Supplier supplier1, supplier2, supplier3, supplier4;
		Part part1, part2;

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction xaction = em.getTransaction();
		out.println("transaction start");
		xaction.begin();

		try {
		// create people 
        person1 = new Person("Max", "Planck", new SimpleDateFormat("MM/dd/yyyy").parse("01/01/1910") ); 
		person2 = new Person("Bobby", "Fischer",new SimpleDateFormat("MM/dd/yyyy").parse("08/29/1930") );  
        person3 = new Person("Ghingis", "Vlad", new SimpleDateFormat("MM/dd/yyyy").parse("06/24/1959") ); 
		
		// create some suppliers
		supplier1 = new Supplier("SupplHose LLC");
		supplier2 = new Supplier("Magic Ride Comp.");
		supplier3 = new Supplier("Bad Parts Inc.");
		supplier4 = new Supplier("EtcFactor Inc.");

		// create some parts
		ArrayList<Supplier> list_of_Xinjector_suppliers = new ArrayList<Supplier>();
		list_of_Xinjector_suppliers.add(supplier4);
		list_of_Xinjector_suppliers.add(supplier3);
		part1 = new Part("Xinjector",list_of_Xinjector_suppliers );
		supplier4.setPart_name(part1);
		supplier3.setPart_name(part1);

		ArrayList<Supplier> list_of_Scompressor_suppliers = new ArrayList<Supplier>();
		list_of_Scompressor_suppliers.add(supplier2);
		list_of_Scompressor_suppliers.add(supplier1);
		part2 = new Part("Scompressor", list_of_Scompressor_suppliers);
		supplier2.setPart_name(part2);
		supplier1.setPart_name(part2);

		// create some cars
		car1 = new Car(Color.BLUE, person1, "FZ47782");
		car1.add_part(part1);
		car1.add_part(part2);
		part2.add_car(car1);
		person1.getCars_owned().add(car1);

		car2 = new Car(Color.RED, person2, "MK12345KJ");
		car2.add_part(part2);
		part2.add_car(car2);
		person2.getCars_owned().add(car2);

		car3 = new Car(Color.GREEN, person1, "CKJ234738");
		car3.add_part(part1);
		part1.add_car(car3);
		person1.getCars_owned().add(car3);

		car4 = new Car(Color.RED, person2, "FZ3WUIJ02");
		car4.add_part(part2);
		part2.add_car(car4);
		person2.getCars_owned().add(car4);

		// persist just the Person objects to test CascadeType.PERSIST
		em.persist(person1);
		em.persist(person2);
		em.persist(person3);
		out.println("transaction 1 end");
		xaction.commit();
		
//		// make a change on existing object
//		out.println("transaction 2 start");
//		em.getTransaction().begin();
//		person1.setLast("Jones");
//		out.println("transaction 2 end");
//		xaction.commit();
//		
//		System.out.println("find all cars with vin starting with 'FZ'");
//		Query query = em.createQuery("SELECT e FROM Car e WHERE e.vin LIKE 'FZ%'");
//	    List<Car> cars=(List<Car>)query.getResultList( );
//	    if (cars != null) {
//	        for( Car c: cars ) {
//	           System.out.println(c);
//	          }
//	    }
//
//	    // transfer title of 1st car to new owner
//	    Car car = cars.get(0);
//		out.println("transaction 3 start");
//		em.getTransaction().begin();
//		car.getOwner().getCars_owned().remove(car);  // remove current owner
//		person3.add_cars_owned(car);  // person3 now owns car
//		car.setOwner(person3);  // car knows now
//		out.println("transaction 3 end");
//		xaction.commit();
//
//		System.out.println("find all cars with parts from Bad Parts Inc.");
//		final String bad_parts = "Bad Parts";
//		query = em.createQuery("SELECT p FROM Part p, IN(p.suppliers) AS s WHERE s.company_name LIKE :comp_name");
//		query.setParameter("comp_name", bad_parts + "%");
//	    List<Part> parts=(List<Part>)query.getResultList( );
//	    if (parts != null) {
//	        for( Part p: parts ) {
//	           System.out.println(p);
//	          }
//	    }
//		// delete supplier Bad Parts Inc.
//		out.println("transaction 4 start");
//		em.getTransaction().begin();
//
//		// delete a supplier from parts manually since JPQL DELETE only applies to @Entity objects
//		Iterator<Part> parts_iter = parts.iterator();
//		while (parts_iter.hasNext()) {
//			Part part = parts_iter.next();
//			List<Supplier> suppliers = part.getSuppliers();
//			Iterator<Supplier> supplier_iter = suppliers.iterator();
//			while (supplier_iter.hasNext()) {
//				Supplier s =  supplier_iter.next();
//				if (s.getCompany_name().startsWith(bad_parts)) {
//					supplier_iter.remove();
//				}
//			}
//		}
//		em.flush();  // flush to prevent FK issues
//		
//		// and finally delete Bad Parts Inc. as a Supplier
//		query = em.createQuery("DELETE FROM Supplier s WHERE s.company_name LIKE :comp_name");
//		query.setParameter("comp_name", bad_parts + "%");
//		query.executeUpdate();
//		out.println("transaction 4 end");
//		xaction.commit();
		}

		catch (Exception ex) {
			System.out.println("Exception: rolling back " + ex);
			xaction.rollback();
		}

		finally {
			em.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}