package delete;

import java.util.ArrayList;

import entities.Customer;
import entities.Note;
import entities.Shipment;

public class DeleteNote {

	Customer customer;
	
	public DeleteNote(){
		
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
	
	public Shipment delete(int sid, int nid) throws java.lang.NullPointerException {
		if(this.getCustomer()!=null){
		Customer customer = this.getCustomer();
		if (customer.getShipmentById(sid) != null) {
			Shipment shipment = customer.getShipmentById(sid);
				if (shipment.getNotes() != null) {
					ArrayList<Note> notes = shipment.getNotes();
					int i = 0;
					while (i < notes.size()) {
						if (notes.get(i).getId() == nid) {
							notes.remove(i);
						}
						i++;
					}
					shipment.setNotes(notes);
					return shipment;	
			} 
			else {
					throw new java.lang.NullPointerException("Notes not found");
			}
			} 
		else {
				throw new java.lang.NullPointerException("Shipment not found");
		}
		}
		else {
			throw new java.lang.NullPointerException("Customer not found");
		}

	}
	
}
