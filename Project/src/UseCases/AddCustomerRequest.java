package UseCases;

import WineClub.WineClub;

public abstract class AddCustomerRequest {
	String street, city, state, zip;
	String name, email, phone, twitter, facebook;
	
	public AddCustomerRequest(String street, String c, String state, String z, String name, String e, String p, String tw, String fb) {
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
	public abstract AddCustomerResponse addAccount(WineClub club);
}
