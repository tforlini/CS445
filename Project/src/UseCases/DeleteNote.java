package UseCases;

import java.util.ArrayList;

import Entities.Customer;
import Entities.Note;
import Entities.Shipment;

public class DeleteNote {
	private Customer customer;
	
	public DeleteNote(){
		this.customer=new Customer();
	}
	
	public DeleteNote(Customer customer){
		this.customer=customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shipment delete(int id, int nid) {
		Customer customer = this.getCustomer();
		Shipment shipment = customer.getShipmentById(id);
		if (shipment != null) {
			Note note = shipment.getNoteById(nid);
			if (note != null) {
				ArrayList<Note> notes = shipment.getNotes();
				if(notes != null){

				int i = 0;
				while (i < notes.size()) {
					if (notes.get(i).getId() == nid) {
						notes.remove(i);
					}
					i++;
				}
				shipment.setNotes(notes);
				System.out.println("Note deleted successfully \n");
				return shipment;
			} 
			else{
				System.out.println("Notes not found \n");
			}
			}
				else {
				System.out.println("Note not found \n");
			}
		} 
		else {
			System.out.println("Shipment not found \n");
		}
		return null;
	}
}
