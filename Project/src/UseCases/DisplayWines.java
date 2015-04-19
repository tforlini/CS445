package UseCases;

import java.util.ArrayList;

import Entities.Customer;
import Entities.Shipment;
import Entities.Wine;

public class DisplayWines {
	private Customer customer;
	
	public DisplayWines(){
		this.customer=new Customer();
	}
	public DisplayWines(Customer customer){
		this.customer=customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void displayWines(){
		Customer customer = this.getCustomer();
		ArrayList<Shipment> shipments = customer.getShipments();
		if(shipments != null){
			int i=0;
			System.out.println("Wines: \n");
			while(i<shipments.size()){
				ArrayList<Wine> wines = shipments.get(i).getMonthlySelection().getWines();
				if(wines != null){
					int j=0;
					System.out.println("Shipment n°: "+shipments.get(i).getId());
					while(j<wines.size()){
						System.out.println("ID: "+wines.get(j).getID());
						System.out.println("Label Name: "+wines.get(j).getLabelName()+" \n");
						j++;
					}
				}
				else{
					System.out.println("Wines not found \n");
				}
				i++;
			}
		}
		else{
			System.out.println("Shipments not found \n");
		}
	}
	
	public void displayWines(int wid){
		Customer customer = this.getCustomer();
		ArrayList<Shipment> shipments = customer.getShipments();
		if(shipments != null){
			int i=0;
			//System.out.println("Wines: \n");
			while(i<shipments.size()){
				Wine wine = shipments.get(i).getMonthlySelection().getWineById(wid);
				if(wine != null){
					System.out.println("Shipment n°: "+shipments.get(i).getId());
					System.out.println("ID: "+wine.getID());
					System.out.println("Label Name: "+wine.getLabelName());
					System.out.println("Wine Type: "+wine.getWineType());
					System.out.println("Wine Variety: "+wine.getWineVariety());
					System.out.println("Grape: "+wine.getGrape());
					System.out.println("Region: "+wine.getRegion());
					System.out.println("Country: "+wine.getCountry());
					System.out.println("Maker: "+wine.getMaker());
					System.out.println("Year: "+wine.getYear());
					System.out.println("Rating: "+wine.getRating()+" \n");
				}
				else{
					System.out.println("Wine not found \n");
				}
				i++;
			}
		}
		else{
			System.out.println("Shipments not found \n");
		}
	}
}
