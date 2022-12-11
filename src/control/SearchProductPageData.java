package control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductsDAO;
import model.Products;

public class SearchProductPageData {

	NavbarData navbarData;
	PaginationData pgdata = new PaginationData();

	public String errorMessage;

	public boolean failed;

	public SearchProductPageData(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("============ SearchProductPageData ============");
		StringBuffer temp = new StringBuffer();

		// prepare navbar data
		try {
			System.out.println("============ prepare navbar data ============");
			navbarData = new NavbarData(request, response);

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "SearchProductPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "SearchProductPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "SearchProductPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "SearchProductPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		// prepare SearchProductPageData

		try {
			System.out.println("============ prepare SearchProductPageData ============");
			String title = request.getParameter("search");
			String spageid=request.getParameter("page");  
	        int pageid=Integer.parseInt(spageid);  
	        int total=8;  
	        if(pageid==1){}  
	        else{  
	            pageid=pageid-1;  
	            pageid=pageid*total+1;  
	        }  
			List<Products> products = ProductsDAO.ProductsSearch(title,pageid,total);
			request.setAttribute("products", products);
			pgdata.paginationData(request, response);

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "ProductCollectionPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductCollectionPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductCollectionPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductCollectionPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}

	}

}
