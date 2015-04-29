package update.classes;

import entities.Customer;
import entities.Note;
import entities.Shipment;

public class UpdateShipmentNote {

	Customer customer;
	
	public UpdateShipmentNote(){
		
	}
	public UpdateShipmentNote(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public Shipment update(String content,int sid,int nid) throws java.lang.NullPointerException{
		if(this.getCustomer()!=null){
		Customer customer = this.getCustomer();
		if(customer.getShipmentById(sid) != null){
		Shipment shipment = customer.getShipmentById(sid);
		if(shipment.getNoteById(nid) != null){
		Note note = shipment.getNoteById(nid);
		note.setContent(content);
		shipment.updateNote(note);
		return shipment;
		}
		else{
			throw new java.lang.NullPointerException("Note not found \n");
		}
		}
		else{
			throw new java.lang.NullPointerException("Shipment not found \n");
		}
		}
		else{
			throw new java.lang.NullPointerException("Customer not found \n");
		}
	}
}
