package project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.data.CategoryDAO;
import project.data.ProductDAO;
import project.data.ReviewDAO;
import project.model.Product;
import project.model.Review;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ProductDAO productDao;
       private ReviewDAO reviewDao;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        productDao = new ProductDAO();
        reviewDao= new ReviewDAO();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("pid"));
		
		Product product = productDao.getProduct(id);
		List<Product> productrelated=productDao.get4productRelated(product.getCategory().getId());
		List<Review> listreview=reviewDao.getAllbyProductId(id);
		request.setAttribute("listreview", listreview);
		request.setAttribute("product", product);
		request.setAttribute("sumrv",listreview.size());		
		request.setAttribute("productrelated", productrelated);
		
		request.getRequestDispatcher("/project/product-detail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
