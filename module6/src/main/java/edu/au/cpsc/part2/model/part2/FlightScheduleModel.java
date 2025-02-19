package edu.au.cpsc.part2.model.part2;

import javafx.beans.property.*;

public class FlightScheduleModel {

    private final StringProperty flightDesignator = new SimpleStringProperty();
    private final StringProperty departureAirport = new SimpleStringProperty();
    private final StringProperty arrivalAirport = new SimpleStringProperty();
    private final BooleanProperty isNew = new SimpleBooleanProperty(true);
    private final BooleanProperty isModified = new SimpleBooleanProperty(false);

    private final BooleanProperty isValidFlightDesignator = new SimpleBooleanProperty(false);
    private final BooleanProperty isValidDepartureAirport = new SimpleBooleanProperty(false);
    private final BooleanProperty isValidArrivalAirport = new SimpleBooleanProperty(false);

    public String getFlightDesignator() {
        return flightDesignator.get();
    }

    public void setFlightDesignator(String flightDesignator) {
        this.flightDesignator.set(flightDesignator);
        setValidFlightDesignator(!flightDesignator.trim().isEmpty());
    }

    public StringProperty flightDesignatorProperty() {
        return flightDesignator;
    }

    public String getDepartureAirport() {
        return departureAirport.get();
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport.set(departureAirport);
        setValidDepartureAirport(!departureAirport.trim().isEmpty());
    }

    public StringProperty departureAirportProperty() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport.get();
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport.set(arrivalAirport);
        setValidArrivalAirport(!arrivalAirport.trim().isEmpty());
    }

    public StringProperty arrivalAirportProperty() {
        return arrivalAirport;
    }

    public boolean isNew() {
        return isNew.get();
    }

    public BooleanProperty isNewProperty() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew.set(isNew);
    }

    public boolean isModified() {
        return isModified.get();
    }

    public BooleanProperty isModifiedProperty() {
        return isModified;
    }

    public void setModified(boolean isModified) {
        this.isModified.set(isModified);
    }

    public boolean isValidFlightDesignator() {
        return isValidFlightDesignator.get();
    }

    public BooleanProperty isValidFlightDesignatorProperty() {
        return isValidFlightDesignator;
    }

    public void setValidFlightDesignator(boolean isValidFlightDesignator) {
        this.isValidFlightDesignator.set(isValidFlightDesignator);
    }

    public boolean isValidDepartureAirport() {
        return isValidDepartureAirport.get();
    }

    public BooleanProperty isValidDepartureAirportProperty() {
        return isValidDepartureAirport;
    }

    public void setValidDepartureAirport(boolean isValidDepartureAirport) {
        this.isValidDepartureAirport.set(isValidDepartureAirport);
    }

    public boolean isValidArrivalAirport() {
        return isValidArrivalAirport.get();
    }

    public BooleanProperty isValidArrivalAirportProperty() {
        return isValidArrivalAirport;
    }

    public void setValidArrivalAirport(boolean isValidArrivalAirport) {
        this.isValidArrivalAirport.set(isValidArrivalAirport);
    }
}


