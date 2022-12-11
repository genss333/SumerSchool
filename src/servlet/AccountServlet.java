package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.AccountPageData;
import control.UserAccountData;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("================== Account Servlet ==================");
		AccountPageData data = new AccountPageData(request, response);
		System.out.println("Account Servlet failed== "+data.failed);
		
		if (data.failed) {
			// redirect to Error page
			System.out.println("data error massage== "+data.errorMessage);
			
			request.setAttribute("exception", data.errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);

		} else {
			// Redirect to JSP
			RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("================== Update Account Servlet ==================");
		UserAccountData data = new UserAccountData(request, response);
		System.out.println("Update Account Servlet failed== "+data.failed);
		
		if (data.failed) {
			// redirect to Error page
			System.out.println("data error massage== "+data.errorMessage);
			
			request.setAttribute("exception", data.errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);

		} 
	}

}
