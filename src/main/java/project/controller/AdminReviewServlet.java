package project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.data.ReviewDAO;
import project.model.Review;

/**
 * Servlet implementation class AdminReviewServlet
 */
@WebServlet("/AdminReviewServlet")
public class AdminReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReviewDAO reviewDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReviewServlet() {
        super();
        reviewDao=new ReviewDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		 response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("project/Admin/Review.jsp");
	        dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		 response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        String id =   request.getParameter("Id");
	        if(id != null){
	            int idreview = Integer.parseInt(id);
	            reviewDao.delete(idreview);  
	        }
	        return;
	}

}
