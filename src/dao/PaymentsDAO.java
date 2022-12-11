package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.ConnectionFactory;
import model.Payments;

public class PaymentsDAO {
	public boolean PayMents(Payments pay)throws SQLException, ClassNotFoundException, Exception, NumberFormatException {
		System.out.println("Payment Medthods");
		boolean set = false;
		try {
			String sql = "INSERT INTO cart (product_id, quantity, total, user, card_type, namecard, date, status) "
					+ "VALUES ('"+pay.getP_id()+"', '"+pay.getQty()+"', '"+pay.getTotal()+"', '"+pay.getUser()+"', "
							+ "'"+pay.getCardtype()+"', '"+pay.getCcname()+"','"+pay.getDate()+"', '"+pay.getStatus()+"')";
			System.out.println(sql);
			ConnectionFactory connDB = new ConnectionFactory();
			Connection con = connDB.getConnection();
			Statement stmnt = null;
			if (con != null) {
				stmnt = con.createStatement();
				stmnt.execute(sql);
				set= true;
				stmnt.close();
				con.close();
				System.out.println(" successfully.");
			}
		} catch (NumberFormatException ex) {

			System.out.println("Class:" + "PayMents, " + ex.getMessage());
			throw ex;
		} catch (ClassNotFoundException ex) {
			System.out.println("Class:" + "PayMents, " + ex.getMessage());
			throw ex;
		} catch (SQLException ex) {
			System.out.println("Class:" + "PayMents, " + ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			System.out.println("Class:" + "PayMents, " + ex.getMessage());
			throw ex;
		}
		
		return set;
	}
}
