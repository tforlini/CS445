package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {
	
	private WineClub club;
	private ArrayList<Customer> customers;
	private ArrayList<Shipment> shipments;
	private  static int cancellationNumber;
	private static int returnNumber;
	private static int exchangeNumber;
	
	public CustomerService(){
		this.customers=new ArrayList<Customer>();
		this.shipments= new ArrayList<Shipment>();
		CustomerService.cancellationNumber=0;
		CustomerService.returnNumber=0;
		CustomerService.exchangeNumber=0;
	}
	public CustomerService(ArrayList<Customer> customers,ArrayList<Shipment> shipments,WineClub club){
		this.customers=customers;
		this.shipments= shipments;
		this.club=club;
		CustomerService.cancellationNumber=0;
		CustomerService.returnNumber=0;
		CustomerService.exchangeNumber=0;
	}
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	public ArrayList<Shipment> getShipments() {
		return shipments;
	}
	public void setShipments(ArrayList<Shipment> shipments) {
		this.shipments = shipments;
	}
	public int getCancellationNumber() {
		return cancellationNumber;
	}
	public void setCancellationNumber(int cancellationNumber) {
		CustomerService.cancellationNumber = cancellationNumber;
	}
	public int getReturnNumber() {
		return returnNumber;
	}
	public void setReturnNumber(int returnNumber) {
		CustomerService.returnNumber = returnNumber;
	}
	public int getExchangeNumber() {
		return exchangeNumber;
	}
	public void setExchangeNumber(int exchangeNumber) {
		CustomerService.exchangeNumber = exchangeNumber;
	}
	
	public WineClub getClub() {
		return club;
	}
	public void setClub(WineClub club) {
		this.club = club;
	}
	public Customer callService(Customer customer){
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What is Your Email address or Last Name or Phone Number or Facebook/Twitter?\n");
		String id = input.nextLine();

		if (customer.isMatch(id)){
			System.out.println(customer.getName()+" "+"you are connected to customer Service\n");
			return customer;
		}
		else{
			System.out.println("Unable to find you in our service\n");
			return null;
		}
	}
	
	public void cancelDelivery(Customer customer){
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What delivery do you want to cancel ?\n");
		int delivery = Integer.parseInt(input.nextLine());

		Shipment shipment = customer.getShipmentById(delivery);
		shipment.setState(ShipmentState.CANCELLED);
		
		this.shipments.add(shipment);
		this.customers.add(customer);
		
		System.out.println("Your shipment from "+shipment.getSubscriptionDate() +" is cancelled\n");
		
	}
	
}
