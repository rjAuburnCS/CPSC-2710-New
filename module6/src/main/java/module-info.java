module edu.au.cpsc.part2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.au.cpsc.part2 to javafx.fxml;
    exports edu.au.cpsc.part2;

    opens edu.au.cpsc.part1 to javafx.fxml;
    exports edu.au.cpsc.part1;
    exports edu.au.cpsc.part2.controller;
    opens edu.au.cpsc.part2.controller to javafx.fxml;
}