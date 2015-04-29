package entities;

import java.util.ArrayList;
import java.util.Calendar;

import entities.Note;


public class Shipment {

	protected int id;
	protected double price;
	protected int numberOfMonthlySelections;
	protected MonthlySelection monthlySelection;
	protected String type;
	protected Calendar subscriptionDate;
	protected String customerEmail;
	protected double averageRating;
	protected ArrayList<Note> notes;
	protected DayOfWeek forecastedDeliveryDate;
	protected TimeOfDay forecastedDeliveryTime;
	protected double deliveryCharge;
	protected ShipmentState state;
	protected static int shipmentsNumber;


	public Shipment() {

		
		this.numberOfMonthlySelections=0;
		this.monthlySelection= new MonthlySelection();
		this.type="AR";
		this.subscriptionDate=Calendar.getInstance();
		this.customerEmail="";
		this.notes=new ArrayList<Note>();
		this.forecastedDeliveryDate=DayOfWeek.Mon;
		this.forecastedDeliveryTime=TimeOfDay.PM;
		this.deliveryCharge=5.01;
		this.state=this.getState();
		this.price=this.getMonthlySelection().getPrice();
		shipmentsNumber++;
		this.id=IdGenerator.newID();
	}

	public Shipment(int numberOfMonthlySelections, MonthlySelection monthlySelection,String type,Calendar subscriptionDate,String customerEmail,ArrayList<Note> notes,DayOfWeek forecastedDeliveryDate,TimeOfDay forecastedDeliveryTime, int deliveryCharge,ShipmentState state) {
		this.id=IdGenerator.newID();
		this.numberOfMonthlySelections=numberOfMonthlySelections;
		this.monthlySelection=monthlySelection;
		this.type=type;
		this.subscriptionDate=subscriptionDate;
		this.customerEmail=customerEmail;
		this.notes=notes;
		this.forecastedDeliveryDate=forecastedDeliveryDate;
		this.forecastedDeliveryTime=forecastedDeliveryTime;
		this.deliveryCharge=0;
		this.state=state;
		this.price=this.getMonthlySelection().getPrice();
		shipmentsNumber++;
	}

	public ShipmentState getState() {
		Calendar lastweek = Calendar.getInstance();
		lastweek.add(Calendar.DAY_OF_MONTH,-7);
		if (this.getSubscriptionDate().before(lastweek)){
		return ShipmentState.DELIVERED;
		}
		return ShipmentState.ACTIVE;
	}

	public void setState(ShipmentState state) {
		this.state = state;
	}

	public double getPrice() {
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

	public Calendar getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Calendar subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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

	public Note getNoteById(int nid){
		ArrayList<Note> notes = this.getNotes();
		if(notes != null){
		int i=0;
		while(i<notes.size()){
			if(notes.get(i).getId() == nid){
				return notes.get(i);
			}
			i++;
		}
		}
		else{
			System.out.println("Note not found \n");
		}
		return null;
	}
	
	public void updateNote(Note newNote){
		int newId = newNote.getId();
		ArrayList<Note> notes = this.getNotes();
		if(notes != null){
		int i=0;
		while(i<notes.size()){
			if(notes.get(i).getId() == newId){
				notes.set(i, newNote);
			}
			i++;
		}
		this.setNotes(notes);
		}
	}
	
	public void updateWine(Wine newWine) {
		int newId = newWine.getID();
		ArrayList<Wine> wines = this.getMonthlySelection().getWines();
		int i = 0;
		while (i < wines.size()) {
			if (wines.get(i).getID() == newId) {
				wines.set(i, newWine);
			}
			i++;
		}
		this.monthlySelection.setWines(wines);
	}
	
	public ArrayList<Note> getNotes() {
		return notes;
	}

	public void addNote(Note note){
		this.notes.add(note);
	}
	
	public void setNotes(ArrayList<Note> note) {
		this.notes = note;
	}

	public DayOfWeek getForecastedDeliveryDate() {
		return forecastedDeliveryDate;
	}

	public void setForecastedDeliveryDate(String forecastedDeliveryDate) {
		if(forecastedDeliveryDate.equals("Mon")){
		this.forecastedDeliveryDate = DayOfWeek.Mon;
		}
		else if(forecastedDeliveryDate.equals("Tue")){
			this.forecastedDeliveryDate = DayOfWeek.Tue;
			}
		else if(forecastedDeliveryDate.equals("Wed")){
			this.forecastedDeliveryDate = DayOfWeek.Wed;
			}
		else if(forecastedDeliveryDate.equals("Thu")){
			this.forecastedDeliveryDate = DayOfWeek.Thu;
			}
		else if(forecastedDeliveryDate.equals("Fri")){
			this.forecastedDeliveryDate = DayOfWeek.Fri;
			}
		else if(forecastedDeliveryDate.equals("Sat")){
			this.forecastedDeliveryDate = DayOfWeek.Sat;
			}
		else{
			System.out.println("You entered a wrong day \n");
		}
	}
	
	public void setForecastedDate(DayOfWeek forecastedDeliveryDate) {
		this.forecastedDeliveryDate=forecastedDeliveryDate;
	}

	public TimeOfDay getForecastedDeliveryTime() {
		return forecastedDeliveryTime;
	}

	public void setForecastedDeliveryTime(String forecastedDeliveryTime) {
		if(forecastedDeliveryTime.equals("AM")){
		this.forecastedDeliveryTime = TimeOfDay.AM;
		}
		else if(forecastedDeliveryTime.equals("PM")){
			this.forecastedDeliveryTime = TimeOfDay.PM;
			}
		else{
			System.out.println("You entered a wrong time \n");
		}
	}

	public void setForecastedTime(TimeOfDay forecastedDeliveryTime) {
		this.forecastedDeliveryTime=forecastedDeliveryTime;
	}
	
	public double getDeliveryCharge() {
		return deliveryCharge;
	}

	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}

    private boolean isMatchType(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.type.matches(regex);
    }
    private boolean isMatchNote(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	ArrayList<Note> notes = this.notes;
    	int i=0;
    	while(i<notes.size()){
    		if(!notes.get(i).getContent().matches(regex)){
    			return false;
    		}
    		i++;
    	}
    	return true;
    }

    private boolean isMatchEmail(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.customerEmail.matches(regex);
    }
    public boolean isMatch(String kw) {
    	if (isMatchType(kw) || isMatchEmail(kw) || isMatchNote(kw)) {
    		return true;
    	} else return false;
    }

}
