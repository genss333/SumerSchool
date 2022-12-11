package model;

public class Order{
	
	int id;
	int pid;
	int qty;
	double total;
	String status;
	String title;
	String image;
	double price;
	String date;
	public Order(int id, int pid, int qty, double total, String status, String title, String image, double price,
			String date) {
		super();
		this.id = id;
		this.pid = pid;
		this.qty = qty;
		this.total = total;
		this.status = status;
		this.title = title;
		this.image = image;
		this.price = price;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", pid=" + pid + ", qty=" + qty + ", total=" + total + ", status=" + status
				+ ", title=" + title + ", image=" + image + ", price=" + price + ", date=" + date + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
