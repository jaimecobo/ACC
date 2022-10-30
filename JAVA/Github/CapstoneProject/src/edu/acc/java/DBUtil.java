package edu.acc.java
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class DBUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotels360");
	
}
