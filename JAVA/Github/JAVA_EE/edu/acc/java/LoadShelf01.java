package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet("/LoadShelf")
public class LoadShelf01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadShelf01() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// persist (4) users, alter email address on one, delete one, print remaining
		// then forward to JSP
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		List<Item> items = new ArrayList<>();
		items.add(new Item("bread", 7));
		items.add(new Item("vanilla ice cream", 12));
		items.add(new Item("Coke 12oz", 5));
		items.add(new Item("dozen eggs", 13));
		Shelf shelf1 = new Shelf("7-11 at Elm and Lamar", items);
		items = new ArrayList<>();
		items.add(new Item("tacos", 47));
		items.add(new Item("cherry ice cream", 42));
		items.add(new Item("Coke 48oz", 99));
		items.add(new Item("Noosa yogurt", 13));
		Shelf shelf2 = new Shelf("HEB at 53rd and Red River", items);
		EntityManagerFactory emf = DBUtil.getEmFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction trans = em.getTransaction();

		try {
			trans.begin();
			em.persist(shelf1); // add a shelf with cascade ALL
			em.persist(shelf2); // add a shelf with cascade ALL
			trans.commit();
		} catch (Exception ex) {
			trans.rollback();
			out.println("Error: [" + ex + "]");
			return;
		}

		out.println("db load successful");
		out.println("any Coke 48oz?");

		String query = "select s.location, i.name, i.count from Shelf s join s.items i where i.name = 'Coke 48oz'";
		List<Object[]> result = em.createQuery(query, Object[].class).getResultList();
		if (result != null) {
			for (Object[] i : result)
				out.println("\nlocation=" + i[0] + 
						    " name=" + i[1] +
						    " count= " + i[2]);
		}

		em.close();
		request.setAttribute("result", result);
		this.getServletContext()
		  .getRequestDispatcher("/WEB-INF/loadShelf.jsp")
		  .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}