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
			HeaderBean bean = new HeaderBean(key, val);
			beanCache.add(bean);
		}
		
		Object[] beanArray =  beanCache.toArray();
		for (Object bean : beanArray) {
			HeaderBean z = (HeaderBean) bean;
			System.out.println(z.getKey() + ":" + z.getValue());
		}
		
        //response.getWriter().append("done");
        request.setAttribute("x", beanArray);  // JSP can see as ${x}
        this.getServletContext().getRequestDispatcher("/header_dump.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}