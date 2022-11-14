package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DB_Connector06
 */
@WebServlet("/DB_Connector06")
public class DB_Connector06 extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DB_Connector06() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Starting the DB_Connector06");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		LocalMySQLCP localDB = new LocalMySQLCP();
		/*
		String city = "Dallas";
		String population = "1400000";
		String sql = "insert into cities (name, population) values (?,?)";
		String[] parms;
		int rowCount;
	
		try {
			out.println("<br>" + city + " not found -- inserting");
			sql = "insert into cities (name, population) values (?,?)";
		    parms = new String[]{city, population};  
			rowCount = localDB.executeUpdate(sql, parms);
		*/
		String hotel_name = "Four";
		String hotel_address = "4444 address 4444";
		String hotel_id = "13";
		String hotel_email = "four@hotels360.com";
		String hotel_description = "This is the Four hotel";
		String hotel_type = "1";
		String num_of_floors = "8";
		String num_of_rooms = "40";
		//"insert into hotel (hotel_id, hotel_name, hotel_address, hotel_email, hotel_description, hotel_type, num_of_floors, num_of_rooms) values (?,?,?,?,?,?,?,?)";
		String sql = "insert into hotel (hotel_id, hotel_name, hotel_address, hotel_email, hotel_description, hotel_type, num_of_floors, num_of_rooms) values (?,?,?,?,?,?,?,?)";
		String[] parms;
		
		int rowCount;
		try {
			out.println("<br>" + hotel_name + " not found -- inserting --");
			sql = "insert into hotel (hotel_id, hotel_name, hotel_address, hotel_email, hotel_description, hotel_type, num_of_floors, num_of_rooms ) values (?,?,?,?,?,?,?,?)";
		    parms = new String[]{hotel_id, hotel_name, hotel_address, hotel_email, hotel_description, hotel_type, num_of_floors, num_of_rooms};  
			rowCount = localDB.executeUpdate(sql, parms);
			
			
		//localDB.executeUpdate(updateCities);
		}catch(SQLException ex){
			out.println("ERROR catch DB_Connector06");
			ex.printStackTrace();
			ex.printStackTrace();
			localDB.printTrace(ex);
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
