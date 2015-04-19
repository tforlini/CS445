package UseCases;

import java.util.Scanner;

import Entities.Customer;
import Entities.Note;
import Entities.Shipment;

public class UpdateNote {
	private Customer customer;
	
	public UpdateNote(){
		this.customer = new Customer();
	}
	public UpdateNote(Customer customer){
		this.customer=customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Shipment update(int id, int nid){
		Customer customer = this.getCustomer();
		Shipment shipment = customer.getShipmentById(id);
		if(shipment != null){
		Note note = shipment.getNoteById(nid);
		if(note != null){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What is the new content for your note ?\n");
		String content = input.nextLine();
		note.setContent(content);
		shipment.updateNote(note);
		System.out.println("Note updated successfully \n");
		return shipment;
		}
		else{
			System.out.println("Note not found \n");
		}
		}
		else{
			System.out.println("Shipment not found \n");
		}
		return null;
	}
}
