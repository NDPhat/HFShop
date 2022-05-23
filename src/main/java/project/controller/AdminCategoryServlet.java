package project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.data.CategoryDAO;
import project.model.Category;

/**
 * Servlet implementation class AdminCategoryServlet
 */
@WebServlet("/AdminCategoryServlet")
public class AdminCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDAO cateDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCategoryServlet() {
        super();
        cateDao=new CategoryDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("project/Admin/Category.jsp");
	        dispatcher.forward(request,response);
	        return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String message="";
	        response.setContentType("text/html");
	        response.setCharacterEncoding("UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        boolean isSuccess = false;
	        try {
	            String method = request.getParameter("method");
	            if (method.equals("create") == true){
	                String Name = request.getParameter("Name");
	                if(cateDao.CheckNameExist(Name) == true)
	                {
	                    message = "name category is existing";
	                }
	                else {
	                    Category cate = new Category(); 
	                    cate.setTitle(Name);
	                    cate.setDescription(Name);
	                    cateDao.save(cate);
	                    message = "add new category successful";
	                }
	            }
	            else if (method.equals("edit") == true) {
	                String idnum = request.getParameter("categoryId");
	                String Name = request.getParameter("categoryName");
	                if(idnum== null || idnum.equals("")){
	                    message = "Id not found";
	                }
	                else{
	                    int id = Integer.parseInt(idnum);
	                    Category categoriesEntity = cateDao.getCategory(id);

	                    if(categoriesEntity == null){
	                        message = "Id is not existing";
	                    }
	                    else if (cateDao.CheckNameExist(Name) == true &&
	                            Name.equals(categoriesEntity.getTitle()) == false) {

	                        message = "name category is existing";
	                    } else {
	                     
	                        categoriesEntity.setTitle(Name);
	                        categoriesEntity.setDescription(Name);
	                        cateDao.update(categoriesEntity);
	                        message = "edit category successful";
	                    }
	                }
	            }
	        }catch (Exception e){
	            System.out.println("Registe failed: "+e);
	            message = "Something was wrong";
	        }
	        DirectEror(message,isSuccess,request,response);
	}
	  public void DirectEror(String Message,boolean isSuccess,HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
	        req.setAttribute("Message", Message);
	        req.setAttribute("isSuccess", isSuccess);
	        RequestDispatcher dispatcher //
	                = req.getServletContext().getRequestDispatcher("project/Admin/Category.jsp");
	        dispatcher.forward(req, resp);
	        return;
	    }

}
