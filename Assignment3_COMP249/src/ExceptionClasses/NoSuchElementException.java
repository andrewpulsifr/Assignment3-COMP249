package ExceptionClasses;

public class NoSuchElementException extends Exception {

	public NoSuchElementException(){
		super("---------------------------------------------------"+
		"\nError: Index out of bounds. Please try again."+
		"\n---------------------------------------------------\n");
	}
	
}
