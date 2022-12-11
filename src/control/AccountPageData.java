package control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AuthenDAO;
import model.Authen;
import model.Book;

public class AccountPageData {

	NavbarData navbarData;

	public String errorMessage;

	public boolean failed;
	public boolean check = false;

	public AccountPageData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("============ AccountPageData ============");
		StringBuffer temp = new StringBuffer();

		// prepare navbar data
		try {
			System.out.println("============ prepare navbar data ============");
			navbarData = new NavbarData(request, response);
			HttpSession session = request.getSession();

			if (session.getAttribute("UpdateSuccess") == "UpdateSuccess") {
				check = true;
				request.setAttribute("alert", check);
				session.removeAttribute("UpdateSuccess");
			}

			if (session.getAttribute("UpdateFailed") == "UpdateFailed") {
				request.setAttribute("alert", check);
				session.removeAttribute("UpdateFailed");
			}

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "AccountPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "AccountPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "AccountPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "AccountPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		// prepare User account data

		try {
			System.out.println("============ prepare User Account data ============");

			HttpSession session = request.getSession();
			String email = String.valueOf(session.getAttribute("Username"));
			List<Authen> user = AuthenDAO.User(email);
			List<Book> book = AuthenDAO.UserBook(email);
			request.setAttribute("user", user);
			request.setAttribute("book", book);

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "AccountPageData.UserAccount, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "AccountPageData.UserAccount, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "AccountPageData.UserAccount, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "AccountPageData.UserAccount, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}

	}

}
