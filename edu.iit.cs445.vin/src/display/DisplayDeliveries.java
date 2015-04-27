package display;

import java.util.ArrayList;

import Entities.Customer;
import Entities.Shipment;
import Entities.ShipmentState;
import Entities.WineClub;

public class DisplayDeliveries {
	private WineClub club;

	public DisplayDeliveries(){
		
	}
	
	public DisplayDeliveries(WineClub club) {
		this.club = club;
	}

	public WineClub getClub() {
		return club;
	}

	public void setClub(WineClub club) {
		this.club = club;
	}
	
	public DisplayDeliveriesResponse displayDeliveries() throws java.lang.NullPointerException{
		DisplayDeliveriesResponse response = new DisplayDeliveriesResponse();
		boolean addCustomer = false;
		ArrayList<Object> Customers = new ArrayList<Object>();
		
		WineClub club = this.getClub();
		if(club.getCustomers()!=null){
			ArrayList<Customer> customers = club.getCustomers(); 
			int i=0;
			while(i<customers.size()){
				addCustomer=false;
				if(customers.get(i).getShipments()!=null){
					ArrayList<Shipment> shipments = customers.get(i).getShipments();
					int j=0;
					while(j<shipments.size()){
						if(shipments.get(j).getState().equals(ShipmentState.ACTIVE)){
							addCustomer=true;
							if(addCustomer==true){
								break;
							}
						}
						j++;
					}
					if(addCustomer==true){
						Customers.add("name: "+customers.get(i).getName());
						Customers.add("phone: "+customers.get(i).getPhone());
						Customers.add("email: "+customers.get(i).getEmail());
						Customers.add("address: {");
						Customers.add("street: "+customers.get(i).getAddress().getStreet());
						Customers.add("city: "+customers.get(i).getAddress().getCity());
						Customers.add("state: "+customers.get(i).getAddress().getState());
						Customers.add("zip: "+customers.get(i).getAddress().getZip()+"}");
						Customers.add("dow: "+customers.get(i).getDeliveryDay());
						Customers.add("tod: "+customers.get(i).getDeliveryTime());
					}
				}
				else{
					throw new java.lang.NullPointerException("Shipments not found");
				}
				i++;
			}
		}
		else{
			throw new java.lang.NullPointerException("Customers not found");
		}
		response.setDeliver_to(Customers);
		return response;
		
	}
}
