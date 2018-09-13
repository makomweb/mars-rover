
public class Program {

	public static void main(String[] args) {

		Plateau p = new Plateau(5, 5);
		
		{
			Rover rover = new Rover("One");
			rover.dropRover(p, "1 2 N");
			rover.processInstructions("LMLMLMLMM");
			System.out.println("Rover report - " + rover.toString());
		}

		{
			Rover rover = new Rover("Two");
			rover.dropRover(p, "3 3 E");
			rover.processInstructions("MMRMMRMRRM");
			System.out.println("Rover report - " + rover.toString());
		}
	}
}
