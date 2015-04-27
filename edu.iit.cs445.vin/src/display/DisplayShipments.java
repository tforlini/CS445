package display;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entities.Customer;
import Entities.Shipment;
public class DisplayShipments {
Customer customer;

public DisplayShipments(){
	this.customer=new Customer();
}

public DisplayShipments(Customer customer){
	this.customer=customer;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public DisplayShipmentsResponse displayShipments() throws java.lang.NullPointerException{
	SimpleDateFormat dt = new SimpleDateFormat("MMM/yyyy"); 
	DisplayShipmentsResponse result = new DisplayShipmentsResponse();
	ArrayList<Object> Shipments = new ArrayList<Object>();
	
	if(this.getCustomer().getShipments() != null){
		ArrayList<Shipment> shipments = this.getCustomer().getShipments();
	int  i=0;
	while(i<shipments.size()){
		Shipments.add("id: "+shipments.get(i).getId());
		Shipments.add("selection_date: "+dt.format(shipments.get(i).getMonthlySelection().getDate().getTime()));
		Shipments.add("status: "+shipments.get(i).getState());
		i++;
	}
	result.setShipments(Shipments);
	return result;
	}
	else {
		throw new java.lang.NullPointerException("Shipments not found");
	}
}
}
