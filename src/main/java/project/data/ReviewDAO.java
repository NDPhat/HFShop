package project.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import project.model.Category;
import project.model.Review;


public class ReviewDAO {
	public void update(Review review) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(review);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
          
             
            e.printStackTrace();
        }
    }
	public void save(Review review) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(review);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void delete(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a user object
			Review review = session.get(Review.class, id);
			if (review != null) {
				session.delete(review);
				
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Review> getAllbyProductId(int pid) {

		Transaction transaction = null;
		List<Review> reviews = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an object

			// products = session.createQuery("FROM Product ORDER
			// BY").setMaxResults(4).getResultList();
			reviews = session.createQuery("FROM Review R where R.product.Id =: pid ").setParameter("pid", pid).list();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return reviews;
	}
	@SuppressWarnings("unchecked")
	public List<Review> getAll() {

		Transaction transaction = null;
		List<Review> reviews = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an object

			// products = session.createQuery("FROM Product ORDER
			// BY").setMaxResults(4).getResultList();
			reviews = session.createQuery("FROM Review ").getResultList();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {  
			
			e.printStackTrace();
		}
		return reviews;
	}
	public Review getOnebyId(int rid) {

		Transaction transaction = null;
		Review reviews = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an object

			// products = session.createQuery("FROM Product ORDER
			// BY").setMaxResults(4).getResultList();
			reviews = (Review) session.createQuery("FROM Review R where R.Id =: rid ").setParameter("rid", rid);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return reviews;
	}

}
