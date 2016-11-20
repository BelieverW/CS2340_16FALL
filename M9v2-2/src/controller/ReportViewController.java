package controller;

/**
 * Created by rober_000 on 10/11/2016.
 * M5_V2
 */

import fxapp.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;
//import java.io.IOException;
//import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportViewController {
    @FXML
    private TextField titleField;
    @FXML
    private TextField locationField;
    @FXML
    private ComboBox<WaterType> typeField;
    @FXML
    private ComboBox<WaterCondition> conditionField;
    private User user;
    private Report report;
    private Reports reportList;
    private Stage dialogStage;
    private MainApp mainapp;
    private static final Logger LOGGER = Logger.getLogger("ReportViewController");

    @FXML
    private void initialize() {
        this.typeField.setItems(Reports.getWaterTypeList());
        this.conditionField.setItems(Reports.getWaterConditionList());
        typeField.setValue(WaterType.OTHER);
        conditionField.setValue(WaterCondition.UNKNOWN);
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMainapp(MainApp mainApp) {
        this.mainapp = mainApp;
    }

    @FXML
    private void handleFinish() {

        Report newreport = new UserReport(user.getUserName(), titleField.getText(), locationField.getText(),
                typeField.getValue(), conditionField.getValue());
        user.submitReport(newreport);
        this.mainapp.showMainOverview(this.user);
        dialogStage.close();

    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

}
