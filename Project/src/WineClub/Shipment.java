package WineClub;

import java.util.Date;

public class Shipment {

	protected int id;
	protected int price;
	protected int numberOfMonthlySelections;
	protected MonthlySelection monthlySelection;
	protected String type;
	protected Date subscriptionDate;
	protected Customer customer;
	protected double averageRating;
	protected String note;
	protected Date forecastedDeliveryDate;
	protected String forecastedDeliveryTime;
	protected int deliveryCharge;
	protected static int shipmentsNumber;
	
	
	
	
	public Shipment() {
		
		this.price=50;
		this.numberOfMonthlySelections=0;
		this.monthlySelection= new MonthlySelection();
		this.type="";
		this.subscriptionDate=new Date();
		this.customer=null;
		this.note="";
		this.forecastedDeliveryDate=null;
		this.forecastedDeliveryTime="";
		this.deliveryCharge=5;
		shipmentsNumber++;
		this.id=shipmentsNumber;
	}
	
	public Shipment(int id,int price,int numberOfMonthlySelections, MonthlySelection monthlySelection,String type,Date subscriptionDate,Customer customer,String note,Date forecastedDeliveryDate,String forecastedDeliveryTime, int deliveryCharge) {
		this.id=id;
		this.price=price;
		this.numberOfMonthlySelections=numberOfMonthlySelections;
		this.monthlySelection=monthlySelection;
		this.type=type;
		this.subscriptionDate=subscriptionDate;
		this.customer=null;
		this.note="";
		this.forecastedDeliveryDate=null;
		this.forecastedDeliveryTime="";
		this.deliveryCharge=0;
		shipmentsNumber++;
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

	public MonthlySelection getMonthlySelection() {
		return monthlySelection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public static int getShipmentsNumber() {
		return shipmentsNumber;
	}

	public static void setShipmentsNumber(int shipmentsNumber) {
		Shipment.shipmentsNumber = shipmentsNumber;
	}

	public void setNumberOfMonthlySelections(int numberOfMonthlySelections) {
		this.numberOfMonthlySelections = numberOfMonthlySelections;
	}

	public void setMonthlySelection(MonthlySelection monthlySelection) {
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

	
	public void setAverageRating(){
		int i=0; 
		double	rating=0;
		while(i<this.getMonthlySelection().getWines().size()){
			rating = rating + this.getMonthlySelection().getWines().get(i).getRating();
			i++;
		}
		rating = rating/6;
		this.averageRating=rating;
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


	
}
