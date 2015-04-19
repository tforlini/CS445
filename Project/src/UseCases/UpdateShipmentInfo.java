package UseCases;

import java.util.Scanner;

import Entities.Customer;
import Entities.Shipment;

public class UpdateShipmentInfo {
	Customer customer;
	
	public UpdateShipmentInfo(){
		this.customer=new Customer();
	}
	public UpdateShipmentInfo(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Shipment updateShipment(int id){
		Customer customer = this.getCustomer();
		Shipment shipment = customer.getShipmentById(id);
		if(shipment != null){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What day do you want to be served ?\n");
		String day = input.nextLine();
		shipment.setForecastedDeliveryDate(day);
		System.out.println("What time of the day do you want to be served ?\n");
		String time = input.nextLine();
		shipment.setForecastedDeliveryTime(time);
		System.out.println("Shipment successfully updated \n");
		return shipment;
		}
		else{
			System.out.println("Shipment not found \n");
		}
		return null;
	}
}
