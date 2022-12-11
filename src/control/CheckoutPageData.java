package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

import dao.ProductsDAO;
import model.Cart;
import model.Products;
import servieces.PaymentServices;

public class CheckoutPageData {

	NavbarData navbarData;

	public String errorMessage;

	public boolean failed;
	public boolean check = false;
	public String url ;

	public CheckoutPageData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("============ CheckoutPageData ============");
		StringBuffer temp = new StringBuffer();

		// prepare navbar data
		try {

			System.out.println("============ prepare navbar data ============");
			navbarData = new NavbarData(request, response);

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "CheckoutPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "CheckoutPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "CheckoutPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "CheckoutPageData.NavbarData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		try {

			int id = Integer.valueOf(request.getParameter("id"));
			List<Products> item = ProductsDAO.ProductsDetail(id);
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			for (Cart c : cart_list) {
				if (c.getId() == id) {
					int quantity = c.getQuantity();
					request.setAttribute("qty", quantity);
				}
			}

			String paymentId = request.getParameter("paymentId");
			String payerId = request.getParameter("PayerID");

			PaymentServices paymentServices = new PaymentServices();
			Payment payment = paymentServices.getPaymentDetails(paymentId);

			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();

			request.setAttribute("payer", payerInfo);
			request.setAttribute("transaction", transaction);
			request.setAttribute("shippingAddress", shippingAddress);
			request.setAttribute("item", item);
			url = "checkout.jsp?paymentId=" + paymentId + "&PayerID=" + payerId;

		}catch (PayPalRESTException ex) {
			System.out.println("Class:" + "CheckoutPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "CheckoutPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "CheckoutPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "CheckoutPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "CheckoutPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}

	}

}
