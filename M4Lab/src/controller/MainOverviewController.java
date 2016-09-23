package controller;

/**
 * Created by rober_000 on 9/20/2016.
 */
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.User;
import fxapp.MainApp;

public class MainOverviewController {
    @FXML
    private Label lableField;

    private model.User user;
    private MainApp mainapp;

    /**
     * set the user logging in
     * @param who
     */
    public void setUser(User who) {
        this.user = who;
        lableField.setText("Hi, " + user.getUserLevel());
    }

    /**
     * set the main stage
     * @param main
     */
    public void setMainApp(MainApp main) {
        this.mainapp = main;
    }

}
