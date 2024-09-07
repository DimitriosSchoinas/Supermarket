package Supermarket;

public class ProductClass implements Product {

	private String name;
	private int volume, price;
	
	public ProductClass(String name, int price, int volume) {
		
		this.name = name;
		this.volume = volume;
		this.price = price;
	}

	@Override
	public int getPrice() {
		
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getVolume() {
		return volume;
	}
}
