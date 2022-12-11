package control;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

import dao.OrderDAO;
import dao.PaymentsDAO;
import dao.ProductsDAO;
import model.Cart;
import model.Payments;
import model.Products;
import model.Stock;
import servieces.PaymentServices;

public class PaymentData {
	
	public String errorMessage;

	public boolean failed;
	public boolean check = false;
	
	public PaymentData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("============ PaymentData ============");
		StringBuffer temp = new StringBuffer();
		
		String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
        int id = Integer.valueOf(request.getParameter("id"));
		HttpSession session = request.getSession();
		String email = String.valueOf(session.getAttribute("Username"));
		int quantity = 0 ;
		double total = 0;
 
        try {
            PaymentServices paymentServices = new PaymentServices();
            Payment payment = paymentServices.executePayment(paymentId, payerId);
            Transaction transaction = payment.getTransactions().get(0);
            ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
            
            String sDateTime = payment.getCreateTime();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  
            Date date = formatter.parse(sDateTime);  
            
    		ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
    		List<Products> products = ProductsDAO.ProductsDetail(id);
    		for (Cart c : cart_list) {
    			if (c.getId() == id) {
    				quantity =+ c.getQuantity();
    				for(Products p : products) {
    					total = quantity*p.getPrice();
    				}
    			}
    		}
    		
    		PaymentsDAO dao = new PaymentsDAO();
    		OrderDAO upstk = new OrderDAO();
    		Payments pay = new Payments(payment.getCart(), id, quantity, total, email, payment.getCart(),
    		shippingAddress.getRecipientName(), String.valueOf(date), "pay");
    		if(dao.PayMents(pay)) {
    			String bookId = request.getParameter("id");
    			for(Products p : products) {
    				int instk = p.getStk() - quantity;
    				Stock stk = new Stock(instk, id);
    				upstk.UpdateStock(stk);
    			}
    			if (bookId != null) {
    				if (cart_list != null) {
    					for (Cart c : cart_list) {
    						if (c.getId() == Integer.parseInt(bookId)) {
    							cart_list.remove(cart_list.indexOf(c));
    							break;
    						}
    					}
    				}
    				response.sendRedirect(request.getContextPath() + "/OrderServlet?page=1");

    			} else {
    				response.sendRedirect(request.getContextPath() + "/CheckoutServlet?id="+id+"&paymentId=" + paymentId + "&PayerID=" + payerId);
    			}
    		}else {
    			response.sendRedirect(request.getContextPath() + "/CheckoutServlet?id="+id+"&paymentId=" + paymentId + "&PayerID=" + payerId);
    		}
             
        } catch (PayPalRESTException ex) {
        	System.out.println("Class:" + "CheckoutPageData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
        }catch (NumberFormatException ex) {
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
