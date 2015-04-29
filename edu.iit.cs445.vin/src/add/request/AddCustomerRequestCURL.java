package add.request;

import entities.Address;

public class AddCustomerRequestCURL {
	String email;
	String name;
	String phone;
	Address address;
	String facebook;
	String twitter;
	
	public AddCustomerRequestCURL(){
		
	}
	public AddCustomerRequestCURL(String email,String name,String phone,Address address,String facebook,String twitter){
		this.email=email;
		this.name=name;
		this.phone=phone;
		this.address=address;
		this.facebook=facebook;
		this.twitter=twitter;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	
}
