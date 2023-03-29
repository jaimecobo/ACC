package edu.acc.java;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Deny
 */
@WebServlet("/Servlet_Deny")
public class Servlet_22_Deny extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_22_Deny() {
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
		
		String id_Reservation = request.getParameter("id_Reservation");
		System.out.println("id_Reservation = " + id_Reservation);
		
		String sql;
		String[] parms;
		LocalMySQLCP localDB = new LocalMySQLCP();
		DataManager dt = new DataManager();
		int rowCount;
		
		try {

			sql = "update reservation set status='Denied'  WHERE id_Reservation=?";
		    parms = new String[]{id_Reservation};  
			rowCount = localDB.executeUpdate(sql, parms);
			
		}catch(SQLException ex){
			System.out.println("ERROR IN Servlet_Create_Reservation TRYING TO INSERT \"DENIED\" STATUS IN THE DB");
			ex.printStackTrace();
			localDB.printTrace(ex);
			
		}finally {
			
//			dt.close(rs);
//			dt.close(pst);
//			dt.close(conn);

		}
		
		response.sendRedirect("Pending_Reservations_01");
		
	}

}