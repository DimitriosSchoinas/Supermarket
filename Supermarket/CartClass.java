package Supermarket;

import java.util.Iterator;
import java.util.LinkedList;

public class CartClass implements Cart {

	private String identifier;
	private int maxCapacity;
	private int actualCapacity;
	private int totalPrice;
	private LinkedList<Product> cartProducts;
	
	public CartClass(String id, int capacity) {
		
		this.identifier = id;
		this.maxCapacity = capacity;
		actualCapacity = 0;
		totalPrice = 0;
		cartProducts = new LinkedList<Product>();
	}

	@Override
	public void addProduct(Product product) {
		
		cartProducts.add(product);
		actualCapacity = actualCapacity + product.getVolume();
		totalPrice = totalPrice + product.getPrice();
		
	}

	@Override
	public boolean isFull(int volumeToAdd) {
		
		return actualCapacity + volumeToAdd > maxCapacity;
	}

	@Override
	public void removeProduct(Product product) {
		
		cartProducts.remove(product);
		actualCapacity = actualCapacity - product.getVolume();
		totalPrice = totalPrice - product.getPrice();
		
	}

	@Override
	public boolean productExists(Product product) {
		return cartProducts.contains(product);
	}

	@Override
	public Iterator<Product> iterator() {
		
		return cartProducts.iterator();
	}

	@Override
	public int getActualCapacity() {
		
		return actualCapacity;
	}

	@Override
	public int getTotalPrice() {
		
		return totalPrice;
	}

	@Override
	public void cleanCart() {
		actualCapacity = 0;
		totalPrice = 0;
		cartProducts.removeAll(cartProducts);
	}
}
