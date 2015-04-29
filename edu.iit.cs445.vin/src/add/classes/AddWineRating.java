package add.classes;

import java.util.ArrayList;

import entities.Customer;
import entities.MonthlySelection;
import entities.Shipment;
import entities.Wine;
import entities.WineClub;

public class AddWineRating {
		WineClub club;
		
		public AddWineRating(){
			
		}
		public AddWineRating(WineClub club){
		this.club=club;	
		}
		public WineClub getClub() {
			return club;
		}
		public void setClub(WineClub club) {
			this.club = club;
		}
		
		public void addWineRating(int uid,int wid,int rating) throws java.lang.NullPointerException{
			WineClub club = this.getClub();
			
			/// MODIFY CUSTOMER WINES ///
			if( club.getCustomerById(uid) != null){
				Customer customer = club.getCustomerById(uid);
				if(customer.getShipments()!=null){
					ArrayList<Shipment> shipments = customer.getShipments();
					int i=0;
					while(i<shipments.size()){
						if(shipments.get(i).getMonthlySelection().getWineById(wid)!=null){
							Wine wine = shipments.get(i).getMonthlySelection().getWineById(wid);
							wine.addRating(rating);
							shipments.get(i).updateWine(wine);
							customer.updateShipment(shipments.get(i));
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
			
			
			/// MODIFY CLUB WINES ///
			ArrayList<MonthlySelection> selections = club.getSelections();
			
			int i=0;
			while(i<selections.size()){
				Wine wine = selections.get(i).getWineById(wid);	
				wine.addRating(rating);
				selections.get(i).updateWine(wine);
				i++;
			}
			
			/// MODIFY CURRENT SELECTION ///
			MonthlySelection selection = club.getSelection();
			Wine wine = selection.getWineById(wid);
			wine.addRating(rating);
			selection.updateWine(wine);
			
		}
		
}
