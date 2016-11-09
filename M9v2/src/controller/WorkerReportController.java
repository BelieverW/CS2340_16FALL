package controller;

/**
 * Created by rober_000 on 10/26/2016.
 */
import fxapp.MainApp;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkerReportController {
    @FXML
    private TextField locationField;
    @FXML
    private ComboBox<model.Condition> conditionField;
    @FXML
    private TextField contaminantField;
    @FXML
    private TextField virusField;
    @FXML
    private TextField titleField;
// user to be saved
    private User user;
    //private Report report;
    //private Reports reportList;
    // dialog stage of this window
    private Stage dialogStage;
    // connection to main app
    private MainApp mainapp;
    private static final Logger LOGGER =Logger.getLogger("ReportViewController");

    @FXML
    private void initialize() {
        this.conditionField.setItems(Reports.getOverCondition());
        this.conditionField.setValue(Condition.TREATABLE);
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

    /**
     * handle when finish
     */
    @FXML
    private void handleFinish() {
        try {
            WorkerReport newreport = new WorkerReport(user.getUserName(), titleField.getText(), locationField.getText(),
                    conditionField.getValue(), virusField.getText(), contaminantField.getText());
            Worker.submitWorkerReport(newreport);
            this.mainapp.showMainOverview(this.user);
            dialogStage.close();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to submit report!!");
            e.printStackTrace();
        }
    }
    @FXML
    private void handleUserReport() {
        this.mainapp.showReportView(user, false);
        this.dialogStage.close();
    }
    /**
     * handle when user try to cancel
     */
    @FXML
    private  void handleCancel() {
        dialogStage.close();
    }
}
