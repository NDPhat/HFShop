package project.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import project.model.User;

public class UserDAO {
	@SuppressWarnings("unchecked")
	public List<User> getAll() {

		Transaction transaction = null;
		List<User> users = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an object

			// products = session.createQuery("FROM Product ORDER
			// BY").setMaxResults(4).getResultList();
			users = session.createQuery("FROM User").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return users;
	}

	public User validate(String email, String password) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an object
			user = (User) session.createQuery("FROM User U WHERE U.Email = :email").setParameter("email", email)
					.uniqueResult();

			if (user != null && user.getPassword().equals(password)) {
				return user;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public boolean isExist(String email) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an object
			user = (User) session.createQuery("FROM User U WHERE U.Email = :email").setParameter("email", email)
					.uniqueResult();
			if (user != null) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}

	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public User getUserbyId(int uid)
	{
		Transaction transaction = null;
		User users = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an object
			users = (User) session.createQuery("FROM User U WHERE U.id = :uid").setParameter("uid", uid)
					.uniqueResult();
			if (users != null) {
				return users;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	public User getUserbyEmail(String email)
	{
		Transaction transaction = null;
		User users = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an object
			users = (User) session.createQuery("FROM User U WHERE U.Email = :email").setParameter("email", email)
					.uniqueResult();
			if (users != null) {
				return users;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	public void UpdateUserbyId(User user)
	{
		 Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // save the student object
	            session.update(user);
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	          
	             
	            e.printStackTrace();
	        }
	
	}
}
