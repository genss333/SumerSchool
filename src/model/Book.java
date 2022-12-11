package model;

public class Book {
	String email;
	String image;
	String phone;
	String street;
	String city;
	String state;
	String zipcode;
	public Book(String email, String image, String phone, String street, String city, String state,
			String zipcode) {
		super();
		this.email = email;
		this.image = image;
		this.phone = phone;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "Book [email=" + email + ", image=" + image + ", phone=" + phone + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
}
