
import java.util.Date;
import java.util.Map;
import java.util.HashMap;


public class Order implements Pricable {


    // Data-Fields 
    private Map<FoodItem, Integer> orderFoodItems = new HashMap<>();
    private Table orderTable; 
    private User orderUser; 
	private Date orderDate;
	private int orderDuration;
	private float orderPrice;
 
    


   // Constructors	
    Order(User orderUser, Date orderDate, int orderDuration, Map<FoodItem, Integer> orderFooditems, Table orderTable){	
		this.orderUser = orderUser;
		this.orderDate = orderDate;
		this.orderDuration = orderDuration;
		this.orderFoodItems = orderFoodItems;
		this.orderTable = orderTable;
        this.orderTable.setIsAvailable(false);
        this.orderPrice = this.calcPrice();
	}		


    
    // Getters Methods
    public Map<FoodItem, Integer> getOrderFood() {
        return this.orderFoodItems;
    }
    public User getUser() {
        return this.orderUser;
    }
    public Date getDate() {
        return this.orderDate;
    }
    public int getDuration() {
        return this.orderDuration;
    }
    public float getPrice() {
        return this.orderPrice;
    }
    public Table getTable() {
        return this.orderTable;
    }


    
    // Setters & Other Methods
    public void addFood(Map<FoodItem, Integer> orderFoodItems) {
		this.orderFoodItems = orderFoodItems;
    }
    public void setUser() {
		this.orderUser = orderUser;
    }
    public void setDate() {
		this.orderDate = orderDate;
    }
    public void setOrderDuration() {
		this.orderDuration = orderDuration;

    }
    public void setOrderTable() {
		this.orderTable = orderTable;
    }	
    private float calcPrice() {
        float totalPrice = 0;
        for (Map.Entry<FoodItem, Integer> entry : this.orderFoodItems.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue(); // price = price + foodPrice*quantity
        }
        return totalPrice; 
    } 


    @Override
    public int compareTo(Pricable other) {
		   if( this.getPrice() > other.getPrice() )
			   return 1;
	       else if ( this.getPrice() == other.getPrice())
	    	   return 0;
	       return -1;
	}



}
