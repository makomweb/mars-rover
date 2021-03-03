
public class PositionNotOnPlateauException extends RuntimeException {

	private Plateau plateau;
	private Position position;
	
	public PositionNotOnPlateauException(Plateau plateau, Position position) {
		super("Position is not on the plateau!");
		
		this.plateau = plateau;
		this.position = position;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public Position getPosition() {
		return position;
	}
}
