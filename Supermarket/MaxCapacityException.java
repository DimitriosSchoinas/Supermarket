package Supermarket;

public class MaxCapacityException extends Exception {

private static final String MESSAGE = "Capacidade excedida!\n";
	
	public MaxCapacityException() {
		super(MESSAGE);
	}
}
