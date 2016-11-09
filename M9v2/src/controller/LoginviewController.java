package controller;

import fxapp.MainApp;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Database;
import model.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by rober_000 on 9/19/2016.
 */
public class LoginviewController {
    private MainApp mainapp;

    //text field for user id
    @FXML
    private TextField uidField;

    @FXML
    private PasswordField passwordField;

    private static final Logger LOGGER =Logger.getLogger("LoginviewController");

    /**
     * set the main stage for controller
     */
    public void setMainApp(MainApp main) {
        this.mainapp = main;
    }
    /**
     * handle the login
     */
    @FXML
    private void handleLogin() {
        String name = uidField.getText();
        String password = passwordField.getText();
        try {
            model.Database database = new model.Database();
            User user = database.getAuth(name, password);
            if ( user != null) {
                mainapp.showMainOverview(user);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(mainapp.getMainStage());
                alert.setTitle("Login Fail");
                alert.setHeaderText("ERROR Username or Password!");
                alert.setContentText("Please Reenter the Username and Password!");
                alert.showAndWait();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load database!!");
            e.printStackTrace();
        }
    }

    /**
     * handle the pressed "sign up" button
     */
    @FXML
    private void handleSignUp() {
        String name = uidField.getText();
        String password = passwordField.getText();
        if (name == null){
            name = "set a username";
        }
        if (password == null) {
            password = "set a password";
        }
        User user = new User(name, password);
        mainapp.showSignUp(user, true);
    }


}
