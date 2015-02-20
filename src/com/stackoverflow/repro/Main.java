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
    private BorderPane rootLayout;
    private AppIconsTask loadIconsTask;
    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        initRootLayout();
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

            AnchorPane appsPane = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(appsPane);

            // Give the controller access to the main app.
            AppController controller = loader.getController();
            controller.setMainApp(this);

            loadIconsTask = new AppIconsTask();
            controller.setAppLoadTask(loadIconsTask);

            new Thread(loadIconsTask).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

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
