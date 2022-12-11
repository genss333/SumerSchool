package model;

public class GoogleAuth {
	
	String email;
	String pictureUrl;
	String name;
	String givenName;
	String familyName;
	
	public GoogleAuth(String email, String pictureUrl, String name, String givenName, String familyName) {
		super();
		this.email = email;
		this.pictureUrl = pictureUrl;
		this.name = name;
		this.givenName = givenName;
		this.familyName = familyName;
	}

	@Override
	public String toString() {
		return "GoogleAuth [email=" + email + ", pictureUrl=" + pictureUrl + ", name=" + name + ", givenName="
				+ givenName + ", familyName=" + familyName + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	
	

}
