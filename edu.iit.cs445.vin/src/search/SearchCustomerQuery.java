package search;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entities.Customer;
import Entities.Shipment;
import Entities.Wine;

public class SearchCustomerQuery {
	private Customer customer;
	
	public SearchCustomerQuery(){
		
	}
	
	public SearchCustomerQuery(Customer customer){
		this.customer=customer;
	}
	
	public SearchCustomerQueryResponse searchQuery(String query){
		SimpleDateFormat dt = new SimpleDateFormat("MMM/yyyy"); 
		SearchCustomerQueryResponse result = new SearchCustomerQueryResponse();
		Customer customer = this.customer;
		ArrayList<Object> Wines = new ArrayList<Object>();
		ArrayList<Object> Shipments = new ArrayList<Object>();
		ArrayList<Object> Notes = new ArrayList<Object>();
		
		if(!query.equals("")){
		ArrayList<Shipment> shipments = customer.getShipments();

		int i=0;
		while(i<shipments.size()){
			ArrayList<Wine> wines = shipments.get(i).getMonthlySelection().getWines();
			int j=0;
			while(j<wines.size()){
				if(wines.get(j).getLabelName().matches(query) || wines.get(j).getMaker().matches(query) || wines.get(j).getGrape().matches(query) ||wines.get(j).getCountry().matches(query) || wines.get(j).getRegion().matches(query)){
					
					Wines.add("id: "+wines.get(j).getID());
					Wines.add("label_name: "+wines.get(j).getLabelName());
					
				}
				
				j++;
				int k=0;
				while(k<shipments.get(i).getNotes().size()){
			if(shipments.get(i).getNotes().get(k).getContent().matches(query) || shipments.get(i).getCustomerEmail().matches(query)){
				
				Shipments.add("id: "+shipments.get(i).getId());
				Shipments.add("selection_month: "+dt.format(shipments.get(i).getMonthlySelection().getDate()));
				Notes.add("id: "+shipments.get(i).getNotes().get(k).getId());
				Notes.add("content: "+shipments.get(i).getNotes().get(k).getContent());
			}
				k++;
			}
			}
			result.setWines(Wines);
			i++;
		}
		result.setShipments(Shipments);
		result.setNotes(Notes);
		}
		else{
			ArrayList<Shipment> shipments = customer.getShipments();
			int i=0;
			while(i<shipments.size()){
				ArrayList<Wine> wines = shipments.get(i).getMonthlySelection().getWines();
				int j=0;
				while(j<wines.size()){
					Wines.add("id: "+wines.get(j).getID());
					Wines.add("label_name: "+wines.get(j).getLabelName());
					
					j++;
				}
				
				result.setWines(Wines);
				Shipments.add("id: "+shipments.get(i).getId());
				Shipments.add("selection_month: "+dt.format(shipments.get(i).getMonthlySelection().getDate()));
				int k=0;
				while(k<shipments.get(i).getNotes().size()){
				Notes.add("id: "+shipments.get(i).getNotes().get(k).getId());
				Notes.add("content: "+shipments.get(i).getNotes().get(k).getContent());
				k++;
				}
				i++;
			}
			result.setShipments(Shipments);
			result.setNotes(Notes);
			
		}
		return result;
	}
	
}
