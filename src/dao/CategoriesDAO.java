package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionFactory;
import model.Categories;

public class CategoriesDAO {
	private static String COLLECTION = "SELECT DISTINCT collection FROM product WHERE instock > 0 AND inshop = 'yes' GROUP BY collection ";
	private static String BRAND = "SELECT DISTINCT brand,collection FROM product WHERE instock > 0 AND inshop = 'yes'";

	public static List<Categories> ShowCategories() throws SQLException, ClassNotFoundException,Exception,NumberFormatException {
		List<Categories> cat = new ArrayList<Categories>();

		try {
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(COLLECTION);
				while (rs.next()) {
					String col = rs.getString("collection");
					Categories c = new Categories(col, "");
					System.out.println(c.toString());
					cat.add(c);
				}
			}

		} catch (NumberFormatException ex) {
			
			System.out.println("Class:" + "CategoriesDAO, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "CategoriesDAO, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "CategoriesDAO, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "CategoriesDAO, " + ex.getMessage());
			throw ex;
		}

		return cat;

	}

	public static List<Categories> ShowBrand() throws SQLException, ClassNotFoundException,Exception,NumberFormatException  {
		List<Categories> cat = new ArrayList<Categories>();

		try {
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();

			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(BRAND);
				while (rs.next()) {
					String brand = rs.getString("brand");
					String col = rs.getString("collection");
					Categories c = new Categories(col, brand);
					System.out.println(c.toString());
					cat.add(c);
				}
			}

		} catch (NumberFormatException ex) {
			
			System.out.println("Class:" + "CategoriesDAO, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "CategoriesDAO, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "CategoriesDAO, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "CategoriesDAO, " + ex.getMessage());
			throw ex;
		}

		return cat;

	}
}
