package Entities;

import java.util.ArrayList;
import java.util.Calendar;


public class Customer {
	
	protected int id;
	protected String name;
	protected Address address;
	protected DayOfWeek deliveryDay;
	protected TimeOfDay deliveryTime;
	protected String email;
	protected String phone;
	protected String facebookId;
	protected String twitterId;
	protected Calendar inscriptionDate;
	protected ArrayList<Shipment> shipments;
	protected int numberOfSelections;
	protected static int numberOfCustomers;
	
	public Customer() {
		
		this.name="";
		this.address= new Address();
		this.deliveryDay=DayOfWeek.Mon;
		this.deliveryTime=TimeOfDay.PM;
		this.email="";
		this.phone="";
		this.facebookId="";
		this.twitterId="";
		this.inscriptionDate=Calendar.getInstance();
		this.shipments= new ArrayList<Shipment>();
		this.numberOfSelections=0;
		numberOfCustomers++;
		this.id=IdGenerator.newID();
		
	}

	public Customer(String name, Address address, DayOfWeek deliveryDay,TimeOfDay deliveryTime, String email, String phone, String facebookId, String twitterId, Calendar inscriptionDate, ArrayList<Shipment> shipments,int numberOfSelections ) {
		
		this.name=name;
		this.address=address;
		this.deliveryDay=deliveryDay;
		this.deliveryTime=deliveryTime;
		this.email=email;
		this.phone=phone.replaceAll("[\\s\\-()]", "");
		this.facebookId=facebookId;
		this.twitterId=twitterId;
		this.inscriptionDate=inscriptionDate;
		this.shipments=shipments;
		this.numberOfSelections=numberOfSelections;
		numberOfCustomers++;
		this.id=IdGenerator.newID();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public static int getNumberOfCustomers() {
		return numberOfCustomers;
	}

	public static void setNumberOfCustomers(int numberOfCustomers) {
		Customer.numberOfCustomers = numberOfCustomers;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public DayOfWeek getDeliveryDay() {
		return deliveryDay;
	}

	public void setDayOfWeek(String forecastedDeliveryDate) {
		if(forecastedDeliveryDate.equals("Mon")){
		this.deliveryDay = DayOfWeek.Mon;
		}
		else if(forecastedDeliveryDate.equals("Tue")){
			this.deliveryDay = DayOfWeek.Tue;
			}
		else if(forecastedDeliveryDate.equals("Wed")){
			this.deliveryDay= DayOfWeek.Wed;
			}
		else if(forecastedDeliveryDate.equals("Thu")){
			this.deliveryDay= DayOfWeek.Thu;
			}
		else if(forecastedDeliveryDate.equals("Fri")){
			this.deliveryDay= DayOfWeek.Fri;
			}
		else if(forecastedDeliveryDate.equals("Sat")){
			this.deliveryDay= DayOfWeek.Sat;
			}
		else{
			System.out.println("You entered a wrong day \n");
		}
	}
	
	public void setTimeOfDay(String forecastedDeliveryTime) {
		if(forecastedDeliveryTime.equals("AM")){
		this.deliveryTime = TimeOfDay.AM;
		}
		else if(forecastedDeliveryTime.equals("PM")){
			this.deliveryTime= TimeOfDay.PM;
			}
		else{
			System.out.println("You entered a wrong time \n");
		}
	}
	
	public void setDeliveryDay(DayOfWeek deliveryDay) {
		this.deliveryDay = deliveryDay;
	}

	public TimeOfDay getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(TimeOfDay deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}

	public Calendar getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Calendar inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public ArrayList<Shipment> getShipments() {
		return shipments;
	}
	
	public Shipment getShipmentById(int id){
		ArrayList<Shipment> shipments = this.getShipments();
		
		int i=0;
		while(i<shipments.size()){
			
			if(shipments.get(i).getId() == id){
				return shipments.get(i);
			}
			i++;
		}
		return null;
	}

	public void setShipments(ArrayList<Shipment> shipments) {
		this.shipments = shipments;
	}

	public int getNumberOfSelections() {
		return numberOfSelections;
	}

	public void setNumberOfSelections(int numberOfSelections) {
		this.numberOfSelections = numberOfSelections;
	}

	public void addShipment(Shipment shipment){
		this.shipments.add(shipment);
		
	}

	public void updateShipment(Shipment newShipment){
		ArrayList<Shipment> shipments = this.getShipments();
		if(shipments != null && newShipment != null){
		int newId = newShipment.getId();
		
		int i=0;
		while (i<shipments.size()){
			
			if(shipments.get(i).getId() == newId){
				shipments.set(i,newShipment);
			}
			i++;
		}
		}
		else{
			System.out.println("Unable to find your shipment\n");
		}
	}
	
    private boolean isMatchPhone(String kw) {
    	String s = kw.replaceAll("[\\s\\-()]", ""); 
    	String regex = "(?i).*" + s + ".*";
    	return this.phone.matches(regex);
    }
    private boolean isMatchName(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.name.matches(regex);
    }

    private boolean isMatchEmail(String kw) {
    	String regex = "(?i).*" + kw + ".*";
    	return this.email.matches(regex);
    }
    public boolean isMatch(String kw) {
    	if (isMatchName(kw) || isMatchEmail(kw) || isMatchPhone(kw)) {
    		return true;
    	} else return false;
    }

}
