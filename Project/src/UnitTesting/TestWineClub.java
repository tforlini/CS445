package UnitTesting;
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

import Database.Database;
import Entities.Address;
import Entities.Customer;
import Entities.DayOfWeek;
import Entities.TimeOfDay;
import WineClub.WineClub;

import java.util.ArrayList;

public class TestWineClub {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private WineClub club = new WineClub();
	private Database database = new Database();
	
	public TestWineClub() {
	}
	@Before
	public void setUpStreams() throws JsonParseException, JsonMappingException, IOException {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		File file = new File("Test.json");
		database.setFile(file);
		club.setCustomers(database.getCustomers());
	    
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	@Parameters
	public static ArrayList<Customer> data() {

	    ArrayList<Customer> customers = new ArrayList<Customer>();
	    Customer customer1 = new Customer("Tony Forlini",new Address("3000 N Sheridan Rd","Chicago","Illinois","60657"),DayOfWeek.Mon,TimeOfDay.PM,"toforli@hotmail.com","","tony forlini","tforlini",null, "",null,0);
	    Customer customer2 = new Customer("Michael Jordan",new Address("Main street","Chicago","IL","60657"),DayOfWeek.Mon,TimeOfDay.PM,"mj23@gmail.com","","M jordan","@MJ23",null,"",null,0);
	    Customer customer3 = new Customer("Barack Obama",new Address("White house rd","Washington DC","NY","45678"),DayOfWeek.Mon,TimeOfDay.PM,"bobama@gmail.com","","barack obama","@bObama",null,"",null,0);
	    Customer customer4 = new Customer("Steeve Carell",new Address("Kreynshaw st","Los Angeles","CA","90210"),DayOfWeek.Mon,TimeOfDay.PM,"scarell@gmail.com","","steeve carell","@scarell",null,"",null,0);
	    customers.add(customer1);
	    customers.add(customer2);
	    customers.add(customer3);
	    customers.add(customer4);
	    
	    return customers;
	  }

	@Test
	public void testReadDatabase() throws JsonParseException, JsonMappingException, IOException {
		
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
	public void test_check_email(){
		Customer customer1 = new Customer("Tony Forlini",new Address("3000 N Sheridan Rd","Chicago","Illinois","60657"),DayOfWeek.Mon,TimeOfDay.PM,"toforli@hotmail.com","","tony forlini","tforlini",null, "",null,0);
		club.addCustomer(customer1);
		assertFalse(club.checkEmail(club.getCustomers(),customer1));
	}
	@Test
	public void test_add_customer(){
		Customer customer1 = new Customer("Tony Forlini",new Address("3000 N Sheridan Rd","Chicago","Illinois","60657"),DayOfWeek.Mon,TimeOfDay.PM,"toli@hotmail.com","","tony forlini","tforlini",null, "",null,0);
		club.addCustomer(customer1);
		assertTrue(club.getCustomers().contains(customer1));
	}
}
