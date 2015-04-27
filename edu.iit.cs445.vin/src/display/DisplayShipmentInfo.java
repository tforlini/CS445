package display;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entities.Customer;
import Entities.Shipment;
import Entities.Wine;

public class DisplayShipmentInfo {
	Customer customer;
	
	public DisplayShipmentInfo(){
		this.customer=new Customer();
	}
	public DisplayShipmentInfo(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public DisplayShipmentInfoResponse displayInfo(int sid) throws java.lang.NullPointerException{
		SimpleDateFormat dt = new SimpleDateFormat("MMM/yyyy");
		SimpleDateFormat dt2 = new SimpleDateFormat("dd-MMM-yyyy");
		if(this.getCustomer()!=null){
		Customer customer = this.getCustomer();
		DisplayShipmentInfoResponse response = new DisplayShipmentInfoResponse();
		ArrayList<Object> Wines = new ArrayList<Object>();
		
		if(customer.getShipmentById(sid) != null){
		Shipment shipment = customer.getShipmentById(sid);
		response.setSelection_month(dt.format(shipment.getMonthlySelection().getDate().getTime()));
		response.setStatus(shipment.getState());
		response.setDate(dt2.format(shipment.getSubscriptionDate().getTime()));
		response.setType(shipment.getType());

		ArrayList<Wine> wines = shipment.getMonthlySelection().getWines();
		int i=0;
		while(i<wines.size()){
			Wines.add("id: "+wines.get(i).getID());
			Wines.add("label_name: "+wines.get(i).getLabelName());
			i++;
		}
		response.setWines(Wines);
		return response;
		}
		else{
			throw new java.lang.NullPointerException("Shipment not found");
		}
	}
		else{
			throw new java.lang.NullPointerException("Customer not found");
		}
	}
}
