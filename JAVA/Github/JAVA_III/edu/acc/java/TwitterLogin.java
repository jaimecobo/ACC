package edu.acc.java;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TwitterLogin
 */
@WebServlet("/TwitterLogin")
public class TwitterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwitterLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get login form paramters and check password. Iff good password, forward to twitterLoginPass.html, else TwitterLoginFail.html
		request.setAttribute("uid", request.getParameter("uid"));
		request.setAttribute("pswd", request.getParameter("pswd"));
		request.setAttribute("forgotPswd", request.getParameter("forgotPswd")); 
        Random rand = new Random(); // mock password verification by randomly accepting or failing password check;
        String url = "noop";
        if (rand.nextInt() % 2 == 0) 
        	url = "TwitterLoginPass.html";
        else
        	url = "TwitterLoginFail.html";
        this.getServletContext().getRequestDispatcher("/" + url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}