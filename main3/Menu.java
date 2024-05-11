import javafx.scene.control.Alert;
import javafx.application.Platform;
import javafx.stage.Stage;
import java.util.List;
import java.util.ArrayList;


public class Menu {




    // Data-Fields 
    
    public static ArrayList<FoodItem> foodItemsInMenuList = new ArrayList<>(); 



    // Methods 
    
    public static ArrayList<FoodItem> getFoodItemsInMenu() {
        return foodItemsInMenuList;  
    }
    public static void addInitialItems() {
        foodItemsInMenuList.add(new FoodItem("Burger", 150));
        foodItemsInMenuList.add(new FoodItem("Pizza", 110));
        foodItemsInMenuList.add(new FoodItem("Salad", 50));
        foodItemsInMenuList.add(new FoodItem("Soup", 40));
        foodItemsInMenuList.add(new FoodItem("Coffe", 50));
        foodItemsInMenuList.add(new FoodItem("Water", 10)); 
    } 
    public static void addFoodItemToMenu(String name, float price) {

            
        if(price > 0) {
            boolean validName  = true;

            // compare the names case-insensitive to check if the provided name is a duplicate 
            String lowerCaseName = name.toLowerCase(); 
            for(FoodItem food : foodItemsInMenuList) {
                if(lowerCaseName.equals(food.getName().toLowerCase())) {
                    validName = false;
                    AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid input", "A Food item with that name already exists, Please Enter another Name...");
                    break;
                } 
            }              
            if(validName == true) {
                foodItemsInMenuList.add(new FoodItem(name, price)); 
                AlertClass.showAlert(Alert.AlertType.INFORMATION, "Success Message", "Sucessfully added the food item "+name+" with price $"+price);
            }
        } 
        else {
            AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid input", "Please Enter a Valid Price..."); 
        }


     }
    public static void editFoodItemFromMenu(String oldName, int oldPrice, String newName, int newPrice) {

        if(newPrice >= 0) {
            boolean validName  = false;
            // compare the old name case-insensitive with the names in the menu to check if doesn't exist 
            String lowerCaseOldName = oldName.toLowerCase(); 
            for(FoodItem food : foodItemsInMenuList) {
                if(lowerCaseOldName.equals(food.getName().toLowerCase())) {
                    validName = true;
                        AlertClass.showAlert(Alert.AlertType.INFORMATION, "Success Message", "Sucessfully edited the food item "+food.getName()+" with old price $"+food.getPrice()+" to "+newName+" with new price $"+newPrice);
                    food.changeName(newName); 
                    food.changePrice(newPrice); 
                    break;
                } 
            }              
            if(validName == false) {
                AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "the Food Item name provided doesn't exist in Menu, Please Enter a Valid Name..."); 
            }

        } 
        else {
            AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "Please Enter a Valid Price...");
        }
         

         
    }
    public static void deleteFoodItemFromMenu(String name) {

        boolean validName  = false;

        for(int i = 0; i < foodItemsInMenuList.size(); i++) {
            if(name.equals(foodItemsInMenuList.get(i).getName())) {
                validName = true;
                foodItemsInMenuList.remove(i); 
                AlertClass.showAlert(Alert.AlertType.INFORMATION, "Success Message", "Sucessfully removed the food item "+name);
                break;
            } 
        }              
        if(validName == false) {
            AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "Food Item name entered doesn't exist, please enter the correct Food Item name..."); 
        }
         
    }
    public static boolean checkValidInputs(String foodName, int foodPrice) {
        // check if price provided is +ve
        if(foodPrice>=0) {
            // if so check if new foodName provided is valid 
            for(int i = 0; i < foodName.length(); i++) {
                if (!Character.isLetter(foodName.charAt(i)) && !Character.isWhitespace(foodName.charAt(i))) {
                    AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid Input", "Food Name must consist of alphabetical letters and white spaces only, please enter a valid Food Name...");
                    return false;
                }    
            } 
        }
        else {
            AlertClass.showAlert(Alert.AlertType.ERROR, "Invlid Input", "Please enter a valid price..."); 
            return false;
        } 
        return true; 
    }
    public static boolean checkValidInputs(String foodOldName, int foodOldPrice, String foodNewName, int foodNewPrice) {
        // check if prices provided are +ve
        if((foodOldPrice>=0) && (foodNewPrice>=0)) {
            // if so check if new foodName provided is valid 
            for(int i = 0; i < foodNewName.length(); i++) {
                if (!Character.isLetter(foodNewName.charAt(i)) && !Character.isWhitespace(foodNewName.charAt(i))) {
                    AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid Input", "Food Name must consist of alphabetical letters and white spaces only, please enter a valid Food Name...");
                    return false;
                }    
            } 
        }
        else {
            AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid price..."); 
            return false;
        } 
        return true; 
    }





}
