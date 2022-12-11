package control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShowProductDAO;
import model.Products;

public class IndexPageData {

	NavbarData navbarData;

	public String errorMessage;

	public boolean failed;
	public boolean check = false;

	public IndexPageData(HttpServletRequest request, HttpServletResponse response){
		System.out.println("============ IndexPageData ============");
		StringBuffer temp = new StringBuffer();

		// prepare navbar data
		try {
			System.out.println("============ prepare navbar data ============");
			navbarData = new NavbarData(request, response);
			HttpSession session = request.getSession();
			
			if(session.getAttribute("LoginSuccess") == "LoginSuccess"){
				check = true;
				request.setAttribute("alert", check);
				session.removeAttribute("LoginSuccess");
			}

			if(session.getAttribute("GoogleSuccess") != null){
				check = true;
				request.setAttribute("alert", check);
				session.removeAttribute("GoogleSuccess");
			}


		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "IndexPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "IndexPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "IndexPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "IndexPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		// prepare bestseller data
		try {
			System.out.println("============ prepare bestseller data ============");
			List<Products> best = ShowProductDAO.ProductsBestseller();
			request.setAttribute("best", best);

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "IndexPageData.ProductsBestseller, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "IndexPageData.ProductsBestseller, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "IndexPageData.ProductsBestseller, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}catch (Exception ex) {
			System.out.println("Class:" + "IndexPageData.ProductsBestseller, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		// prepare onsale data
		try {
			System.out.println("============ prepare onsale data ============");
			List<Products> onsale = ShowProductDAO.ProductsOnsale();
			request.setAttribute("onsale", onsale);

		}catch (NumberFormatException ex) {
			System.out.println("Class:" + "IndexPageData.ProductsOnsale, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "IndexPageData.ProductsOnsale, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "IndexPageData.ProductsOnsale, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}catch (Exception ex) {
			System.out.println("Class:" + "IndexPageData.ProductsOnsale, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}

	}

}
