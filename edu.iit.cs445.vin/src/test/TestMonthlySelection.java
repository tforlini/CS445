package test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import entities.Address;
import entities.Customer;
import entities.DayOfWeek;
import entities.MonthlySelection;
import entities.TimeOfDay;
import entities.Wine;
import entities.WineType;
import entities.WineVariety;

public class TestMonthlySelection {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private MonthlySelection selection = new MonthlySelection();
	
	public TestMonthlySelection(){
		
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
	public void test_get_wine_by_id(){
		
		ArrayList<Wine> wines = new ArrayList<Wine>();
		Wine wine1 = new Wine(5,WineVariety.RED,WineType.SPARKLING,"Villageoise","champagne","reims","france","Moet & chandon","2012",null);
		wine1.setID(1);
		wines.add(wine1);
		selection.setWines(wines);
		
		assertEquals(selection.getWineById(1), wine1);
		
	}
	
	@Test
	public void test_update_wine(){
		
		ArrayList<Wine> wines = new ArrayList<Wine>();
		Wine wine1 = new Wine(5,WineVariety.RED,WineType.SPARKLING,"Villageoise","champagne","reims","france","Moet & chandon","2012",null);
		wine1.setID(1);
		wines.add(wine1);
		
		selection.setWines(wines);
		Wine wine2 = new Wine(5,WineVariety.RED,WineType.SPARKLING,"Chateau latour","rouge","bordeaux","france","chateau","2011",null);
		wine2.setID(1);
		selection.updateWine(wine2);
		
		assertEquals(selection.getWineById(1), wine2);
		
	}
}
