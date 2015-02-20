package com.stackoverflow.repro;

import com.stackoverflow.repro.controller.AppController;
import com.stackoverflow.repro.tasks.AppIconsTask;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

    private Stage primaryStage;
    private AnchorPane rootLayout;
    private AppIconsTask loadIconsTask;
    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        showInstalledApps();
    }

    /**
     * Shows the app overview inside the root layout.
     */
    public void showInstalledApps() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/InstalledAppsPane.fxml"));

            rootLayout = (AnchorPane) loader.load();

            // Give the controller access to the main app.
            AppController controller = loader.getController();
            controller.setMainApp(this);

            loadIconsTask = new AppIconsTask();
            controller.setAppLoadTask(loadIconsTask);

            new Thread(loadIconsTask).start();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout, 600, 400);

            primaryStage.setTitle("Hello");
            primaryStage.setScene(scene);
            primaryStage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
