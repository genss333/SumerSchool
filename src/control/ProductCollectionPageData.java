package control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductsDAO;
import model.Products;

public class ProductCollectionPageData {

	NavbarData navbarData;
	PaginationData pgdata = new PaginationData();

	public String errorMessage;

	public boolean failed;

	public ProductCollectionPageData(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("============ ProductCollectionPageData ============");
		StringBuffer temp = new StringBuffer();

		// prepare navbar data
		try {
			System.out.println("============ prepare navbar data ============");
			navbarData = new NavbarData(request, response);

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "ProductCollectionPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductCollectionPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductCollectionPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductCollectionPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		// prepare ProductCollectionPageData

		try {
			System.out.println("============ prepare ProductCollection Data ============");
			String col = request.getParameter("col");
			String brand = request.getParameter("brand");
			List<Products> products = ProductsDAO.ProductsCollection(col, brand);
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
