package com.stackoverflow.repro.controller;


import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ResourceBundle;

import com.stackoverflow.repro.Main;
import com.stackoverflow.repro.tasks.AppIconsTask;
import com.stackoverflow.repro.tasks.ProfilingTask;
import com.stackoverflow.repro.utils.MyVbox;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.*;


public class AppController
        implements Initializable {

    @FXML
    private StackPane stackpaneapps;

    @FXML
    private BorderPane progresspane;

    @FXML
    private ProgressIndicator progress;

    @FXML
    private ProgressIndicator stopProfInd;

    @FXML
    private BorderPane profilingpane;

    @FXML
    private Label devicename;

    private ObservableValue<Number> profProperty;

    // Reference to the main application.
    private Main mainApp;

    private AppIconsTask appLoadTask;

    private ProfilingTask prTask;

    private Queue<MyVbox> clickedAppQueue;

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        clickedAppQueue = new LinkedList<MyVbox>();
    }
    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param task
     *
     */
    public void setAppLoadTask(AppIconsTask task) {
        this.appLoadTask = task;
        progresspane.setVisible(true);
        progress.progressProperty().bind(appLoadTask.progressProperty());
        progresspane.visibleProperty().bind(appLoadTask.runningProperty());
        profilingpane.setVisible(false);
        appLoadTask.setOnSucceeded(t -> drawAppIcons());

    }


    void drawAppIcons(){
        profilingpane.setVisible(true);
        prTask = new ProfilingTask();
        new Thread(prTask).start();
    }
}