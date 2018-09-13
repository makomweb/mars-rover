import org.junit.Test;
import static org.junit.Assert.*;

public class RoverRideTests {

	@Test
	public void testRoverOne() {
		
		Rover r = new Rover("One");
		r.dropRover(1, 2, 'N');
		
		r.receiveInstruction(Instruction.LEFT);
		r.receiveInstruction(Instruction.MOVE);
		r.receiveInstruction(Instruction.LEFT);
		r.receiveInstruction(Instruction.MOVE);		
		r.receiveInstruction(Instruction.LEFT);
		r.receiveInstruction(Instruction.MOVE);
		r.receiveInstruction(Instruction.LEFT);
		r.receiveInstruction(Instruction.MOVE);
		r.receiveInstruction(Instruction.MOVE);
		
		String report = r.report();
		
		assertEquals("1 3 N", report);
	}
	
	@Test
	public void testRoverTwo() {
		
		Rover r = new Rover("Two");
		r.dropRover(3, 3, 'E');
		
		r.receiveInstruction(Instruction.MOVE);
		r.receiveInstruction(Instruction.MOVE);
		r.receiveInstruction(Instruction.RIGHT);
		r.receiveInstruction(Instruction.MOVE);		
		r.receiveInstruction(Instruction.MOVE);
		r.receiveInstruction(Instruction.RIGHT);			
		r.receiveInstruction(Instruction.MOVE);
		r.receiveInstruction(Instruction.RIGHT);
		r.receiveInstruction(Instruction.RIGHT);
		r.receiveInstruction(Instruction.MOVE);

		String report = r.report();
		
		assertEquals("5 1 E", report);
	}
}
