package edu.au.cpsc.module4.model;

import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ScheduledFlight {

    private String flightDesignator;
    private String departureAirportIdent;
    private LocalTime departureTime;
    private String arrivalAirportIdent;
    private LocalTime arrivalTime;
    private Set<DayOfWeek> daysOfWeek;

    public ScheduledFlight(String flightDesignator, String departureAirportIdent, LocalTime departureTime, String arrivalAirportIdent, LocalTime arrivalTime, Set<DayOfWeek> daysOfWeek) {
        setFlightDesignator(flightDesignator);
        setDepartureAirportIdent(departureAirportIdent);
        setDepartureTime(departureTime);
        setArrivalAirportIdent(arrivalAirportIdent);
        setArrivalTime(arrivalTime);
        setDaysOfWeek(daysOfWeek);
    }
    public String getFlightDesignator() {
        return flightDesignator;
    }

    public void setFlightDesignator(String flightDesignator) {
        if (flightDesignator == null) throw new IllegalArgumentException("Flight Designator needs a value");
        this.flightDesignator = flightDesignator;
    }

    public String getDepartureAirportIdent() {
        return departureAirportIdent;
    }

    public void setDepartureAirportIdent(String departureAirportIdent) {
        if (departureAirportIdent == null) throw new IllegalArgumentException("Airport Ident needs a value");
        this.departureAirportIdent = departureAirportIdent;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        if (departureTime == null) throw new IllegalArgumentException("Departure time needs a value");
        this.departureTime = departureTime;
    }

    public String getArrivalAirportIdent() {
        return arrivalAirportIdent;
    }

    public void setArrivalAirportIdent(String arrivalAirportIdent) {
        if (arrivalAirportIdent == null) throw new IllegalArgumentException("Arrival Airport Ident needs a value");
        this.arrivalAirportIdent = arrivalAirportIdent;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        if (arrivalTime == null) throw new IllegalArgumentException("Flight Designator needs a value");
        this.arrivalTime = arrivalTime;
    }

    public Set<DayOfWeek> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(Set<DayOfWeek> daysOfWeek) {
        if (daysOfWeek == null) throw new IllegalArgumentException("Day needs a value");
        this.daysOfWeek = daysOfWeek;
    }
}
