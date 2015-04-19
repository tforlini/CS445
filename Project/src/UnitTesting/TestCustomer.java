package UnitTesting;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Entities.Address;
import Entities.Customer;
import Entities.DayOfWeek;
import Entities.Shipment;
import Entities.TimeOfDay;

public class TestCustomer {

	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final Customer customer = new Customer("Tony Forlini",new Address("3000 N Sheridan Rd","Chicago","IL","60657"),DayOfWeek.Mon,TimeOfDay.AM,"tforlini@hawk.iit.edu","3124783001","Tony Forlini","tforlini",new Date(),"password",new ArrayList<Shipment>(),1);
	private Shipment shipment = new Shipment();
	
	public TestCustomer() {
	}
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	    
	    shipment.setId(0);
	    customer.addShipment(shipment);
	}
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	@Test
	   public void test_search_match_name() {
    assertTrue(customer.isMatch("Tony Forlini"));
    }

	@Test
	   public void test_search_match_email() {
 	assertTrue(customer.isMatch("tforlini@hawk.iit.edu"));
	}
	@Test
	   public void test_search_match_phone_partial() {
	assertTrue(customer.isMatch("3001"));
	}
    @Test
    	public void test_formatted_phone_number_matches() {
    assertTrue(customer.isMatch("478-3001"));
    }
    @Test
    	public void test_search_match_phone_full() {
    assertTrue(customer.isMatch("3124783001"));
    }

    @Test
    public void test_search_Shipment_by_id(){
    	assertTrue(customer.getShipmentById(0).getId() == 0);
    }
    @Test
    public void test_get_shipments(){
    	assertTrue(customer.getShipments().contains(shipment));
    }
}
