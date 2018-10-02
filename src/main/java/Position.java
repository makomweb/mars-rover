
public class Position {

	public int x;
	public int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(Position other) {
		this.x = other.x;
		this.y = other.y;
	}
	
	public boolean isEqual(Position other) {
		return x == other.x && y == other.y;
	}
	
	@Override
	public String toString() {
		return x + " " + y;
	}
	
	public boolean IsOnPlateau(Plateau p) {
		if (x < 0 || x > p.dimX) {
			return false;
		}
		
		if (y < 0 || y > p.dimY) {
			return false;
		}
		
		return true;
	}
	
	public Position moveForward(Heading heading) {
		Position newPosition = null;
		
		switch (heading) {
			case EAST: newPosition = new Position(x + 1, y); break;
			case NORTH: newPosition = new Position(x, y + 1); break;
			case SOUTH: newPosition = new Position(x, y - 1); break;
			case WEST: newPosition = new Position(x - 1, y); break;
		}

		return newPosition;
	}
}
