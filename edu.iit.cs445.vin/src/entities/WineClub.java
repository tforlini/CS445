package entities;

import java.util.ArrayList;


public class WineClub {

	protected MonthlySelection selection;
	protected ArrayList<MonthlySelection> selections;
	protected ArrayList<Customer> customers;
	protected ArrayList<Administrator> administrators;
	protected static long numberOfCustomers;
	protected ArrayList<Shipment> shipments;
	protected ArrayList<Receipt> receipts;
	protected static int numberOfDeliveries;
	protected NoShipList noShipList;
	
	
	public WineClub() {
		this.selection = new MonthlySelection();
		this.selections = new ArrayList<MonthlySelection>();
		this.customers= new ArrayList<Customer>();
		this.administrators=new ArrayList<Administrator>();
		this.shipments= new ArrayList<Shipment>();
		this.receipts=new ArrayList<Receipt>();
		
	}
	
	public WineClub(MonthlySelection selection,ArrayList<MonthlySelection> selections,ArrayList<Shipment> shipments,ArrayList<Customer> customers,ArrayList<Administrator> administrators,ArrayList<Receipt> receipts ) {
		this.selection = selection;
		this.selections=selections;
		this.customers=customers;
		this.administrators=administrators;
		this.shipments=shipments;
		this.receipts=receipts;
	}

	public MonthlySelection getSelection() {
		return selection;
	}

	public void setSelection(MonthlySelection selection) {
		this.selection = selection;
	}

	public ArrayList<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(ArrayList<Receipt> receipts) {
		this.receipts = receipts;
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

	public ArrayList<MonthlySelection> getSelections() {
		return selections;
	}

	public void setSelections(ArrayList<MonthlySelection> selections) {
		this.selections = selections;
	}

	public MonthlySelection getSelectionById(int mid){
		ArrayList<MonthlySelection> selections = this.getSelections();
		int i=0;
		while(i<selections.size()){
			if(selections.get(i).getId()==mid){
			return selections.get(i);	
			}
			i++;
		}
		return null;
	}
	
	public ArrayList<Administrator> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(ArrayList<Administrator> administrators) {
		this.administrators = administrators;
	}

	public void updateShipment(Shipment newShipment){
		ArrayList<Shipment> shipments = this.getShipments();
		int newId = newShipment.getId();
		
		int i=0;
		while (i<shipments.size()){
			
			if(shipments.get(i).getId() == newId){
				shipments.set(i,newShipment);
			}
			i++;
		}
		this.setShipments(shipments);
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
		MonthlySelection selection = new MonthlySelection();
		selection = this.getSelection();
		selection.setWines(wines);
		this.setSelection(selection);

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
		this.setShipments(wineShipments);
	}
	
	
	
	
	public void updateWine(int newId) {
		Wine newWine = this.getSelection().getWineById(newId);
		ArrayList<Wine> wines = this.getSelection().getWines();
		int i = 0;
		while (i < wines.size()) {
			if (wines.get(i).getID() == newId) {
				wines.set(i, newWine);

			}
			i++;
		}
		MonthlySelection selection = new MonthlySelection();
		selection = this.getSelection();
		selection.setWines(wines);
		this.setSelection(selection);

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
		this.setShipments(wineShipments);
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
			if(newCustomer.getShipments()!=null){
		ArrayList<Shipment> shipments = newCustomer.getShipments();	
			int j=0;
			while(j<shipments.size()){
				shipments.get(j).setCustomerEmail(newCustomer.getEmail());
				j++;
			}
			this.setShipments(shipments);
		}
		else{
			System.out.println("Customer not found\n");
		}
		}
	}
	
	
	public void updateAdministrator(Administrator newAdministrator){
		ArrayList<Administrator> administrators = this.getAdministrators();
		if(administrators !=null){
			int newId = newAdministrator.getId();
			int i =0;
			while(i<administrators.size()){
				if(administrators.get(i).getId() == newId){
					administrators.set(i,newAdministrator);
				}
				i++;
			}
			this.setAdministrators(administrators);
		}
		else{
			System.out.println("Administrator not found\n");
		}
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
			return false;
		}
		
	}
	
	public boolean addAdmin(Administrator admin){
		
		if (checkId(this.administrators,admin)){
		this.administrators.add(admin);
		return true;
		}
		else{
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
	
	public boolean checkId(ArrayList<Administrator> administrators, Administrator newAdmin){
		int i=0;
		while(i<administrators.size()){
			if(newAdmin.getId() == administrators.get(i).getId()){
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

	
	
public Customer getCustomerById(int id){
	ArrayList<Customer> customers = this.customers;
	int i=0;
	while(i<customers.size()){
		if(customers.get(i).getId() == id )
		return customers.get(i);
		i++;
	}
	return null;
	
}

public Administrator getAdministratorById(int id){
	ArrayList<Administrator> admins = this.administrators;
	int i=0;
	while(i<admins.size()){
		if(admins.get(i).getId() == id )
		return admins.get(i);
		i++;
	}
	return null;
	
}

public Receipt getReceiptById(int id){
	ArrayList<Receipt> receipts = this.receipts;
	int i=0;
	while(i<receipts.size()){
		if(receipts.get(i).getId() == id){
			return receipts.get(i);
		}
		i++;
	}
	return null;
}

	public void addMonthlySelection(MonthlySelection selection){
		this.selections.add(selection);
	}
	
	public void addReceipt(Receipt receipt){
		this.receipts.add(receipt);
	}
}
