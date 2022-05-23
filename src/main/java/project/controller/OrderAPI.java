package project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.data.OrderDAO;
import project.data.OrderDetailDAO;
import project.model.Order;
import project.model.OrderDetail;
import project.model.User;

/**
 * Servlet implementation class OrderAPI
 */
@WebServlet(name = "OrderAPI", value = "/OrderAPI")
public class OrderAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDAO orderDAO;
	private OrderDetailDAO orderDTDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAPI() {
      orderDAO=new OrderDAO() ;
      orderDTDAO=new OrderDetailDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.loadOrderAPI(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	 private void loadOrderAPI(HttpServletRequest request,HttpServletResponse response) throws IOException
	    {
		  	HttpSession session = request.getSession();
	        User user=(User) session.getAttribute("user");
	        List<Order> orderlist=orderDAO.getListOrderByEmail((user.getEmail()));
	        try (PrintWriter out = response.getWriter()) {
	            for (int i=0;i<orderlist.size();i++) {
	              List<OrderDetail> detaillist=orderDTDAO.getDetailReceptByReceiptID(orderlist.get(i).getId()) ;
	              double sum=0;
	              int num=0;
	              if(detaillist.size()!=0)
	              {
	            	  for(int k=0;k<detaillist.size();k++)
		              {
		            	  sum=sum+detaillist.get(k).getPrice();
		            	  num=num+detaillist.get(k).getQuantity();
		              }
	              }    
	                out.println("<tr>\n" +
	                        "     <td>"+i+ "</td>\n" +
	                        "     <td>"+orderlist.get(i).getCreateDate()+"</td>\n" +
	                        "     <td><span class=\"success\">"+orderlist.get(i).getStatus()+"</span></td>\n" +
	                        "     <td>"+"$"+sum+" For "+num+" Item "+"</td>\n" +
	                        "     <td><a href=\"/hfshop10/ViewCartServlet?orderid="+orderlist.get(i).getId()+"&" +"action=view"+"\" class=\"view\">view</a></td>\n" +
	                        "     </tr> ");
	            }
	        }

	    }

}
