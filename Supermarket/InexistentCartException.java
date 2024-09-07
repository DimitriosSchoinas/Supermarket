package Supermarket;

public class InexistentCartException extends Exception {

private static final String MESSAGE = "Carrinho inexistente!\n";
	
	public InexistentCartException() {
		super(MESSAGE);
	}
}
