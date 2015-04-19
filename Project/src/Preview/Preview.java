package Preview;

import java.util.ArrayList;
import java.util.Scanner;

import Entities.Customer;
import Entities.MonthlySelection;
import Entities.Shipment;
import Entities.Wine;
import WineClub.WineClub;

public class Preview implements Display{

	WineClub wineClub;
	
	public Preview() {
		this.wineClub = new WineClub();
	}
	
	public Preview(WineClub wineClub) {
		this.wineClub = wineClub;
	}

	@Override
	public void selection() {
		
		MonthlySelection selection = this.wineClub.getSelection();
		int i = 0;
		while (i < selection.getWines().size()) {
			System.out.println("****************************************");
			System.out.println("Wine n°" + selection.getWines().get(i).getID());
			System.out.println("Name:" + selection.getWines().get(i).getPrice()+ "$");
			System.out.println("Variety:" + selection.getWines().get(i).getWineVariety());
			System.out.println("Type:" + selection.getWines().get(i).getWineType());
			System.out.println("Label Name:" + selection.getWines().get(i).getLabelName());
			System.out.println("Grape:" + selection.getWines().get(i).getGrape());
			System.out.println("Region:" + selection.getWines().get(i).getRegion());
			System.out.println("Country:" + selection.getWines().get(i).getCountry());
			System.out.println("Maker:" + selection.getWines().get(i).getMaker());
			System.out.println("Year:" + selection.getWines().get(i).getYear());
			System.out.println("Rating:" + selection.getWines().get(i).getRating()+ "/10");
			System.out.println("****************************************");
			System.out.println("\n");
			i++;
		}
		
	}

	@Override
	public void wine() {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What Wine do you want information about ?");
		ArrayList<Wine> wines = this.wineClub.getSelection().getWines();
		String id = input.nextLine();
		int number = Integer.parseInt(id);
		
		int i=0;
		
		while(i<wines.size()){
		
		if(wines.get(i).getID() == number){
		System.out.println("****************************************");
		System.out.println("Wine n°" + wines.get(i).getID());
		System.out.println("Price:" + wines.get(i).getPrice()+ "$");
		System.out.println("Variety:" + wines.get(i).getWineVariety());
		System.out.println("Type:" + wines.get(i).getWineType());
		System.out.println("Label Name:" + wines.get(i).getLabelName());
		System.out.println("Grape:" + wines.get(i).getGrape());
		System.out.println("Region:" + wines.get(i).getRegion());
		System.out.println("Country:" + wines.get(i).getCountry());
		System.out.println("Maker:" + wines.get(i).getMaker());
		System.out.println("Year:" + wines.get(i).getYear());
		System.out.println("Rating:" + wines.get(i).getRating()+ "/10");
		System.out.println("****************************************");
		System.out.println("\n");
		}
		i++;
		}
	}

	@Override
	public void shipments(Customer customer) {

		ArrayList<Shipment> shipments = this.wineClub.getShipments();
		 int i=0;
		 while(i<shipments.size()){
			 System.out.println("****************************************");
			 System.out.println("Shipment:" + shipments.get(i).getId());
			 System.out.println("Price:" + shipments.get(i).getPrice());
			 System.out.println("Ammount:" + shipments.get(i).getNumberOfMonthlySelections());
			 System.out.println("Type:" + shipments.get(i).getType());
			 System.out.println("Average Rating:" + shipments.get(i).getAverageRating());
			 System.out.println("Comment:" + shipments.get(i).getNotes());
			 System.out.println("Delivery Date:" + shipments.get(i).getForecastedDeliveryDate());
			 System.out.println("Delivery Time:" + shipments.get(i).getForecastedDeliveryTime());
			 System.out.println("Delivery Charge:" + shipments.get(i).getDeliveryCharge());
			 System.out.println("****************************************");
			 System.out.println("\n");
			 i++;
		 }
		
	}

}
