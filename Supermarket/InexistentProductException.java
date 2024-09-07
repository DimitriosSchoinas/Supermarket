package Supermarket;

public class InexistentProductException extends Exception {

private static final String MESSAGE = "Artigo inexistente!\n";
	
	public InexistentProductException() {
		super(MESSAGE);
	}
}
