package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin01
 */
@WebServlet("/ServletLogin01")
public class Servlet_51_Login01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_51_Login01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *
	 */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        request.getRequestDispatcher("Login_Form.jsp").forward(request, response);
        
    }
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
//        LocalMySQLCP localDB = new LocalMySQLCP();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        out.println("Username = " + username);
		out.print("<br>");
		out.println("Password = " + password);	
		
//        String username = "admin";
//        String password = "strongpassword";
       
        /*
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
		        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels360", "root", "sesame");
		        PreparedStatement pst = conn.prepareStatement("Select username, password from user where username=? and password=?");
		        pst.setString(1, username);
		        pst.setString(2, password);
		        ResultSet rs = pst.executeQuery();
		        if (rs.next()) {
		           out.println("Correct login credentials");
		        } 
		        else {
		           out.println("Incorrect login credentials");
		        }
		    }
    		catch (ClassNotFoundException | SQLException ex) {
		        	System.out.println("ERROR in Catch");
		        	ex.printStackTrace();
		    }
*/
    }
    
}

