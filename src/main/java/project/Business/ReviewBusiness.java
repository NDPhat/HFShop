package project.Business;

import java.util.ArrayList;
import java.util.List;

import project.JSon.ReviewJSon;
import project.data.ReviewDAO;
import project.model.Review;

public class ReviewBusiness {
	static ReviewDAO rvDao=new ReviewDAO();
	 public static List<ReviewJSon> getListReview(){
	        List <ReviewJSon> reviewJSONList = new ArrayList<>();
	        List<Review> entityList = rvDao.getAll();
	        for(Review review : entityList){
	            ReviewJSon temp_review = getReview(review);
	            reviewJSONList.add(temp_review);
	        }
	        reviewJSONList.sort((ReviewJSon a, ReviewJSon b)->a.getId()- b.getId());
	        return reviewJSONList;
	    }
	    public static ReviewJSon getReview(Review review){
	        ReviewJSon reviewJSON = new ReviewJSon();

	        if(review != null) {
	            String productName = "None";
	            String Author = "None";
	            if(review.getProduct() != null){
	                productName = review.getProduct().getName();
	            }

	            if(review.getUser() != null){
	                Author = review.getUser().getName();
	            }
	            reviewJSON.setId(review.getId());
	            reviewJSON.setProductName(productName);
	            reviewJSON.setAuthor(Author);
	            reviewJSON.setReview(review.getComment());
	            reviewJSON.setRating(review.getSosao());
	        }
	        return reviewJSON;
	    }

}
