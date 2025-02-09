package edu.au.cpsc.module3.mod3project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AirportApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/au/cpsc/module3/mod3project/AirApp-view.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
    }
}
