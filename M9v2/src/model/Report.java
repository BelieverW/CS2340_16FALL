package model;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Daniel_RICE on 11/10/2016.
 */
public class Report {
    protected String user;
    protected String title;
    protected String date;
    protected String location;
    protected String path;
    protected String filename;
    protected String reportId;

    public Report(String u, String title, String date, String location) {
        this.user = u;
        this.title =title;
        this.date = date;
        this.location = location;
        this.filename = u + title + date;
        this.path = "./reports/" + filename + ".txt";
        this.reportId = String.format("%05d", Reports.getReportIdSize() + 1);
        Reports.updateReportIdSize(reportId);
    }

    public Report(String u, String title, String location) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        this.user = u;
        this.title =title;
        this.date = dateFormat.format(now);
        this.location = location;
        this.filename = u + title + date;
        this.path = "./reports/" + filename + ".txt";
        this.reportId = String.format("%05d", Reports.getReportIdSize() + 1);
        Reports.updateReportIdSize(reportId);
    }

    /* **********************
     * Getters and setters for properties
     */
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public StringProperty getTitleProperty() {
        return new SimpleStringProperty(this.title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public StringProperty getDateProperty() {
        return new SimpleStringProperty(this.date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPath() {
        return path;
    }

    public String getFilename() {
        return filename;
    }

    public String getReportId() { return reportId; }
    public void setReportId(String reportId) { this.reportId = reportId; }
}
