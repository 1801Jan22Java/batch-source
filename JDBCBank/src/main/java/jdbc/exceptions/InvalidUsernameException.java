package jdbc.exceptions;

public class InvalidUsernameException extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		
		return "Username not found in the database, try entering name again";
	}

}
