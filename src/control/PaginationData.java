package control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import dao.ProductsDAO;
import model.Order;
import model.Products;


public class PaginationData {
	
	StringBuffer temp = new StringBuffer();
	
	public void paginationData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException,Exception,NumberFormatException {
		 System.out.println("==============Pepeare Pagination Data ===============");
		 HttpSession session = request.getSession();
		 String header = request.getParameter("header");
		 String title = request.getParameter("search");
		 String adduser = String.valueOf(session.getAttribute("Username"));
		try {
			if(header.equals("Shop All")){
			  	List<Products> total = ProductsDAO.CountProduct();
				double qty = 0;
				for(Products index : total) {
					qty += index.id;
				}
				qty = qty/8;
				for(int i=1; i<=Math.ceil(qty); i++){
					request.setAttribute("pgpage", i);
					request.setAttribute(
							"location", 
							request.getContextPath()+"/AllProductServlet?header=Shop All&&page="
							);
				}
		  	}else if(header.equals("On Sale")) {
		  		List<Products> total = ProductsDAO.CountProductOnsale();
				double qty = 0;
				for(Products index : total) {
					qty += index.id;
				}
				qty = qty/8;
				for(int i=1; i<=Math.ceil(qty); i++){
					request.setAttribute("pgpage", i);
					request.setAttribute(
							"location", 
							request.getContextPath()+"/OnsaleProductServlet?header=On Sale&&page="
							);
				}
		  	}else if(header.equals("Search Products")) {
		  		List<Products> total = ProductsDAO.CountSearch(title);
				double qty = 0;
				for(Products index : total) {
					qty += index.id;
				}
				qty = qty/8;
				for(int i=1; i<=Math.ceil(qty); i++){
					request.setAttribute("pgpage", i);
					request.setAttribute(
							"location", 
							request.getContextPath()+"/ProductSerchServlet?header=Search Products&&search="+title+"&&page="
							);
				}
		  	}else if(header.equals("Best Seller")) {
		  		List<Products> total = ProductsDAO.CountBestseller();
				double qty = 0;
				for(Products index : total) {
					qty += index.id;
				}
				qty = qty/8;
				for(int i=1; i<=Math.ceil(qty); i++){
					request.setAttribute("pgpage", i);
					request.setAttribute(
							"location", 
							request.getContextPath()+"/bestseller?header=Best Seller&&page="
							);
				}
		  	}else{
		  		String col = request.getParameter("col");
				String brand = request.getParameter("brand");
		  		List<Products> total = ProductsDAO.CountCollection(col, brand);
				double qty = 0;
					for(Products index : total) {
						qty += index.id;
					}
				qty = qty/8;
				for(int i=1; i<=Math.ceil(qty); i++){ 
					request.setAttribute("pgpage", i);
					request.setAttribute(
							"location", 
							request.getContextPath()+"/ProductsCollectionServlet?header="+col+"/"+brand+"&&col="
							+col+"&&brand="+brand+"&&page="
							);
				}
		  	}
			
			if(header.equals("order")) {
		  		List<Order> total = OrderDAO.CountOrder(adduser);
				double qty = 0;
				for(Order index : total) {
					qty += index.getId();
				}
				qty = qty/4;
				for(int i=1; i<=Math.ceil(qty); i++){
					request.setAttribute("pgpage", i);
				}
			}
			
		}catch (NumberFormatException ex) {
			System.out.println("Class:" + "paginationData, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "paginationData, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "paginationData, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "paginationData, " + ex.getMessage());
			throw ex;
		}
		
	}

}
