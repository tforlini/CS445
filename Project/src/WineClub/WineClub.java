package WineClub;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Entities.Customer;
import Entities.MonthlySelection;
import Entities.NoShipList;
import Entities.Shipment;
import Entities.Wine;


public class WineClub implements Deliver {

	protected MonthlySelection selection;
	protected ArrayList<Customer> customers;
	protected static long numberOfCustomers;
	protected ArrayList<Shipment> shipments;
	protected static int numberOfDeliveries;
	protected DeliveryHistory deliveryHistory;
	protected NoShipList noShipList;
	
	
	public WineClub() {
		this.selection = new MonthlySelection();
		this.deliveryHistory = new DeliveryHistory();
		this.customers= new ArrayList<Customer>();
		this.shipments= new ArrayList<Shipment>();
		
	}
	
	public WineClub(MonthlySelection selection,DeliveryHistory deliveryHistory,ArrayList<Shipment> shipments,ArrayList<Customer> customers) {
		this.selection = selection;
		this.deliveryHistory = deliveryHistory;
		this.customers=customers;
		this.shipments=shipments;
	}

	public MonthlySelection getSelection() {
		return selection;
	}

	public void setSelection(MonthlySelection selection) {
		this.selection = selection;
	}

	public DeliveryHistory getDeliveryHistory() {
		return deliveryHistory;
	}

	public void setDeliveryHistory(DeliveryHistory deliveryHistory) {
		this.deliveryHistory = deliveryHistory;
	}

	public NoShipList getNoShipList() {
		return noShipList;
	}

	public void setNoShipList(NoShipList noShipList) {
		this.noShipList = noShipList;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public long getNumberOfCustomers() {
		return numberOfCustomers;
	}

	public void setNumberOfCustomers(long numberOfCustomers) {
		WineClub.numberOfCustomers = numberOfCustomers;
	}

	public ArrayList<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(ArrayList<Shipment> shipments) {
		this.shipments = shipments;
	}

	public void updateShipment(Shipment newShipment){
		ArrayList<Shipment> shipments = this.getShipments();
		if(shipments != null && newShipment != null){
		int newId = newShipment.getId();
		
		int i=0;
		while (i<shipments.size()){
			
			if(shipments.get(i).getId() == newId){
				shipments.set(i,newShipment);
			}
			i++;
		}
		}
		else{
			System.out.println("Unable to find your shipment\n");
		}
	}
	
	public void updateCustomer(Customer newCustomer){
		ArrayList<Customer> customers = this.getCustomers();
		if(customers !=null){
			int newId = newCustomer.getId();
			int i =0;
			while(i<customers.size()){
				if(customers.get(i).getId() == newId){
					customers.set(i,newCustomer);
				}
				i++;
			}
		ArrayList<Shipment> shipments = newCustomer.getShipments();	
			int j=0;
			while(j<shipments.size()){
				shipments.get(j).setCustomerEmail(newCustomer.getEmail());
				j++;
			}
			
		}
		else{
			System.out.println("Customer not found\n");
		}
	}
	
	public void updateWine(Wine newWine) {
		int newId = newWine.getID();
		ArrayList<Wine> wines = this.getSelection().getWines();
		int i = 0;
		while (i < wines.size()) {
			if (wines.get(i).getID() == newId) {
				wines.set(i, newWine);
			}
			i++;
		}

		int j = 0;
		ArrayList<Shipment> wineShipments = this.getShipments();
		while (j < wineShipments.size()) {
			ArrayList<Wine> wShip = wineShipments.get(j).getMonthlySelection().getWines();

			int k = 0;
			while (k < wShip.size()) {
				if (wShip.get(k).getID() == newId) {
					wShip.set(k, newWine);
				}
				k++;
			}

			j++;
		}
	}
	public Customer getCustomerById(int id){
		ArrayList<Customer> customers = this.customers;
		int i=0;
		while(i<customers.size()){
			if(customers.get(i).getId() == id )
			return customers.get(i);
			i++;
		}
		System.out.println("Customer not found");
		return null;
		
	}
	public static int getNumberOfDeliveries() {
		return numberOfDeliveries;
	}

	public static void setNumberOfDeliveries(int numberOfDeliveries) {
		WineClub.numberOfDeliveries = numberOfDeliveries;
	}
	
	public boolean addCustomer(Customer customer){
		
		if (checkEmail(this.customers,customer)){
		this.customers.add(customer);
		WineClub.numberOfCustomers = customer.getId();
		return true;
		}
		else{
			System.out.println("User already existing");
			return false;
		}
		
	}
	
	public boolean checkEmail(ArrayList<Customer> customers, Customer newCustomer){
		
		int i =0;
		while (i<customers.size()){
			if (newCustomer.getEmail().equals(customers.get(i).getEmail())){
			return false;
			}
			i++;
			
		}
		return true;
	}
	
	public void addShipment(Shipment shipment){
		
		this.shipments.add(shipment);
		WineClub.numberOfDeliveries++;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void setDelivery(Customer customer) throws ParseException {
		

		Shipment shipment = new Shipment();
		MonthlySelection selection = this.getSelection();
		shipment.setMonthlySelection(selection);

		shipment.setAverageRating();
		// System.out.println(shipment.getAveragRating());

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("How many Selection box do you want for this month ?\n");
		String numberOfSelections = input.nextLine();
		int number = Integer.parseInt(numberOfSelections);
		shipment.setNumberOfMonthlySelections(number);
		System.out.println("Your number of monthly package is set to: "+ shipment.getNumberOfMonthlySelections());
		
		System.out.println("What delivery Type do you want ?\n");
		System.out.println("(Type AR for all reds, AW for all whites and RW for a mix of 3 reds and 3 whites )");
		String type = input.nextLine();
		shipment.setType(type);
		System.out.println("Your type of monthly package is set to: "+ shipment.getType() + "\n");
		
		System.out.println("When do you want to be served ?");
		System.out.println("Format : MM-DD-YYYY\n");
		String date = input.nextLine();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		Date dateStr = formatter.parse(date);
		
		System.out.println("Would you like to be served in the morning or afternoon ?");
		System.out.println("(Type M for Morning and A for Afternoon)");
		

		
		
		shipment.setCustomerEmail(customer.getEmail());
		
		customer.addShipment(shipment);
		this.addShipment(shipment);

		
	}
	

	
}
