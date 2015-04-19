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

import WineClub.WineClub;
import Database.Database;

public class TestShipments {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private WineClub club = new WineClub();
	private Database databaseShipments = new Database(club, new File("Shipments.json"));
	public TestShipments(){
		
	}
	
	@Before
	public void setUpStreams() throws JsonParseException, JsonMappingException, IOException {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	    club.setShipments(databaseShipments.getShipments());
	}
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	@Test
	   public void test_search_match_email() {
		assertTrue(club.getShipments().get(0).isMatch("toforli@hotmail.com"));
 }
	
	@Test
	   public void test_search_match_type() {
		assertTrue(club.getShipments().get(0).isMatch("AR"));
}
	@Test
	   public void test_search_match_note() {
		assertTrue(club.getShipments().get(0).isMatch("Hey"));
}
}
