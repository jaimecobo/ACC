package edu.acc.java;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletI
 */
@WebServlet("/ServletI")
public class ServletI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int COOKIE_TTL = 60;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletI() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// create and add a new cookie with a static name ("x")
		// then dump the cookies that came back
		HttpSession session = request.getSession();  // just to see jsessionid cookie
		String cookie_key = "monster";
		System.out.println("Created cookie key: " + cookie_key);
		Cookie cookie = new Cookie(cookie_key, "Seseme Street");
		cookie.setMaxAge(COOKIE_TTL);  // cookie lasts for this long
		cookie.setPath("/");
		response.addCookie(cookie);
		
		// see what cookies came back from client (also use your browser inspector to see cookies)
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			System.out.println("Sorry, no cookies returned");
		}
		else {
		    for (Cookie next_cookie : cookies) {
			    System.out.println("Recv'd cookie with name=" + next_cookie.getName()
					    + " and value= " + next_cookie.getValue());
		    }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}