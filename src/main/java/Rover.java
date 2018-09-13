
public class Rover {
	
	private Plateau plateau;
	private Position position;	
	private Heading heading;
	private String name;
	
	public Rover(String name) {
		this.name = name;
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
				default: /* An unknown instruction is ignored. */ break;
			}
		}
	}
	
	private void processInstruction(Instruction instruction) {

		if (position == null || heading == null) {
			throw new NotDroppedException();
		}
		
		switch (instruction) {
			case LEFT: turnLeft(); break;
			case MOVE: move(); break;
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
	
	private void move() {
		
		Position newPosition = null;
		
		switch (heading) {
			case E: newPosition = new Position(position.x + 1, position.y); break;
			case N: newPosition = new Position(position.x, position.y + 1); break;
			case S: newPosition = new Position(position.x, position.y - 1); break;
			case W: newPosition = new Position(position.x - 1, position.y); break;
		}

		if (!newPosition.IsOnPlateau(plateau)) {
			throw new PositionNotOnPlateauException(plateau, newPosition);
		}
		
		position = newPosition;
	}
}
