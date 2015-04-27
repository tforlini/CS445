package update;

import java.util.ArrayList;

import Entities.Address;
import Entities.Customer;
import Entities.ErrorResponse;
import Entities.NoShipList;
import Entities.WineClub;

public class UpdateCustomer {
	
	private Customer customer;
	
	
	public UpdateCustomer(Customer customer){
		
		this.customer=customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public Customer update(String name,String email,String address,String city,String state,String zip,String phone,String facebook,String twitter){
		Customer customer = this.customer;
		customer.setName(name);
		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setAddress(new Address(address,city,state,zip));
		customer.setFacebookId(facebook);
		customer.setTwitterId(twitter);
		return customer;
		
			
	}
	
	public UpdateCustomerResponse update(WineClub club) {

		ArrayList<ErrorResponse> errors = new ArrayList<ErrorResponse>();
		
		if (addressInBannedState()) {
			errors.add(new ErrorResponse(1009,"We may not ship to this state"));
			return new UpdateCustomerResponse(0,errors);
		}

		if (invalidID(club.getCustomers(), this.customer)){
			errors.add(new ErrorResponse(1013,"Invalid ID"));
			return new UpdateCustomerResponse(0,errors);
		}
		
		else {
			club.addCustomer(this.customer);
			return new UpdateCustomerResponse(this.customer.getId(),errors);
		}
		
	}

	private boolean addressInBannedState() {
		for(NoShipList state : NoShipList.values()){
			if(this.customer.getAddress().getState().equals(state)){
				return true;
			}
		}
		return false;
	}
	
	private boolean invalidID(ArrayList<Customer> customers, Customer newCustomer){
		int i=0;
		while(i<customers.size()){
			if(newCustomer.getId() == customers.get(i).getId()){
				return false;
			}
			i++;
		}
		return true;
	}
	
	}
