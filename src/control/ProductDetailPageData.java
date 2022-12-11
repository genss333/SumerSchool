package control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductsDAO;
import model.Products;


public class ProductDetailPageData {
	
	NavbarData navbarData;

	public String errorMessage;

	public boolean failed;
	
	public ProductDetailPageData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("============ ProductDetailPageData ============");
		StringBuffer temp = new StringBuffer();

		// prepare navbar data
		try {
			System.out.println("============ prepare navbar data ============");
			navbarData = new NavbarData(request, response);

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "ProductDetailPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductDetailPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductDetailPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductDetailPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}
		
		// prepare product detail
		
		try {
			System.out.println("============ prepare product detail data ============");
			int p_id = Integer.valueOf(request.getParameter("pid"));
			List<Products> products = ProductsDAO.ProductsDetail(p_id);
			request.setAttribute("products", products);
			String col = request.getParameter("col");
			String brand = request.getParameter("brand");
			int id = Integer.valueOf(request.getParameter("pid"));
			List<Products> relate = ProductsDAO.ProductsRelate(col, brand,id);
			request.setAttribute("relate", relate);

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "ProductDetailPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductDetailPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductDetailPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductDetailPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}
		
		if (failed) {
			errorMessage = temp.toString();
		}
		
	}

}
