package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Wine;
import entities.WineType;
import entities.WineVariety;

public class TestWine {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final Wine wine = new Wine(15, WineVariety.WHITE,WineType.SPARKLING,"Dom Perignon","","Champagne","France","Moet & Chandon","2012",null); 
	
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
	public void test_characteristics_of_default_new_wine() {
		Wine w = new Wine();
		assertEquals(WineVariety.RED, w.getWineVariety());
		assertEquals(WineType.TABLE, w.getWineType());
		assertEquals("", w.getLabelName());
		assertEquals("", w.getGrape());
		assertEquals("", w.getRegion());
		assertEquals("", w.getCountry());
		assertEquals("", w.getMaker());
		assertEquals("", w.getYear());
	}
	
	@Test
	public void test_characteristics_of_new_wine() {
		
		assertEquals(WineVariety.WHITE, wine.getWineVariety());
		assertEquals(WineType.SPARKLING, wine.getWineType());
		assertEquals("Dom Perignon", wine.getLabelName());
		assertEquals("", wine.getGrape());
		assertEquals("Champagne", wine.getRegion());
		assertEquals("France", wine.getCountry());
		assertEquals("Moet & Chandon", wine.getMaker());
		assertEquals("2012", wine.getYear());
	}
	@Test
	public void test_get_number_of_user_ratings_after_adding_a_rating() {
		Wine w = new Wine();
		int n = w.getNumberOfRatings();
		w.addRating(1);
		assertEquals(n+1, w.getNumberOfRatings());
	}
	
	@Test
	public void test_get_number_of_user_ratings_after_adding_two_ratings() {
		Wine w = new Wine();
		int n = w.getNumberOfRatings();
		w.addRating(1);
		w.addRating(2);
		assertEquals(n+2, w.getNumberOfRatings());
	}
		
	@Test
	public void test_average_ratings_after_adding_a_rating() {
		Wine w = new Wine();
		float r = w.getRating();
		int addNewRating = 5;
		
		w.addRating(addNewRating);
		int n = w.getNumberOfRatings();
		float newRating = r * (n-1)/n + addNewRating/n;
		assertEquals(newRating, w.getRating(), 0.01);
	}

	@Test
	public void test_average_ratings_after_adding_two_ratings() {
		Wine w = new Wine();
		float r = w.getRating();
		
		int addNewRating_1 = 5;		
		w.addRating(addNewRating_1);
		int n = w.getNumberOfRatings();
		float newRating = r * (n-1)/n + addNewRating_1/n;
		
		r = w.getRating();
		int addNewRating_2 = 2;
		w.addRating(addNewRating_2);
		n = w.getNumberOfRatings();
		newRating = (float) (addNewRating_1 + addNewRating_2)/n;
		
		assertEquals(newRating, w.getRating(), 0.01);
	}
	
	@Test
	public void test_search_match() {
		Wine w = new Wine();
		assertTrue(w.isMatch("ReD"));
		assertTrue(w.isMatch("table"));
	}
	
	@Test
	public void test_search_fail() {
		Wine w = new Wine();
		assertFalse(w.isMatch("blah-blah-blah"));
	}
}
