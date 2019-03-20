import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class RoverRideTests {

	private Plateau plateau = new Plateau(5, 5);
	
	@Test
	public void moving_rover_one_should_succeed() {
		Rover rover = new Rover("Opportunity");
		rover.dropRover(plateau, 1, 2, 'N');
		
		//rover.processInstructions("LMLMLMLMM");

		rover.processInstructions(convertToArray("LMLMLMLMM"));
		
		String report = rover.reportPosition();		
		assertEquals("1 3 N", report);
	}
	
	private static Instruction[] convertToArray(String instructions) {
		return new Instructions(instructions).getInstructions();
	}
	@Test
	public void moving_rover_two_should_succeed() {
		Rover rover = new Rover("Opportunity");
		rover.dropRover(plateau, 3, 3, 'E');
		//rover.processInstructions("MMRMMRMRRM");
		rover.processInstructions(convertToArray("MMRMMRMRRM"));

		String report = rover.reportPosition();
		assertEquals("5 1 E", report);
	}
	
	@Test
	public void moving_rover_beyond_plateau_should_throw() {
		Rover rover = new Rover("Opportunity");
		rover.dropRover(plateau, 2, 2, 'N');
		
		try {
			//rover.processInstructions("MMMMMMMM");
			rover.processInstructions(convertToArray("MMMMMMMM"));
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
			//rover.processInstructions("MMMMMM");
			rover.processInstructions(convertToArray("MMMMMM"));
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
			//rover.processInstructions("XXXX");
			rover.processInstructions(convertToArray("XXXX"));
			assertTrue("Should have thrown before!", false);
		}
		catch (UnknownInstructionException ex) {
			
		}
	}
	
	@Test
	public void moving_rover_over_another_rover_should_throw() {
		Rover one = new Rover("Curiosity");
		Rover two = new Rover("Opportunity");
		
		one.dropRover(plateau, "3 5 E");
		
		try {
			two.dropRover(plateau, "3 5 N");
			assertTrue("Should have thrown before!", false);
		}
		catch (RuntimeException ex) {
			
		}
	}
	
	@Test
	public void dropping_at_10_10_should_give_exact_report() {

		Plateau plat = new Plateau(20, 20);
		
		Rover one = new Rover("Curiosity");
		
		one.dropRover(plat, "10 10 N");
		
		String report = one.reportPosition();
		
		//assertTrue("Report is not like expected", "10 10 N".equals(report));
		assertEquals("10 10 N", report);
	}
	
	@Test
	public void dropping_two_rovers_next_to_eachother_should_succeed() {
		Rover one = new Rover("Curiosity");
		Rover two = new Rover("Opportunity");
		
		one.dropRover(plateau, "3 5 E");
		two.dropRover(plateau, "4 5 N");
	}
}