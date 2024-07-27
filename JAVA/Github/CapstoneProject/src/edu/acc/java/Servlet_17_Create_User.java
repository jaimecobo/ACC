package edu.acc.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Create_User
 */
@WebServlet("/Create_User")
public class Servlet_17_Create_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_17_Create_User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("05_management_Options.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		final JPanel panel = new JPanel();
		// create a jframe
	    JFrame frame = new JFrame("JOptionPane showMessageDialog example");
		
		PrintWriter out  = response.getWriter();	
		response.setContentType("text/html");
		
		String password = request.getParameter("password");
		String salt = null;
		System.out.println("1111111111 " + password);
		
		try {
			System.out.println("222222222 starting first Try block 'checkPasswordStrength' -- password = " + password);
			_00_Hashing_Salting_Passwords.checkPasswordStrength(password);
			System.out.println("33333333 After checkPasswordStrength -- password = " + password);
			try {
				System.out.println("444444444 starting second Try block 'geSalt' & 'hashPassword' -- password = " + password);
				salt = _00_Hashing_Salting_Passwords.getSalt();
				password = _00_Hashing_Salting_Passwords.hashSaltAndPassword(password, salt);
				System.out.println("555555555 After hashPassword -- password = " + password);
			}catch(Exception ex) {
				System.out.println("7777777777 Exception at hashAndSaltPassword catch -- password = " + password);
				   out.println("<script type=\"text/javascript\">");
				   out.println("alert(" + ex + ");");
				   out.println("location='17_adminUserForm.jsp';");
				   out.println("</script>");
//				JOptionPane.showMessageDialog(frame, ex, "Warning", JOptionPane.WARNING_MESSAGE);
				ex.printStackTrace();
			}
		
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			System.out.println("666666666 Exception at checkPasswordStrength catch -- password = " + password);
			out.println("<script type=\"text/javascript\">");
			   out.println("alert(" + ex + ");");
			   
		}

	}

}