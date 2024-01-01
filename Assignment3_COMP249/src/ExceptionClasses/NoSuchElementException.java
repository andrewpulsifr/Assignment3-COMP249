// -----------------------------------------------------
// Assignment 3
// Question: III
// Written by: Andrew Pulsifer (40234525)
// ---------------------------------

package ExceptionClasses;

/**
 * Custom exception class representing an exception when an index is out of bounds.
 * Implemented to avoid repetitively sending text to param constructor of NoSuchElementException class
 * Extends {@code Exception}.
 */
public class NoSuchElementException extends Exception {

	/**
     * Constructs a new {@code NoSuchElementException} with a default error message.
     * The error message indicates that the index is out of bounds and advises the user to try again.
     */
	public NoSuchElementException(){
		super("---------------------------------------------------"+
		"\nError: Index out of bounds. Please try again."+
		"\n---------------------------------------------------\n");
	}
	
}
