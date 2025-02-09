package com.example.demo6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    private String ident;
    private String type;
    private String name;
    private Integer elevationFt;
    private String continent;
    private String isoCountry;
    private String isoRegion;
    private String municipality;
    private String gpsCode;
    private String iataCode;
    private String localCode;
    private Double latitude;
    private Double longitude;

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getElevationFt() {
        return elevationFt;
    }

    public void setElevationFt(Integer elevationFt) {
        this.elevationFt = elevationFt;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getIsoCountry() {
        return isoCountry;
    }

    public void setIsoCountry(String isoCountry) {
        this.isoCountry = isoCountry;
    }

    public String getIsoRegion() {
        return isoRegion;
    }

    public void setIsoRegion(String isoRegion) {
        this.isoRegion = isoRegion;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getLocalCode() {
        return localCode;
    }

    public void setLocalCode(String localCode) {
        this.localCode = localCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    public static List<Airport> readAll() throws IOException {
        List<Airport> airports = new ArrayList<>();

        try (InputStream is = Airport.class.getResourceAsStream("/com/example/demo6/airport-codes.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            // Skip header line
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",", -1); // -1 to include empty values
                Airport airport = new Airport();

                // Set the values for airport object from the CSV line
                airport.setIdent(values[0]);
                airport.setType(values[1]);
                airport.setName(values[2]);
                airport.setElevationFt(values[3].isEmpty() ? null : Integer.parseInt(values[3]));
                airport.setContinent(values[4]);
                airport.setIsoCountry(values[5]);
                airport.setIsoRegion(values[6]);
                airport.setMunicipality(values[7]);
                airport.setGpsCode(values[8]);
                airport.setIataCode(values[9]);
                airport.setLocalCode(values[10]);

                // Handle parsing for Double values with empty check
                airport.setLongitude(values[11].isEmpty() ? null : Double.parseDouble(values[11]));
                airport.setLatitude(values[12].isEmpty() ? null : Double.parseDouble(values[12]));

                airports.add(airport);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            // Consider logging or rethrowing the exception as needed
        }

        return airports;
    }
}
