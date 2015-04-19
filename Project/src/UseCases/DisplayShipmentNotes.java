package UseCases;

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
	public void displayNotes(int id){
		Customer customer = this.getCustomer();
		Shipment shipment = customer.getShipmentById(id);
		ArrayList<Note> notes = shipment.getNotes();
		if(notes != null){
			System.out.println("Notes: \n");
		int i=0;
		while(i<notes.size()){
			System.out.println("ID: "+notes.get(i).getId());
			System.out.println("Date: "+notes.get(i).getDate());
			System.out.println("Content: "+notes.get(i).getContent()+" \n");
			i++;
		}
	}
		else{
			System.out.println("No notes to display \n");
		}
	}
	
	public void displayNotes(int id, int nid){
		Customer customer = this.getCustomer();
		Shipment shipment = customer.getShipmentById(id);
		Note note = shipment.getNoteById(nid);
		if(note != null){
			System.out.println("Note: \n");
			System.out.println("ID: "+note.getId());
			System.out.println("Date: "+note.getDate());
			System.out.println("Content: "+note.getContent()+" \n");
			
		}
		else{
			System.out.println("No notes to display \n");
		}
	}
	
}
