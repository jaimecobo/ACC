package edu.acc.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeanStalk
 */
@WebServlet("/BeanStalk")
public class BeanStalk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeanStalk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HeaderBean> beanCache = new ArrayList<>();
		Enumeration<String> hdr_names = request.getHeaderNames();  // get all the HTTP header keys
		while (hdr_names.hasMoreElements()) {
			String key =  hdr_names.nextElement();
			String val =  request.getHeader(key);
			HeaderBean bean = new HeaderBean(key, val); // persist key and value in a Java bean
			beanCache.add(bean); // and add to a collection
		}
		
		// See what is in the ArrayList
		// toArray() is one way...an easier way is to iterate the ArrayList
		Object[] beanArray =  beanCache.toArray();
		for (Object bean : beanArray) {
			HeaderBean z = (HeaderBean) bean;
			System.out.println(z.getKey() + ":" + z.getValue());
		}
		
        //response.getWriter().append("done");
        request.setAttribute("beanArray", beanArray);  // so JSP can see
        this.getServletContext().getRequestDispatcher("/header_dump_forEach.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}