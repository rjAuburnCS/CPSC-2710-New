package edu.au.cpsc.module4.controller;

import edu.au.cpsc.module4.model.ScheduledFlight;
import edu.au.cpsc.module4.data.AirlineDatabase;
import edu.au.cpsc.module4.data.AirlineDatabaseIO;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class FlightScheduleController {

    @FXML private TableView<ScheduledFlight> flightTableView;
    @FXML private TableColumn<ScheduledFlight, String> flightDesignatorColumn;
    @FXML private TableColumn<ScheduledFlight, String> departureAirportColumn;
    @FXML private TableColumn<ScheduledFlight, String> arrivalAirportColumn;
    @FXML private TableColumn<ScheduledFlight, String> daysOfWeekColumn;
    @FXML private TextField flightDesignatorField;
    @FXML private TextField departureAirportField;
    @FXML private TextField arrivalAirportField;
    @FXML private ToggleButton mondayButton, tuesdayButton, wednesdayButton, thursdayButton, fridayButton, saturdayButton, sundayButton;

    private AirlineDatabase database;

    public void initialize() {
        flightDesignatorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFlightDesignator()));
        departureAirportColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDepartureAirportIdent()));
        arrivalAirportColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArrivalAirportIdent()));
        daysOfWeekColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDaysOfWeekShortForm()));

        // Ensure the columns resize with the window
        flightDesignatorColumn.prefWidthProperty().bind(flightTableView.widthProperty().multiply(0.25));
        departureAirportColumn.prefWidthProperty().bind(flightTableView.widthProperty().multiply(0.25));
        arrivalAirportColumn.prefWidthProperty().bind(flightTableView.widthProperty().multiply(0.25));
        daysOfWeekColumn.prefWidthProperty().bind(flightTableView.widthProperty().multiply(0.25));

        database = loadDatabase();
        flightTableView.getItems().setAll(database.getScheduledFlights());
    }

    private AirlineDatabase loadDatabase() {
        try (InputStream is = new FileInputStream("flights.dat")) {
            return AirlineDatabaseIO.load(is);
        } catch (IOException | ClassNotFoundException e) {
            return new AirlineDatabase();
        }
    }

    private void saveDatabase() {
        try (OutputStream os = new FileOutputStream("flights.dat")) {
            AirlineDatabaseIO.save(database, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void handleAddFlight() {
        ScheduledFlight flight = createScheduledFlightFromFields();
        if (flight != null) {
            database.addScheduledFlight(flight);
            saveDatabase();
            flightTableView.getItems().setAll(database.getScheduledFlights());
        }
    }

    @FXML private void handleRemoveFlight() {
        ScheduledFlight selectedFlight = flightTableView.getSelectionModel().getSelectedItem();
        if (selectedFlight != null) {
            database.removeScheduledFlight(selectedFlight);
            saveDatabase();
            flightTableView.getItems().setAll(database.getScheduledFlights());
        }
    }

    @FXML private void handleClearFields() {
        flightDesignatorField.clear();
        departureAirportField.clear();
        arrivalAirportField.clear();
        mondayButton.setSelected(false);
        tuesdayButton.setSelected(false);
        wednesdayButton.setSelected(false);
        thursdayButton.setSelected(false);
        fridayButton.setSelected(false);
        saturdayButton.setSelected(false);
        sundayButton.setSelected(false);
    }

    private ScheduledFlight createScheduledFlightFromFields() {
        String flightDesignator = flightDesignatorField.getText();
        String departureAirportIdent = departureAirportField.getText();
        String arrivalAirportIdent = arrivalAirportField.getText();
        LocalTime departureTime = LocalTime.of(13, 30); // Placeholder for actual time input
        LocalTime arrivalTime = LocalTime.of(15, 0); // Placeholder for actual time input
        Set<DayOfWeek> daysOfWeek = new HashSet<>();

        if (mondayButton.isSelected()) daysOfWeek.add(DayOfWeek.MONDAY);
        if (tuesdayButton.isSelected()) daysOfWeek.add(DayOfWeek.TUESDAY);
        if (wednesdayButton.isSelected()) daysOfWeek.add(DayOfWeek.WEDNESDAY);
        if (thursdayButton.isSelected()) daysOfWeek.add(DayOfWeek.THURSDAY);
        if (fridayButton.isSelected()) daysOfWeek.add(DayOfWeek.FRIDAY);
        if (saturdayButton.isSelected()) daysOfWeek.add(DayOfWeek.SATURDAY);
        if (sundayButton.isSelected()) daysOfWeek.add(DayOfWeek.SUNDAY);

        if (flightDesignator.isEmpty() || departureAirportIdent.isEmpty() || arrivalAirportIdent.isEmpty() || daysOfWeek.isEmpty()) {
            showAlert("Input Error", "All fields must be filled out.");
            return null;
        }

        return new ScheduledFlight(flightDesignator, departureAirportIdent, departureTime, arrivalAirportIdent, arrivalTime, daysOfWeek);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
