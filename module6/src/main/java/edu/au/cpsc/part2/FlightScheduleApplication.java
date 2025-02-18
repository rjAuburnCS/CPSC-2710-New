package edu.au.cpsc.part2;

import edu.au.cpsc.part2.controller.FlightScheduleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FlightScheduleApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlightScheduleApplication.class.getResource("flight-schedule-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Flight Schedule Application");
        stage.setScene(scene);

        stage.setOnCloseRequest(event -> {
            FlightScheduleController controller = fxmlLoader.getController();
            controller.saveDatabase();
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

