package Supermarket;

import java.util.Iterator;

public interface SupermarketSystem {

	void createCart(String identification, int capacity) throws ExistentCartException;

	void createProduct(String productName, int productPrice, int productVolume) throws ExistentProductException;

	void deposit(String productName, String cartId)throws InexistentCartException, InexistentProductException,MaxCapacityException;

	void remove(String productName, String cartId)throws InexistentCartException,InexistentProductInCartException;

	Iterator<Product> listProducts(String cartId) throws EmptyCartException, InexistentCartException;

	int getTotalCartPrice(String cartID)throws InexistentCartException,EmptyCartException;

	void cleanCart(String cartID)throws InexistentCartException, EmptyCartException;

}
