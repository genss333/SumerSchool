package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionFactory;
import model.Order;
import model.Stock;

public class OrderDAO {

	public static List<Order> ShowOrder(String user, int start, int last)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Show Order");
		List<Order> order = new ArrayList<Order>();

		try {
			String sql = "SELECT cart.id,cart.product_id,cart.quantity,cart.total,cart.status,cart.date,product.title,product.image,product.price,cart.user \r\n"
					+ "FROM cart \r\n" + "INNER JOIN product ON cart.product_id = product.id \r\n" + "WHERE cart.user='"
					+ user + "' \r\n" + "LIMIT " + (start - 1) + "," + last;
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("id");
					int pid = rs.getInt("product_id");
					int qty = rs.getInt("quantity");
					double total = rs.getDouble("total");
					String status = rs.getString("status");
					String title = rs.getString("title");
					String image = rs.getString("image");
					double price = rs.getDouble("price");
					String date = rs.getString("date");
					Order or = new Order(id, pid, qty, total, status, title, image, price, date);
					System.out.println(or.toString());
					order.add(or);
					System.out.println("succesfully");
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "OrderDAO.ShowOrder, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "OrderDAO.ShowOrder, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "OrderDAO.ShowOrder, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "OrderDAO.ShowOrder, " + ex.getMessage());
			throw ex;
		}
		return order;
	}

	public static List<Order> SearchOrder(int id) throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Search Order");
		List<Order> order = new ArrayList<Order>();

		try {
			String sql = "SELECT * FROM cart WHERE id='" + id + "'";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					id = rs.getInt("id");
					int pid = rs.getInt("product_id");
					int qty = rs.getInt("quantity");
					double total = 0;
					String status = "";
					String title = "";
					String image = "";
					double price = 0;
					String date = "";
					Order or = new Order(id, pid, qty, total, status, title, image, price, date);
					System.out.println(or.toString());
					order.add(or);
					System.out.println("succesfully");
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "OrderDAO.SearchOrder, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "OrderDAO.SearchOrder, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "OrderDAO.SearchOrder, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "OrderDAO.SearchOrder, " + ex.getMessage());
			throw ex;
		}
		return order;
	}

	public static List<Order> CountOrder(String user) throws SQLException, ClassNotFoundException, Exception, NumberFormatException{
		System.out.println("Count Order");
		List<Order> order = new ArrayList<Order>();

		try {
			String sql = "SELECT COUNT(id) quantity FROM cart WHERE user='" + user + "'";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					int total = rs.getInt("quantity");
					Order or = new Order(total, 0, 0, 0, "", "", "", 0, "");
					System.out.println(or.toString());
					order.add(or);
					System.out.println("succesfully");
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "OrderDAO.CountOrder, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "OrderDAO.CountOrder, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "OrderDAO.CountOrder, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "OrderDAO.CountOrder, " + ex.getMessage());
			throw ex;
		}
		return order;
	}

	public boolean UpdateStock(Stock stk) throws SQLException, ClassNotFoundException, Exception, NumberFormatException{
		System.out.println("Update Stock");
		boolean set = false;
		try {
			String sql = "UPDATE product SET instock = '" + stk.getQuantity() + "' WHERE product.id = '" + stk.getId()
					+ "'";
			System.out.println(sql);
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(sql);
				set = true;
				stmnt.close();
				con.close();
				System.out.println(" successfully.");
			}
		}  catch (NumberFormatException ex) {
			System.out.println("Class:" + "OrderDAO.UpdateStock, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "OrderDAO.UpdateStock, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "OrderDAO.UpdateStock, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "OrderDAO.UpdateStock, " + ex.getMessage());
			throw ex;
		}

		return set;
	}

	public boolean DeleteOrder(int id) throws SQLException, ClassNotFoundException, Exception, NumberFormatException{
		System.out.println("Delete Order");
		boolean set = false;
		try {
			String sql = "DELETE FROM cart WHERE id='" + id + "'";
			System.out.println(sql);
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(sql);
				set = true;
				stmnt.close();
				con.close();
				System.out.println(" successfully.");
			}
		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "OrderDAO.DeleteOrder, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "OrderDAO.DeleteOrder, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "OrderDAO.DeleteOrder, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "OrderDAO.DeleteOrder, " + ex.getMessage());
			throw ex;
		}
		return set;
	}

}
