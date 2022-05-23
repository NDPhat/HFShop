package project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.data.OrderDAO;
import project.data.OrderDetailDAO;
import project.data.UserDAO;
import project.model.Order;
import project.model.OrderDetail;
import project.model.User;

/**
 * Servlet implementation class AdminEditOrderServlet
 */
@WebServlet("/AdminEditOrderServlet")
public class AdminEditOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private OrderDAO orderDao;
      private OrderDetailDAO orderDDao;
      private UserDAO userDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditOrderServlet() {
        super();
        orderDao=new OrderDAO() ;
        orderDDao=new OrderDetailDAO() ;
        userDao=new UserDAO() ;
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
       
        int idtrans = Integer.parseInt(id);
        double sum=0;
        Order order = orderDao.getOnebyId(idtrans);
        if(order != null){               
            User users =userDao.getUserbyEmail(order.getEmail());
            List<OrderDetail> orderlist=orderDDao.getDetailReceptByReceiptID(idtrans);
            for(int i=0;i<orderlist.size();i++)
            {
            	sum=sum+orderlist.get(i).getPrice()*orderlist.get(i).getQuantity();
            }
            request.setAttribute("order",order);
            request.setAttribute("sum",sum);
            request.setAttribute("user",users);
            request.setAttribute("ListProduct",orderlist);
            RequestDispatcher dispatcher = request.getRequestDispatcher("project/Admin/EditOrder.jsp");
            dispatcher.forward(request,response);
            return;
        }
          
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
        String status = request.getParameter("status");
        if(id != null){
            int idTran = Integer.parseInt(id);
            Order order = orderDao.getOnebyId(idTran);
            if(order != null)
            {
                order.setStatus(status);
                orderDao.update(order);
            }
        }
        response.sendRedirect("/AdminEditOrderServlet?Id="+id);
        return;
	}

}
