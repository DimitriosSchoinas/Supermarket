package Supermarket;

import java.util.Iterator;

public interface Cart {

	void addProduct(Product product);
	boolean isFull(int volumeToAdd);
	void removeProduct(Product product);
	boolean productExists(Product product);
	Iterator<Product> iterator();
	int getActualCapacity();
	int getTotalPrice();
	void cleanCart();
}
