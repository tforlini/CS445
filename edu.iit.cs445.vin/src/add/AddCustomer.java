package add;

import java.util.ArrayList;
import java.util.Calendar;

import add.AddCustomerResponse;
import Entities.Address;
import Entities.Customer;
import Entities.DayOfWeek;
import Entities.ErrorResponse;
import Entities.NoShipList;
import Entities.Shipment;
import Entities.TimeOfDay;
import Entities.WineClub;

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
		s = new Customer (this.name,this.a,DayOfWeek.Mon,TimeOfDay.PM,this.email,this.phone,this.facebook,this.twitter,Calendar.getInstance(),new ArrayList<Shipment>(), 0);
		Shipment newShip = new Shipment();
		newShip.setMonthlySelection(club.getSelection());
		newShip.setForecastedDate(s.getDeliveryDay());
		newShip.setForecastedTime(s.getDeliveryTime());
		newShip.setCustomerEmail(s.getEmail());
		s.addShipment(newShip);
		
	ArrayList<ErrorResponse> errors = new ArrayList<ErrorResponse>();
		
		if (addressInBannedState()) {
			errors.add(new ErrorResponse(1009,"We may not ship to this state"));
			return new AddCustomerResponse(0,errors);
		}
		
		if (userHasAccount(club.getCustomers(), s)) {
			errors.add(new ErrorResponse(1014,"An account with this email address exists"));
			return new AddCustomerResponse(0,errors);
		}
		
		if (!nameProvided()) {
			errors.add(new ErrorResponse(1000,"Name must be provided"));
			return new AddCustomerResponse(0,errors);
		}
		
		if (!emailProvided()){
			errors.add(new ErrorResponse(1002,"Email address must be provided"));
			return new AddCustomerResponse(0,errors);
		}
		
		if (!addressProvided()){
			errors.add(new ErrorResponse(1004,"Address must be provided"));
			return new AddCustomerResponse(0,errors);
		}
		
		if (!cityProvided()){
			errors.add(new ErrorResponse(1006,"City must be provided"));
			return new AddCustomerResponse(0,errors);
		}
		
		if (!stateProvided()){
			errors.add(new ErrorResponse(1008,"State must be provided"));
			return new AddCustomerResponse(0,errors);
		}
		
		if (!zipProvided()){
			errors.add(new ErrorResponse(1010,"Zip code must be provided"));
			return new AddCustomerResponse(0,errors);
		}
		
		if (!phoneProvided()){
			errors.add(new ErrorResponse(1012,"Phone number must be provided"));
			return new AddCustomerResponse(0,errors);
		}

		else {
			club.addCustomer(s);
			return new AddCustomerResponse(s.getId(),errors);
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
	
	private boolean nameProvided(){
		if (this.s.getName().equals("")){
			return false;
		}
		return true;
	}
	
	private boolean emailProvided(){
		if (this.s.getEmail().equals("")){
			return false;
		}
		return true;
	}
	
	private boolean addressProvided(){
		if(this.s.getAddress().getStreet().equals("") ){
			return false;
		}
		return true;
	}
	
	private boolean cityProvided(){
		if( this.s.getAddress().getCity().equals("") ){
			return false;
		}
		return true;
	}
	
	private boolean stateProvided(){
		if( this.s.getAddress().getState().equals("") ){
			return false;
		}
		return true;
	}
	
	private boolean zipProvided(){
		if( this.s.getAddress().getZip().equals("") ){
			return false;
		}
		return true;
	}
	
	private boolean phoneProvided(){
		if( this.s.getPhone().equals("")){
			return false;
		}
		return true;
	}
	
	private boolean addressInBannedState() {
		for(NoShipList state : NoShipList.values()){
			if(this.a.getState().equals(state)){
				return true;
			}
		}
		return false;
	}


	public Address getA() {
		return a;
	}


	public void setA(Address a) {
		this.a = a;
	}


	public Customer getS() {
		return s;
	}


	public void setS(Customer s) {
		this.s = s;
	}
	
}
