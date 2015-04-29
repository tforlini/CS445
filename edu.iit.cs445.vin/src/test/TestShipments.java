package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.DayOfWeek;
import entities.MonthlySelection;
import entities.Note;
import entities.Shipment;
import entities.ShipmentState;
import entities.TimeOfDay;

public class TestShipments {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private ArrayList<Shipment> shipments = new ArrayList<Shipment>();
	public TestShipments(){
		
	}
	
	@Before
	public void setUpStreams() throws JsonParseException, JsonMappingException, IOException {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	    ArrayList<Note> notes = new ArrayList<Note>();
	    Note note = new Note(Calendar.getInstance(),"Hey");
	    notes.add(note);
	    Shipment shipment = new Shipment(1,new MonthlySelection(),"AR",Calendar.getInstance(),"toforli@hotmail.com",notes,DayOfWeek.Mon,TimeOfDay.PM,5,ShipmentState.ACTIVE);
	    shipments.add(shipment);
	}
	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	@Test
	   public void test_search_match_email() {
		assertTrue(shipments.get(0).isMatch("toforli@hotmail.com"));
 }
	
	@Test
	   public void test_search_match_type() {
		assertTrue(shipments.get(0).isMatch("AR"));
}
	@Test
	   public void test_search_match_note() {
		assertTrue(shipments.get(0).isMatch("Hey"));
}
}
