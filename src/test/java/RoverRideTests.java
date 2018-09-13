import org.junit.Test;
import static org.junit.Assert.*;

public class RoverRideTests {

	@Test
	public void testRoverOne() {
		
		Rover r = new Rover("One");
		r.dropRover(1, 2, 'N');
		r.processInstructions("LMLMLMLMM");
		
		String report = r.report();		
		assertEquals("1 3 N", report);
	}
	
	@Test
	public void testRoverTwo() {
		
		Rover r = new Rover("Two");
		r.dropRover(3, 3, 'E');
		r.processInstructions("MMRMMRMRRM");

		String report = r.report();
		assertEquals("5 1 E", report);
	}
}
