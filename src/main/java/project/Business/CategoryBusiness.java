package project.Business;

import java.util.ArrayList;
import java.util.List;

import project.JSon.CategoryJson;
import project.data.CategoryDAO;
import project.model.Category;

public class CategoryBusiness {
	static CategoryDAO cateDao=new CategoryDAO();
	 public static List<CategoryJson> getListCategory(){
	        List <CategoryJson> CategoryJSONList = new ArrayList<>();
	        List<Category> entityList = cateDao.getAll();
	        for(Category cate: entityList){
	            CategoryJson temp_cate = getCategory(cate);
	            CategoryJSONList.add(temp_cate);
	        }
	        CategoryJSONList.sort((CategoryJson a,CategoryJson b)->a.getId() -b.getId());
	        return CategoryJSONList;
	    }
	    public static CategoryJson getCategory(Category cate){
	        if(cate != null)
	        {
	            CategoryJson cateJSON = new CategoryJson();
	            String name = cate.getTitle();
	            cateJSON.setId(cate.getId());
	            cateJSON.setTitle(name);
	            return cateJSON;
	        }
	        return null;
	    }

}
