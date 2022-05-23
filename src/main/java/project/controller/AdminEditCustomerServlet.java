package project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.data.CategoryDAO;
import project.data.ProductDAO;
import project.data.UserDAO;
import project.model.User;

/**
 * Servlet implementation class AdminEditCustomerServlet
 */
@WebServlet("/AdminEditCustomerServlet")
public class AdminEditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditCustomerServlet() {
        super();
       
		userDao = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("Id");
        try{
            int idCustomer = Integer.parseInt(id);
            User users = userDao.getUserbyId(idCustomer);
            if(users != null){
                request.setAttribute("users",users);          
                RequestDispatcher dispatcher = request.getRequestDispatcher("project/Admin/CustomerAccount.jsp");
                dispatcher.forward(request,response);
                return;
            }
            else {
                response.sendRedirect("/admin/customer");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
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
