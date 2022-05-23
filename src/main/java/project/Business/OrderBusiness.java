package project.Business;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import project.JSon.OrderJson;
import project.data.OrderDAO;
import project.data.OrderDetailDAO;
import project.data.UserDAO;
import project.model.Order;
import project.model.User;

public class OrderBusiness {
	static OrderDAO orderDao=new OrderDAO();
	static OrderDetailDAO orderDDao=new  OrderDetailDAO();
	static UserDAO userDao=new UserDAO();
	 public static OrderJson getOrder(Order order){
	        OrderJson orderJSON = null;
	        if(order != null) {
	            int Id = -1;
	            String CustomerName = "None";
	            double total = 0;
	            String date = "01.01.2001";
	            String status = "Publish";

	            User user = userDao.getUserbyEmail(order.getEmail());
	            CustomerName= user.getName();
	            Id = order.getId();
	            for ( int i=0;i<orderDDao.getDetailReceptByReceiptID(order.getId()).size();i++)
	            {
	            	total=total+orderDDao.getDetailReceptByReceiptID(order.getId()).get(i).getPrice();
	            }
	            date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(order.getCreateDate());
	            status = order.getStatus();

	            orderJSON = new OrderJson(Id,CustomerName,total,date,status);
	        }
	        return orderJSON;
	    }
	    public static List<OrderJson> getListOrderUser(String email){
	        List <OrderJson> orderJSONList = new ArrayList<>();
	        List<Order> entityList = orderDao.getListOrderByEmail(email);
	        for(Order order : entityList){
	            OrderJson temp_order = getOrder(order);
	            if (temp_order != null)
	                orderJSONList.add(temp_order);
	        }
	        orderJSONList.sort((OrderJson a, OrderJson b)->a.getId() - b.getId());
	        return orderJSONList;
	    }
	    public static List<OrderJson> getListOrder(){
	    	 List <OrderJson> orderJSONList = new ArrayList<>();
		        List<Order> entityList = orderDao.getAll();
		        for(Order order : entityList){
		            OrderJson temp_order = getOrder(order);
		            if (temp_order != null)
		                orderJSONList.add(temp_order);
		        }
		        orderJSONList.sort((OrderJson a, OrderJson b)->a.getId() - b.getId());
		        return orderJSONList;
	    }

}
