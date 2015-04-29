package test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import database.Database;
import entities.Address;
import entities.Administrator;
import entities.Customer;
import entities.DayOfWeek;
import entities.MonthlySelection;
import entities.Shipment;
import entities.ShipmentState;
import entities.TimeOfDay;
import entities.Wine;
import entities.WineClub;
import entities.WineType;
import entities.WineVariety;

import java.util.ArrayList;
import java.util.Calendar;

public class TestWineClub {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private WineClub club = new WineClub();
		
	public TestWineClub() {
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
	public static ArrayList<Customer> data() {

	    ArrayList<Customer> customers = new ArrayList<Customer>();
	    Customer customer1 = new Customer("Tony Forlini",new Address("3000 N Sheridan Rd","Chicago","IL","60657"),DayOfWeek.Mon,TimeOfDay.PM,"toforli@hotmail.com","3124783001","Tony Forlini","tforlini",null,null,0);
	    Customer customer2 = new Customer("Michael Jordan",new Address("Main streeet","Chicago","IL","60657"),DayOfWeek.Mon,TimeOfDay.PM,"mj23@gmail.com","3124783001","M jordan","@MJ23",null,null,0);
	    Customer customer3 = new Customer("Barack Obama",new Address("White house rd","Washington DC","NY","45678"),DayOfWeek.Mon,TimeOfDay.PM,"bobama@gmail.com","","barack obama","@bObama",null,null,0);
	    Customer customer4 = new Customer("Steeve Carell",new Address("Crenshaw st","Los Angeles","CA","90210"),DayOfWeek.Mon,TimeOfDay.PM,"scarell@gmail.com","","steeve carell","@scarell",null,null,0);
	    customers.add(customer1);
	    customers.add(customer2);
	    customers.add(customer3);
	    customers.add(customer4);
	    
	    return customers;
	  }

	@Test
	public void test_read_database() throws JsonParseException, JsonMappingException, IOException {
		

		Database database = new Database();
		File file = new File("Test.json");
		club.setCustomers(database.getCustomers(file));
		
		int j=0;
		while(j<club.getCustomers().size()){
			assertEquals(club.getCustomers().get(j).getName(),data().get(j).getName());
			assertEquals(club.getCustomers().get(j).getAddress().getStreet(),data().get(j).getAddress().getStreet());
			assertEquals(club.getCustomers().get(j).getAddress().getCity(),data().get(j).getAddress().getCity());
			assertEquals(club.getCustomers().get(j).getAddress().getState(),data().get(j).getAddress().getState());
			assertEquals(club.getCustomers().get(j).getAddress().getZip(),data().get(j).getAddress().getZip());
			assertEquals(club.getCustomers().get(j).getFacebookId(),data().get(j).getFacebookId());
			assertEquals(club.getCustomers().get(j).getTwitterId(),data().get(j).getTwitterId());
			j++;
		}
	}
	
	@Test
	public void test_update_shipment(){
		
		Shipment shipment = new Shipment(1,new MonthlySelection(),"AR",Calendar.getInstance(),"toforli@hotmail.com",null,DayOfWeek.Mon,TimeOfDay.PM,5,ShipmentState.ACTIVE);
		shipment.setId(1);
		club.addShipment(shipment);
		
		Shipment shipment2 = new Shipment(1,new MonthlySelection(),"AW",Calendar.getInstance(),"bobama@gmail.com",null,DayOfWeek.Sat,TimeOfDay.AM,5,ShipmentState.DELIVERED);;
		shipment2.setId(1);
		club.updateShipment(shipment2);
		
		assertEquals(club.getShipments().get(0), shipment2);
	}

	@Test
	public void test_update_wine(){
		
		ArrayList<Wine> wines = new ArrayList<Wine>();
		Wine wine1 = new Wine(5,WineVariety.RED,WineType.SPARKLING,"Villageoise","champagne","reims","france","Moet & chandon","2012",null);
		wine1.setID(1);
		wines.add(wine1);
		
		club.setSelection(new MonthlySelection(wines,10,1,Calendar.getInstance(),"AR"));
		Wine wine2 = new Wine(5,WineVariety.RED,WineType.SPARKLING,"Chateau latour","rouge","bordeaux","france","chateau","2011",null);
		wine2.setID(1);
		club.updateWine(wine2);
		
		assertEquals(club.getSelection().getWineById(1), wine2);
	
	}	
	
	@Test
	public void test_update_customer(){
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Customer customer1 = new Customer("Tony Forlini",new Address("3000 N Sheridan Rd","Chicago","IL","60657"),DayOfWeek.Mon,TimeOfDay.PM,"toforli@hotmail.com","3124783001","Tony Forlini","tforlini",null,null,0);
		customer1.setId(1);
		customers.add(customer1);
		
		club.setCustomers(customers);
		Customer customer2 = new Customer("Michael Jordan",new Address("Main streeet","Chicago","IL","60657"),DayOfWeek.Mon,TimeOfDay.PM,"mj23@gmail.com","3124783001","M jordan","@MJ23",null,null,0);
		customer2.setId(1);
		club.updateCustomer(customer2);
		
		assertEquals(club.getCustomerById(1),customer2);
	
	}
	
	@Test
	public void test_update_administrator(){
		ArrayList<Administrator> admins = new ArrayList<Administrator>();
		Administrator admin1 = new Administrator("Tony");
		admin1.setId(1);
		admins.add(admin1);
		
		club.setAdministrators(admins);
		Administrator admin2 = new Administrator("Michel");
		admin2.setId(1);
		club.updateAdministrator(admin2);
		
		assertEquals(club.getAdministratorById(1), admin2);
		
	}
	
	@Test
	public void test_get_customer_by_id(){
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Customer customer1 = new Customer("Tony Forlini",new Address("3000 N Sheridan Rd","Chicago","IL","60657"),DayOfWeek.Mon,TimeOfDay.PM,"toforli@hotmail.com","3124783001","Tony Forlini","tforlini",null,null,0);
		customer1.setId(1);
		customers.add(customer1);
		club.setCustomers(customers);
		assertEquals(club.getCustomerById(1), customer1);
	}
	
	@Test 
	public void test_get_administrator_by_id(){
		
		ArrayList<Administrator> admins = new ArrayList<Administrator>();
		Administrator admin1 = new Administrator("Tony");
		admin1.setId(1);
		admins.add(admin1);
		
		club.setAdministrators(admins);
		assertEquals(club.getAdministratorById(1), admin1);
	}
	
	@Test
	public void test_get_selection_by_id(){
		
		ArrayList<Wine> wines = new ArrayList<Wine>();
		Wine wine1 = new Wine(5,WineVariety.RED,WineType.SPARKLING,"Villageoise","champagne","reims","france","Moet & chandon","2012",null);
		wine1.setID(1);
		wines.add(wine1);
		
		MonthlySelection selection = new MonthlySelection(wines,10,1,Calendar.getInstance(),"AR");
		ArrayList<MonthlySelection> selections = new ArrayList<MonthlySelection>();
		selection.setId(1);
		selections.add(selection);
		
		
		club.setSelections(selections);
		assertEquals(club.getSelectionById(1), selection);
	}




}
