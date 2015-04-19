package UseCases;

import java.util.ArrayList;
import java.util.Date;

import Entities.Address;
import Entities.Customer;
import Entities.DayOfWeek;
import Entities.NoShipList;
import Entities.Shipment;
import Entities.TimeOfDay;
import UseCases.AddCustomerRequest;
import UseCases.AddCustomerResponse;
import WineClub.WineClub;

public class AddCustomer extends AddCustomerRequest {
	private Address a;
	private Customer s;
	
	public AddCustomer(String street, String city, String state, String zip,
			String name,String email, String phone, String twitter, String facebook) {
		super(street, city, state, zip, name, email, phone, twitter, facebook);

	}

	
	@Override
	public AddCustomerResponse addAccount(WineClub club) {
		a = new Address(this.street, this.city, this.state, this.zip);
		s = new Customer (this.name,this.a,DayOfWeek.Mon,TimeOfDay.PM,this.email,this.phone,this.facebook,this.twitter,new Date(),"",new ArrayList<Shipment>(), 0);
		
		if (addressInBannedState()) {
			return new AddCustomerResponse(0, false, "Cannot ship to this state");
		}
		
		if (userHasAccount(club.getCustomers(), s)) {
			return new AddCustomerResponse(0, false, "User already has an account");
		} else {
			club.addCustomer(s);
			return new AddCustomerResponse(s.getId(), true, "Congratulations");
		}
	}
	private boolean userHasAccount(ArrayList<Customer> customers, Customer newCustomer) {
		int i =0;
		while (i<customers.size()){
			if (newCustomer.getEmail().equals(customers.get(i).getEmail())){
			return true;
			}
			i++;
			
		}
		return false;
	}
	
	private boolean addressInBannedState() {
		for(NoShipList state : NoShipList.values()){
			if(this.a.getState().equals(state)){
				return true;
			}
		}
		return false;
	}
}
