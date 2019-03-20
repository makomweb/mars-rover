import java.util.ArrayList;
import java.util.List;

public class Instructions {
	private String instructions;
	public Instructions(String instructions) {
		this.instructions = instructions;
	}
	
	public Instruction[] getInstructions() {
		ArrayList<Instruction> result = new ArrayList<Instruction>();
		
		for (char c: instructions.toCharArray()) {
			switch (c) {
				case 'L': result.add(Instruction.LEFT); break;
				case 'M': result.add(Instruction.MOVE); break;
				case 'R': result.add(Instruction.RIGHT); break;
				default: throw new UnknownInstructionException(c);
			}
		}
		
		return result.toArray(new Instruction[result.size()]);
	}
}
