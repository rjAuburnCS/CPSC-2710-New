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

    private void validateAndSet(StringProperty property, String value, BooleanProperty validProperty) {
        property.set(value);
        validProperty.set(!value.trim().isEmpty());
    }

    public String getFlightDesignator() {
        return flightDesignator.get();
    }

    public void setFlightDesignator(String flightDesignator) {
        validateAndSet(this.flightDesignator, flightDesignator, isValidFlightDesignator);
    }

    public StringProperty flightDesignatorProperty() {
        return flightDesignator;
    }

    public String getDepartureAirport() {
        return departureAirport.get();
    }

    public void setDepartureAirport(String departureAirport) {
        validateAndSet(this.departureAirport, departureAirport, isValidDepartureAirport);
    }

    public StringProperty departureAirportProperty() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport.get();
    }

    public void setArrivalAirport(String arrivalAirport) {
        validateAndSet(this.arrivalAirport, arrivalAirport, isValidArrivalAirport);
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

