package display.classes;

import java.util.ArrayList;

import display.response.DisplayWinesResponse;
import entities.Customer;
import entities.Shipment;
import entities.ShipmentState;
import entities.Wine;

public class DisplayWines {
	private Customer customer;
	
	public DisplayWines(){
		this.customer=new Customer();
	}
	public DisplayWines(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public DisplayWinesResponse displayWines() throws java.lang.NullPointerException{
		DisplayWinesResponse response = new DisplayWinesResponse();
		ArrayList<Object> Wines = new ArrayList<Object>();
		if(this.getCustomer()!=null){
		Customer customer = this.getCustomer();
		ArrayList<Shipment> shipments = customer.getShipments();
		if(shipments != null){
			int i=0;
			
			while(i<shipments.size()){
				
				ArrayList<Wine> wines = shipments.get(i).getMonthlySelection().getWines();
				if(wines != null){
					int j=0;
					if(shipments.get(i).getState().equals(ShipmentState.DELIVERED)){
					while(j<wines.size()){
						Wines.add("id: "+wines.get(j).getID());
						Wines.add("label_name: "+wines.get(j).getLabelName());
						j++;
					}
				}
				}
				else{
					throw new java.lang.NullPointerException("Wines not found");
				}
				i++;
				
			}
		}
		else{
			throw new java.lang.NullPointerException("Shipments not found");
		}	
			response.setWines(Wines);
			return response;
		}
		else{
			throw new java.lang.NullPointerException("Customer not found");
		}	
		
	}
	
	public DisplayWinesResponse displayWineById(int wid){
		DisplayWinesResponse response = new DisplayWinesResponse();
		ArrayList<Object> Wines = new ArrayList<Object>();
		if(this.getCustomer()!=null){
		Customer customer = this.getCustomer();
		ArrayList<Shipment> shipments = customer.getShipments();
		if(shipments != null){ 
			int i=0;
			while(i<shipments.size()){
				
				if(shipments.get(i).getMonthlySelection().getWineById(wid) != null){
					Wine wine = shipments.get(i).getMonthlySelection().getWineById(wid);
					
					if(shipments.get(i).getState().equals(ShipmentState.DELIVERED)){

						Wines.add("id: "+wine.getID());
						Wines.add("label_name: "+wine.getLabelName());
						Wines.add("country: "+wine.getCountry());
						Wines.add("grape: "+wine.getGrape());
						Wines.add("maker: "+wine.getMaker());
						Wines.add("region: "+wine.getRegion());
						Wines.add("year: "+wine.getYear());
				}
				}
				else{
					throw new java.lang.NullPointerException("Wine not found");
				}
				i++;
				
			}
		}
		else{
			throw new java.lang.NullPointerException("Shipments not found");
		}	
			response.setWines(Wines);
			return response;
		}
		else{
			throw new java.lang.NullPointerException("Customer not found");
		}
	}
}
