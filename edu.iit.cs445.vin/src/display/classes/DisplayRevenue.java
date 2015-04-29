package display.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import display.response.DisplayRevenueResponse;
import entities.Shipment;
import entities.ShipmentState;
import entities.WineClub;

public class DisplayRevenue {
	WineClub club;
	
	public DisplayRevenue(){
		
	}
	public DisplayRevenue(WineClub club){
		this.club=club;
	}
	
	public WineClub getClub() {
		return club;
	}
	public void setClub(WineClub club) {
		this.club = club;
	}
	public DisplayRevenueResponse getRevenue(String start,String end) throws java.lang.NullPointerException, ParseException{
		DisplayRevenueResponse response = new DisplayRevenueResponse();
		SimpleDateFormat dt = new SimpleDateFormat("YYYYMMDD");
		Date startDate = null;
		Date endDate = null;
		if(!start.equals("")){
		startDate = dt.parse(start);
		}
		if(!end.equals("")){
		endDate = dt.parse(end);
		}
	
		double wineRevenue = 0;
		int numberOfSelections = 0;
		double price=0;
		double unitsDelivered=0;
		double unitsReturned=0;
		double deliveryRevenue=0;
		
		WineClub club = this.getClub();
		if(club.getShipments()!=null){
			ArrayList<Shipment> shipments = club.getShipments(); 
			int i=0;
			while(i<shipments.size()){
				price=0;
				numberOfSelections=0;
				if(shipments.get(i).getSubscriptionDate().before(endDate) && shipments.get(i).getSubscriptionDate().after(startDate) && startDate!=null && endDate!=null){
					if(shipments.get(i).getState().equals(ShipmentState.DELIVERED)){

						numberOfSelections = shipments.get(i).getNumberOfMonthlySelections();
						price = shipments.get(i).getPrice();
						if(numberOfSelections!=0){
						deliveryRevenue+=shipments.get(i).getDeliveryCharge();
						unitsDelivered++;
						}
						wineRevenue += price*numberOfSelections;
						
					}
					else if(shipments.get(i).getState().equals(ShipmentState.RETURNED)){
						
						numberOfSelections = shipments.get(i).getNumberOfMonthlySelections();
						price = shipments.get(i).getPrice();
						if(numberOfSelections!=0){
						deliveryRevenue+=shipments.get(i).getDeliveryCharge();
						unitsReturned++;
						}
						wineRevenue -= price*numberOfSelections;
				}
					else{
						continue;
					}
				}
				else if(startDate==null && endDate!=null && shipments.get(i).getSubscriptionDate().before(endDate)){
					if(shipments.get(i).getState().equals(ShipmentState.DELIVERED)){

						numberOfSelections = shipments.get(i).getNumberOfMonthlySelections();
						price = shipments.get(i).getPrice();
						if(numberOfSelections!=0){
						deliveryRevenue+=shipments.get(i).getDeliveryCharge();
						unitsDelivered++;
						}
						wineRevenue += price*numberOfSelections;
						
					}
					else if(shipments.get(i).getState().equals(ShipmentState.RETURNED)){
						
						numberOfSelections = shipments.get(i).getNumberOfMonthlySelections();
						price = shipments.get(i).getPrice();
						if(numberOfSelections!=0){
						deliveryRevenue+=shipments.get(i).getDeliveryCharge();
						unitsReturned++;
						}
						wineRevenue -= price*numberOfSelections;
				}
					else{
						continue;
					}
				}
				else if(endDate==null && startDate!=null && shipments.get(i).getSubscriptionDate().after(startDate)){
					if(shipments.get(i).getState().equals(ShipmentState.DELIVERED)){

						numberOfSelections = shipments.get(i).getNumberOfMonthlySelections();
						price = shipments.get(i).getPrice();
						if(numberOfSelections!=0){
						deliveryRevenue+=shipments.get(i).getDeliveryCharge();
						unitsDelivered++;
						}
						wineRevenue += price*numberOfSelections;
						
					}
					else if(shipments.get(i).getState().equals(ShipmentState.RETURNED)){
						
						numberOfSelections = shipments.get(i).getNumberOfMonthlySelections();
						price = shipments.get(i).getPrice();
						if(numberOfSelections!=0){
						deliveryRevenue+=shipments.get(i).getDeliveryCharge();
						unitsReturned++;
						}
						wineRevenue -= price*numberOfSelections;
				}
					else{
						continue;
					}
				}
				else{
					if(shipments.get(i).getState().equals(ShipmentState.DELIVERED)){

						numberOfSelections = shipments.get(i).getNumberOfMonthlySelections();
						price = shipments.get(i).getPrice();
						if(numberOfSelections!=0){
						deliveryRevenue+=shipments.get(i).getDeliveryCharge();
						unitsDelivered++;
						}
						wineRevenue += price*numberOfSelections;
						
					}
					else if(shipments.get(i).getState().equals(ShipmentState.RETURNED)){
						
						numberOfSelections = shipments.get(i).getNumberOfMonthlySelections();
						price = shipments.get(i).getPrice();
						if(numberOfSelections!=0){
						deliveryRevenue+=shipments.get(i).getDeliveryCharge();
						unitsReturned++;
						}
						wineRevenue -= price*numberOfSelections;
				}
					else continue;
				}
				i++;
			}
			
			response.setDelivery_revenue(deliveryRevenue);
			response.setUnits_delivered(unitsDelivered);
			response.setUnits_returned(unitsReturned);
			response.setWine_revenue(wineRevenue);
			
		}
		else{
			throw new java.lang.NullPointerException("Shipments not found");
		}
		return response;
	}
}
