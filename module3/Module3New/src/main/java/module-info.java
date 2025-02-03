module edu.au.cpsc.module3new {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.au.cpsc.module3new to javafx.fxml;
    exports edu.au.cpsc.module3new;
}