package control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import dao.ProductsDAO;
import model.Order;
import model.Products;
import model.Stock;

public class RemoveOrderData {
	public String errorMessage;

	public boolean failed;

	public RemoveOrderData(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("============ RemoveOrderData ============");

		StringBuffer temp = new StringBuffer();
		try {
			String id = request.getParameter("id");
			String pid = request.getParameter("pid");
			OrderDAO dao = new OrderDAO();
			List<Products> product = ProductsDAO.ProductsDetail(Integer.valueOf(pid));
			List<Order> order = OrderDAO.SearchOrder(Integer.valueOf(id));
			int qty = 0;
			int stk = 0;
			for (Products index : product) {
				stk += index.stk;
			}
			for (Order index : order) {
				qty += index.getQty();
			}

			int total = stk + qty;
			Stock stock = new Stock(total, Integer.valueOf(pid));
			if (dao.UpdateStock(stock)) {
				dao.DeleteOrder(Integer.valueOf(id));
				response.sendRedirect(request.getContextPath() + "/OrderServlet?page=1");
			}
		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "RemoveOrderData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "RemoveOrderData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (SQLException ex) {
			System.out.println("Class:" + "RemoveOrderData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		} catch (Exception ex) {
			System.out.println("Class:" + "RemoveOrderData, " + ex.getMessage());
			String msg = ex.getMessage();
			temp.append(msg).append("\n");
			failed = true;
		}

		if (failed) {
			errorMessage = temp.toString();
		}

	}
}
