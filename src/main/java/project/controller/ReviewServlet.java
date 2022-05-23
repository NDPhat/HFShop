package project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.data.ProductDAO;
import project.data.ReviewDAO;
import project.data.UserDAO;
import project.model.Product;
import project.model.Review;
import project.model.User;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReviewDAO reviewDAO;
    private ProductDAO productDAO;
    private UserDAO userDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
    	reviewDAO=new ReviewDAO();
    	productDAO=new ProductDAO();
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
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
		 String URL = "/hfshop10/detail?pid=";
		String productIdString = request.getParameter("productId");
        String ratingString = request.getParameter("rate");
        String commentString = request.getParameter("review");
      
        int rating = Integer.parseInt(ratingString);
        int productId = Integer.parseInt(productIdString);
        HttpSession session = request.getSession();
        User user=(User) session.getAttribute("user");
        Product product=productDAO.getProduct(productId);
        Review review=new Review();
        review.setComment(commentString);
        review.setProduct(product);
        review.setSosao(rating);
        review.setUser(user);
        reviewDAO.save(review);
        URL += productId;
        response.sendRedirect(URL);
        
	}

}
