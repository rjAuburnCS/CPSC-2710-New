package edu.au.cpsc.module7;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RyanTaskManagerApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/au/cpsc/module7/Main-View.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/edu/au/cpsc/module7/mystyle/main.css").toExternalForm()); // Apply CSS
            primaryStage.setScene(scene);
            primaryStage.setTitle("Task Manager");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showErrorDialog("Failed to load the main view.");
        }
    }

    private void showErrorDialog(String message) {
        // Add your custom error dialog implementation here
        System.err.println(message);
    }

    public static void main(String[] args) {
        launch(args);
    }
}


