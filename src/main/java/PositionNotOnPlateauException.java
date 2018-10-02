
public class PositionNotOnPlateauException extends RuntimeException {

	private Plateau plateau;
	private Position position;
	
	public PositionNotOnPlateauException(Plateau plateau, Position p) {
		super("Position is not on the plateau!");
		
		this.plateau = plateau;
		this.position = p;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public Position getPosition() {
		return position;
	}
}
