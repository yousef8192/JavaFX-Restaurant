
import java.util.ArrayList;
import java.util.List;


public class FoodItem extends Sellable   {
    
    // Data-Fields
	private String name;
	private float price;


    // Constructors 
    FoodItem(String n , float price){
		this.name = n;
		this.price = price;
	}
   
    // Getters 
    public String getName() {
        return this.name;
    }	     
    public float getPrice() {
        return this.price;
    }

	     
    // Setters
    public void changeName(String name) {
		this.name = name;
	}
    public void changePrice(float price) {
		this.price = price;
	}

}
