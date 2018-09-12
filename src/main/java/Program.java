
public class Program {

	public static void main(String[] args) {

		Plateau plateau = new Plateau(5, 5);
		
		{
			Rover rover = new Rover();
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
			
			System.out.println("Rover 1: " + rover.toString());
		}

		{
			Rover rover = new Rover();
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
			
			System.out.println("Rover 2: " + rover.toString());
		}
	}
}
