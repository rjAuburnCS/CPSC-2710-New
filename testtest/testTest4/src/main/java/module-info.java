module com.example.testtest4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testtest4 to javafx.fxml;
    exports com.example.testtest4;
}