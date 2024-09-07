package Supermarket;

public class ExistentCartException extends Exception {

	private static final String MESSAGE = "Carrinho existente!\n";
	public ExistentCartException() {
		super(MESSAGE);
	}
}
