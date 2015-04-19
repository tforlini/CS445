package UseCases;

import Entities.Customer;

public class DisplayCustomer {
	
	Customer customer;
	
	public DisplayCustomer(){
		this.customer=new Customer();
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
	public void displayInfo(){
		Customer customer = this.customer;
		System.out.println("ID: "+ customer.getId()+"\n");
		System.out.println("Name: "+ customer.getName()+"\n");
		System.out.println("Address: "+ customer.getAddress().getStreet()+" "+customer.getAddress().getCity()+" "+customer.getAddress().getState()+" "+customer.getAddress().getZip()+"\n");
		System.out.println("Email: "+ customer.getEmail()+"\n");
		System.out.println("Facebook: "+ customer.getFacebookId()+"\n");
		System.out.println("Twitter: "+ customer.getTwitterId()+"\n");
		
	}
}
	
