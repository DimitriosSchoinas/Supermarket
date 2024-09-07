package Supermarket;

public class EmptyCartException extends Exception {

private static final String MESSAGE = "Carrinho vazio!\n";
	
	public EmptyCartException() {
		super(MESSAGE);
	}
}
