import java.util.*;

public class Plateau {
	
	public int dimX;
	public int dimY;
	
	private List<Rover> rovers = new ArrayList<Rover>();
	
	public Plateau(int dimX, int dimY) {
		
		this.dimX = dimX;
		this.dimY = dimY;
	}
	
	public void addRover(Rover rover) {
		rovers.add(rover);
	}
	
	public boolean isOccupied(Position position) {
		for (Rover r : rovers) {
			if (r.hasPosition(position)) {
				return true;
			}
		}
		
		return false;
	}
}
