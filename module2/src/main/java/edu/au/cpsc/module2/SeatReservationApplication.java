package edu.au.cpsc.module2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.time.LocalDate;

public class SeatReservationApplication extends Application {

    private SeatReservation seatReservation;

    private TextField flightDesignatorField;
    private DatePicker flightDatePicker;
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField numberOfBagsField;
    private CheckBox flyingWithInfantCheckBox;
    private TextField numberOfPassengersField;
    @Override
    public void start(Stage stage) {
        seatReservation = new SeatReservation();
        seatReservation.setFlightDesignator("AUB111");
        seatReservation.setFlightDate(LocalDate.now());
        seatReservation.setFirstName("BRUCE");
        seatReservation.setLastName("PEARL");
        seatReservation.setNumberOfBags(111);
        seatReservation.makeNotFlyingWithInfant();


        flightDesignatorField = new TextField();
        flightDatePicker = new DatePicker();
        firstNameField = new TextField();
        lastNameField = new TextField();
        numberOfBagsField = new TextField();
        flyingWithInfantCheckBox = new CheckBox("Flying with Infant");
        numberOfPassengersField = new TextField("1");
        numberOfPassengersField.setEditable(false);


        flyingWithInfantCheckBox.setOnAction(e -> {
            if (flyingWithInfantCheckBox.isSelected()) {
                numberOfPassengersField.setText("2");
            } else {
                numberOfPassengersField.setText("1");
            }
        });


        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            try {
                seatReservation.setFlightDesignator(flightDesignatorField.getText());
                seatReservation.setFlightDate(flightDatePicker.getValue());
                seatReservation.setFirstName(firstNameField.getText());
                seatReservation.setLastName(lastNameField.getText());
                seatReservation.setNumberOfBags(Integer.parseInt(numberOfBagsField.getText()));
                if (flyingWithInfantCheckBox.isSelected()) {
                    seatReservation.makeFlyingWithInfant();
                } else {
                    seatReservation.makeNotFlyingWithInfant();
                }
                System.out.println(seatReservation);
                javafx.application.Platform.exit();
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        });


        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            System.out.println("Cancel clicked");
            javafx.application.Platform.exit();
        });


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(new Label("Flight Designator:"), 0, 0);
        gridPane.add(flightDesignatorField, 1, 0);
        gridPane.add(new Label("Flight Date:"), 0, 1);
        gridPane.add(flightDatePicker, 1, 1);
        gridPane.add(new Label("First Name:"), 0, 2);
        gridPane.add(firstNameField, 1, 2);
        gridPane.add(new Label("Last Name:"), 0, 3);
        gridPane.add(lastNameField, 1, 3);
        gridPane.add(new Label("Number of Bags:"), 0, 4);
        gridPane.add(numberOfBagsField, 1, 4);
        gridPane.add(flyingWithInfantCheckBox, 1, 5);
        gridPane.add(new Label("Number of Passengers:"), 0, 6);
        gridPane.add(numberOfPassengersField, 1, 6);

        HBox buttonsBox = new HBox(10, saveButton, cancelButton);
        buttonsBox.setAlignment(Pos.TOP_RIGHT);

        BorderPane root = new BorderPane();
        root.setCenter(gridPane);
        root.setBottom(buttonsBox);

        Scene scene = new Scene(root, 500, 300);
        stage.setTitle("Seat Reservation");
        stage.setScene(scene);

        updateUI();
        stage.show();
    }

    private void updateUI() {
        flightDesignatorField.setText(seatReservation.getFlightDesignator());
        flightDatePicker.setValue(seatReservation.getFlightDate());
        firstNameField.setText(seatReservation.getFirstName());
        lastNameField.setText(seatReservation.getLastName());
        numberOfBagsField.setText(String.valueOf(seatReservation.getNumberOfBags()));
        flyingWithInfantCheckBox.setSelected(seatReservation.isFlyingWithInfant());
        numberOfPassengersField.setText(seatReservation.isFlyingWithInfant() ? "2" : "1");
    }

    public static void main(String[] args) {
        launch();
    }



}


