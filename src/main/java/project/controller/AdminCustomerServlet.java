package project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AdminCustomerServlet
 */
@WebServlet("/AdminCustomerServlet")
public class AdminCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCustomerServlet() {
        super();
      
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("project/Admin/Customer.jsp");
	        dispatcher.forward(request,response);
	        return;
	       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("project/Admin/Customer.jsp");
	        dispatcher.forward(request,response);
	        return;
	        
	       
	}

}
