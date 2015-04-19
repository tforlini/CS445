package UseCases;

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
	public void displayInfo(int id){
		Customer customer = this.getCustomer();
		Shipment shipment = customer.getShipmentById(id);
		if(shipment != null){
		System.out.println("Selection Month :"+shipment.getMonthlySelection().getDate());
		System.out.println("Status :"+shipment.getState());
		System.out.println("Type :"+shipment.getType());
		ArrayList<Wine> wines = shipment.getMonthlySelection().getWines();
		System.out.println("Wines : \n");
		int i=0;
		while(i<wines.size()){
			System.out.println("ID: "+wines.get(i).getID());
			System.out.println("Label Name: "+wines.get(i).getLabelName()+"\n");
			i++;
		}
	}
		else{
			System.out.println("Shipment not found");
		}
	}
}
