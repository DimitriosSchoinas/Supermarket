package Supermarket;

public class InexistentProductInCartException extends Exception {

private static final String MESSAGE = "Artigo inexistente no carrinho!\n";
	
	public InexistentProductInCartException() {
		super(MESSAGE);
	}
}
