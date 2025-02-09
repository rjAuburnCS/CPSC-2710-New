package edu.au.cpsc.module4.model;

import java.time.LocalTime;
import java.time.DayOfWeek;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public String getDaysOfWeekString() {
        return daysOfWeek.stream().map(DayOfWeek::name).collect(Collectors.joining(", "));
    }

    public String getDaysOfWeekShortForm() {
        return Stream.of(DayOfWeek.values())
                .filter(daysOfWeek::contains)
                .map(day -> {
                    switch (day) {
                        case MONDAY: return "M";
                        case TUESDAY: return "T";
                        case WEDNESDAY: return "W";
                        case THURSDAY: return "R";
                        case FRIDAY: return "F";
                        case SATURDAY: return "S";
                        case SUNDAY: return "U";
                        default: return "";
                    }
                })
                .collect(Collectors.joining(", "));
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduledFlight that = (ScheduledFlight) o;
        return Objects.equals(flightDesignator, that.flightDesignator) &&
                Objects.equals(departureAirportIdent, that.departureAirportIdent) &&
                Objects.equals(departureTime, that.departureTime) &&
                Objects.equals(arrivalAirportIdent, that.arrivalAirportIdent) &&
                Objects.equals(arrivalTime, that.arrivalTime) &&
                Objects.equals(daysOfWeek, that.daysOfWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightDesignator, departureAirportIdent, departureTime, arrivalAirportIdent, arrivalTime, daysOfWeek);
    }
}
