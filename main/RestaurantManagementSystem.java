
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.geometry.Pos;   

                             
public class RestaurantManagementSystem extends Application {



/////////////////////////////////////////////////// Class's Data-Fields

    // order related data-fields
    private Date orderTime=null;
    private Label totalPriceLabel;
    private Map<FoodItem, Integer> selectedItems = new HashMap<>();


    // ArrayList that holds food items present in the menu 
    private static ArrayList<FoodItem> foodItemsInMenuList = new ArrayList<>(); 
         
    // ArrayList that holds all users registered in the JavaFX Restaurant
    private static ArrayList<User> users = new ArrayList<>(); 

    // index of the Array list for the user currently logged in  
    private static int currentUserIndex = 0; 
       
    // main primaryStage used in all pages 
    private Stage primaryStage;




/////////////////////////////////////////////////// javaFX start() Method
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        enterPage();
    }







/////////////////////////////////////////////////// favaFX Page-Display Methods

    private void enterPage() {

        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("Welcome to JavaFX Restaurant!!");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the Buttons
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 
         
        // create the Buttons  
        Button loginButton      = new Button("Login"); 
        Button registerButton   = new Button("Register"); 

        // adjust their margin
        VBox.setMargin(loginButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(registerButton, new Insets(20, 0, 30, 0));

        // adjust their size in pixels 
        loginButton.setPrefSize(200,100); 
        registerButton.setPrefSize(200,100); 
        
        // customize Buttons style
        loginButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        registerButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
         
        // add the Buttons to the VBox 
        vBox.getChildren().add(loginButton);
        vBox.getChildren().add(registerButton);

        // create action for the Buttons
        loginButton.setOnAction(e -> {loginPage();});
        registerButton.setOnAction(e -> {registerPage();});

        // create a Borderpane and attach hBox and vBox to it
        BorderPane enterPagePane = new BorderPane();
        enterPagePane.setTop(hBox);
        enterPagePane.setCenter(vBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(enterPagePane, 650, 600);
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setScene(scene);  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void loginPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Login");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the TextFileds
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create TextFields for the username and password 
        TextField userNameField = new TextField();
        userNameField.setPromptText("Username");
        PasswordField pwdField = new PasswordField();
        pwdField.setPromptText("Password");

        // Customize the textFields
        userNameField.setMaxWidth(400);
        userNameField.setMinWidth(400);
        pwdField.setMaxWidth(400);
        pwdField.setMinWidth(400);
        userNameField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        pwdField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 

        // adjust margin of the TextFields Button
        VBox.setMargin(userNameField, new Insets(20, 0, 30, 0));
        VBox.setMargin(pwdField, new Insets(20, 0, 30, 0));

        // add the TextFields to the VBox 
        vBox.getChildren().add(userNameField);
        vBox.getChildren().add(pwdField);

        // Create another HBox for the Bottom control Buttons 
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(123);
        // hBox.setStyle("-fx-background-color: gold");
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create login Button & back Button then customize them
        Button loginButton = new Button("Login");
        Button backButton = new Button("Back");
        loginButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        

        // add the buttons in it 
        controlButtonsHBox.getChildren().add(backButton);
        controlButtonsHBox.getChildren().add(loginButton);
 
        // create action for the login Button
        loginButton.setOnAction(e -> {

            String userName = userNameField.getText();
            String password = pwdField.getText();
            boolean validCredentials = false; 

            for(int i = 0; i < users.size(); i++) {
                if((userName.equals(users.get(i).getUserName())) && (password.equals(users.get(i).getPassword()))) {
                    validCredentials = true; 
                    currentUserIndex = i;
                    break;
                }
            } 

            if (validCredentials == true) {
                if(users.get(currentUserIndex).getUserName() == "admin") {
                    adminLoggedInPage(); 
                } 
                else {
                    userLoggedInPage(); 
                }
            } 
            else {
                // Show error message for invalid credentials
                showAlert(Alert.AlertType.ERROR, "Error", "Invalid username or password");
            }

        });

        // create action for the back Button
        backButton.setOnAction(e -> {enterPage();});
         
 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 600);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void registerPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Register");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the TextFileds
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create TextFields for the username and password 
        TextField userNameField = new TextField();
        PasswordField pwdField = new PasswordField();
        TextField phoneNumberField = new TextField();
        TextField addressField = new TextField();
        userNameField.setPromptText("Username");
        pwdField.setPromptText("Password");
        phoneNumberField.setPromptText("Phone Number");
        addressField.setPromptText("Address");

        // Customize the textFields
        userNameField.setMinWidth(400);
        userNameField.setMaxWidth(400);
        pwdField.setMinWidth(400);
        pwdField.setMaxWidth(400);
        phoneNumberField.setMinWidth(400);
        phoneNumberField.setMaxWidth(400);
        addressField.setMinWidth(400);
        addressField.setMaxWidth(400);
        userNameField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        pwdField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        phoneNumberField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        addressField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 

        // adjust margin of the TextFields Button
        VBox.setMargin(userNameField, new Insets(20, 0, 30, 0));
        VBox.setMargin(pwdField, new Insets(20, 0, 30, 0));
        VBox.setMargin(phoneNumberField, new Insets(20, 0, 30, 0));
        VBox.setMargin(addressField, new Insets(20, 0, 30, 0));

        // add the TextFields to the VBox 
        vBox.getChildren().add(userNameField);
        vBox.getChildren().add(pwdField);
        vBox.getChildren().add(phoneNumberField);
        vBox.getChildren().add(addressField);

        // Create another HBox for the Bottom control Buttons 
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(95);
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create Register Button & back Button then customize them
        Button registerButton = new Button("Register");
        Button backButton = new Button("Back");
        registerButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        

        // add the buttons in it
        controlButtonsHBox.getChildren().add(backButton);
        controlButtonsHBox.getChildren().add(registerButton);
 
        // create action for the register Button
        registerButton.setOnAction(e -> {

            String userName = userNameField.getText();
            String password = pwdField.getText();
            String phoneNumber = phoneNumberField.getText();
            String address = addressField.getText();

            boolean errorExists = false;
            boolean duplicateExists = false;

            errorExists = checkErrorsInInput(userName, password, phoneNumber, address);
            
            if(errorExists == false) {
                duplicateExists = checkDuplicatesInInput(userName, phoneNumber);
                if(duplicateExists == false) {
                    // add the user to the database 
                    addUser(userName, password, phoneNumber, address); 
                     
                    // display Successful registration message 
                    showAlert(Alert.AlertType.INFORMATION, "Successful Registration!!!", "Congratulations! You have sucessfully registered in the JavaFX Restaurant, enjoy your meals!");

                    // go back to the enter page to enter the new credentials and log in
                    enterPage();
                }            
            }
                                                  
        });

        // create action for the back Button
        backButton.setOnAction(e -> {enterPage();});
         
 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 850);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }



    private void userLoggedInPage() {

        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("Welcome back "+users.get(currentUserIndex).getUserName()+"!!");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the Buttons
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 
         
        // create the Buttons  
        Button menuButton       = new Button("Menu"); 
        Button orderButton      = new Button("Order"); 
        Button logoutButton     = new Button("Logout"); 

        // adjust their margin
        VBox.setMargin(orderButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(logoutButton, new Insets(20, 0, 30, 0));

        // adjust their size in pixels 
        orderButton.setPrefSize(200,100); 
        logoutButton.setPrefSize(200,100); 
        
        // customize Buttons style
        orderButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        logoutButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
         
        // add the Buttons to the VBox 
        vBox.getChildren().add(orderButton);
        vBox.getChildren().add(logoutButton);

        // create action of logout Button
        orderButton.setOnAction(e -> {tableRegistrationPage();});
        logoutButton.setOnAction(e -> {
            currentUserIndex = 0;
            enterPage();
        });

        // create a Borderpane and attach hBox and vBox to it
        BorderPane enterPagePane = new BorderPane();
        enterPagePane.setTop(hBox);
        enterPagePane.setCenter(vBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(enterPagePane, 650, 600);
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setScene(scene);  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void tableRegistrationPage() {
    
    // Prompt the user to select a table
    List<Table> availableTables = Table.getAvailableTables();                          // Implement this method to retrieve available tables
    ChoiceDialog<Table> tableChoiceDialog = new ChoiceDialog<>(null, availableTables); // null is the default value
    tableChoiceDialog.setHeaderText("Select a table:");
    Optional<Table> selectedTableResult = tableChoiceDialog.showAndWait();
    // The previous line presents the tableChoiceDialog to the user and waits for the user's interaction
    // Optional is a container object that may or may not contain a non-null value

    boolean validInput = false;

    if (selectedTableResult.isPresent()) {

        Table selectedTable = selectedTableResult.get();

        // Prompt the user to input order time
        while (!validInput) {

        TextInputDialog orderTimeDialog = new TextInputDialog();
        orderTimeDialog.setHeaderText("Enter order time (DD/MM/YYYY HH:MM)");
        Optional<String> orderTimeResult = orderTimeDialog.showAndWait();
        
        
        if (orderTimeResult.isPresent()) {
            
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Parse the order time string to Date
           
            try {

                sdf.setLenient(false); 
                orderTime = sdf.parse(orderTimeResult.get());
                validInput=true;
                selectedTable.setOrderTime(orderTime);
                
                // Prompt the user to input the duration
                TextInputDialog durationDialog = new TextInputDialog();
                durationDialog.setHeaderText("Enter duration in minutes:");
                Optional<String> durationResult = durationDialog.showAndWait();

                if (durationResult.isPresent()) {
                    int duration = Integer.parseInt(durationResult.get());
                    selectedTable.setDuration(duration);
                    menuSelectionPage(); // Proceed with other operations (e.g., menu selection)
                }

            } 
            catch (ParseException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid input format", "Please enter the order time in the correct format (DD/MM/YY HH:MM)"); 
            }
            catch (NumberFormatException e) {
                showAlert(Alert.AlertType.ERROR, "Invalid input format", "Please enter the duration in a valid format...");
            }
        } else {
            validInput=true;
            // Exit the method if the dialog is cancelled
            // Order time input cancelled
        }
        
    
    }
}} 

    private void menuSelectionPage() {
         
         
        VBox menuSelectionLayout = new VBox(10);
        menuSelectionLayout.setPadding(new Insets(20));
        Label menuLabel = new Label("Select Food Items:");

        HBox foodItemsLayout = new HBox(25);
        VBox foodItemsCheckBoxVBox = new VBox(13.5);
        VBox foodItemsPriceVBox = new VBox(13.5);
        VBox foodItemsSpinnerVBox  = new VBox(5);
        foodItemsLayout.setAlignment(javafx.geometry.Pos.CENTER); 
        foodItemsCheckBoxVBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT); 
        foodItemsPriceVBox.setAlignment(javafx.geometry.Pos.CENTER); 
        foodItemsSpinnerVBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT); 

        for (FoodItem foodItem : getFoodItemsInMenu()) {

            // create a check box for the food item
            CheckBox checkBox = new CheckBox(foodItem.getName());

            // create a quantity spinner for the food item 
            Spinner<Integer> quantitySpinner = new Spinner<>(0, 10, 0);
            quantitySpinner.setEditable(true);
                        
            // create javaFX HBox and configure it to hold the menu information 
            HBox itemCheckBoxLayout = new HBox(10);
            HBox itemSpinnerLayout = new HBox(10);
            itemCheckBoxLayout.setAlignment(javafx.geometry.Pos.CENTER_LEFT); 
            itemSpinnerLayout.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);   
            itemCheckBoxLayout.getChildren().add(checkBox);
            itemSpinnerLayout.getChildren().addAll(new Label("Quantity:"), quantitySpinner);

            checkBox.setOnAction(e -> {

                if (checkBox.isSelected()) {
                    selectedItems.put(foodItem, quantitySpinner.getValue());
                } else {
                    selectedItems.remove(foodItem);
                }
                updateTotalPrice();
            });
            quantitySpinner.getValueFactory().valueProperty().addListener((observable, oldValue, newValue) -> {
                if (checkBox.isSelected()) {
                    selectedItems.put(foodItem, newValue);//upate the map 
                    updateTotalPrice();
                }             
            });
            Label priceLabel = new Label("$"+foodItem.getPrice());
            foodItemsPriceVBox.getChildren().add(priceLabel);   
            foodItemsCheckBoxVBox.getChildren().add(itemCheckBoxLayout);   
            foodItemsSpinnerVBox.getChildren().add(itemSpinnerLayout);   
        }

        foodItemsLayout.getChildren().addAll(foodItemsCheckBoxVBox, foodItemsPriceVBox, foodItemsSpinnerVBox); 

        totalPriceLabel = new Label("Total Price: $0.00");
        Button submitButton = new Button("Submit Order");
        submitButton.setOnAction(e ->{

            boolean isValidSelection = false;

            for (Map.Entry<FoodItem, Integer> entry : selectedItems.entrySet()) {
                if (entry.getValue() > 0) {
                    isValidSelection = true;
                    break;
                }
            }

            if (!isValidSelection) {
                // Show an alert to inform the user to select at least one item
                showAlert(Alert.AlertType.WARNING, "No Food Items Selected", "Please select at least one food item and specify the quantity."); 
                // Exit the method without processing the order
                return; 
            }
            submitOrder(orderTime.toString());
        });

        menuSelectionLayout.getChildren().addAll(menuLabel, foodItemsLayout, totalPriceLabel, submitButton);
        Scene scene = new Scene(menuSelectionLayout, 500, 600);
        primaryStage.setScene(scene);
    }

    private void orderSubmissionPage(String orderTime, double totalPrice) {
    // Create labels to display order time and total price
    Label orderTimeLabel = new Label("Order Time: " + orderTime);
    Label totalPriceLabel = new Label("Total Price: $" + String.format("%.2f", totalPrice));

    // Create a button to close the stage
    Button closeButton = new Button("Close");
    closeButton.setOnAction(e -> userLoggedInPage());

    // Create a layout to arrange the components
    VBox layout = new VBox(20);
    layout.setPadding(new Insets(20));
    layout.getChildren().addAll(orderTimeLabel, totalPriceLabel, closeButton);

    // Update the scene with the new layout
    Scene scene = new Scene(layout, 300, 200);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Order Confirmation");
}



    private void adminLoggedInPage() {

        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("Welcome back "+users.get(currentUserIndex).getUserName()+"!!");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBox for the Buttons
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 
         
        // create the Buttons  
        Button addButton       = new Button("Add Item"); 
        Button editButton      = new Button("Edit Item"); 
        Button deleteButton    = new Button("Delete Item"); 
        Button logoutButton    = new Button("Logout"); 

        // adjust their margin
        VBox.setMargin(addButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(editButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(deleteButton, new Insets(20, 0, 30, 0));
        VBox.setMargin(logoutButton, new Insets(20, 0, 30, 0));

        // adjust their size in pixels 
        addButton.setPrefSize(300,100); 
        editButton.setPrefSize(300,100); 
        deleteButton.setPrefSize(300,100); 
        logoutButton.setPrefSize(300,100); 
        
        // customize Buttons style
        addButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        editButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        deleteButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        logoutButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
         
        // add the Buttons to the VBox 
        vBox.getChildren().add(addButton);
        vBox.getChildren().add(editButton);
        vBox.getChildren().add(deleteButton);
        vBox.getChildren().add(logoutButton);

        // create action for the Buttons
        addButton.setOnAction(e -> {addItemPage();});
        editButton.setOnAction(e -> {editItemPage();});
        deleteButton.setOnAction(e -> {deleteItemPage();});
        logoutButton.setOnAction(e -> {enterPage();});

        // create a Borderpane and attach hBox and vBox to it
        BorderPane enterPagePane = new BorderPane();
        enterPagePane.setTop(hBox);
        enterPagePane.setCenter(vBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(enterPagePane, 650, 750);
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setScene(scene);  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void addItemPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Add Item");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);
        // Create a VBox for the TextFileds
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create TextFields for the username and password 
        TextField itemNameField = new TextField();
        TextField itemPriceField = new TextField();
        itemNameField.setPromptText("Item Name...");
        itemPriceField.setPromptText("Item Price...");


        // Customize the textFields
        itemNameField.setMinWidth(400);
        itemNameField.setMaxWidth(400);
        itemPriceField.setMinWidth(400);
        itemPriceField.setMaxWidth(400);
        itemNameField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        itemPriceField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 


        // adjust margin of the TextFields Button
        VBox.setMargin(itemNameField, new Insets(20, 0, 30, 0));
        VBox.setMargin(itemPriceField, new Insets(20, 0, 30, 0));


        // add the TextFields to the VBox 
        vBox.getChildren().add(itemNameField);
        vBox.getChildren().add(itemPriceField);


        // Create another HBox for the Bottom control Buttons 
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(90);
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create add item Button & back Button then customize them
        Button addItemButton = new Button("Add Item");
        Button backButton = new Button("Back");
        addItemButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        

        // add the buttons in it 
        controlButtonsHBox.getChildren().add(backButton);
        controlButtonsHBox.getChildren().add(addItemButton);

         
         
        // create action for the add item Button
        addItemButton.setOnAction(e -> {

            String foodName     = "";
            int foodPrice       = 0;
            boolean validPrice  = true;

            try {
                foodName  = itemNameField.getText();
                foodPrice = Integer.parseInt(itemPriceField.getText());
            } 
            catch (NumberFormatException e2) {
                validPrice = false;
                showAlert(Alert.AlertType.ERROR, "Invalid Input Format", "Please enter a valid price...");
            }
            if(validPrice == true) {
                if(validInputs(foodName, foodPrice)) {
                    // the add Method checks for duplicates and alerts the user accordingly 
                    addFoodItemToMenu(foodName, foodPrice);
                }
            }
            
        });

        // create action for the back Button
        backButton.setOnAction(e -> {adminLoggedInPage();});

 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 850);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void editItemPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Edit Item");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);
        // Create a VBox for the TextFileds
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create TextFields for the old values 
        TextField itemOldNameField = new TextField();
        TextField itemOldPriceField = new TextField();
        itemOldNameField.setPromptText("Item's Old Name...");
        itemOldPriceField.setPromptText("Item's Old Price...");

        // Create TextFields for the new values 
        TextField itemNewNameField = new TextField();
        TextField itemNewPriceField = new TextField();
        itemNewNameField.setPromptText("Item's New Name...");
        itemNewPriceField.setPromptText("Item's New Price...");


        // Customize the textFields
        itemOldNameField.setMinWidth(400);
        itemOldNameField.setMaxWidth(400);
        itemOldPriceField.setMinWidth(400);
        itemOldPriceField.setMaxWidth(400);
        itemOldNameField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        itemOldPriceField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        itemNewNameField.setMinWidth(400);
        itemNewNameField.setMaxWidth(400);
        itemNewPriceField.setMinWidth(400);
        itemNewPriceField.setMaxWidth(400);
        itemNewNameField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 
        itemNewPriceField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 


        // adjust margin of the TextFields 
        VBox.setMargin(itemOldNameField, new Insets(20, 0, 30, 0));
        VBox.setMargin(itemOldPriceField, new Insets(20, 0, 30, 0));
        VBox.setMargin(itemNewNameField, new Insets(20, 0, 30, 0));
        VBox.setMargin(itemNewPriceField, new Insets(20, 0, 30, 0));


        // add the TextFields to the VBox 
        vBox.getChildren().add(itemOldNameField);
        vBox.getChildren().add(itemOldPriceField);
        vBox.getChildren().add(itemNewNameField);
        vBox.getChildren().add(itemNewPriceField);


        // Create another HBox for the Bottom control Buttons 
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(90);
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create edit item Button & back Button then customize them
        Button editItemButton = new Button("Edit Item");
        Button backButton = new Button("Back");
        editItemButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        

        // add the buttons in it 
        controlButtonsHBox.getChildren().add(backButton);
        controlButtonsHBox.getChildren().add(editItemButton);
 
        // create action for the edit Item Button
        editItemButton.setOnAction(e -> {

            String foodOldName  = "";
            String foodNewName  = "";
            int foodOldPrice    = 0;
            int foodNewPrice    = 0;
            boolean validPrice = true;

            try {
                foodOldName  = itemOldNameField.getText();
                foodNewName  = itemNewNameField.getText();
                foodOldPrice = Integer.parseInt(itemOldPriceField.getText());
                foodNewPrice = Integer.parseInt(itemNewPriceField.getText());
            } 
            catch (NumberFormatException e2) {
                validPrice = false;
                showAlert(Alert.AlertType.ERROR, "Input ", "Please enter a valid price...");
            }
            if(validPrice && validInputs(foodOldName, foodOldPrice, foodNewName, foodNewPrice)) {
                // the edit Method checks for duplicates and alerts the user accordingly
                editFoodItemFromMenu(foodOldName, foodOldPrice, foodNewName, foodNewPrice);
            }
            
        });

        // create action for the back Button
        backButton.setOnAction(e -> {adminLoggedInPage();});

 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 850);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void deleteItemPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Delete Item");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);
        // Create a VBox for the TextFileds
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(15, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create TextFields for the username and password 
        TextField itemNameField = new TextField();
        TextField itemPriceField = new TextField();
        itemNameField.setPromptText("Item Name...");


        // Customize the textFields
        itemNameField.setMinWidth(400);
        itemNameField.setMaxWidth(400);
        itemNameField.setFont(Font.font("Verdana", FontWeight.BOLD, 30)); 


        // adjust margin of the TextFields Button
        VBox.setMargin(itemNameField, new Insets(20, 0, 30, 0));


        // add the TextFields to the VBox 
        vBox.getChildren().add(itemNameField);


        // Create another HBox for the Bottom control Buttons 
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(90);
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create delete item Button & back Button then customize them
        Button deleteItemButton = new Button("Delete Item");
        Button backButton = new Button("Back");
        deleteItemButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        

        // add the buttons in it 
        controlButtonsHBox.getChildren().add(backButton);
        controlButtonsHBox.getChildren().add(deleteItemButton);
 
        // create action for the delete item Button
        deleteItemButton.setOnAction(e -> {
            String foodName  = itemNameField.getText();
            deleteFoodItemFromMenu(foodName);
        });

        // create action for the back Button
        backButton.setOnAction(e -> {adminLoggedInPage();});

 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane loginPagePane = new BorderPane();
        loginPagePane.setTop(hBox);
        loginPagePane.setCenter(vBox);
        loginPagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(loginPagePane, 650, 850);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }







/////////////////////////////////////////////////// Order Methods

    private void updateTotalPrice() {
        float totalPrice = 0;
        for (Map.Entry<FoodItem, Integer> entry : selectedItems.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }                 // price =price+food *quantity
        totalPriceLabel.setText("Total Price: $" + String.format("%.2f", totalPrice));
    }

    private void submitOrder(String orderTime) {
        // Implement order submission logic here
        // For now, let's just display a message with selected items and total price
        StringBuilder orderDetails = new StringBuilder("Selected Items:\n");
        
        for (Map.Entry<FoodItem, Integer> entry : selectedItems.entrySet()) {
            orderDetails.append(entry.getKey().getName()).append(" (Quantity: ").append(entry.getValue()).append(")\n");
        }
        float totalPrice = 0;
       
        for (Map.Entry<FoodItem, Integer> entry : selectedItems.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        orderSubmissionPage(orderTime, totalPrice);
        orderDetails.append("\nTotal Price: $").append(String.format("%.2f", totalPrice));
        System.out.println(orderDetails.toString());
        System.out.println();
    }

    private List<FoodItem> getFoodItemsInMenu() {
        return foodItemsInMenuList;  
    }




/////////////////////////////////////////////////// Menu Configuration Methods

    private void addFoodItemToMenu(String name, int price) {

        if(price > 0) {
            boolean validName  = true;

            // compare the names case-insensitive to check if the provided name is a duplicate 
            String lowerCaseName = name.toLowerCase(); 
            for(FoodItem food : foodItemsInMenuList) {
                if(lowerCaseName.equals(food.getName().toLowerCase())) {
                    validName = false;
                    showAlert(Alert.AlertType.ERROR, "Invalid input", "A Food item with that name already exists, Please Enter another Name...");
                    break;
                } 
            }              
            if(validName == true) {
                foodItemsInMenuList.add(new FoodItem(name, price)); 
                showAlert(Alert.AlertType.INFORMATION, "Success Message", "Sucessfully added the food item "+name+" with price $"+price);
            }
             

        } 
        else {
            showAlert(Alert.AlertType.ERROR, "Invalid input", "Please Enter a Valid Price..."); 
        }


     }

    private void editFoodItemFromMenu(String oldName, int oldPrice, String newName, int newPrice) {
        if(newPrice >= 0) {
            boolean validName  = false;
            // compare the old name case-insensitive with the names in the menu to check if doesn't exist 
            String lowerCaseOldName = oldName.toLowerCase(); 
            for(FoodItem food : foodItemsInMenuList) {
                if(lowerCaseOldName.equals(food.getName().toLowerCase())) {
                    validName = true;
                    showAlert(Alert.AlertType.INFORMATION, "Success Message", "Sucessfully edited the food item "+food.getName()+" with old price $"+food.getPrice()+" to "+newName+" with new price $"+newPrice);
                    food.changeName(newName); 
                    food.changePrice(newPrice); 
                    break;
                } 
            }              
            if(validName == false) {
                showAlert(Alert.AlertType.ERROR, "Error", "the Food Item name provided doesn't exist in Menu, Please Enter a Valid Name..."); 
            }

        } 
        else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please Enter a Valid Price...");
        }
         

         
    }

    private void deleteFoodItemFromMenu(String name) {

        boolean validName  = false;

        for(int i = 0; i < foodItemsInMenuList.size(); i++) {
            if(name.equals(foodItemsInMenuList.get(i).getName())) {
                validName = true;
                foodItemsInMenuList.remove(i); 
                showAlert(Alert.AlertType.INFORMATION, "Success Message", "Sucessfully removed the food item "+name);
                break;
            } 
        }              
        if(validName == false) {
            showAlert(Alert.AlertType.ERROR, "Error", "Food Item name entered doesn't exist, please enter the correct Food Item name..."); 
        }
         
    }

    private boolean validInputs(String foodName, int foodPrice) {
        // check if price provided is +ve
        if(foodPrice>=0) {
            // if so check if new foodName provided is valid 
            for(int i = 0; i < foodName.length(); i++) {
                if (!Character.isLetter(foodName.charAt(i)) && !Character.isWhitespace(foodName.charAt(i))) {
                    showAlert(Alert.AlertType.ERROR, "Invalid Input", "Food Name must consist of alphabetical letters and white spaces only, please enter a valid Food Name...");
                    return false;
                }    
            } 
        }
        else {
            showAlert(Alert.AlertType.ERROR, "Invlid Input", "Please enter a valid price..."); 
            return false;
        } 
        return true; 
    }

    private boolean validInputs(String foodOldName, int foodOldPrice, String foodNewName, int foodNewPrice) {
        // check if prices provided are +ve
        if((foodOldPrice>=0) && (foodNewPrice>=0)) {
            // if so check if new foodName provided is valid 
            for(int i = 0; i < foodNewName.length(); i++) {
                if (!Character.isLetter(foodNewName.charAt(i)) && !Character.isWhitespace(foodNewName.charAt(i))) {
                    showAlert(Alert.AlertType.ERROR, "Invalid Input", "Food Name must consist of alphabetical letters and white spaces only, please enter a valid Food Name...");
                    return false;
                }    
            } 
        }
        else {
            showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter a valid price..."); 
            return false;
        } 
        return true; 
    }





/////////////////////////////////////////////////// Registration Methods 
 
    private static void addUser(String userName, String password, String phoneNumber, String Address) {
        users.add(new User(userName, password, phoneNumber, Address)); 
    }

    private static boolean checkErrorsInInput(String userName, String password, String phoneNumber, String address) {

        if(userName.length() < 3) {
                showAlert(Alert.AlertType.ERROR, "Error", "User Name must be at least 3 characters long, please enter a valid User Name...");
                return true; 
        } 

        if(password.length() < 8) {
            showAlert(Alert.AlertType.ERROR, "Error", "Password must be at least 8 characters long, please enter a valid Password...");
            return true; 
        }  

        for(int i = 0; i < userName.length(); i++) {
            // check if the userName contains a special character
            if (!Character.isDigit(userName.charAt(i)) && !Character.isLetter(userName.charAt(i)) && !Character.isWhitespace(userName.charAt(i))) {
                showAlert(Alert.AlertType.ERROR, "Error", "User Name can't contains special characters, only letters/numbers/spaces are allowed, please enter a valid User Name...");
                return true; 
            }    
        } 

        for(int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                showAlert(Alert.AlertType.ERROR, "Error", "Phone Number must consist of 11 numbers only starting with 0, please enter a valid Phone Number...");
                return true; 
            }    
        } 

        if(phoneNumber.length() != 11) {
            showAlert(Alert.AlertType.ERROR, "Error", "Phone Number must consist of 11 numbers only starting with 0, please enter a valid Phone Number...");
            return true; 
        }  

        if(address.length() <= 5) {
            showAlert(Alert.AlertType.ERROR, "Error", "please enter a valid Address...");
            return true; 
        }                 

        return false; 
    }

    private static boolean checkDuplicatesInInput(String userName, String phoneNumber) {
        for(User user : users) {
            if((userName.equals(user.getUserName()))) {
                showAlert(Alert.AlertType.ERROR, "Error", "User Name provided is already registered, please enter another User Name...");
                return true; 
            }
            if((phoneNumber.equals(user.getPhoneNumber()))) {
                showAlert(Alert.AlertType.ERROR, "Error", "Phone Number provided is already registered, please enter another Phone Number...");
                return true; 
            }
        }  
        return false; 
    }



/////////////////////////////////////////////////// Alert method

    private static void showAlert(javafx.scene.control.Alert.AlertType alertType, String alertHeader ,String alertStringMessage) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(alertHeader);
        alert.setContentText(alertStringMessage);
        alert.showAndWait(); 
    }




/////////////////////////////////////////////////// main method

    public static void main(String[] args) {

        // create an empty user which indicates that there is no user currently logged in (its index in the ArrayList is 0)
        addUser("", "", "", ""); 

        // create the admin user (its index in the ArrayList is 1)
        addUser("admin", "admin", "00000000000", ""); 

        // create a test user (its index in the ArrayList is 1)
        addUser("test", "test", "01123456789", "Cairo, Egypt"); 

        // add initial items to the menu 
        foodItemsInMenuList.add(new FoodItem("Burger", 150));
        foodItemsInMenuList.add(new FoodItem("Pizza", 110));
        foodItemsInMenuList.add(new FoodItem("Salad", 50));
        foodItemsInMenuList.add(new FoodItem("Soup", 40));
        foodItemsInMenuList.add(new FoodItem("Coffe", 50));
        foodItemsInMenuList.add(new FoodItem("Water", 10)); 

        // run the javaFX program
        Application.launch(args);

    }



}


 





