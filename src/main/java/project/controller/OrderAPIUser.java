package project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import murach.email.business.User;
import project.Business.OrderBusiness;
import project.JSon.OrderJson;
import project.data.UserDAO;

/**
 * Servlet implementation class OrderAPIUser
 */
@WebServlet("/OrderAPIUser")
public class OrderAPIUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAPIUser() {
        super();
		userDao = new UserDAO();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String id =  request.getParameter("Id");
	        int UserId = Integer.parseInt(id);
	        System.out.print("Hello"+UserId);
	        project.model.User user=userDao.getUserbyId(UserId);
	        
	        response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        Gson gson = new Gson();
	        List<OrderJson> list = OrderBusiness.getListOrderUser(user.getEmail());
	        String JSON = gson.toJson(list);
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(JSON);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
