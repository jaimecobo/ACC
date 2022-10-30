package edu.acc.java

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hotels360");
	
		public static EntityManagerFactory getEmFactory() {
			return emf;
		}
		
}
