package jdbc.exceptions;

public class InvalidPasswordException  extends Exception{

private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		
		return "entered password not found in the database for that username try entering again";
	}

}
