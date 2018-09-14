
public class UnknownInstructionException extends RuntimeException {

	public UnknownInstructionException(char instruction) {
		super("Unknown instruction '" + instruction + "'!");
	}
}
