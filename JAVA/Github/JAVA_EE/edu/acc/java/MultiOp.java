package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MultiOp
 */
@WebServlet("/MultiOp")
public class MultiOp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiOp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// persist (4) users, alter email address on one, delete one, print remaining
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String msg = "success";
		User user1 = new User("Pete", "Isburgh", "peter@isburgh.com");
		User user2 = new User("Popeye", "Rules", "popeye@isburgh.com");
		User user3 = new User("Oliveoil", "Rules", "oliveoil@isburgh.com");
		User user4 = new User("Joe", "Redneck", "red@hotmail.com");
		EntityManagerFactory emf = DBUtil.getEmFactory();
		EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
		try {
			trans.begin();
			em.persist(user1);  // add some users
			em.persist(user2);
			em.persist(user3);
			em.persist(user4);
			user3.setEmail("oliveoil@gmail.com");
			em.merge(user3); // update Olive Oil's email in db
            em.remove(em.merge(user4)); // whoops, no rednecks
			trans.commit();
		}
		 catch (Exception ex) {
			trans.rollback();
			msg = "Error: [" + ex + "]";
		}
		finally {
			em.close();
		}

		em = emf.createEntityManager();
        trans = em.getTransaction();
		try {
			trans.begin();
            String query = "select p from User p"; 
            TypedQuery<User> all_users = em.createQuery(query, User.class);
            List<User> users = all_users.getResultList();
            if (users != null) {
            	for (User u : users) {
            		out.print("<br>" + u.getFirstName() + " " + 
            	              u.getLastName() + " " +
            				  u.getEmail());
            	}
            }
		}
		 catch (Exception ex) {
			trans.rollback();
			msg = "Error: [" + ex + "]";
		}
		finally {
			em.close();
			
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}