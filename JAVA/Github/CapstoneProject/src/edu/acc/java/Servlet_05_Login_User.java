package edu.acc.java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet_Login
 */
@WebServlet("/Login")
public class Servlet_05_Login_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_05_Login_User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("04_adminAccess.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
//		PrintWriter out  = response.getWriter();	
//		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String salt = null;
		if (username.equals("administrator01")) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
	        PreparedStatement pst = conn.prepareStatement("Select salt from user where username=?");
	        pst.setString(1, username);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	System.out.println("rs.getString(1) = " + rs.getString(1));
	        salt = rs.getString(1);
	        	System.out.println("Salt = " + salt);
	        }
	        try {
	        }catch (NoSuchAlgorithmException ex) {
			// TODO Auto-generated catch block
	        }
		}catch (ClassNotFoundException | SQLException ex) {
        	System.out.println("ERROR in Catch");
        	ex.printStackTrace();
		}
		}
	}

}