package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionFactory;
import model.Products;

public class ShowProductDAO {

	private static final String SELECT_PRODUCTS_ONSALE = "SELECT * FROM product WHERE status='onsale'AND instock > 0 LIMIT 4 ";
	private static final String SELECT_PRODUCTS_BESTSELLER = "SELECT * FROM product,cart "
			+ "WHERE product.id=cart.product_id AND product.instock > 0 AND product.status = 'onsale'"
			+ " GROUP BY cart.product_id " + "ORDER BY cart.quantity DESC LIMIT 4 ";
	

	public static List<Products> ProductsOnsale()
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Products onsale");
		List<Products> products = new ArrayList<Products>();
		try {
			System.out.println("selectSql:" + SELECT_PRODUCTS_ONSALE);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
				if (con != null) {
					stmnt = con.createStatement();
					ResultSet rs = stmnt.executeQuery(SELECT_PRODUCTS_ONSALE);
					while (rs.next()) {
						int id = rs.getInt("id");
						String title = rs.getString("title");
						String des = rs.getString("des");
						String image = rs.getString("image");
						double price = rs.getDouble("price");
						double sale = rs.getDouble("sale");
						String collection = rs.getString("collection");
						String brand = rs.getString("brand");
						int stk = rs.getInt("instock");
						String status = rs.getString("status");
						Products pro = new Products(id, title, des, image, price, sale, collection, brand, stk, status);
						System.out.println(pro.toString());
						products.add(pro);
						System.out.println("succesfully");
					}
					stmnt.close();
					con.close();
					System.out.println("Searched successfully.");
				}

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "ShowProductDAO.ProductsOnsale, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ShowProductDAO.ProductsOnsale, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ShowProductDAO.ProductsOnsale, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ShowProductDAO.ProductsOnsale, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	public static List<Products> ProductsBestseller() throws SQLException, ClassNotFoundException,Exception,NumberFormatException {
		System.out.println("Products Bestseller");
		List<Products> products = new ArrayList<Products>();
		try {
			System.out.println("selectSql:" + SELECT_PRODUCTS_BESTSELLER);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(SELECT_PRODUCTS_BESTSELLER);
				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String des = rs.getString("des");
					String image = rs.getString("image");
					double price = rs.getDouble("price");
					double sale = rs.getDouble("sale");
					String collection = rs.getString("collection");
					String brand = rs.getString("brand");
					int stk = rs.getInt("instock");
					String status = rs.getString("status");
					Products pro = new Products(id, title, des, image, price, sale, collection, brand, stk, status);
					System.out.println(pro.toString());
					products.add(pro);
					System.out.println("succesfully");
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			} 
		} catch (NumberFormatException ex) {
			
			System.out.println("Class:" + "ShowProductDAO.ProductsBestseller, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ShowProductDAO.ProductsBestseller, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ShowProductDAO.ProductsBestseller, " + ex.getMessage());
			throw ex;
		}catch (Exception ex) {
			System.out.println("Class:" + "ShowProductDAO.ProductsBestseller, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

}
