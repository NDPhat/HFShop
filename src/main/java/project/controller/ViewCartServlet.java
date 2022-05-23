package project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.data.OrderDAO;
import project.data.OrderDetailDAO;
import project.data.ProductDAO;
import project.model.LineItem;
import project.model.OrderDetail;
import project.model.Product;

/**
 * Servlet implementation class ViewCartServlet
 */
@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDao;
	private OrderDetailDAO orderDTDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCartServlet() {
    	productDao = new ProductDAO();
		orderDTDao = new OrderDetailDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
		List<LineItem> cart = new ArrayList<LineItem>();
		 String orderid= request.getParameter("orderid");
		 HttpSession session = request.getSession();
		 List<OrderDetail> dtlist=orderDTDao.getDetailReceptByReceiptID(Integer.parseInt(orderid));
		 for(int i=0;i<dtlist.size();i++)
		 {
			 	Product product = productDao.getProduct(dtlist.get(i).getProduct().getId());
				LineItem lineItem = new LineItem(product,dtlist.get(i).getQuantity());
				cart.add(lineItem);
				
				
		 }
		 session.setAttribute("cart", cart);
		 request.setAttribute("status", "view");
		 request.getRequestDispatcher("project/shoping-cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
