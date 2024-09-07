package Supermarket;

public class ExistentProductException extends Exception {

	private static final String MESSAGE = "Artigo existente!\n";
	
	public ExistentProductException() {
		super(MESSAGE);
	}
}
