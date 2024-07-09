
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
import javafx.application.Platform;

public class Restaurant extends Application {

/////////////////////////////////////////////////// Class's Data-Fields

    // Income of the Restaurant 
    private float Income = 0;
 
    // ArrayList that holds all users registered in the JavaFX Restaurant
    private static ArrayList<User> users = new ArrayList<>(); 

    // ArrayList that holds all orders done in the JavaFX Restaurant
    private static ArrayList<Order> orders = new ArrayList<>(); 
   
    // Hash Map for the Current Order being done
    private Map<FoodItem, Integer> selectedItems = new HashMap<>();
     
    // index of the Array list for the user currently logged in  
    private static int currentUserIndex = 0; 
       
    // javaFX Primary Stage 
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
                AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "Invalid username or password");
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
                    AlertClass.showAlert(Alert.AlertType.INFORMATION, "Successful Registration!!!", "Congratulations! You have sucessfully registered in the JavaFX Restaurant, enjoy your meals!");

                    // go back to the enter page to enter the new credentials and log in
                    enterPage();
                }            
            }
                                                  
        });

        // create action for the back Button
        backButton.setOnAction(e -> {enterPage();});
         
 
        // create a Borderpane and attach hBox and vBox to it
        BorderPane pagePane = new BorderPane();
        pagePane.setTop(hBox);
        pagePane.setCenter(vBox);
        pagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(pagePane, 650, 850);
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

        // create action of order Button
        orderButton.setOnAction(e -> {orderPage();});

        // create action of logout Button
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

    private void orderPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Order");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);

        // Create a VBoxes for the Labels & TextFileds
        VBox vBox = new VBox(20);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.TOP_LEFT); 

        VBox[] vboxArr = new VBox[4];
        for(int i = 0; i < 3; i++) {
            vboxArr[i] = new VBox(1);
            vboxArr[i].setPadding(new Insets(5, 5, 5, 5));
            vboxArr[i].setAlignment(javafx.geometry.Pos.TOP_LEFT); 
        } 
                 
        // Create Labels for the TextFields 
        Label tableNumberLabel = new Label("Enter Table Number (0-"+(Hall.getNumTables()-1)+")");
        Label orderDateLabel = new Label("Enter Order Date in the format (DD/MM/YY HH:MM)");
        Label orderDurationLabel = new Label("Enter Order Duration in minutes (60-240)");
        tableNumberLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15)); 
        tableNumberLabel.setStyle("-fx-text-fill: #000000;");
        orderDateLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15)); 
        orderDateLabel.setStyle("-fx-text-fill: #000000;");
        orderDurationLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15)); 
        orderDurationLabel.setStyle("-fx-text-fill: #000000;");
       
        
        // Create TextFields for input 
        TextField tableNumberField = new TextField();
        TextField orderDateField = new TextField();
        TextField orderDurationField = new TextField();
        tableNumberField.setPromptText("Table Number...");
        orderDateField.setPromptText("Order Date...");
        orderDurationField.setPromptText("Order Duration...");


        // Customize the textFields
        tableNumberField.setMinWidth(620);
        tableNumberField.setMaxWidth(620);
        orderDateField.setMinWidth(620);
        orderDateField.setMaxWidth(620);
        orderDurationField.setMinWidth(620);
        orderDurationField.setMaxWidth(620);
        tableNumberField.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 
        orderDateField.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 
        orderDurationField.setFont(Font.font("Verdana", FontWeight.BOLD, 15)); 


        // adjust margin of the TextFields Button
        VBox.setMargin(tableNumberField, new Insets(12, 0, 12, 0));
        VBox.setMargin(orderDateField, new Insets(12, 0, 12, 0));
        VBox.setMargin(orderDurationField, new Insets(12, 0, 12, 0));


        // add the TextFields to the VBox 
        vboxArr[0].getChildren().add(tableNumberLabel);
        vboxArr[0].getChildren().add(tableNumberField);
        vboxArr[1].getChildren().add(orderDateLabel);
        vboxArr[1].getChildren().add(orderDateField);
        vboxArr[2].getChildren().add(orderDurationLabel);
        vboxArr[2].getChildren().add(orderDurationField);
        for(int i = 0; i < 3; i++) {
            vBox.getChildren().add(vboxArr[i]); 
        } 


        //////////////////////////////////////////////////////////////////////////// 
 
        VBox menuSelectionLayout = new VBox(10);
        menuSelectionLayout.setPadding(new Insets(5));
        Label menuLabel = new Label("Please select Food Items you would like to order :");
        menuLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15)); 
        menuLabel.setStyle("-fx-text-fill: #000000;");
         
        HBox foodItemsLayout = new HBox(130);
        VBox foodItemsCheckBoxVBox = new VBox(20);
        VBox foodItemsPriceVBox = new VBox(20);
        VBox foodItemsSpinnerVBox  = new VBox(12);
        foodItemsLayout.setAlignment(javafx.geometry.Pos.CENTER); 
        foodItemsCheckBoxVBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT); 
        foodItemsPriceVBox.setAlignment(javafx.geometry.Pos.CENTER); 
        foodItemsSpinnerVBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT); 
         
        for (FoodItem foodItem : Menu.getFoodItemsInMenu()) {

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
            });
            quantitySpinner.getValueFactory().valueProperty().addListener((observable, oldValue, newValue) -> {
                if (checkBox.isSelected()) {
                    selectedItems.put(foodItem, newValue);//upate the map 
                }             
            });
            



            Label priceLabel = new Label("$"+foodItem.getPrice());
            foodItemsPriceVBox.getChildren().add(priceLabel);   
            foodItemsCheckBoxVBox.getChildren().add(itemCheckBoxLayout);   
            foodItemsSpinnerVBox.getChildren().add(itemSpinnerLayout);   
        }

        foodItemsLayout.getChildren().addAll(foodItemsCheckBoxVBox, foodItemsPriceVBox, foodItemsSpinnerVBox); 



        // Add the Menu Items to the to the container VBox then to the Central VBox 
        menuSelectionLayout.getChildren().addAll(menuLabel, foodItemsLayout); 
        vBox.getChildren().add(menuSelectionLayout); 

        //////////////////////////////////////////////////////////////////////////// 


 
        // Create another HBox for the Bottom control Buttons 
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(15, 15, 80, 15));
        controlButtonsHBox.setSpacing(95);
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 
 
        // Create Register Button & back Button then customize them
        Button submitButton = new Button("Sumbit");
        Button backButton = new Button("Back");
        submitButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        

        // add the buttons in it
        controlButtonsHBox.getChildren().add(backButton);
        controlButtonsHBox.getChildren().add(submitButton);
 
        // create action for the sumbit Button
        submitButton.setOnAction(e1 -> {

            int tableNumber = 0; 
            int orderDuration= 0; 
            Date orderDate = new Date(); 
            Date currentDate = new Date(); 

            boolean validInput = true;
                try {

                    tableNumber = Integer.parseInt(tableNumberField.getText());
                    orderDuration = Integer.parseInt(orderDurationField.getText());
                    currentDate = new Date();              

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Parse the order time string to Date 
                    sdf.setLenient(false); 
                    orderDate = sdf.parse(orderDateField.getText());


                    if(tableNumber > Hall.getNumTables()) {
                        validInput = false;
                        AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid input", "Please enter an appropriate Table number...");                 
                    }
                    else if((orderDuration > 240)||orderDuration < 60){
                        validInput = false;
                        AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid input", "Please enter a Duration within the valid Range...");                 
                    }
                    else {
                        if((orderDate.before(currentDate))) {
                            validInput = false;
                            AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid input", "Please enter a valid Date...");                 
                        }
                        else {
                            validInput = true;

                            boolean isValidSelection = false;

                            for (Map.Entry<FoodItem, Integer> entry : selectedItems.entrySet()) {
                                if (entry.getValue() > 0) {
                                    isValidSelection = true;
                                    break;
                                }
                            }

                            if (!isValidSelection) {
                                // Show an alert to inform the user to select at least one item
                                AlertClass.showAlert(Alert.AlertType.WARNING, "No Food Items Selected", "Please select at least one food item and specify the quantity."); 
                                // Exit the method without processing the order
                                return; 
                            }
                            else if(validInput==true && Hall.allTables.get(tableNumber).isAvailable()) {
                                submitOrder(users.get(currentUserIndex), orderDate,  orderDuration, selectedItems, Hall.getTable(tableNumber));
                            }
                            else {
                                AlertClass.showAlert(Alert.AlertType.ERROR, "Table not Free", "Please select another Table..."); 
                            }

                        }
                    }




                } 
                catch (ParseException e) {
                    validInput = false;
                    AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid input format", "Please enter the order time in the correct format (DD/MM/YY HH:MM)"); 
                }
                catch (NumberFormatException e) {
                    validInput = false;
                    AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid input format", "Please enter the duration in a valid format...");
                }


            ;});

        //  create action for the back Button
        backButton.setOnAction(e -> {userLoggedInPage();});

        // create a Borderpane and attach hBox and vBox to it
        BorderPane pagePane = new BorderPane();
        pagePane.setTop(hBox);
        pagePane.setCenter(vBox);
        pagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(pagePane, 650, 850);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }

    private void orderSubmissionPage(String orderTime, double totalPrice, StringBuilder orderDetails) {

    // Create labels to display order time and total price
    Text orderTimeLabel = new Text("Order Time: " + orderTime);
    Text orderDetailsText = new Text(orderDetails.toString());
    Text totalPriceLabel = new Text("Total Price: $" + String.format("%.2f", totalPrice));
    orderTimeLabel.setFont(new Font(20)); 
    orderDetailsText.setFont(new Font(20)); 
    totalPriceLabel.setFont(new Font(20)); 

    // Create a button to close the stage
    Button closeButton = new Button("Close");
    closeButton.setOnAction(e -> userLoggedInPage());

    // Create a layout to arrange the components
    VBox layout = new VBox(20);
    layout.setPadding(new Insets(20));
    layout.getChildren().addAll(orderTimeLabel, orderDetailsText, totalPriceLabel, closeButton);

    // Update the scene with the new layout
    Scene scene = new Scene(layout);
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
        Button infoButton = new Button("Info"); 
        Button addButton = new Button("Add Item"); 
        Button editButton = new Button("Edit Item"); 
        Button deleteButton = new Button("Delete Item"); 
        Button addTableButton = new Button("Add Table"); 
        Button removeTableButton  = new Button("Remove Table"); 
        Button logoutButton = new Button("Logout"); 

        // adjust their margin
        VBox.setMargin(infoButton, new Insets(10, 0, 10, 0));
        VBox.setMargin(addButton, new Insets(10, 0, 10, 0));
        VBox.setMargin(editButton, new Insets(10, 0, 10, 0));
        VBox.setMargin(deleteButton, new Insets(10, 0, 10, 0));
        VBox.setMargin(addTableButton, new Insets(10, 0, 10, 0));
        VBox.setMargin(removeTableButton, new Insets(10, 0, 10, 0));
        VBox.setMargin(logoutButton, new Insets(10, 0, 10, 0));

        // adjust their size in pixels 
        infoButton.setPrefSize(300,100); 
        addButton.setPrefSize(300,100); 
        editButton.setPrefSize(300,100); 
        addTableButton.setPrefSize(300,100); 
        removeTableButton.setPrefSize(300,100); 
        deleteButton.setPrefSize(300,100); 
        logoutButton.setPrefSize(300,100); 
        
        // customize Buttons style
        infoButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        addButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        editButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        addTableButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        removeTableButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        deleteButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
        logoutButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");
         
        // add the Buttons to the VBox 
        vBox.getChildren().add(infoButton);
        vBox.getChildren().add(addButton);
        vBox.getChildren().add(editButton);
        vBox.getChildren().add(deleteButton);
        vBox.getChildren().add(addTableButton);
        vBox.getChildren().add(removeTableButton);
        vBox.getChildren().add(logoutButton);

        // create action for the Buttons
        infoButton.setOnAction(e -> {infoPage();});
        addButton.setOnAction(e -> {addItemPage();});
        editButton.setOnAction(e -> {editItemPage();});
        deleteButton.setOnAction(e -> {deleteItemPage();});
        logoutButton.setOnAction(e -> {enterPage();});
        addTableButton.setOnAction(e -> {
            Hall.addTable(); 
            AlertClass.showAlert(Alert.AlertType.INFORMATION, "Operation Successful", "Added a Table Successfully...");  
        });
        removeTableButton.setOnAction(e -> {
            Hall.removeTable(); 
            AlertClass.showAlert(Alert.AlertType.INFORMATION, "Operation Successful", "Removed a Table Successfully...");  
        });

        // create a Borderpane and attach hBox and vBox to it
        BorderPane enterPagePane = new BorderPane();
        enterPagePane.setTop(hBox);
        enterPagePane.setCenter(vBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(enterPagePane, 650, 900);
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
                AlertClass.showAlert(Alert.AlertType.ERROR, "Invalid Input Format", "Please enter a valid price...");
            }
            if(validPrice == true) {
                if(Menu.checkValidInputs(foodName, foodPrice)) {
                Menu.addFoodItemToMenu(foodName, foodPrice);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        // the add Method checks for duplicates and alerts the user accordingly 
                        // Menu.addFoodItemToMenu(name, price);
                    }
                });
                    
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
                AlertClass.showAlert(Alert.AlertType.ERROR, "Input ", "Please enter a valid price...");
            }
            if(validPrice && Menu.checkValidInputs(foodOldName, foodOldPrice, foodNewName, foodNewPrice)) {
                // the edit Method checks for duplicates and alerts the user accordingly
                Menu.editFoodItemFromMenu(foodOldName, foodOldPrice, foodNewName, foodNewPrice);
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
            Menu.deleteFoodItemFromMenu(foodName);
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

    private void infoPage() {


        // Create an HBox for the Title Label
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setStyle("-fx-background-color: gold");
        hBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create the Title Label and add it
        Label welcomeLabel = new Label("JavaFX Restaurant -- Info");
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 40)); 
        welcomeLabel.setStyle("-fx-text-fill: #000000;");
        hBox.getChildren().add(welcomeLabel);
        // Create a VBox for the TextFileds
        VBox vBox = new VBox(5);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setAlignment(javafx.geometry.Pos.CENTER); 


        // Labels         
        Label numUsers  = new Label("Number of JavaFX Restaurant Users :  "+getNumUsers());
        Label numOrders = new Label("Number of JavaFX Restaurant Orders :  "+getNumOrders());
        Label numTables = new Label("Number of JavaFX Restaurant Tables :  "+Hall.getNumTables());

        numUsers.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25)); 
        numOrders.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25)); 
        numTables.setFont(Font.font("Times New Roman", FontWeight.BOLD, 25)); 
        numUsers.setStyle("-fx-text-fill: #000000;");
        numOrders.setStyle("-fx-text-fill: #000000;");
        numTables.setStyle("-fx-text-fill: #000000;");
        


        // adjust margin of the TextFields Button
        VBox.setMargin(numUsers, new Insets(20, 0, 30, 0));
        VBox.setMargin(numOrders, new Insets(20, 0, 30, 0));
        VBox.setMargin(numTables, new Insets(20, 0, 30, 0));



        // add the TextFields to the VBox 
        vBox.getChildren().add(numUsers);
        vBox.getChildren().add(numOrders);
        vBox.getChildren().add(numTables);


        //////////////////////////////////////////////////////////////////////////// 
 
        VBox menuSelectionLayout = new VBox(10);
        menuSelectionLayout.setPadding(new Insets(5));
        Label menuLabel = new Label("-------------------------MENU-------------------------");
        menuLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28)); 
        menuLabel.setStyle("-fx-text-fill: #000000;");
         
        HBox foodItemsLayout = new HBox(300);
        VBox foodItemsCheckBoxVBox = new VBox(20);
        VBox foodItemsPriceVBox = new VBox(20);

        foodItemsLayout.setAlignment(javafx.geometry.Pos.CENTER); 
        foodItemsCheckBoxVBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT); 
        foodItemsPriceVBox.setAlignment(javafx.geometry.Pos.CENTER); 

         
        for (FoodItem foodItem : Menu.getFoodItemsInMenu()) {

            // create a check box for the food item
            Label nameLabel = new Label(foodItem.getName());
            Label priceLabel = new Label("$"+foodItem.getPrice());
            nameLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 26)); 
            nameLabel.setStyle("-fx-text-fill: #000000;");
            priceLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 26)); 
            priceLabel.setStyle("-fx-text-fill: #000000;");
         
               
            // create javaFX HBox and configure it to hold the menu information 
            HBox itemCheckBoxLayout = new HBox(10);
            itemCheckBoxLayout.setAlignment(javafx.geometry.Pos.CENTER_LEFT); 
            itemCheckBoxLayout.getChildren().add(nameLabel);

            foodItemsPriceVBox.getChildren().add(priceLabel);   
            foodItemsCheckBoxVBox.getChildren().add(itemCheckBoxLayout);   

        }

        foodItemsLayout.getChildren().addAll(foodItemsCheckBoxVBox, foodItemsPriceVBox); 



        // Add the Menu Items to the to the container VBox then to the Central VBox 
        menuSelectionLayout.setAlignment(javafx.geometry.Pos.CENTER); 
        menuSelectionLayout.getChildren().addAll(menuLabel, foodItemsLayout); 
        vBox.getChildren().add(menuSelectionLayout); 



        // Create another HBox for the Bottom control Buttons 
        HBox controlButtonsHBox = new HBox(15);
        controlButtonsHBox.setPadding(new Insets(50, 15, 50, 15));
        controlButtonsHBox.setAlignment(javafx.geometry.Pos.CENTER); 

        // Create back Button then customize it
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-text-fill: #000000; -fx-font-size: 33; -fx-font-weight: bold; -fx-background-radius: 15; -fx-border-radius: 15;-fx-background-color: gold; -fx-border-color: #000000; -fx-border-width: 3px;");        

        // add the buttons in it 
        controlButtonsHBox.getChildren().add(backButton);

        // create action for the back Button
        backButton.setOnAction(e -> {adminLoggedInPage();});

        // create a Borderpane and attach hBox and vBox to it
        BorderPane pagePane = new BorderPane();
        pagePane.setTop(hBox);
        pagePane.setCenter(vBox);
        pagePane.setBottom(controlButtonsHBox);

        // create scene and put the BorderPane in it then finally configure the stage
        Scene scene = new Scene(pagePane);
        primaryStage.setScene(scene);  
        primaryStage.setTitle("JavaFX Restaurant");  
        primaryStage.setResizable(false);
        primaryStage.show();  

    }






/////////////////////////////////////////////////// Restaurant Methods

    private int getNumUsers() {
        return users.size()-1; 
    }

    private int getNumOrders() {
        return orders.size(); 
    }

    private void submitOrder(User orderUser, Date orderDate, int orderDuration ,Map<FoodItem, Integer> foodItems, Table orderTable) {
         
        orders.add(new Order(orderUser, orderDate, orderDuration, foodItems, orderTable)); 

        String orderTime = orderDate.toString();
        StringBuilder orderDetails = new StringBuilder("Selected Items:\n");
        
        for (Map.Entry<FoodItem, Integer> entry : foodItems.entrySet()) {
            orderDetails.append(entry.getKey().getName()).append("   ($").append(entry.getKey().getPrice()).append(")   (Quantity: ").append(entry.getValue()).append(")\n");
        }
        float totalPrice = 0;
       
        for (Map.Entry<FoodItem, Integer> entry : foodItems.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        orderSubmissionPage(orderTime, totalPrice, orderDetails);
        selectedItems = new HashMap<>();
    }







/////////////////////////////////////////////////// Users Registration Methods 
 
    private static void addUser(String userName, String password, String phoneNumber, String Address) {
        users.add(new User(userName, password, phoneNumber, Address)); 
    }

    private static boolean checkErrorsInInput(String userName, String password, String phoneNumber, String address) {

        if(userName.length() < 3) {
                AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "User Name must be at least 3 characters long, please enter a valid User Name...");
                return true; 
        } 

        if(password.length() < 8) {
            AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "Password must be at least 8 characters long, please enter a valid Password...");
            return true; 
        }  

        for(int i = 0; i < userName.length(); i++) {
            // check if the userName contains a special character
            if (!Character.isDigit(userName.charAt(i)) && !Character.isLetter(userName.charAt(i)) && !Character.isWhitespace(userName.charAt(i))) {
                AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "User Name can't contains special characters, only letters/numbers/spaces are allowed, please enter a valid User Name...");
                return true; 
            }    
        } 

        for(int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "Phone Number must consist of 11 numbers only starting with 0, please enter a valid Phone Number...");
                return true; 
            }    
        } 

        if(phoneNumber.length() != 11) {
            AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "Phone Number must consist of 11 numbers only starting with 0, please enter a valid Phone Number...");
            return true; 
        }  

        if(address.length() <= 5) {
            AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "please enter a valid Address...");
            return true; 
        }                 

        return false; 
    }

    private static boolean checkDuplicatesInInput(String userName, String phoneNumber) {
        for(User user : users) {
            if((userName.equals(user.getUserName()))) {
                AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "User Name provided is already registered, please enter another User Name...");
                return true; 
            }
            if((phoneNumber.equals(user.getPhoneNumber()))) {
                AlertClass.showAlert(Alert.AlertType.ERROR, "Error", "Phone Number provided is already registered, please enter another Phone Number...");
                return true; 
            }
        }  
        return false; 
    }



/////////////////////////////////////////////////// main method

    public static void main(String[] args) {

        // create an empty user which indicates that there is no user currently logged in (its index in the ArrayList is 0)
        addUser("", "", "", ""); 

        // create the admin user (its index in the ArrayList is 1)
        addUser("admin", "admin", "", ""); 

        // create a test user (its index in the ArrayList is 2)
        addUser("test", "test", "01123456789", "Cairo, Egypt"); 

        // add initial items to the menu 
        Menu.addInitialItems(); 

        // add Tables to the Hall 
        Hall.addMultipleTables(10); 
             
        // run the javaFX program
        Application.launch(args);

    }



}


 





