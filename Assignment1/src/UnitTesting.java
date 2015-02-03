import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author tofor_000
 *
 */
public class UnitTesting {

	/**
	 * @throws java.lang.Exception
	 */
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

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
	public void testMoveTiger() {
		
		Tiger tiger = new Tiger();
		tiger.move();
		assertEquals(tiger.toString() + " has just pounced.",outContent.toString());
	}

	@Test
	public void testMoveAnt() {
		
		Ant ant = new Ant();
		ant.move();
		assertEquals(ant.toString() + " is crawling around.", outContent.toString());
	}
	
	@Test
	public void testMoveBat() {
		
		Bat bat = new Bat();
		bat.move();
		assertEquals(bat.toString() + " is swooping through the dark.", outContent.toString());
	}
	
	@Test
	public void testMoveFly() {
		
		Fly fly = new Fly();
		fly.move();
		assertEquals(fly.toString() + " is buzzing around in flight.", outContent.toString());
	}
	
	@Test
	public void testEat() {
		
		Bat bat = new Bat();
		Fly flyEaten = new Fly();
		bat.eat(flyEaten);
		assertEquals(bat.toString() + " has just eaten a " + bat.getLastEat().toString() + "\n", outContent.toString());
	}
	
	@Test
	public void testToString() {

		Fly fly = new Fly();
		assertEquals(fly.name + " " + fly.getClass().getSimpleName(), fly.toString());
	}
	
	@Test
	public void testWhatDidYouEat() throws IOException {
		Bat bat = new Bat();
		Fly notEating = new Fly();
		Fly flyEaten = new Fly();
		
		bat.eat(flyEaten);
		outContent.flush();
		outContent.reset();
		System.setOut(new PrintStream(outContent));
		
		bat.whatDidYouEat();
		assertEquals(bat.toString() + " has eaten " + bat.getLastEat().toString(), outContent.toString());
		
		outContent.reset();
		notEating.whatDidYouEat();
		assertEquals(notEating.toString() + " has had nothing to eat!", outContent.toString());
	}
	

}
