package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloJPA
 */
@WebServlet("/HelloJPA")
public class HelloJPA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloJPA() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String msg = "success";
		User user = new User("Pete", "Isburgh", "peter@isburgh.com");
		EntityManagerFactory emf = DBUtil.getEmFactory();
		EntityManager em = emf.createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		}
		 catch (Exception ex) {
			trans.rollback();
			msg = "Error: [" + ex + "]";
		}
		finally {
			em.close();
			out.println(msg);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}