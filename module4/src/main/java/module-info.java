module edu.au.cpsc.module4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.au.cpsc.module4 to javafx.fxml;
    exports edu.au.cpsc.module4;
    exports edu.au.cpsc.module4.controller;
    opens edu.au.cpsc.module4.controller to javafx.fxml;
}