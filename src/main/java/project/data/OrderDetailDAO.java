package project.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import project.model.OrderDetail;

public class OrderDetailDAO {
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getDetailReceptByReceiptID(int orderid){
		
		Transaction transaction = null;
		List<OrderDetail> listOrderDT = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an object
			listOrderDT = session
				    .createQuery("from OrderDetail O where O.order.Id =: orderid")
					   .setParameter("orderid",orderid).list();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return listOrderDT;

	}
	

}
