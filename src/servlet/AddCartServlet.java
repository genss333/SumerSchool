package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import control.CartActionData;
import control.RemoveOrderData;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("Username") == null) {
			session.setAttribute("PlaseLogin", "PlaseLogin");
			response.sendRedirect("SinginServlet");
		}else {
			System.out.println("================== Add To Cart Servlet ==================");
			CartActionData addcart = new CartActionData();
			System.out.println("Add To Cart Servlet failed== " + addcart.failed);
			if (addcart.failed) {
				// redirect to Error page
				System.out.println("data error massage== " + addcart.errorMessage);

				request.setAttribute("exception", addcart.errorMessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
				dispatcher.forward(request, response);

			} else {
				addcart.AddToCart(request, response);
			}
		}
		
		
	}

}
