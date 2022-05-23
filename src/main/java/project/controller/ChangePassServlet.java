package project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.data.UserDAO;
import project.model.User;

/**
 * Servlet implementation class ChangePassServlet
 */
@WebServlet("/ChangePassServlet")
public class ChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassServlet() {
        userDAO=new UserDAO();
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
		 	String message="";
			String email = request.getParameter("email");
	        String pass = request.getParameter("password");
	        String newpass = request.getParameter("newpassword");
	        String repass = request.getParameter("repassword");
	        User user=userDAO.validate(email, pass);
	        if(user!=null)
	        {
	        	if(newpass.equals(repass))
	        	{
	        		user.setEmail(email);
	        		user.setPassword(newpass);
	        		userDAO.UpdateUserbyId(user);
	        		 message = "Change Password Successfully";
                     isSuccess= true;	
	        	}
	        	else
	        	{
	        		 message = "Re Passowrd don't Match";
	        	}
	        }
	        else
	        {
                message="Password don't correct";

	        }
	        isSuccess = true;
	        DirectEror(isSuccess,message,request,response);
	}
	 public void DirectEror(Boolean isSuccess,String message,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		
	        req.setAttribute("isSuccess", isSuccess);
	        req.setAttribute("message", message);    
	        req.getRequestDispatcher("project/myaccount.jsp").forward(req, resp);
	    }
}
