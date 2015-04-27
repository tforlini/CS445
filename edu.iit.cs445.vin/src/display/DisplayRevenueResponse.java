package display;

public class DisplayRevenueResponse {
	double units_delivered;
	double units_returned;
	double wine_revenue;
	double delivery_revenue;
	
	public DisplayRevenueResponse(){
		
	}
	
	public DisplayRevenueResponse(double units_delivered,double units_returned,double wine_revenue,double delivery_revenue){
		this.units_delivered=units_delivered;
		this.units_returned=units_returned;
		this.wine_revenue=wine_revenue;
		this.delivery_revenue=delivery_revenue;
	}

	public double getUnits_delivered() {
		return units_delivered;
	}

	public void setUnits_delivered(double units_delivered) {
		this.units_delivered = units_delivered;
	}

	public double getUnits_returned() {
		return units_returned;
	}

	public void setUnits_returned(double units_returned) {
		this.units_returned = units_returned;
	}

	public double getWine_revenue() {
		return wine_revenue;
	}

	public void setWine_revenue(double wine_revenue) {
		this.wine_revenue = wine_revenue;
	}

	public double getDelivery_revenue() {
		return delivery_revenue;
	}

	public void setDelivery_revenue(double delivery_revenue) {
		this.delivery_revenue = delivery_revenue;
	}
	
	
}
