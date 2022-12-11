package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.CartActionData;

/**
 * Servlet implementation class MinusCartServlet
 */
@WebServlet("/MinusCartServlet")
public class MinusCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("================== Minus Cart Servlet ==================");
		CartActionData addcart = new CartActionData();
		System.out.println("Minus Cart Servlet failed== " + addcart.failed);
		if (addcart.failed) {
			// redirect to Error page
			System.out.println("data error massage== " + addcart.errorMessage);

			request.setAttribute("exception", addcart.errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);

		}else {
			addcart.MinusCart(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
