import org.junit.Test;
import static org.junit.Assert.*;

public class RoverRideTests {

	private Plateau plateau = new Plateau(5, 5);
	
	@Test
	public void moving_rover_one_should_succeed() {

		Rover rover = new Rover("Opportunity");
		rover.dropRover(plateau, 1, 2, 'N');
		rover.processInstructions("LMLMLMLMM");
		
		String report = rover.reportPosition();		
		assertEquals("1 3 N", report);
	}
	
	@Test
	public void moving_rover_two_should_succeed() {

		Rover rover = new Rover("Opportunity");
		rover.dropRover(plateau, 3, 3, 'E');
		rover.processInstructions("MMRMMRMRRM");

		String report = rover.reportPosition();
		assertEquals("5 1 E", report);
	}
	
	@Test
	public void moving_rover_beyond_plateau_should_throw() {

		Rover rover = new Rover("Opportunity");
		rover.dropRover(plateau, 2, 2, 'N');
		
		try {
			rover.processInstructions("MMMMMMMM");
			assertTrue("Moving should have thrown before!", false);			
		}
		catch (PositionNotOnPlateauException ex) {
			assertEquals("Position is not on the plateau!", ex.getMessage());
		}
	}
	
	@Test
	public void dropping_rover_beyond_plateau_should_throw() {

		Rover rover = new Rover("Opportunity");
		try {
			rover.dropRover(plateau, 6, 6, 'N');
			assertTrue("Dropping should have thrown before!", false);
		}
		catch (PositionNotOnPlateauException ex) {
			assertEquals("Position is not on the plateau!", ex.getMessage());
		}
	}
	
	@Test
	public void not_dropped_rover_should_report_properly() {

		Rover rover = new Rover("Opportunity");
		String report = rover.reportPosition();
		assertEquals("Not dropped yet.", report);
	}
	
	@Test
	public void moving_an_undropped_rover_should_throw() {

		Rover rover = new Rover("Opportunity");
		try {
			rover.processInstructions("MMMMMM");
			assertTrue("Moving an undropped rover should have thrown before!", false);
		}
		catch (NotDroppedException ex) {
			assertEquals("Rover was not dropped on the plateau!", ex.getMessage());
		}
	}
	
	@Test
	public void unknown_instruction_should_throw() {

		Rover rover = new Rover("Opportunity");
		try {
			rover.processInstructions("XXXX");
			assertTrue("Should have thrown before", false);
		}
		catch (UnknownInstructionException ex) {
			
		}
	}
	
	@Test
	public void moving_rover_over_another_rover_should_throw() {
		
		throw new RuntimeException("Not yet implemented!");
	}
}
