package WineClub;

import java.util.ArrayList;
import java.util.Date;

public class Customer {
	
	protected int id;
	protected String firstName;
	protected String lastName;
	protected String address;
	protected Date deliveryDay;
	protected String deliveryTime;
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
		
		this.firstName="";
		this.lastName="";
		this.address="";
		this.deliveryDay=null;
		this.deliveryTime="";
		this.email="";
		this.phone="";
		this.facebookId="";
		this.twitterId="";
		this.inscriptionDate=null;
		this.password="";
		this.shipments= new ArrayList<Shipment>();
		this.numberOfSelections=0;
		numberOfCustomers++;
		this.id=numberOfCustomers;
		
	}

	public Customer(int id,String firstName,String lastName, String address, Date deliveryDay,String deliveryTime, String email, String phone, String facebookId, String twitterId, Date inscriptionDate,String password, ArrayList<Shipment> shipments,int numberOfSelections ) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.deliveryDay=deliveryDay;
		this.deliveryTime=deliveryTime;
		this.email=email;
		this.phone=phone;
		this.facebookId=facebookId;
		this.twitterId=twitterId;
		this.inscriptionDate=inscriptionDate;
		this.password=password;
		this.shipments=shipments;
		this.numberOfSelections=numberOfSelections;
		numberOfCustomers++;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static int getNumberOfCustomers() {
		return numberOfCustomers;
	}

	public static void setNumberOfCustomers(int numberOfCustomers) {
		Customer.numberOfCustomers = numberOfCustomers;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDeliveryDay() {
		return deliveryDay;
	}

	public void setDeliveryDay(Date deliveryDay) {
		this.deliveryDay = deliveryDay;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
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

}
