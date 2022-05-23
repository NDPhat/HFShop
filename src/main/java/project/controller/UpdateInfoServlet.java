package project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.data.UserDAO;
import project.model.User;

/**
 * Servlet implementation class UpdateInfoServlet
 */
@WebServlet("/UpdateInfoServlet")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserDAO userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
        userDao=new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Boolean isSuccess = false;
		String name = request.getParameter("name");
        String number = request.getParameter("phone");
        String add = request.getParameter("address");
        HttpSession session = request.getSession();
        User user=(User) session.getAttribute("user");
        user.setName(name);
        user.setAddress(add);
        user.setPhone(number);
        userDao.UpdateUserbyId(user);
        isSuccess = true;
        DirectEror(isSuccess,request,response);
        
 
       
	}
	 public void DirectEror(Boolean isSuccess,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
	        req.setAttribute("isSuccess", isSuccess);       
	        req.getRequestDispatcher("project/myaccount.jsp").forward(req, resp);
	    }

}
