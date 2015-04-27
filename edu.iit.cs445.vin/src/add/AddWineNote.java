package add;

import java.util.ArrayList;
import Entities.Customer;
import Entities.Note;
import Entities.Shipment;
import Entities.Wine;

public class AddWineNote {
	
	Customer customer;

	public AddWineNote(){
		
	}
	public AddWineNote(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int addNote(int wid,String content) throws java.lang.NullPointerException{
		int newid=0;
		Wine wine = new Wine();
		if(this.getCustomer()!=null){
			Customer customer = this.getCustomer();
			if(customer.getShipments()!=null){
				ArrayList<Shipment> shipments = customer.getShipments();
				int i=0;
				while(i<shipments.size()){
					if(shipments.get(i).getMonthlySelection().getWineById(wid)!=null){
						wine = shipments.get(i).getMonthlySelection().getWineById(wid);
						Note newNote = new Note();
						newNote.setContent(content);
						wine.addNote(newNote);
						customer.updateShipment(shipments.get(i));
						newid = newNote.getId();
					}
					else{
						throw new java.lang.NullPointerException("Wine not found");
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
		return newid;
	}
	
	public AddWineNoteResponse getResponse(int wid,int nid) throws java.lang.NullPointerException{
		Wine wine = new Wine();
		AddWineNoteResponse response = new AddWineNoteResponse();  
		if(this.getCustomer()!=null){
			Customer customer = this.getCustomer();
			if(customer.getShipments()!=null){
				ArrayList<Shipment> shipments = customer.getShipments();
				int i=0;
				while(i<shipments.size()){
					if(shipments.get(i).getMonthlySelection().getWineById(wid)!=null){
						wine = shipments.get(i).getMonthlySelection().getWineById(wid);
						if(wine.getNoteById(nid)!=null){
							Note note = wine.getNoteById(nid); 
							response.setId(note.getId());
						}
						else{
							throw new java.lang.NullPointerException("Note not found");
						}
					}
					else{
						throw new java.lang.NullPointerException("Wine not found");
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
		return response;
	}
}
