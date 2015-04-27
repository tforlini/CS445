package display;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Entities.Customer;
import Entities.Note;
import Entities.Shipment;

public class DisplayShipmentNotes {
	Customer customer;
	
	public DisplayShipmentNotes(){
		this.customer=new Customer();
	}
	
	public DisplayShipmentNotes(Customer customer){
		this.customer=customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public DisplayShipmentNotesResponse displayNotes(int id) throws java.lang.NullPointerException{
		SimpleDateFormat dt = new SimpleDateFormat("dd-MMM-yyyy");
		DisplayShipmentNotesResponse response = new DisplayShipmentNotesResponse();
		ArrayList<Object> Notes = new ArrayList<Object>();
		
		if(this.getCustomer()!=null){
		Customer customer = this.getCustomer();
		if(customer.getShipmentById(id)!=null){
		Shipment shipment = customer.getShipmentById(id);
		ArrayList<Note> notes = shipment.getNotes();
		if(notes != null){
		int i=0;
		while(i<notes.size()){
			Notes.add("id: "+notes.get(i).getId());
			Notes.add("date: "+dt.format(notes.get(i).getDate().getTime()));
			Notes.add("content: "+notes.get(i).getContent());
			i++;
		}
		response.setNotes(Notes);
		return response; 
	}
		
		else{
			throw new java.lang.NullPointerException("No notes to display");
		}
		}
		else{
			throw new java.lang.NullPointerException("Shipment not found");
		}
		}
		else{
			throw new java.lang.NullPointerException("Customer not found");
		}
	}
	
	public DisplayShipmentNoteByIdResponse displayNotes(int id, int nid){
		SimpleDateFormat dt = new SimpleDateFormat("dd-MMM-yyyy");
		DisplayShipmentNoteByIdResponse response = new DisplayShipmentNoteByIdResponse();
		
		
		if(this.getCustomer()!=null){
		Customer customer = this.getCustomer();
		if(customer.getShipmentById(id)!=null){
		Shipment shipment = customer.getShipmentById(id);
		Note note = shipment.getNoteById(nid);
		if(note != null){
			response.setDate(dt.format(note.getDate().getTime()));
			response.setContent(note.getContent());
			return response; 
		}
		else{
			throw new java.lang.NullPointerException("No notes to display");
		}
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
