package model;

public class Stock {
	int quantity;
	int id;
	public Stock(int quantity, int id) {
		super();
		this.quantity = quantity;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Stock [quantity=" + quantity + ", id=" + id + "]";
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	
}
