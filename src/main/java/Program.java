import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter dimensions of the plateau (in the form x y):");
		String dimensions = scanner.nextLine();
		
		Plateau p = createPlateauFromDimensions(dimensions);
		
		int i = 0;
		while (true) {

			i++;
			
			String name = "Rover " + i;
			
			System.out.print("Enter drop information for " + name + " (in the form x y h):");
			String dropInfo = scanner.nextLine();
						
			Rover r = dropRover(name, p, dropInfo);
			System.out.println("Report: " + r.reportPosition());

			System.out.print("Enter instructions for " + name + " (in the form LMRMMMLMM):");
			String instructions = scanner.nextLine();

			r.processInstructions(instructions);
			System.out.println("Report: " + r.reportPosition());
		}
	}
	
	private static Rover dropRover(String roverId, Plateau p, String dropInfo) {		
		
		Rover r = new Rover(roverId);
		r.dropRover(p,  dropInfo);
		
		return r;
	}

	private static Plateau createPlateauFromDimensions(String dimensions) {
		
		String[] parts = dimensions.split(" ");
		int dimX = Integer.parseInt(parts[0]);
		int dimY = Integer.parseInt(parts[1]);
		
		return new Plateau(dimX, dimY);
	}
}
