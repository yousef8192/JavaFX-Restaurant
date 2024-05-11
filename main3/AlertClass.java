import javafx.scene.control.Alert;
import java.util.List;
import javafx.application.Platform;

public class AlertClass {


    public static void showAlert(javafx.scene.control.Alert.AlertType alertType, String alertHeader ,String alertStringMessage) {

        // The following code is to enable external Classes to 
        // be able to alter javaFX in the Main Class which is running javaFX
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Alert alert = new Alert(alertType);
                alert.setHeaderText(alertHeader);
                alert.setContentText(alertStringMessage);
                alert.showAndWait(); 
            }
        });
    }


}
