package fxapp;/**
 * Created by rober_000 on 9/20/2016.
 */
import javafx.fxml.FXML;
import model.User;
import controller.LoginviewController;
import controller.MainOverviewController;
import controller.MainScreenController;
import controller.SignupController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import java.io.IOException;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApp extends Application {
    /**the java logger for main class */
    private static final Logger LOGGER = Logger.getLogger("MainApp");
    //primary stage of this application
    private Stage mainStage;
    //the pane of main screen
    private BorderPane rootLayout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.mainStage = primaryStage;
        this.mainStage.setTitle("Welcome...");

        initRootLayout();

        showLogin();
    }
    /**
     * Initializes the root layout
     */
    public void initRootLayout() {
        try {
            //Load root layout from fxml file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/MainScreenView.fxml"));
            rootLayout = (BorderPane) loader.load();
            //connect the main screen controller to the mainapp
            MainScreenController controller = loader.getController();
            controller.setMainApp(this);
            //show the sign containing the root layout
            Scene scene = new Scene(rootLayout);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (IOException e) {
            //error on load
            LOGGER.log(Level.SEVERE, "Fail to find the fxml file for main screen!");
            e.printStackTrace();
        }
    }
    /**
     * show the login interface
     */
    public void showLogin() {
        try {
            // load login
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/Loginview.fxml"));
            AnchorPane Loginview = (AnchorPane) loader.load();
            //set the login in interface into the screen
            rootLayout.setCenter(Loginview);
            //link the login to the mainaoo
            LoginviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            //error on load
            LOGGER.log(Level.SEVERE, "ERROR! Cannot find Login interface");
            e.printStackTrace();
        }
    }
    /**
     * open a dialog for signup
     * @param name the username to registered
     * @param password the password to be registered
     * @return true if user regisered, false otherwise
     */
    public void showSignUp(String name, String password) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/Signupview.fxml"));
            AnchorPane signupview = (AnchorPane) loader.load();
            //create a dialog stage
            Stage dialogstage = new Stage();
            dialogstage.setTitle("Sign Up");
            dialogstage.initModality(Modality.WINDOW_MODAL);
            dialogstage.initOwner(mainStage);
            Scene scene = new Scene(signupview);
            dialogstage.setScene(scene);

            //set the username and passwod into the controller
            SignupController controller = loader.getController();
            controller.setUserInfo(name, password);
            controller.setDialogStage(dialogstage);

            //shwo the dialog and wait
            dialogstage.showAndWait();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * open the application after login
     * @param user the user logged in
     */
    public void showMainOverview(User user) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/MainScreenOverview.fxml"));
            AnchorPane mainoverview = (AnchorPane) loader.load();
            rootLayout.setCenter(mainoverview);
            //link to the controller
            MainOverviewController controller = loader.getController();
            controller.setMainApp(this);
            controller.setUser(user);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * get the main stage
     * @return return the main stage
     */
    public Stage getMainStage() {
        return this.mainStage;
    }


}
