//package javaapplication4;


public interface Sellable extends Comparable<Sellable> {
	
	
	float getPrice();

	void changePrice(float newPrice);
	void changeName(String newName);
	
	public int getQuantity();
	
}
