package update;

import Entities.Customer;

public class UpdateDeliveryInfo {
	Customer customer;
	
	public UpdateDeliveryInfo(){
		
	}
	
	public UpdateDeliveryInfo(Customer customer){
		this.customer=customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Customer updateDeliveryInfo(String dow,String tod) throws java.lang.NullPointerException{
		if(this.getCustomer()!=null){
			Customer customer = this.getCustomer();
			customer.setDayOfWeek(dow);
			customer.setTimeOfDay(tod);
			
			
		}
		else{
			throw new java.lang.NullPointerException("Customer not found");
		}
		return customer;
		 
	}
}
