import java.util.ArrayList;

public class Hall {

    // Data-Fields 
    public static ArrayList<Table> allTables = new ArrayList<>(); 
    public static ArrayList<Table> availableTables = new ArrayList<>(); 
    public static int numTables = 0; 

    // Getters 
    public static ArrayList<Table> getTables() {
        return allTables;  
    }
    public static ArrayList<Table> getAvailableTables() {
        return availableTables;  
    }
    public static int getNumTables() {
        return numTables; 
    }    
    public static Table getTable(int n) {
        return allTables.get(n); 
    }    

    // Setters and Other Methods 
    public static void addTable() {
        numTables++;
        int newTableNumber = allTables.size();
        allTables.add(new Table(newTableNumber));
    } 
    public static void addMultipleTables(int n) {
        numTables+=n;
        int oldSize = allTables.size();
        for(int i = 0; i < n; i++) {
            allTables.add(new Table(oldSize+i)); 
        }  
    } 
    public static void removeTable() { 
        numTables--;
        int tableNumToRemove = allTables.size()-1;
        allTables.remove(tableNumToRemove);
        for(int i = 0; i < availableTables.size(); i++) {
            if(availableTables.get(i).getTableNumber()==tableNumToRemove) {
                availableTables.remove(i); 
            } 
        }             

    } 


} 
