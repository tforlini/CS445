package WineClub;

import java.util.ArrayList;


public class WineClub {

	protected MonthlySelection selection;
	protected ArrayList<Customer> customers;
	protected long numberOfCustomers;
	protected ArrayList<Shipment> shipments;
	protected static int numberOfDeliveries;
	protected DeliveryHistory deliveryHistory;
	protected NoShipList noShipList;
	
	
	public WineClub() {
		this.selection = new MonthlySelection();
		this.deliveryHistory = new DeliveryHistory();
		this.noShipList = new NoShipList();
		this.customers= new ArrayList<Customer>();
		this.shipments= new ArrayList<Shipment>();
		
	}
	
	public WineClub(MonthlySelection selection,DeliveryHistory deliveryHistory,NoShipList noShipList,ArrayList<Shipment> shipments,ArrayList<Customer> customers) {
		this.selection = selection;
		this.deliveryHistory = deliveryHistory;
		this.noShipList = noShipList;
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
		this.numberOfCustomers = numberOfCustomers;
	}

	public ArrayList<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(ArrayList<Shipment> shipments) {
		this.shipments = shipments;
	}

	public static int getNumberOfDeliveries() {
		return numberOfDeliveries;
	}

	public static void setNumberOfDeliveries(int numberOfDeliveries) {
		WineClub.numberOfDeliveries = numberOfDeliveries;
	}
	
	public void addCustomer(Customer customer){
		if (checkEmail(this.customers,customer)){
		this.customers.add(customer);
		this.numberOfCustomers = customer.getId();
		}
		else{
			System.out.println("User already existing");
		}
		
	}
	
	public boolean checkEmail(ArrayList<Customer> customers, Customer newCustomer){
		
		int i =0;
		while (i<customers.size()){
			if (!newCustomer.getEmail().equals(customers.get(i).getEmail())){
			return true;
			}
			i++;
		}
		return false;
	}
	
}
