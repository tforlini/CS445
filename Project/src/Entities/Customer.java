package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Comment.Comment;


public class Customer implements Comment{
	
	protected int id;
	protected String name;
	protected Address address;
	protected DayOfWeek deliveryDay;
	protected TimeOfDay deliveryTime;
	protected String email;
	protected String phone;
	protected String facebookId;
	protected String twitterId;
	protected Date inscriptionDate;
	protected String password;
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
		this.inscriptionDate=new Date();
		this.password="";
		this.shipments= new ArrayList<Shipment>();
		this.numberOfSelections=0;
		numberOfCustomers++;
		this.id=numberOfCustomers;
		
	}

	public Customer(String name, Address address, DayOfWeek deliveryDay,TimeOfDay deliveryTime, String email, String phone, String facebookId, String twitterId, Date inscriptionDate,String password, ArrayList<Shipment> shipments,int numberOfSelections ) {
	
		this.name=name;
		this.address=address;
		this.deliveryDay=deliveryDay;
		this.deliveryTime=deliveryTime;
		this.email=email;
		this.phone=phone.replaceAll("[\\s\\-()]", "");
		this.facebookId=facebookId;
		this.twitterId=twitterId;
		this.inscriptionDate=inscriptionDate;
		this.password=password;
		this.shipments=shipments;
		this.numberOfSelections=numberOfSelections;
		numberOfCustomers++;
		this.id=numberOfCustomers;
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

	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
    	if (isMatchName(kw) || isMatchEmail(kw) || isMatchPhone(kw) ) {
    		return true;
    	} else return false;
    }

	@Override
	public Shipment addNote(int id) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What comment do you have for this shipment ?\n");
		String note = input.nextLine();
		
		Note noteAdd = new Note(new Date(),note);
		Shipment shipment = this.getShipmentById(id);
		if(shipment != null){
		shipment.addNote(noteAdd);
		System.out.println("Note added successfully \n");
		System.out.println("ID: "+noteAdd.getId()+" \n");
		}
		return shipment;
		
	}

	@Override
	public Wine rateWine() {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("What Shipment do you want to add a note about?\n");
		String ID =input.nextLine();
		int id = Integer.parseInt(ID);
		Shipment shipment = this.getShipmentById(id);
		
		System.out.println("What Wine do you want to rate ?\n");
		String wineID = input.nextLine();
		int wineId = Integer.parseInt(wineID);
		Wine wine = shipment.getMonthlySelection().getWineById(wineId);
		
		System.out.println("What is your rating for this wine ?\n");
		String ratingStr = input.nextLine();
		int rating = Integer.parseInt(ratingStr);
		wine.addRating(rating);
		
		return wine;
	}

}
