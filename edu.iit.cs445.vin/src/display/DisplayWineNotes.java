package display;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entities.Customer;
import Entities.Note;
import Entities.Shipment;
import Entities.Wine;

public class DisplayWineNotes {
	Customer customer;
	
	public DisplayWineNotes(){
		
	}
	
	public DisplayWineNotes(Customer customer){
		this.customer=customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public DisplayWineNotesResponse displayNotes(int wid) throws java.lang.NullPointerException{
		SimpleDateFormat dt = new SimpleDateFormat("dd-MMM-yyyy");
		DisplayWineNotesResponse response = new DisplayWineNotesResponse();
		ArrayList<Object> Notes = new ArrayList<Object>();
		if(this.getCustomer()!=null){
		Customer customer = this.getCustomer();
		if(customer.getShipments()!=null){
			ArrayList<Shipment> shipments = customer.getShipments();
			int i=0;
			while(i<shipments.size()){
				if(shipments.get(i).getMonthlySelection().getWineById(wid)!=null){
					Wine wine = shipments.get(i).getMonthlySelection().getWineById(wid);
						if(wine.getNotes()!=null){
							ArrayList<Note> notes = wine.getNotes();
							int k=0;
							while(k<notes.size()){
								Notes.add("id: "+notes.get(k).getId());
								Notes.add("content: "+notes.get(k).getContent());
								Notes.add("date: "+dt.format(notes.get(k).getDate().getTime()));
								k++;
							}
						}
						else{
							throw new java.lang.NullPointerException("Notes not found");
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
		}
		else{
			throw new java.lang.NullPointerException("Customer not found");
		}
		response.setNotes(Notes);
		return response;
	}
	
	public DisplayWineNotesResponse displayNoteById(int wid,int nid) throws java.lang.NullPointerException{
		SimpleDateFormat dt = new SimpleDateFormat("dd-MMM-yyyy");
		DisplayWineNotesResponse response = new DisplayWineNotesResponse();
		ArrayList<Object> Notes = new ArrayList<Object>();
		if(this.getCustomer()!=null){
		Customer customer = this.getCustomer();
		if(customer.getShipments()!=null){
			ArrayList<Shipment> shipments = customer.getShipments();
			int i=0;
			while(i<shipments.size()){
				if(shipments.get(i).getMonthlySelection().getWineById(wid)!=null){
					Wine wine = shipments.get(i).getMonthlySelection().getWineById(wid);
						if(wine.getNoteById(nid)!=null){
							Note note = wine.getNoteById(nid);
														
								Notes.add("id: "+note.getId());
								Notes.add("content: "+note.getContent());
								Notes.add("date: "+dt.format(note.getDate().getTime()));

						}
						else{
							throw new java.lang.NullPointerException("Notes not found");
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
		}
		else{
			throw new java.lang.NullPointerException("Customer not found");
		}
		response.setNotes(Notes);
		return response;
	}
}
