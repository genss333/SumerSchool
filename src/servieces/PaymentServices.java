package servieces;

import java.util.*;

import com.paypal.api.payments.*;
import com.paypal.base.rest.*;

import model.OrderDetail;
import model.Payers;

public class PaymentServices {
	private static final String CLIENT_ID = "Ab4HoVrqr4CzHn9ER7qibHl8c7G0lWAPi641esA8RbhaMCt7lPwqsnRr5Yj5JEmyw7R33HbMrEgu4X8k";
	private static final String CLIENT_SECRET = "EGRJV0ZJxjOb5yPSYtyj85CHWKiMmpQIx4p5ijei61xWpsYetchjzmPuLiB6vye6D2RI0xPxPJdqmXl8";
	private static final String MODE = "sandbox";

	public String authorizePayment(OrderDetail orderDetail,Payers payerpayment) throws PayPalRESTException {

		Payer payer = getPayerInformation(payerpayment);
		RedirectUrls redirectUrls = getRedirectURLs(orderDetail);
		List<Transaction> listTransaction = getTransactionInformation(orderDetail);

		Payment requestPayment = new Payment();
		requestPayment.setTransactions(listTransaction);
		requestPayment.setRedirectUrls(redirectUrls);
		requestPayment.setPayer(payer);
		requestPayment.setIntent("authorize");

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		Payment approvedPayment = requestPayment.create(apiContext);

		return getApprovalLink(approvedPayment);

	}

	private Payer getPayerInformation(Payers payerpayment) {
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		PayerInfo payerInfo = new PayerInfo();
		payerInfo.setEmail(payerpayment.getEmail())
				 .setFirstName(payerpayment.getFname())
				 .setLastName(payerpayment.getLname());

		payer.setPayerInfo(payerInfo);

		return payer;
	}

	private RedirectUrls getRedirectURLs(OrderDetail orderDetail) {
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:8080/SumerSchool/CartServlet");
		redirectUrls.setReturnUrl("http://localhost:8080/SumerSchool/CheckoutServlet?id="+orderDetail.getP_id());

		return redirectUrls;
	}

	private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
		Details details = new Details();
		details.setShipping("0");
		details.setSubtotal(String.valueOf(orderDetail.getTotal()));
		details.setTax("0");

		Amount amount = new Amount();
		amount.setCurrency("THB");
		amount.setTotal(String.valueOf(orderDetail.getTotal()));
		amount.setDetails(details);

		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription(orderDetail.getTitle());

		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<>();

		Item item = new Item();
		item.setCurrency("THB");
		item.setName(orderDetail.getTitle());
		item.setPrice(String.valueOf(orderDetail.getTotal()));
		item.setQuantity("1");

		items.add(item);
		itemList.setItems(items);
		transaction.setItemList(itemList);

		List<Transaction> listTransaction = new ArrayList<>();
		listTransaction.add(transaction);

		return listTransaction;
	}

	private String getApprovalLink(Payment approvedPayment) {
		List<Links> links = approvedPayment.getLinks();
		String approvalLink = null;

		for (Links link : links) {
			if (link.getRel().equalsIgnoreCase("approval_url")) {
				approvalLink = link.getHref();
				break;
			}
		}

		return approvalLink;
	}

	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
		return Payment.get(apiContext, paymentId);
	}

	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(payerId);

		Payment payment = new Payment().setId(paymentId);

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		return payment.execute(apiContext, paymentExecution);
	}
}