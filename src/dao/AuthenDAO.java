package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionFactory;
import model.Authen;
import model.Book;

public class AuthenDAO {

	public boolean Singup(Authen auth) throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Sinup User");
		boolean set = false;
		try {
			String sql = "INSERT INTO USER (FIRSTNAME,LASTNAME,EMAIL,PASSWORD,STATUS)" + "VALUES ('" + auth.fname
					+ "', '" + auth.lname + "', '" + auth.email + "', '" + auth.password + "','0')";
			String sql2 = "INSERT INTO book (email, image, phone, street, city, state, zipcode) " + "VALUES ('"
					+ auth.email + "', '-', '-', '-', '-', '-', 0)";
			System.out.println(sql);
			System.out.println(sql2);
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
			Statement stmnt2 = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt2 = con.createStatement();
				stmnt.execute(sql);
				stmnt2.execute(sql2);
				set = true;
				stmnt.close();
				con.close();
				System.out.println(" successfully.");
			}

		} catch (NumberFormatException ex) {

			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		}

		return set;
	}

	public boolean Singin(String email, String password)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Sinin User");
		boolean set = false;
		String sql = "SELECT * FROM user WHERE email='" + email + "' AND password='" + password + "'";
		System.out.println(sql);
		try {
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					email = rs.getString("email");
					password = rs.getString("password");
					set = true;
				}
			}

		} catch (NumberFormatException ex) {

			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		}

		return set;
	}

	public static List<Authen> User(String email)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("List User");
		List<Authen> auth = new ArrayList<Authen>();
		String sql = "SELECT * FROM user WHERE email='" + email + "'";
		System.out.println(sql);
		try {
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					email = rs.getString("email");
					String password = rs.getString("password");
					String fname = rs.getString("firstname");
					String lname = rs.getString("lastname");
					Authen a = new Authen(fname, lname, email, password);
					System.out.println(a.toString());
					auth.add(a);
				}
			}

		} catch (NumberFormatException ex) {

			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		}

		return auth;
	}

	public static List<Book> UserBook(String email)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("List User Book");
		List<Book> book = new ArrayList<Book>();
		String sql = "SELECT * FROM book WHERE email='" + email + "'";
		System.out.println(sql);
		try {
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery(sql);
				while (rs.next()) {
					email = rs.getString("email");
					String image = rs.getString("image");
					String phone = rs.getString("phone");
					String street = rs.getString("street");
					String city = rs.getString("city");
					String state = rs.getString("state");
					String zipcode = rs.getString("zipcode");
					Book b = new Book(email, image, phone, street, city, state, zipcode);
					System.out.println(b.toString());
					book.add(b);
				}
			}

		} catch (NumberFormatException ex) {

			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		}

		return book;
	}

	public boolean UpdateUser(Authen auth, Book book, String user)
			throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Update User");
		boolean set = false;
		try {
			String sql = "UPDATE user SET firstname = '" + auth.fname + "', lastname = '" + auth.lname + "', email = '"
					+ auth.email + "'" + " WHERE email = '" + user + "'";
			String sql2 = "UPDATE book SET email = '" + book.getEmail() + "', phone = '" + book.getPhone()
					+ "', street = '" + book.getStreet() + "', " + "city = '" + book.getCity() + "', state = '"
					+ book.getState() + "', zipcode = " + book.getZipcode() + " WHERE email = '" + user + "'";
			System.out.println(sql);
			System.out.println(sql2);
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
			Statement stmnt2 = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt2 = con.createStatement();
				stmnt.execute(sql);
				stmnt2.execute(sql2);
				set = true;
				stmnt.close();
				con.close();
				System.out.println(" successfully.");
			}

		} catch (NumberFormatException ex) {

			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "AuthenDAO, " + ex.getMessage());
			throw ex;
		}

		return set;
	}

}
