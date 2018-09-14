
public class Rover {
	
	private Plateau plateau;
	private Position position;	
	private Heading heading;
	private String name;
	
	public Rover(String name) {
		this.name = name;
	}
	
	public void dropRover(Plateau plateau, String args) {
		
		String[] parts = args.split(" ");
		
		int x = Character.getNumericValue(parts[0].toCharArray()[0]);
		int y = Character.getNumericValue(parts[1].toCharArray()[0]);
		Heading h = ToHeading(parts[2].toCharArray()[0]);
		
		dropRover(plateau, new Position(x, y), h);
	}
	
	private Heading ToHeading(char heading) {
		
		switch (heading) {
			case 'N': return Heading.N;
			case 'W': return Heading.W;
			case 'S': return Heading.S;
			case 'E': return Heading.E;
			default: throw new RuntimeException("Unsupported character '" + heading + "'!");
		}
	}

	public void dropRover(Plateau plateau, Position p, Heading h) {

		if (!p.IsOnPlateau(plateau)) {
			throw new PositionNotOnPlateauException(plateau, p);
		}
		
		this.plateau = plateau;
		position = p;
		heading = h;
	}
	
	public void dropRover(Plateau plateau, int posX, int posY, char heading) {
		
		Heading h = null;
		
		switch (heading) {
			case 'N': h = Heading.N; break;
			case 'W': h = Heading.W; break;
			case 'S': h = Heading.S; break;
			case 'E': h = Heading.E; break;
		}
		
		dropRover(plateau, new Position(posX, posY), h);
	}
	
	@Override
	public String toString() {
		return name + ": " + report();
	}
	
	public String report() {
		
		if (position == null || heading == null) {
			return "Not dropped yet.";
		}
		
		return position.toString() + " " + heading;
	}
	
	public void processInstructions(String instructions) {
		
		for (char c: instructions.toCharArray()) {
			switch (c) {
				case 'L': processInstruction(Instruction.LEFT); break;
				case 'M': processInstruction(Instruction.MOVE); break;
				case 'R': processInstruction(Instruction.RIGHT); break;
				default: throw new UnknownInstructionException(c);
			}
		}
	}
	
	private void processInstruction(Instruction instruction) {

		if (position == null || heading == null) {
			throw new NotDroppedException();
		}
		
		switch (instruction) {
			case LEFT: turnLeft(); break;
			case MOVE: moveForward(); break;
			case RIGHT: turnRight(); break;
		}
	}
	
	private void turnLeft() {
		
		switch (heading) {
			case E: heading = Heading.N; break;
			case N: heading = Heading.W; break;
			case S: heading = Heading.E; break;
			case W: heading = Heading.S; break;
		}
	}
	
	private void turnRight() {
		
		switch (heading) {
			case E: heading = Heading.S; break;
			case N: heading = Heading.E; break;
			case S: heading = Heading.W; break;
			case W: heading = Heading.N; break;
		}
	}
	
	private void moveForward() {
		
		Position newPosition = position.moveForward(heading);
		
		if (!newPosition.IsOnPlateau(plateau)) {
			throw new PositionNotOnPlateauException(plateau, newPosition);
		}
		
		position = newPosition;
	}
}
