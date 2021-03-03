
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
		switch (heading) {
			case EAST: return new Position(x + 1, y);
			case NORTH: return new Position(x, y + 1);
			case SOUTH: return new Position(x, y - 1);
			case WEST: return new Position(x - 1, y);
			default: throw new RuntimeException("Should not get here!");
		}
	}
}
