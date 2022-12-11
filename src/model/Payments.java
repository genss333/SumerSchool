package model;

public class Payments {
	String id;
	int p_id;
	int qty;
	double total;
	String user;
	String cardtype;
	String ccname;
	String date;
	String status;
	
	public Payments() {
		
	}
	
	@Override
	public String toString() {
		return "Payments [id=" + id + ", p_id=" + p_id + ", qty=" + qty + ", total=" + total + ", user=" + user
				+ ", cardtype=" + cardtype + ", ccname=" + ccname + ", date=" + date
				+ ", status=" + status + "]";
	}
	public Payments(String id, int p_id, int qty, double total, String user, String cardtype, String ccname,
			String date, String status) {
		super();
		this.id = id;
		this.p_id = p_id;
		this.qty = qty;
		this.total = total;
		this.user = user;
		this.cardtype = cardtype;
		this.ccname = ccname;
		this.date = date;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
