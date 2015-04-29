package update.request;

import update.response.UpdateCustomerResponse;
import entities.Customer;
import entities.WineClub;

public abstract class UpdateCustomerRequest {
	String street, city, state, zip;
	String name, email, phone, twitter, facebook;
	
	public UpdateCustomerRequest(String street, String c, String state, String z, String name, String e, String p, String tw, String fb) {
		this.street = street;
		this.city = c;
		this.state = state;
		this.zip = z;
		this.name = name;
		this.email = e;
		this.phone = p;
		this.twitter = tw;
		this.facebook = fb;
	}
	
	public abstract UpdateCustomerResponse update(WineClub club);
	
	public abstract Customer update(String name,String email,String address,String city,String state,String zip,String phone,String facebook,String twitter);
}
