package edu.au.cpsc.module3.mod3project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.util.List;

public class AirportController {

    @FXML
    private TextField identField;
    @FXML
    private TextField iataCodeField;
    @FXML
    private TextField localCodeField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField elevationField;
    @FXML
    private TextField countryField;
    @FXML
    private TextField regionField;
    @FXML
    private TextField municipalityField;
    @FXML
    private Button searchButton;
    @FXML
    private Pane mapPane;
    @FXML
    private WebView webView;

    private List<Airport> airports;

    @FXML
    public void initialize() {
        try {
            airports = Airport.readAll();
        } catch (IOException e) {
            e.printStackTrace();
            
        }

        
        identField.setOnAction(event -> searchAirport());
        iataCodeField.setOnAction(event -> searchAirport());
        localCodeField.setOnAction(event -> searchAirport());
        searchButton.setOnAction(event -> searchAirport());
    }

    private void searchAirport() {
        String ident = identField.getText().trim();
        String iataCode = iataCodeField.getText().trim();
        String localCode = localCodeField.getText().trim();

        
        Airport airport = null;
        for (Airport a : airports) {
            if (!ident.isEmpty() && ident.equals(a.getIdent())) {
                airport = a;
                break;
            } else if (!iataCode.isEmpty() && iataCode.equals(a.getIataCode())) {
                airport = a;
                break;
            } else if (!localCode.isEmpty() && localCode.equals(a.getLocalCode())) {
                airport = a;
                break;
            }
        }

     
        if (airport != null) {
            typeField.setText(airport.getType());
            nameField.setText(airport.getName());
            elevationField.setText(airport.getElevationFt() != null ? airport.getElevationFt().toString() : "");
            countryField.setText(airport.getIsoCountry());
            regionField.setText(airport.getIsoRegion());
            municipalityField.setText(airport.getMunicipality());

           
            updateMap(airport);
        }
    }

    private void updateMap(Airport airport) {
        WebEngine webEngine = webView.getEngine();
        double latitude = airport.getLatitude();
        double longitude = airport.getLongitude();
        int zoomLevel = 12; 
        String url = "https://www.windy.com/?" + latitude + "," + longitude + "," + zoomLevel;
        webEngine.load(url);
    }
}
