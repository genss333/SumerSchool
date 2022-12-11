/**
 * AuthorizePaymentServlet class - requests PayPal for payment.
 * @author Nam Ha Minh
 * @copyright https://codeJava.net
 */
package servlet;
 
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import control.AuthorizePaymentData;
 
@WebServlet("/authorize_payment")
public class AuthorizePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public AuthorizePaymentServlet() {
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("================== AuthorizePayment Servlet ==================");
    	AuthorizePaymentData data = new AuthorizePaymentData(request, response);
		System.out.println("AuthorizePayment Servlet failed== "+data.failed);
		
		if (data.failed) {
			// redirect to Error page
			System.out.println("data error massage== "+data.errorMessage);
			
			request.setAttribute("exception", data.errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
			dispatcher.forward(request, response);
		}
    }
 
}