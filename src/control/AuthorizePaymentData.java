package control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paypal.base.rest.PayPalRESTException;

import dao.AuthenDAO;
import model.Authen;
import model.OrderDetail;
import model.Payers;
import servieces.PaymentServices;

public class AuthorizePaymentData {
	
	public String errorMessage;

	public boolean failed;
	
	public AuthorizePaymentData(HttpServletRequest request, HttpServletResponse respons) {
		
		System.out.println("============ AuthorizePaymentData ============");
		StringBuffer temp = new StringBuffer();
		
		try {
			System.out.println("============ prepare AuthorizePaymentDatat data ============");
			String id = request.getParameter("id");
	        String product = request.getParameter("product");
	        String subtotal = request.getParameter("subtotal");
	        String qty = request.getParameter("qty");
	        float total = Float.valueOf(subtotal) * Float.valueOf(qty);
	        
	        String fname = "";
	        String lname = "";
	        HttpSession session = request.getSession();
			String email = String.valueOf(session.getAttribute("Username"));
			
			List<Authen> auth = new AuthenDAO().User(email);
			for(Authen index : auth) {
				index.fname =fname; 
				index.lname = lname;
			}
			
			OrderDetail orderDetail = new OrderDetail(id, product, Float.valueOf(subtotal), Integer.valueOf(qty),
	        		0, 0, total);
	        Payers payers = new Payers(email, fname, lname);
	        
	        PaymentServices paymentServices = new PaymentServices();
            String approvalLink = paymentServices.authorizePayment(orderDetail,payers);
 
            respons.sendRedirect(approvalLink);


		}catch (PayPalRESTException ex) {
			System.out.println("Class:" + "AuthorizePaymentData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
        } catch (NumberFormatException ex) {
			System.out.println("Class:" + "AuthorizePaymentData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "AuthorizePaymentData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "AuthorizePaymentData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "AuthorizePaymentData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}
		
	}

}
