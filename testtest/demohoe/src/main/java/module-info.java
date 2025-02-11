module edu.au.cpsc.demohoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.au.cpsc.demohoe to javafx.fxml;
    exports edu.au.cpsc.demohoe;
    exports edu.au.cpsc.demohoe.Controller;
    opens edu.au.cpsc.demohoe.Controller to javafx.fxml;
}