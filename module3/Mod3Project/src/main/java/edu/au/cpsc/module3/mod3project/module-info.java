module edu.au.cpsc.module3.mod3project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.media;

    opens edu.au.cpsc.module3.mod3project to javafx.fxml;
    exports edu.au.cpsc.module3.mod3project;
}