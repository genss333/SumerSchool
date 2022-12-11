package model;

public class Categories {
	String collection;
	String brand;
	public Categories(String collection, String brand) {
		super();
		this.collection = collection;
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Categories [collection=" + collection + ", brand=" + brand + "]";
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

	
	
	
}
