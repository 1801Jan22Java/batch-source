package cam.revature.exceptions;

public class AccountNotFoundException extends Exception {

	@Override
	public String getMessage() {
		return "The specified account either does not exist or is not yours to modify.";
	}

	private static final long serialVersionUID = 1L;
}
