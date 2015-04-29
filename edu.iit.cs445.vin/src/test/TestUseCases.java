package test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import update.classes.UpdateAdmin;
import update.classes.UpdateCustomer;
import update.classes.UpdateDeliveryInfo;
import update.classes.UpdateShipmentInfo;
import update.classes.UpdateShipmentNote;
import update.classes.UpdateWineNote;
import add.classes.AddAdmin;
import add.classes.AddCustomer;
import add.classes.AddMonthlySelection;
import add.classes.AddNote;
import add.classes.AddReceipt;
import add.classes.AddSelectionWines;
import add.classes.AddWineNote;
import add.response.AddAdminResponse;
import add.response.AddCustomerResponse;
import add.response.AddMonthlySelectionResponse;
import add.response.AddReceiptResponse;
import add.response.AddWineNoteResponse;
import entities.Address;
import entities.Administrator;
import entities.Customer;
import entities.DayOfWeek;
import entities.MonthlySelection;
import entities.Note;
import entities.Receipt;
import entities.Shipment;
import entities.ShipmentState;
import entities.TimeOfDay;
import entities.Wine;
import entities.WineClub;
import entities.WineType;
import entities.WineVariety;

public class TestUseCases {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private WineClub club = new WineClub();
	private Customer customer = new Customer();
	
	public TestUseCases(){
		
	}
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		
	}
	
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Parameters
	public static ArrayList<Customer> customers() {

	    ArrayList<Customer> customers = new ArrayList<Customer>();
	    Customer customer1 = new Customer("Tony Forlini",new Address("3000 N Sheridan Rd","Chicago","IL","60657"),DayOfWeek.Mon,TimeOfDay.PM,"toforli@hotmail.com","3124783001","Tony Forlini","tforlini",null,shipments(),0);
	    Customer customer2 = new Customer("Michael Jordan",new Address("Main streeet","Chicago","IL","60657"),DayOfWeek.Mon,TimeOfDay.PM,"mj23@gmail.com","3124783001","M jordan","@MJ23",null,shipments(),0);
	    Customer customer3 = new Customer("Barack Obama",new Address("White house rd","Washington DC","NY","45678"),DayOfWeek.Mon,TimeOfDay.PM,"bobama@gmail.com","","barack obama","@bObama",null,shipments(),0);
	    Customer customer4 = new Customer("Steeve Carell",new Address("Crenshaw st","Los Angeles","CA","90210"),DayOfWeek.Mon,TimeOfDay.PM,"scarell@gmail.com","","steeve carell","@scarell",null,shipments(),0);
	    customers.add(customer1);
	    customers.add(customer2);
	    customers.add(customer3);
	    customers.add(customer4);
	   	    
	    return customers;
	  }
	
	@Parameters
	public static ArrayList<Shipment> shipments(){
		
		ArrayList<Shipment> shipments = new ArrayList<Shipment>();
		   ArrayList<Note> notes = new ArrayList<Note>();
		    Note note = new Note(Calendar.getInstance(),"Hey");
		    note.setId(1);
		    notes.add(note);
		    Shipment shipment = new Shipment(1,selections().get(0),"AR",Calendar.getInstance(),"toforli@hotmail.com",notes,DayOfWeek.Mon,TimeOfDay.PM,5,ShipmentState.ACTIVE);
		    shipment.setId(1);
		    shipments.add(shipment);
		    
		    return shipments;
	}
	
	@Parameters
	public static ArrayList<Wine> wines(){
		
		ArrayList<Wine> wines = new ArrayList<Wine>();
		Wine wine1 = new Wine(5,WineVariety.RED,WineType.SPARKLING,"Villageoise","champagne","reims","france","Moet & chandon","2012",null);
		wine1.setID(1);
		wines.add(wine1);
		
		return wines;
		
	}
	
	@Parameters
	public static ArrayList<Note> notes(){
		
	    ArrayList<Note> notes = new ArrayList<Note>();
	    Note note = new Note(Calendar.getInstance(),"Hey");
	    note.setId(1);
	    notes.add(note);
	    
	    return notes;
	}
	
	@Parameters
	public static ArrayList<Administrator> admins(){
		
		
		ArrayList<Administrator> admins = new ArrayList<Administrator>();
		Administrator admin1 = new Administrator("Tony");
		admin1.setId(1);
		admins.add(admin1);
		
		return admins;
	}
	
	@Parameters
	public static ArrayList<MonthlySelection> selections(){
		
		ArrayList<Wine> wines = new ArrayList<Wine>();
		Wine wine1 = new Wine(5,WineVariety.RED,WineType.SPARKLING,"Villageoise","champagne","reims","france","Moet & chandon","2012",notes());
		wine1.setID(1);
		wines.add(wine1);
		
		MonthlySelection selection = new MonthlySelection(wines,10,1,Calendar.getInstance(),"AR");
		ArrayList<MonthlySelection> selections = new ArrayList<MonthlySelection>();
		selection.setId(1);
		selections.add(selection);
		
		return selections;
	}
	
	@Test
	public void test_add_admin(){
		
		AddAdminResponse response = new AddAdminResponse();
		
		AddAdmin add = new AddAdmin(club);
		response = add.addAdmin("Tony");
		
		Administrator finaladmin = club.getAdministratorById(response.getId());
		
		assertEquals("Tony", finaladmin.getName());
		
	}
	
	@Test
	public void test_add_customer(){
		
		AddCustomerResponse response = new AddCustomerResponse();
		
		AddCustomer add = new AddCustomer("s", "c", "st", "z", "n", "e", "p", "t", "f");
		response = add.addAccount(club);
		
		Customer customer = club.getCustomerById(response.getId());
		
		assertEquals("s", customer.getAddress().getStreet());
		assertEquals("c", customer.getAddress().getCity());
		assertEquals("st", customer.getAddress().getState());
		assertEquals("z", customer.getAddress().getZip());
		assertEquals("n", customer.getName());
		assertEquals("e", customer.getEmail());
		assertEquals("p", customer.getPhone());
		assertEquals("t", customer.getTwitterId());
		assertEquals("f", customer.getFacebookId());
		
		
	}
		
	
	@Test
	public void test_add_monthly_selection() throws NullPointerException, ParseException{
		
		AddMonthlySelectionResponse response = new AddMonthlySelectionResponse();
		ArrayList<AddSelectionWines> selections = new ArrayList<AddSelectionWines>();
		AddSelectionWines selection = new AddSelectionWines(WineVariety.RED,WineType.SPARKLING,"Villageoise","champagne","reims","france","Moet & chandon","2012");
		selections.add(selection);
		AddMonthlySelection add = new AddMonthlySelection(club);
		
		response = add.addSelection("AR", "Apr/2015",selections);
		
		MonthlySelection finalselection = club.getSelectionById(response.getId());
		
		assertEquals("Villageoise", finalselection.getWines().get(0).getLabelName());
		assertEquals("champagne", finalselection.getWines().get(0).getGrape());
		assertEquals("reims", finalselection.getWines().get(0).getRegion());
		assertEquals("france", finalselection.getWines().get(0).getCountry());
		assertEquals("Moet & chandon", finalselection.getWines().get(0).getMaker());
		assertEquals("2012", finalselection.getWines().get(0).getYear());
		
	}
	
	@Test
	public void test_add_note(){
		

		Shipment shipment = new Shipment(1,new MonthlySelection(),"AR",Calendar.getInstance(),"toforli@hotmail.com",notes(),DayOfWeek.Mon,TimeOfDay.PM,5,ShipmentState.ACTIVE);
		shipment.setId(1);
		customer.addShipment(shipment);
		
		int response = 0;
		AddNote add = new AddNote(customer);
		
		response = add.addNote(1, "Hey");
		
		Note note = customer.getShipmentById(1).getNoteById(response);
		
		assertEquals(note.getContent(), "Hey");
		
	}
	
	@Test
	public void test_add_receipt(){
		
		
		AddReceiptResponse response = new AddReceiptResponse();
		AddReceipt add = new AddReceipt(club);
		response = add.addReceipt("Michel");
		
		Receipt receipt = club.getReceiptById(response.getId());
		
		assertEquals(receipt.getReceived_by(), "Michel");
		
	}
	
	@Test
	public void test_add_wine_note(){
		
		AddWineNoteResponse response = new AddWineNoteResponse(); 
		int nid = 0;
		
		customer.setShipments(shipments());
		AddWineNote add = new AddWineNote(customer);
		nid = add.addNote(1,"Hey");
		
		response = add.getResponse(1, nid);
		Note note = customer.getShipmentById(1).getMonthlySelection().getWineById(1).getNoteById(response.getId());
		
		assertEquals(note.getContent(), "Hey");
	}
	
	@Test
	public void test_update_admin(){
		
		UpdateAdmin update = new UpdateAdmin(club);
		ArrayList<Administrator> admins = new ArrayList<Administrator>();
		
		Administrator admin1= admins().get(0);
		admin1.setId(1);
		admins.add(admin1);
		club.setAdministrators(admins);
		
		Administrator admin2 = new Administrator();
		admin2.setId(1);
		admin2.setName("Michel");
		update.updateAdmin(admin2.getId(), admin2.getName());
		
		Administrator newAdmin = club.getAdministratorById(1);
		
		assertNotEquals("Tony", newAdmin.getName());
		assertEquals("Michel", newAdmin.getName());
		
	}
	  
	@Test
	public void test_update_customer(){
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers = customers();
		club.setCustomers(customers);
		
		Customer customer1 = customers.get(0);
		
		UpdateCustomer update = new UpdateCustomer(customer1); 
		update.update(club);
		Customer response = update.update("n", "c", "s", "c", "st", "z", "p", "f", "t");
		club.updateCustomer(response);
		
		Customer newCustomer = club.getCustomerById(response.getId());

		assertNotEquals(newCustomer.getName(),"Tony Forlini");
		assertEquals("n", newCustomer.getName());
		assertEquals("s",newCustomer.getAddress().getStreet());
		assertEquals("c",newCustomer.getAddress().getCity() );
		assertEquals("st",newCustomer.getAddress().getState() );
		assertEquals("z",newCustomer.getAddress().getZip() );
		assertEquals("p", newCustomer.getPhone());
		assertEquals("f", newCustomer.getFacebookId());
		assertEquals("t", newCustomer.getTwitterId());
	}
	
	@Test
	public void test_update_delivery_info(){
		Customer customer = customers().get(0);
		UpdateDeliveryInfo update = new UpdateDeliveryInfo(customer);
		Customer newCustomer = update.updateDeliveryInfo("Fri", "AM");
		
		assertNotEquals(customers().get(0).getDeliveryDay(), newCustomer.getDeliveryDay());
		assertNotEquals(customers().get(0).getDeliveryTime(), newCustomer.getDeliveryTime());
		
	}
	
	@Test
	public void test_update_shipment_info(){
		
		Customer customer = customers().get(0);
		UpdateShipmentInfo update= new UpdateShipmentInfo(customer);
		Shipment shipment = update.updateShipment(1,"Fri","AM",4);
		
		assertNotEquals(shipment.getForecastedDeliveryDate(),shipments().get(0).getForecastedDeliveryDate());
		assertNotEquals(shipment.getForecastedDeliveryTime(),shipments().get(0).getForecastedDeliveryTime());
	}
	
	@Test
	public void test_update_shipment_note(){
		
		Customer customer = customers().get(0);
		UpdateShipmentNote update = new UpdateShipmentNote(customer);
		Shipment shipment = update.update("Hello", 1,1);
		
		assertNotEquals(shipment.getNoteById(1), customers().get(0).getShipmentById(1).getNoteById(1));
		assertNotEquals(shipment.getNoteById(1), customers().get(0).getShipmentById(1).getNoteById(1));
		
	}
	
	@Test
	public void test_update_wine_note(){
		
		Customer customer = customers().get(0);
		UpdateWineNote d = new UpdateWineNote(customer);
		club.updateWine(1);
		club.updateCustomer(customer);
		d.updateWineNote("Hello", 1, 1);
		
		assertNotEquals(customer.getShipmentById(1).getMonthlySelection().getWineById(1).getNoteById(1).getContent(), customers().get(0).getShipmentById(1).getMonthlySelection().getWineById(1).getNoteById(1).getContent());
		
	}
	
	
}
