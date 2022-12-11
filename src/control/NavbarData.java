package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import dao.AuthenDAO;
import dao.CategoriesDAO;
import model.Authen;
import model.Cart;
import model.Categories;
import model.GoogleAuth;
import servieces.IdTokenVerifierAndParser;

public class NavbarData {

	public NavbarData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {

		try {

			HttpSession session = request.getSession();
			String email = String.valueOf(session.getAttribute("Username"));
			List<Authen> user = AuthenDAO.User(email);
			request.setAttribute("user", user);

			ArrayList<GoogleAuth> g_user = (ArrayList<GoogleAuth>) session.getAttribute("g-user");
			String name = "";
			String pictureUrl = "";
			String g_email = "";
			// String familyName = "";
			// String givenName = "";
			if (g_user != null) {
				for (GoogleAuth googleAuth : g_user) {
					g_email = googleAuth.getEmail();
					pictureUrl = googleAuth.getPictureUrl();
					name = googleAuth.getName();
					// givenName = googleAuth.getGivenName();
					// familyName = googleAuth.getFamilyName();
				}
			}
			request.setAttribute("g_email", g_email);
			request.setAttribute("g_pic", pictureUrl);
			request.setAttribute("g_name", name);
			// request.setAttribute("g_givenName", givenName);
			// request.setAttribute("g_familyName", familyName);

			ArrayList<Cart> count = (ArrayList<Cart>) session.getAttribute("cart-list");
			if (count != null) {
				int qty = 0;
				for (Cart index : count) {
					qty += index.getQuantity();
				}
				request.setAttribute("qty", qty);
			} else {
				request.setAttribute("qty", 0);
			}

			List<Categories> cat = CategoriesDAO.ShowCategories();
			List<Categories> brand = CategoriesDAO.ShowBrand();
			request.setAttribute("cat", cat);
			request.setAttribute("brand", brand);

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "NavbarData, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "NavbarData, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "NavbarData, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "NavbarData, " + ex.getMessage());
			throw ex;
		}

	}

}
