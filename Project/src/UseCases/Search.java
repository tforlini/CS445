package UseCases;

import java.util.ArrayList;

import Entities.Customer;
import Entities.Shipment;
import Entities.Wine;

public class Search {
	private Customer customer;
	
	public Search(){
		this.customer=new Customer();
	}
	
	public Search(Customer customer){
		this.customer=customer;
	}
	
	public ArrayList<Object> searchQuery(String query){
		
		ArrayList<Object> result = new ArrayList<Object>();
		Customer customer = this.getCustomer();
		if(!query.isEmpty()){
		ArrayList<Shipment> shipments = customer.getShipments();
		if(shipments != null){
		int i=0;
		while(i<shipments.size()){
			ArrayList<Wine> wines = shipments.get(i).getMonthlySelection().getWines();
			int j=0;
			while(j<wines.size()){
				if(wines.get(j).isMatch(query)){
					result.add(wines.get(j).getID());
				}
				j++;
			if(shipments.get(i).isMatch(query)){
				result.add(shipments.get(i).getId());
			}
			}
			i++;
		}
		}
		}
		else{
			ArrayList<Shipment> shipments = customer.getShipments();
			int i=0;
			while(i<shipments.size()){
				ArrayList<Wine> wines = shipments.get(i).getMonthlySelection().getWines();
				int j=0;
				while(j<wines.size()){
					result.add(wines.get(j).getID());
					j++;
				}
				result.add(shipments.get(i).getId());
				i++;
			}
			
		}
		return result;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
