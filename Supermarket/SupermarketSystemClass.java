package Supermarket;

import java.util.HashMap;
import java.util.Iterator;


public class SupermarketSystemClass implements SupermarketSystem{

	private HashMap<String, Cart> cart;
	private HashMap<String, Product> product;
	
	public SupermarketSystemClass() {
		cart = new HashMap<String , Cart>();
		product = new HashMap<String , Product>();
	}

	@Override
	public void createCart(String identification, int capacity) throws ExistentCartException {
	
		if(cart.containsKey(identification)) {
			throw new ExistentCartException();
		}
		
		cart.put(identification, new CartClass(identification,capacity));
		
	}

	@Override
	public void createProduct(String productName, int productPrice, int productVolume)	throws ExistentProductException {
		
		if(product.containsKey(productName)) {
			throw new ExistentProductException();
		}
		
		product.put(productName, new ProductClass(productName,productPrice,productVolume));
		
	}

	@Override
	public void deposit(String productName, String cartId) throws InexistentCartException,InexistentProductException,MaxCapacityException {
		
		if(!cart.containsKey(cartId)) {
			throw new InexistentCartException();
		}
		if(!product.containsKey(productName)) {
			throw new InexistentProductException();
		}
		if(cart.get(cartId).isFull(product.get(productName).getVolume())) {
			throw new MaxCapacityException();
		}
		
		cart.get(cartId).addProduct(product.get(productName));
		
	}

	@Override
	public void remove(String productName, String cartId)throws InexistentCartException, InexistentProductInCartException {
		
		if(!cart.containsKey(cartId)) {
			throw new InexistentCartException();
		}
		if(!cart.get(cartId).productExists(product.get(productName))) {
			throw new InexistentProductInCartException();
		}
		cart.get(cartId).removeProduct(product.get(productName));
	}

	@Override
	public Iterator<Product> listProducts(String cartId) throws EmptyCartException, InexistentCartException {
		
		if(!cart.containsKey(cartId)) {
			throw new InexistentCartException();
		}
		if(cart.get(cartId).getActualCapacity() == 0) {
			throw new EmptyCartException();
		}
		
		
		return cart.get(cartId).iterator();
	}

	@Override
	public int getTotalCartPrice(String cartId) throws InexistentCartException, EmptyCartException {
		

		if(!cart.containsKey(cartId)) {
			throw new InexistentCartException();
		}
		if(cart.get(cartId).getActualCapacity() == 0) {
			throw new EmptyCartException();
		}
		return cart.get(cartId).getTotalPrice();
	}

	@Override
	public void cleanCart(String cartId) throws InexistentCartException, EmptyCartException {

		if(!cart.containsKey(cartId)) {
			throw new InexistentCartException();
		}
		if(cart.get(cartId).getActualCapacity() == 0) {
			throw new EmptyCartException();
		}
		cart.get(cartId).cleanCart();
		
	}
}
