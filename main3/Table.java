
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Table {


    	private int tableNumber;
        private boolean isAvailable;
	    private Order currentOrder;


    // Constructors        
    Table(int tableNumber){
        this.tableNumber = tableNumber;
        this.isAvailable = true; // Initially, the table is available
	}


    // Getters
    public int getTableNumber() {
        return tableNumber;
    }
    public Order getCurrentOrder() {
		return this.currentOrder;
	}
    public boolean isAvailable() {
        return isAvailable;
    }


    // Setters 
    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }  
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    // Other Methods	
    public void bookTable(int tableNumber, Order currentOrder) {
		this.currentOrder = currentOrder;
		this.tableNumber = tableNumber;
		this.isAvailable = false;
	}
	

    // toString() method implementation	
        @Override
    public String toString() {
        return "Table " + tableNumber ;
    }

}
