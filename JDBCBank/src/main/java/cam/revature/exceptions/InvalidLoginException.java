package cam.revature.exceptions;

public class InvalidLoginException extends Exception {

	@Override
	public String getMessage() {
		return "Invalid username/password combination! Please try logging in with registered credentials.";
	}
	private static final long serialVersionUID = 1L;

}
