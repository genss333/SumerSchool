package model;

public class Payers {
	
	String email;
	String fname;
	String lname;
	public Payers(String email, String fname, String lname) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	

}
