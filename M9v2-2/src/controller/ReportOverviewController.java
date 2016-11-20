package controller;

/**
 * Created by rober_000 on 10/11/2016.
 * M5_V2
 */

import fxapp.MainApp;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

import java.util.Map;

public class ReportOverviewController {

    @FXML
    private TableView<StringProperty> reportTable;
    @FXML
    private TableColumn<StringProperty, String> fileColumn;

    @FXML
    private Label titleLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label userLabel;
    @FXML
    private Label locationLabel;
    @FXML
    private Label typeLabel;
    @FXML
    private Label conditionLabel;
    @FXML
    private Label virusLabel;
    @FXML
    private Label contaminantLabel;

    private MainApp mainapp;

    private User user;


    @FXML
    private void initialize() {
        fileColumn.setCellValueFactory(TableColumn.CellDataFeatures::getValue);
        reportTable.setItems(Reports.getReportList());
        showReportDetails(null);
        reportTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showReportDetails(newValue));
    }

    public void setMainapp(MainApp mainApp) {
        this.mainapp = mainApp;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @FXML
    private void handleBack() {
        this.mainapp.showMainOverview(this.user);
    }

    private void showReportDetails(StringProperty report) {
        if (report != null) {
            if (report.get().split(",")[1].equals("workerReport")) {
                Map<String, String> map = ((Worker) user).viewReport(report.get(), true);
                titleLabel.setText(map.get("reportId") + " " + map.get("title"));
                timeLabel.setText(map.get("date"));
                userLabel.setText(map.get("user"));
                locationLabel.setText(map.get("location"));
                conditionLabel.setText(map.get("watercondition"));
                virusLabel.setText(map.get("virusPPM"));
                contaminantLabel.setText(map.get("contaminantPPM"));
                typeLabel.setText(map.get("watertype"));
            } else {
                Map<String, String> map = user.viewReport(report.get());
                titleLabel.setText(map.get("reportId") + " " + map.get("title"));
                timeLabel.setText(map.get("date"));
                userLabel.setText(map.get("user"));
                locationLabel.setText(map.get("location"));
                conditionLabel.setText(map.get("watercondition"));
                virusLabel.setText(map.get("virusPPM"));
                contaminantLabel.setText(map.get("contaminantPPM"));
                typeLabel.setText(map.get("watertype"));
            }
        } else {
            titleLabel.setText("");
            timeLabel.setText("");
            userLabel.setText("");
            locationLabel.setText("");
            typeLabel.setText("");
            conditionLabel.setText("");
        }
    }


}
