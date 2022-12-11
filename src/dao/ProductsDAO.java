package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionFactory;
import model.Cart;
import model.Products;

public class ProductsDAO {

	private static final String SELECT_COUNT_PRODUCT = "SELECT COUNT(id) total FROM product";
	private static final String SELECT_COUNT_PRODUCT_ONSALE = "SELECT COUNT(id) total FROM product WHERE status='onsale'";

	public static List<Products> ProductsOnsale(int start, int total)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Products onsale");
		List<Products> products = new ArrayList<Products>();
		try {
			String sql = "SELECT * FROM product WHERE status='onsale' AND instock > 0 AND inshop = 'yes' " + "LIMIT "
					+ (start - 1) + " ," + total + " ";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
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
			System.out.println("Class:" + "ProductsDAO.ProductsOnsale, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsOnsale, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsOnsale, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsOnsale, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	public static List<Products> ProductsAll(int start, int total)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Products all");
		List<Products> products = new ArrayList<Products>();
		try {
			String sql = "SELECT * FROM product WHERE instock > 0 AND inshop = 'yes' LIMIT " + (start - 1) + " ,"
					+ total;
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String des = rs.getString("des");
					String image = rs.getString("image");
					int price = rs.getInt("price");
					int sale = rs.getInt("sale");
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
		}catch (NumberFormatException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsAll, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsAll, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsAll, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsAll, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	public static List<Products> ProductsCollection(String collection, String brand)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Products collection");
		List<Products> products = new ArrayList<Products>();
		try {
			String sql = "SELECT * FROM product WHERE collection='" + collection + "' AND brand='" + brand
					+ "' AND instock > 0 AND inshop = 'yes' ";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("title");
					String des = rs.getString("des");
					String image = rs.getString("image");
					double price = rs.getDouble("price");
					double sale = rs.getDouble("sale");
					collection = rs.getString("collection");
					brand = rs.getString("brand");
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
			System.out.println("Class:" + "ProductsDAO.ProductsCollection, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsCollection, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsCollection, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsCollection, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	public static List<Products> ProductsSearch(String title, int start, int total)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Products Search");
		List<Products> products = new ArrayList<Products>();
		try {
			String sql = "SELECT * FROM product WHERE title LIKE'%" + title + "%' AND instock > 0 AND inshop = 'yes' "
					+ "LIMIT " + (start - 1) + " ," + total + " ";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt("id");
					title = rs.getString("title");
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
			System.out.println("Class:" + "ProductsDAO.ProductsSearch, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsSearch, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsSearch, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsSearch, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	public static List<Products> ProductsDetail(int id)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Products Detail");
		List<Products> products = new ArrayList<Products>();
		try {
			String sql = "SELECT * FROM product WHERE id ='" + id + "' AND instock > 0 AND inshop = 'yes'";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					id = rs.getInt("id");
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
			System.out.println("Class:" + "ProductsDAO.ProductsDetail, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsDetail, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsDetail, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsDetail, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	public static List<Products> ProductsRelate(String collection, String brand, int id)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Products Relate");
		List<Products> products = new ArrayList<Products>();
		try {
			String sql = "SELECT * FROM product WHERE collection='" + collection + "' AND brand='" + brand
					+ "'AND instock > 0 AND inshop = 'yes' AND id != '" + id + "' LIMIT 4 ";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					id = rs.getInt("id");
					String title = rs.getString("title");
					String des = rs.getString("des");
					String image = rs.getString("image");
					double price = rs.getDouble("price");
					double sale = rs.getDouble("sale");
					collection = rs.getString("collection");
					brand = rs.getString("brand");
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
			System.out.println("Class:" + "ProductsDAO.ProductsRelate, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsRelate, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsRelate, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsDetail, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	private PreparedStatement pst;
	private ResultSet rs;

	public List<Cart> getCartProducts(ArrayList<Cart> cartList)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		List<Cart> book = new ArrayList<>();
		try {
			if (cartList.size() > 0) {
				for (Cart item : cartList) {
					String query = "select * from product where id=?";
					ConnectionFactory connDB = new ConnectionFactory();
					Connection con = connDB.getConnection();

					pst = con.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();
					while (rs.next()) {
						Cart row = new Cart();
						row.setId(rs.getInt("id"));
						row.setTitle(rs.getString("title"));
						row.setImage(rs.getString("image"));
						row.setPrice(rs.getDouble("price"));
						row.setBrand(rs.getString("brand"));
						row.setCollection(rs.getString("collection"));
						row.setStk(rs.getInt("instock"));
						row.setQuantity(item.getQuantity());
						book.add(row);
					}

				}
			}

		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "ProductsDAO.getCartProducts, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.getCartProducts, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.getCartProducts, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.getCartProducts, " + ex.getMessage());
			throw ex;
		}
		return book;
	}

	public static List<Products> ProductsBestseller(int start, int total)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Products Bestseller");
		List<Products> products = new ArrayList<Products>();
		try {
			String sql = "SELECT * FROM product,cart "
					+ "WHERE product.id=cart.product_id AND product.instock > 0 AND product.status = 'onsale' AND product.inshop = 'yes' "
					+ "GROUP BY cart.product_id " + "ORDER BY cart.quantity DESC " + "LIMIT " + (start - 1) + " ,"
					+ total;
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
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
			System.out.println("Class:" + "ProductsDAO.ProductsBestseller, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsBestseller, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsBestseller, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.ProductsBestseller, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	public static List<Products> CountProduct()
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Cout Products");
		List<Products> products = new ArrayList<Products>();
		try {
			System.out.println("selectSql:" + SELECT_COUNT_PRODUCT);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(SELECT_COUNT_PRODUCT);
				while (rs.next()) {
					int total = rs.getInt("total");
					Products pro = new Products(total, "", "", "", 0, 0, "", "", 0, "");
					System.out.println(pro.toString());
					products.add(pro);
					System.out.println("succesfully");
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "ProductsDAO.CountProduct, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.CountProduct, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.CountProduct, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.CountProduct, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	public static List<Products> CountProductOnsale()
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Count Products onsale");
		List<Products> products = new ArrayList<Products>();
		try {
			System.out.println("selectSql:" + SELECT_COUNT_PRODUCT_ONSALE);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(SELECT_COUNT_PRODUCT_ONSALE);
				while (rs.next()) {
					int total = rs.getInt("total");
					Products pro = new Products(total, "", "", "", 0, 0, "", "", 0, "");
					System.out.println(pro.toString());
					products.add(pro);
					System.out.println("succesfully");
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "ProductsDAO.CountProductOnsale, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.CountProductOnsale, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.CountProductOnsale, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.CountProductOnsale, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	public static List<Products> CountCollection(String collection, String brand)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Count Products Collection ");
		List<Products> products = new ArrayList<Products>();
		try {
			String sql = "SELECT COUNT(id) total FROM product WHERE collection='" + collection + "' AND brand='" + brand
					+ "'";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					int total = rs.getInt("total");
					Products pro = new Products(total, "", "", "", 0, 0, "", "", 0, "");
					System.out.println(pro.toString());
					products.add(pro);
					System.out.println("succesfully");
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		} catch (NumberFormatException ex) {
			System.out.println("Class:" + "ProductsDAO.CountCollection, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.CountCollection, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.CountCollection, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.CountCollection, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	public static List<Products> CountSearch(String title)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Count Products Serach ");
		List<Products> products = new ArrayList<Products>();
		try {
			String sql = "SELECT COUNT(id) total FROM product WHERE title LIKE'%" + title
					+ "%' AND instock > 0 AND inshop = 'yes'";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					int total = rs.getInt("total");
					Products pro = new Products(total, "", "", "", 0, 0, "", "", 0, "");
					System.out.println(pro.toString());
					products.add(pro);
					System.out.println("succesfully");
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		}  catch (NumberFormatException ex) {
			System.out.println("Class:" + "ProductsDAO.CountSearch, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.CountSearch, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.CountSearch, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.CountSearch, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

	public static List<Products> CountBestseller()
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Count Products Bestseller ");
		List<Products> products = new ArrayList<Products>();
		try {
			String sql = "SELECT COUNT(quantity) quantity " + "FROM cart "
					+ "INNER JOIN product ON cart.product_id=product.id "
					+ "WHERE product.status='onsale'AND product.instock > 0 AND product.inshop = 'yes' ORDER BY cart.quantity DESC";
			System.out.println("selectSql:" + sql);

			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					int quantity = rs.getInt("quantity");
					Products pro = new Products(quantity, "", "", "", 0, 0, "", "", 0, "");
					System.out.println(pro.toString());
					products.add(pro);
					System.out.println("succesfully");
				}
				stmnt.close();
				con.close();
				System.out.println("Searched successfully.");
			}
		}  catch (NumberFormatException ex) {
			System.out.println("Class:" + "ProductsDAO.CountBestseller, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "ProductsDAO.CountBestseller, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "ProductsDAO.CountBestseller, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "ProductsDAO.CountBestseller, " + ex.getMessage());
			throw ex;
		}
		return products;
	}

}
