package cam.revature.exceptions;

public class OverdraftException extends Exception {

	@Override
	public String getMessage() {
		return "Overdraft warning! User attempted to withdraw more money than they have in that account.";
	}
	private static final long serialVersionUID = 1L;

}
