package edu.acc.java;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Approve
 */
@WebServlet("/Servlet_Approve")
public class Servlet_21_Approve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_21_Approve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String id[] = new String[1];
		
		String id_Reservation = request.getParameter("id_Reservation");
		System.out.println("id_Reservation = " + id_Reservation);
		
//		response.sendRedirect("21_underConstruction.html");
		String sql;
		String[] parms;
		LocalMySQLCP localDB = new LocalMySQLCP();
		DataManager dt = new DataManager();
		int rowCount;
		
		try {

			sql = "update reservation set status='Approved'  WHERE id_Reservation=?";
		    parms = new String[]{id_Reservation};  
			rowCount = localDB.executeUpdate(sql, parms);
			
		}catch(SQLException ex){
			System.out.println("ERROR IN Servlet_Create_Reservation TRYING TO INSERT \"APPROVED\" STATUS IN THE DB");
			
		}finally {

		}
		
	}

}