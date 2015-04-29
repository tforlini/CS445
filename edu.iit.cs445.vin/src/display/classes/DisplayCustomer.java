package display.classes;

import display.response.DisplayCustomerResponse;
import entities.Customer;

public class DisplayCustomer {
	Customer customer;
	
	public DisplayCustomer(){
		
	}
	
	public DisplayCustomer(Customer customer){
		this.customer=customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public DisplayCustomerResponse displayCustomer(){
		DisplayCustomerResponse response = new DisplayCustomerResponse();
		response.setName(this.customer.getName());
		response.setEmail(this.customer.getEmail());
		response.setPhone(this.customer.getPhone());
		response.setAddress(this.customer.getAddress());
		response.setFacebook(this.customer.getFacebookId());
		response.setTwitter(this.customer.getTwitterId());
		
		return response;
	}
}
