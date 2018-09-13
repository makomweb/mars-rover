
public class Program {

	public static void main(String[] args) {

		Plateau plateau = new Plateau(5, 5);
		
		{
			Rover rover = new Rover("One");
			rover.dropRover(1, 2, 'N');
			
			rover.receiveInstruction(Instruction.LEFT);
			rover.receiveInstruction(Instruction.MOVE);
			rover.receiveInstruction(Instruction.LEFT);
			rover.receiveInstruction(Instruction.MOVE);		
			rover.receiveInstruction(Instruction.LEFT);
			rover.receiveInstruction(Instruction.MOVE);
			rover.receiveInstruction(Instruction.LEFT);
			rover.receiveInstruction(Instruction.MOVE);
			rover.receiveInstruction(Instruction.MOVE);
			
			System.out.println("Rover report - " + rover.toString());
		}

		{
			Rover rover = new Rover("Two");
			rover.dropRover(3, 3, 'E');
			
			rover.receiveInstruction(Instruction.MOVE);
			rover.receiveInstruction(Instruction.MOVE);
			rover.receiveInstruction(Instruction.RIGHT);
			rover.receiveInstruction(Instruction.MOVE);		
			rover.receiveInstruction(Instruction.MOVE);
			rover.receiveInstruction(Instruction.RIGHT);			
			rover.receiveInstruction(Instruction.MOVE);
			rover.receiveInstruction(Instruction.RIGHT);
			rover.receiveInstruction(Instruction.RIGHT);
			rover.receiveInstruction(Instruction.MOVE);
			
			System.out.println("Rover report - " + rover.toString());
		}
	}
}
