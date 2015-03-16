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

import WineClub.Customer;
import WineClub.Database;
import WineClub.WineClub;

import java.util.ArrayList;

public class TestWineClub {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
		
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
	    Customer customer1 = new Customer(1,"Tony","Forlini","3000 N Sherian Rd",null,"","toforli@hotmail.com","","tony forlini","tforlini",null, "",null,0);
	    Customer customer2 = new Customer(2,"Michael Jordan","Jordan","Chicago",null,"","mj23@gmail.com","","M jordan","@MJ23",null,"",null,0);
	    Customer customer3 = new Customer(3,"Barack","Obama","Washington DC",null,"","bobama@gmail.com","","barack obama","@bObama",null,"",null,0);
	    Customer customer4 = new Customer(4,"Steeve","Carell","Los Angeles",null,"","scarell@gmail.com","","steeve carell","@scarell",null,"",null,0);
	    customers.add(customer1);
	    customers.add(customer2);
	    customers.add(customer3);
	    customers.add(customer4);
	    
	    return customers;
	  }

	@Test
	public void testReadDatabase() throws JsonParseException, JsonMappingException, IOException {
		
		WineClub club = new WineClub();
		Database database = new Database();
		File file = new File("Test.json");
		club.setCustomers(database.getCustomers(file));
		
		int j=0;
		while(j<club.getCustomers().size()){
			assertEquals(club.getCustomers().get(j).getFirstName(),data().get(j).getFirstName());
			assertEquals(club.getCustomers().get(j).getLastName(),data().get(j).getLastName());
			assertEquals(club.getCustomers().get(j).getAddress(),data().get(j).getAddress());
			assertEquals(club.getCustomers().get(j).getFacebookId(),data().get(j).getFacebookId());
			assertEquals(club.getCustomers().get(j).getTwitterId(),data().get(j).getTwitterId());
			j++;
		}
	}

}
