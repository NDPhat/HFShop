package project.Business;

import java.util.ArrayList;
import java.util.List;

import project.JSon.ProductJson;
import project.data.ProductDAO;
import project.model.Product;

public class ProductBusiness {
	static ProductDAO productDao=new ProductDAO();
	 public static List<ProductJson> getListProduct(){
	        List <ProductJson> productJSONList = new ArrayList<>();
	        List<Product> entityList = productDao.getAll();
	        for(Product product : entityList){
	            ProductJson temp_product = getProduct(product);
	            productJSONList.add(temp_product);
	        }
	        productJSONList.sort((ProductJson a,ProductJson b)->a.getId()- b.getId());
	        return productJSONList;
	    }
	    public static ProductJson getProduct(Product product){
	        ProductJson productJSON = new ProductJson();
	        if(product != null) {

	            if((product != null))
	            {
	                productJSON.setId(product.getId());
	                productJSON.setName(product.getName() != null ? product.getName() : "none");
	                productJSON.setCategory(product.getCategory().getTitle());
	                productJSON.setPrice(product.getPrice());  
	            }

	        }
	        return productJSON;
	    }
}
