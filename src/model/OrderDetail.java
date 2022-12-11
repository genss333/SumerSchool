package model;

public class OrderDetail {
	String p_id;
	String title;
	float subtotal;
	int qty;
	float shipping;
	float tax;
	float total;
	
	public OrderDetail(String p_id, String title, float subtotal, int qty, float shipping, float tax, float total) {
		super();
		this.p_id = p_id;
		this.title = title;
		this.subtotal = subtotal;
		this.qty = qty;
		this.shipping = shipping;
		this.tax = tax;
		this.total = total;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getShipping() {
		return shipping;
	}

	public void setShipping(float shipping) {
		this.shipping = shipping;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	
	
	
}