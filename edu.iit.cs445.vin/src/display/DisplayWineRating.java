package display;

import java.util.ArrayList;

import Entities.Customer;
import Entities.Shipment;
import Entities.Wine;
import Entities.WineClub;

public class DisplayWineRating {
	WineClub club;
	
	public DisplayWineRating(){
		
	}
	public DisplayWineRating(WineClub club){
		this.club=club;
		
	}
	public WineClub getClub() {
		return club;
	}
	public void setClub(WineClub club) {
		this.club = club;
	}
	public DisplayWineRatingResponse displayWineRating(int uid,int wid){
		DisplayWineRatingResponse response = new DisplayWineRatingResponse();
		ArrayList<Object> rating = new ArrayList<Object>();
		if(this.getClub().getCustomerById(uid)!=null){
		Customer customer = this.getClub().getCustomerById(uid);
		if(customer.getShipments()!=null){
			ArrayList<Shipment> shipments = customer.getShipments();
			int i=0;
			while(i<shipments.size()){
				if(shipments.get(i).getMonthlySelection().getWineById(wid)!=null){
					Wine wine = shipments.get(i).getMonthlySelection().getWineById(wid);
						rating.add("id: "+wine.getID());
						rating.add("label_name: "+wine.getLabelName());
						rating.add("rating: "+wine.getRating());
				}
				else{
					throw new java.lang.NullPointerException("Wines not found");
				}
				i++;
			}
			
		}
		else{
			throw new java.lang.NullPointerException("Shipments not found");
		}
		}
		response.setRating(rating);
		return response;
	}
}
