package UseCases;

import java.util.Scanner;

import Entities.Address;
import Entities.Customer;

public class UpdateCustomer {
	private Customer customer;
	
	public UpdateCustomer(){
		this.customer=new Customer();
	}
	public UpdateCustomer(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer update(){
		Customer customer = this.customer;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What is your new email ?\n");
		String email = input.nextLine();
		customer.setEmail(email);
		System.out.println("What is your new phone number ?\n");
		String phone = input.nextLine();
		customer.setPhone(phone);
		System.out.println("What is your new address ?\n");
		System.out.println("What is your new street name ?\n");
		String street = input.nextLine();
		System.out.println("What is your new city name ?\n");
		String city = input.nextLine();
		System.out.println("What is your new state name ?\n");
		String state = input.nextLine();
		System.out.println("What is your new zip code ?\n");
		String zip = input.nextLine();
		customer.setAddress(new Address(street,city,state,zip));
		System.out.println("What is your new facebook ID ?\n");
		String facebook = input.nextLine();
		customer.setFacebookId(facebook);
		System.out.println("What is your new twitter ID ?\n");
		String twitter = input.nextLine();
		customer.setTwitterId(twitter);
		System.out.println("Customer updated successfully! \n");
		return customer;
		
			
	}
	}
