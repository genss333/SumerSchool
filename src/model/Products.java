package model;

public class Products {
		public int id;
		public String title;
		public String des;
		public String image;
		public double price;
		public double sale;
		public String collection;
		public String brand;
		public int stk;
		public String status;
		
		public Products() {
			
		}
		
		public Products(int id, String title, String des, String image, double price, double sale, String collection,
				String brand, int stk, String status) {
			super();
			this.id = id;
			this.title = title;
			this.des = des;
			this.image = image;
			this.price = price;
			this.sale = sale;
			this.collection = collection;
			this.brand = brand;
			this.stk = stk;
			this.status = status;
		}
		@Override
		public String toString() {
			return "products [id=" + id + ", title=" + title + ", des=" + des + ", image=" + image + ", price=" + price
					+ ", sale=" + sale + ", collection=" + collection + ", brand=" + brand + ", stk=" + stk
					+ ", status=" + status + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDes() {
			return des;
		}
		public void setDes(String des) {
			this.des = des;
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
		public double getSale() {
			return sale;
		}
		public void setSale(double sale) {
			this.sale = sale;
		}
		public String getCollection() {
			return collection;
		}
		public void setCollection(String collection) {
			this.collection = collection;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public int getStk() {
			return stk;
		}
		public void setStk(int stk) {
			this.stk = stk;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		

}
