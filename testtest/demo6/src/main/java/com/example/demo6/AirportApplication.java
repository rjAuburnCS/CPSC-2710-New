package com.example.demo6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AirportApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo6/AirApp-view.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();  // Ensure the stage is shown
    }

    public static void main(String[] args) {
        launch(args);
    }
}
