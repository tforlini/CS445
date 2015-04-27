package update;

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
	public Shipment updateShipment(int id,String day,String time,int number) throws java.lang.NullPointerException{
		if(this.getCustomer()!=null){
		Customer customer = this.getCustomer();
		if(customer.getShipmentById(id) != null){
		Shipment shipment = customer.getShipmentById(id);
		
		shipment.setForecastedDeliveryDate(day);
		shipment.setForecastedDeliveryTime(time);
		shipment.setNumberOfMonthlySelections(number);
		return shipment;
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
