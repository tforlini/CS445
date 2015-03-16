package WineClub;

import java.util.ArrayList;
import java.util.Date;

public class Shipment {

	protected int price;
	protected static int numberOfMonthlySelections;
	protected ArrayList<MonthlySelection> monthlySelection;
	protected String type;
	protected Date subscriptionDate;
	protected Customer customer;
	protected static int averageRating;
	protected String note;
	protected Date forecastedDeliveryDate;
	protected String forecastedDeliveryTime;
	protected int deliveryCharge;
	
	
	
	
	public Shipment() {
		this.price=0;
		this.monthlySelection= new ArrayList<MonthlySelection>();
		this.type="";
		this.subscriptionDate=new Date();
		this.customer=null;
		this.note="";
		this.forecastedDeliveryDate=null;
		this.forecastedDeliveryTime="";
		this.deliveryCharge=0;
		
	}
	
	public Shipment(int price,int numberOfMonthlySelections, ArrayList<MonthlySelection> monthlySelection,String type,Date subscriptionDate,Customer customer,String note,Date forecastedDeliveryDate,String forecastedDeliveryTime, int deliveryCharge) {
		this.price=price;
		this.monthlySelection=monthlySelection;
		this.type=type;
		this.subscriptionDate=subscriptionDate;
		this.customer=null;
		this.note="";
		this.forecastedDeliveryDate=null;
		this.forecastedDeliveryTime="";
		this.deliveryCharge=0;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberOfMonthlySelections() {
		return numberOfMonthlySelections;
	}

	public ArrayList<MonthlySelection> getMonthlySelection() {
		return monthlySelection;
	}

	public void setMonthlySelection(ArrayList<MonthlySelection> monthlySelection) {
		this.monthlySelection = monthlySelection;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static int getAveragRating() {
		return averageRating;
	}

	public static void setAverageRating(int averageRating) {
		Shipment.averageRating = averageRating;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getForecastedDeliveryDate() {
		return forecastedDeliveryDate;
	}

	public void setForecastedDeliveryDate(Date forecastedDeliveryDate) {
		this.forecastedDeliveryDate = forecastedDeliveryDate;
	}

	public String getForecastedDeliveryTime() {
		return forecastedDeliveryTime;
	}

	public void setForecastedDeliveryTime(String forecastedDeliveryTime) {
		this.forecastedDeliveryTime = forecastedDeliveryTime;
	}

	public int getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

	public void addSelection(MonthlySelection selection){
		this.monthlySelection.add(selection);
		
	}
	
}
