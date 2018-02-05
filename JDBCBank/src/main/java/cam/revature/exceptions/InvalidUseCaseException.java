package cam.revature.exceptions;

public class InvalidUseCaseException extends Exception {

	@Override
	public String getMessage() {
		return "Invalid choice! Please use the provided numbers for choosing an operation.";
	}
	private static final long serialVersionUID = 1L;
}
