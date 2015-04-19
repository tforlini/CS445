package UseCases;

import java.util.ArrayList;

import Entities.Customer;
import Entities.Shipment;

public class DisplayShipments {
	private Customer customer;
	
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

	public void displayShipments(){
		System.out.println("Shipments: \n");
		ArrayList<Shipment> shipments = this.getCustomer().getShipments();
		if(shipments != null){
		int  i=0;
		while(i<shipments.size()){
			System.out.println("ID: "+shipments.get(i).getId());
			System.out.println("Selection date: "+shipments.get(i).getMonthlySelection().getDate());
			System.out.println("Status: "+shipments.get(i).getState()+"\n");
			i++;
		}
		}
		else {
			System.out.println("No shipments fo this user \n");
		}
		}	
}
