package add.classes;

import add.response.AddNoteResponse;
import entities.Customer;
import entities.Note;
import entities.Shipment;

public class AddNote {

	Customer customer;
	
	public AddNote(){
		
	}
	public AddNote(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int addNote(int sid,String content) throws java.lang.NullPointerException {
		
		if(this.getCustomer()!=null){
		Customer customer = this.getCustomer();
		if(customer.getShipmentById(sid)!=null){
		Shipment shipment = customer.getShipmentById(sid);
		Note note = new Note();
		note.setContent(content);
		shipment.addNote(note);
		return note.getId();
		}
		else{
			throw new java.lang.NullPointerException("Shipment not found");
		}
		}
		else{
			throw new java.lang.NullPointerException("Customer not found");
		}
	
		}
	
	public AddNoteResponse response(Shipment shipment,int nid) throws java.lang.NullPointerException {
		AddNoteResponse response = new AddNoteResponse();
		if(shipment!=null){
			if(shipment.getNoteById(nid)!=null){
			response.setId(shipment.getNoteById(nid).getId());
			return response;
			}
			else{
				throw new java.lang.NullPointerException("Note not found");
			}
		}
		else{
			throw new java.lang.NullPointerException("Shipment not found");
		}
		
	}
	
}
