
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

	public void dropRover(Plateau plateau, Position p, Heading h) {

		if (!p.IsOnPlateau(plateau)) {
			throw new PositionNotOnPlateauException(plateau, p);
		}
		
		if (plateau.isOccupied(p)) {
			throw new RuntimeException("Already occupied by a rover!");
		}
		
		this.plateau = plateau;
		position = p;
		heading = h;
		
		plateau.addRover(this);
	}
	
	public void dropRover(Plateau plateau, int posX, int posY, char heading) {
		
		Heading h = ToHeading(heading);
				
		dropRover(plateau, new Position(posX, posY), h);
	}

	public String reportStatus() {
		
		StringBuilder sb = new StringBuilder(name);
		
		sb.append(" ");
		sb.append(reportPosition());
			
		return sb.toString();
	}

	public String reportPosition() {
		
		if (position == null || heading == null) {
			return "Not dropped yet.";
		}
		
		return position.toString() + " " + FromHeading(heading);
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
	
	public boolean hasPosition(Position pos) {
		
		return position.isEqual(pos);
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
			case EAST: heading = Heading.NORTH; break;
			case NORTH: heading = Heading.WEST; break;
			case SOUTH: heading = Heading.EAST; break;
			case WEST: heading = Heading.SOUTH; break;
		}
	}
	
	private void turnRight() {
		
		switch (heading) {
			case EAST: heading = Heading.SOUTH; break;
			case NORTH: heading = Heading.EAST; break;
			case SOUTH: heading = Heading.WEST; break;
			case WEST: heading = Heading.NORTH; break;
		}
	}
	
	private void moveForward() {
		
		Position newPosition = position.moveForward(heading);
		
		if (!newPosition.IsOnPlateau(plateau)) {
			throw new PositionNotOnPlateauException(plateau, newPosition);
		}
		
		position = newPosition;
	}
	
	private static Heading ToHeading(char heading) {
		
		switch (heading) {
			case 'N': return Heading.NORTH;
			case 'W': return Heading.WEST;
			case 'S': return Heading.SOUTH;
			case 'E': return Heading.EAST;
			default: throw new RuntimeException("Unsupported character '" + heading + "'!");
		}
	}
	
	private static char FromHeading(Heading heading) {
		
		switch (heading) {
			case NORTH: return 'N';
			case WEST: return 'W';
			case SOUTH: return 'S';
			case EAST: return 'E';
			default: return ' ';
		}
	}
}
