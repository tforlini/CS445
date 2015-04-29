package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Address;
import entities.Customer;
import entities.DayOfWeek;
import entities.TimeOfDay;

public class TestCustomer {

	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final Customer customer = new Customer("Tony Forlini",new Address("3000 N Sheridan Rd","Chicago","IL","60657"),DayOfWeek.Mon,TimeOfDay.PM,"tforlini@hawk.iit.edu","3124783001","Tony Forlini","tforlini",Calendar.getInstance(),null,1);
	
	
	public TestCustomer() {
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
	@Test
	   public void test_search_match_first_name() {
    assertTrue(customer.isMatch("Tony"));
    }
	@Test
	   public void test_search_match_last_name() {
 	assertTrue(customer.isMatch("Forlini"));
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

}
