package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.RegisterData;
import control.SingupPageData;

@WebServlet("/SingupServlet")
public class SingupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==================  SinginServlet ==================");
		SingupPageData data = new SingupPageData(request, response);
		System.out.println(" Singup Servlet failed== "+data.failed);
		if (data.failed) {
			// redirect to Error page
			System.out.println("data error massage== "+data.errorMessage);
			
			request.setAttribute("exception", data.errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);

		} else {
			// Redirect to JSP
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==================  SinginServlet ==================");
		RegisterData data = new RegisterData(request, response);
		System.out.println(" Singup Servlet failed== "+data.failed);
		if (data.failed) {
			// redirect to Error page
			System.out.println("data error massage== "+data.errorMessage);
			
			request.setAttribute("exception", data.errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);

		} 
	}

}
