package project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.data.CategoryDAO;
import project.data.ProductDAO;
import project.model.Category;
import project.model.Product;

/**
 * Servlet implementation class AdminEditProductServlet
 */
@WebServlet("/AdminEditProductServlet")
public class AdminEditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProductDAO pDao;
    private CategoryDAO cDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
        pDao=new ProductDAO();
        cDao=new CategoryDAO();
        
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
            int idProduct = Integer.parseInt(id);
            Product productsEntity =pDao.getProduct(idProduct);
            List<Category> categoriesEntityList = cDao.getAll();	                   	              
            request.setAttribute("listcate",categoriesEntityList);
            request.setAttribute("product",productsEntity);
            RequestDispatcher dispatcher = request.getRequestDispatcher("project/Admin/EditProduct.jsp");
            dispatcher.forward(request,response);
            return;
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("idproduct");
        int idProduct = Integer.parseInt(id);
        try{

            String productImage= request.getParameter("urlimage");
            String productName = request.getParameter("name");
            String productDescription = request.getParameter("description");
            String productCategory = request.getParameter("category");
            String productPrice = request.getParameter("price"); 
            String productQuantity = request.getParameter("quantity");          
            Category cate = cDao.getCategory(Integer.parseInt(productCategory));
         
            Product productsEntity = pDao.getProduct(idProduct);
            productsEntity.setName(productName);
            productsEntity.setImage(productImage);
            productsEntity.setDescription(productDescription);
            productsEntity.setCategory(cate);
            productsEntity.setPrice(Double.parseDouble(productPrice));
            productsEntity.setQuantity(Integer.parseInt(productQuantity));

            pDao.update(productsEntity);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        response.sendRedirect("/AdminEditProductServlet?Id="+idProduct);
	}

}
