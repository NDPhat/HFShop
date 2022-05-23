package project.Business;

import java.util.ArrayList;
import java.util.List;

import project.JSon.CustomerJson;
import project.data.OrderDAO;
import project.data.UserDAO;
import project.model.User;

public class CustomerBusiness {
	static OrderDAO orderDao=new OrderDAO();
	static UserDAO userDao=new UserDAO();
	 public static List<CustomerJson> getListCustomer(){
	        List <CustomerJson> customerJSONList = new ArrayList<>();
	        List<User> entityList = userDao.getAll();
	        for(User user : entityList){
	            CustomerJson temp_user = getCustomer(user);
	            customerJSONList.add(temp_user);
	        }
	        customerJSONList.sort((CustomerJson a,CustomerJson b)-> a.getId() - b.getId());
	        return customerJSONList;
	        
	    }
	    public static CustomerJson getCustomer(User user){
	    	
	        if(user != null)
	        {
	           
	            CustomerJson userJSON = new CustomerJson();
	            String name = user.getName();
	          
	            String Image = user.getImage();
	          
	            int Oders = orderDao.getListOrderByEmail(user.getEmail()).size();

	            String address=user.getAddress();

	        

	            userJSON.setLocation(address);
	            userJSON.setImage(Image);
	            userJSON.setId(user.getId());
	            userJSON.setName(name);
	            userJSON.setMail(user.getEmail());
	            userJSON.setOrders(Oders);
	            return userJSON;
	        }
	        return null;
	    }

}
