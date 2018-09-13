
public class Position {

	public int x;
	public int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
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
}
