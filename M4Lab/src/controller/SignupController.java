package controller;

/**
 * Created by rober_000 on 9/20/2016.
 */
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Database;
import model.User;
import model.UserLevel;
import sun.security.util.Password;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignupController {
    @FXML
    private TextField useridField;
    @FXML
    private PasswordField firpwField;
    @FXML
    private PasswordField secpwField;
    @FXML
    private RadioButton userRadio;
    @FXML
    private RadioButton workerRadio;
    //store stage for this interface
    private Stage dialogstage;
    //store database
    private Database database;
    private static final Logger LOGGER =Logger.getLogger("SignupController");

    private void initialize() {
    }
    /**
     * set the stage
     * @param dstage the dialog stage to be added in
     */
    public void setDialogStage(Stage dstage) {
        this.dialogstage = dstage;
    }
    /**
     * sets the userInfo
     * @Param username the username
     * @Parm password
     *
     */
    public void setUserInfo(String username, String password) {
        if (username == null) {
            username = "Set a new username";
        }
        if (password == null) {
            password = "Set a new password";
        }
        useridField.setText(username);
        firpwField.setText(password);
        //secpwField.setPlaceholder(new Label("No Content In List"));
        //secpwField.setText("Re-enter your password");
    }
    /** handle the sign up button
     *
     */
    @FXML
    private void handleSignUp() {
        try {
            this.database = new model.Database();
            if (!firpwField.getText().equals(secpwField.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(dialogstage);
                alert.setTitle("Password Error");
                alert.setHeaderText("Two password not much");
                alert.setContentText("Please Re-enter the password!");
                secpwField.setText("");
                alert.showAndWait();
            } else if (database.checkExistance(useridField.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(dialogstage);
                alert.setTitle("User Error!");
                alert.setHeaderText("User already existed");
                alert.setContentText("Please Re-enter the user name!");
                useridField.setText("");
                firpwField.setText("");
                secpwField.setText("");
                alert.showAndWait();
            } else {
                if (userRadio.isSelected()) {
                    database.registerUser(useridField.getText(), firpwField.getText(), UserLevel.USER);
                } else {
                    database.registerUser(useridField.getText(), firpwField.getText(), UserLevel.WORKER);
                }
                dialogstage.close();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load database!!");
            e.printStackTrace();
        }
    }

    /**
     * hadle the cancel button
     */
    @FXML
    private void handleCancel() {
        dialogstage.close();
    }


}
