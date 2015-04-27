package search;

import java.util.ArrayList;

public class SearchCustomerQueryResponse {
	
	ArrayList<Object> wines;
	ArrayList<Object> notes;
	ArrayList<Object> shipments;
	
	public SearchCustomerQueryResponse(){
		this.wines=new ArrayList<Object>();
		this.notes=new ArrayList<Object>();
		this.shipments=new ArrayList<Object>();
	}

	public SearchCustomerQueryResponse(ArrayList<Object> wines, ArrayList<Object> notes,ArrayList<Object> shipments){
		this.wines=wines;
		this.notes=notes;
		this.shipments=shipments;
	}

	public ArrayList<Object> getWines() {
		return wines;
	}

	public void setWines(ArrayList<Object> wines) {
		this.wines = wines;
	}

	public ArrayList<Object> getNotes() {
		return notes;
	}

	public void setNotes(ArrayList<Object> notes) {
		this.notes = notes;
	}

	public ArrayList<Object> getShipments() {
		return shipments;
	}

	public void setShipments(ArrayList<Object> shipments) {
		this.shipments = shipments;
	}
	
	
}
