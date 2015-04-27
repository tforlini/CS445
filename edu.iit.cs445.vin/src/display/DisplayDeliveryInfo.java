package display;

import Entities.Customer;

public class DisplayDeliveryInfo {
	Customer customer;
	
	public DisplayDeliveryInfo(){
		
	}
	public DisplayDeliveryInfo(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public DisplayDeliveryInfoResponse displayInfo() throws java.lang.NullPointerException{
		DisplayDeliveryInfoResponse response = new DisplayDeliveryInfoResponse();
		if(this.getCustomer()!=null){
			Customer customer = this.getCustomer();
			response.setDow(customer.getDeliveryDay());
			response.setTod(customer.getDeliveryTime());
		}
		else{
			throw new java.lang.NullPointerException("Customer not found");
		}
		return response;
	}
	
}
