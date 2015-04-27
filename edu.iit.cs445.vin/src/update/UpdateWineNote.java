package update;

import java.util.ArrayList;

import Entities.Customer;
import Entities.Note;
import Entities.Shipment;
import Entities.Wine;

public class UpdateWineNote {
	Customer customer;
	
	
	public UpdateWineNote(){
		
	}
	public UpdateWineNote(Customer customer){
		this.customer=customer;
		
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void updateWineNote(String content,int wid,int nid) throws java.lang.NullPointerException{
		
		ArrayList<Shipment> shipments = new ArrayList<Shipment>();
		if(this.getCustomer()!=null){
			Customer customer = this.getCustomer();
			if(customer.getShipments()!=null){
				shipments = customer.getShipments();
				int i=0;
				while(i<shipments.size()){
					if(shipments.get(i).getMonthlySelection().getWineById(wid)!=null){
						Wine wine = shipments.get(i).getMonthlySelection().getWineById(wid);
						if(wine.getNoteById(nid)!=null){
							Note note = wine.getNoteById(nid); 
							note.setContent(content);
							shipments.get(i).getMonthlySelection().getWineById(wid).updateNote(note);

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
				throw new java.lang.NullPointerException("Shipment not found");
			}
		}
		else{
			throw new java.lang.NullPointerException("Customer not found");
		}
		this.customer.setShipments(shipments);
	}
}
