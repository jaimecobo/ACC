	package edu.acc.java;

	import java.io.IOException;
//	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

	/**
	 * Servlet implementation class Servlet_Check_Reservation
	 */
	@WebServlet("/Check_Self_Reservation")
	public class Servlet_03_Check_Self_Reservation extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Servlet_03_Check_Self_Reservation() {
	        super();
	        // TODO Auto-generated constructor stub
			
	    }
	    
	    String id_Customer02 = "";
	    
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
//			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			request.getRequestDispatcher("02_reservation_Form.jsp").forward(request, response);
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
//			doGet(request, response);
			
//			PrintWriter out  = response.getWriter();	
			response.setContentType("text/html");
			
			HttpSession session=request.getSession(false);  
	        id_Customer02 = (String)session.getAttribute("id_Customer01");
	        System.out.println("the id_Customer is " + id_Customer02 + " at doPost method in Check_Self_Reservation Servlet.");
	        
			
//			String id_reservation = request.getParameter("resrvNum");
			
//			LocalMySQLCP localDB = new LocalMySQLCP();
			
			
			
//			String sql;
//			String[] parms;
			
			
			//=================================================================================================================
			//=================================================================================================================
	        DataManager dt = new DataManager();
	        String reservation_string = "";
	        if(id_Customer02 != null) {
			
				try {
					List<String> id_Reservation = new ArrayList<String>();
					List<String> entryDates = new ArrayList<String>();
					List<String> departureDates = new ArrayList<String>();
					List<String> status = new ArrayList<String>();
					StringBuilder strBuilder = new StringBuilder();
			
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
					PreparedStatement pst = conn.prepareStatement("Select id_Reservation, departure_date, entry_date, status from reservation where id_Customer=?");
					pst.setString(1, id_Customer02);
					ResultSet rs = pst.executeQuery();
					
					int i = 0;
					while (rs.next()) {
						id_Reservation.add(rs.getString(1));
						departureDates.add(rs.getString(2));
						entryDates.add(rs.getString(3));
						status.add(rs.getString(4));
									
						if((status.get(i).equals("Approved"))) {
							strBuilder.append();
						}
																
						i++;
						
					}

				}
				catch (ClassNotFoundException | SQLException ex) {
						System.out.println("ERROR in Catch");
						ex.printStackTrace();
						
				}
				finally {
	//				dt.close(rs);
	//				dt.close(pst);
	//				dt.close(conn);
	
				}
			
			
			//=================================================================================================================
			//=================================================================================================================
			
	        }

		}

	}