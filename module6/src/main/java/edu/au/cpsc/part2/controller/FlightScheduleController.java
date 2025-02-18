package edu.au.cpsc.part2.controller;

import edu.au.cpsc.part2.data.AirlineDatabase;
import edu.au.cpsc.part2.data.AirlineDatabaseIO;
import edu.au.cpsc.part2.model.FlightScheduleModel;
import edu.au.cpsc.part2.model.ScheduledFlight;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    @FXML private Button addButton, removeButton, clearButton;

    private AirlineDatabase database;
    private FlightScheduleModel model;

    private BooleanProperty isValidDaysOfWeek = new SimpleBooleanProperty(false);

    public void initialize() {
        flightDesignatorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFlightDesignator()));
        departureAirportColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDepartureAirportIdent()));
        arrivalAirportColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getArrivalAirportIdent()));
        daysOfWeekColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDaysOfWeekShortForm()));

        database = loadDatabase();
        flightTableView.getItems().setAll(database.getScheduledFlights());

        model = new FlightScheduleModel();
        bindFieldsToModel();

        setupDaysOfWeekListeners();


        addButton.disableProperty().bind(
                Bindings.or(
                        Bindings.or(
                                model.isValidFlightDesignatorProperty().not(),
                                Bindings.or(
                                        model.isValidDepartureAirportProperty().not(),
                                        model.isValidArrivalAirportProperty().not()
                                )
                        ),
                        Bindings.or(
                                isValidDaysOfWeek.not(),
                                Bindings.and(
                                        model.isNewProperty().not(),
                                        model.isModifiedProperty().not()
                                )
                        )
                )
        );

        removeButton.disableProperty().bind(
                Bindings.isEmpty(flightTableView.getSelectionModel().getSelectedItems())
        );
    }

    private AirlineDatabase loadDatabase() {
        try (InputStream is = new FileInputStream("flights.dat")) {
            return AirlineDatabaseIO.load(is);
        } catch (IOException | ClassNotFoundException e) {
            return new AirlineDatabase();
        }
    }

    public void saveDatabase() {
        try (OutputStream os = new FileOutputStream("flights.dat")) {
            AirlineDatabaseIO.save(database, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void handleAddFlight() {
        System.out.println("Add button clicked");

        ScheduledFlight flight = createScheduledFlightFromFields();
        if (flight != null) {
            database.addScheduledFlight(flight);
            saveDatabase();
            flightTableView.getItems().setAll(database.getScheduledFlights());
        }
    }

    @FXML private void handleRemoveFlight() {
        System.out.println("Remove button clicked");

        ScheduledFlight selectedFlight = flightTableView.getSelectionModel().getSelectedItem();
        if (selectedFlight != null) {
            database.removeScheduledFlight(selectedFlight);
            saveDatabase();
            flightTableView.getItems().setAll(database.getScheduledFlights());
        }
    }

    @FXML private void handleClearFields() {
        System.out.println("Clear button clicked");

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


        flightDesignatorField.setStyle("-fx-border-color: red;");
        departureAirportField.setStyle("-fx-border-color: red;");
        arrivalAirportField.setStyle("-fx-border-color: red;");
    }

    private ScheduledFlight createScheduledFlightFromFields() {
        String flightDesignator = flightDesignatorField.getText().trim();
        String departureAirportIdent = departureAirportField.getText().trim();
        String arrivalAirportIdent = arrivalAirportField.getText().trim();
        LocalTime departureTime = LocalTime.of(0, 0);
        LocalTime arrivalTime = LocalTime.of(0, 0);
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

    private void bindFieldsToModel() {
        flightDesignatorField.textProperty().bindBidirectional(model.flightDesignatorProperty());
        departureAirportField.textProperty().bindBidirectional(model.departureAirportProperty());
        arrivalAirportField.textProperty().bindBidirectional(model.arrivalAirportProperty());


        flightDesignatorField.setStyle("-fx-border-color: red;");
        departureAirportField.setStyle("-fx-border-color: red;");
        arrivalAirportField.setStyle("-fx-border-color: red;");

        flightDesignatorField.textProperty().addListener((observable, oldValue, newValue) -> {
            model.setValidFlightDesignator(!newValue.trim().isEmpty());
        });
        departureAirportField.textProperty().addListener((observable, oldValue, newValue) -> {
            model.setValidDepartureAirport(!newValue.trim().isEmpty());
        });
        arrivalAirportField.textProperty().addListener((observable, oldValue, newValue) -> {
            model.setValidArrivalAirport(!newValue.trim().isEmpty());
        });

        flightDesignatorField.styleProperty().bind(
                Bindings.when(model.isValidFlightDesignatorProperty()).then("-fx-border-color: none;").otherwise("-fx-border-color: red;")
        );
        departureAirportField.styleProperty().bind(
                Bindings.when(model.isValidDepartureAirportProperty()).then("-fx-border-color: none;").otherwise("-fx-border-color: red;")
        );
        arrivalAirportField.styleProperty().bind(
                Bindings.when(model.isValidArrivalAirportProperty()).then("-fx-border-color: none;").otherwise("-fx-border-color: red;")
        );
    }

    private void setupDaysOfWeekListeners() {
        ToggleButton[] dayButtons = {mondayButton, tuesdayButton, wednesdayButton, thursdayButton, fridayButton, saturdayButton, sundayButton};

        for (ToggleButton dayButton : dayButtons) {
            dayButton.selectedProperty().addListener((obs, oldVal, newVal) -> updateDaysOfWeekValidity(dayButtons));
        }
    }

    private void updateDaysOfWeekValidity(ToggleButton[] dayButtons) {
        boolean anySelected = false;
        for (ToggleButton dayButton : dayButtons) {
            if (dayButton.isSelected()) {
                anySelected = true;
                break;
            }
        }
        isValidDaysOfWeek.set(anySelected);
        System.out.println("Days of Week Valid: " + anySelected);
    }
}






