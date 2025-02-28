package edu.au.cpsc.module7.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class TaskDetailController {

    @FXML
    private TextField taskNameField;

    @FXML
    private TextArea taskDescriptionArea;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    private RyanMainController mainController;
    private String initialTask;

    public void setMainController(RyanMainController mainController) {
        this.mainController = mainController;
    }

    public void setTask(String task) {
        this.initialTask = task;
        if (task != null) {
            // Split the task details string by newline
            String[] taskDetails = task.split("\n", 2);

            if (taskDetails.length > 0) {
                taskNameField.setText(taskDetails[0]); // Set the task name
            }
            if (taskDetails.length > 1) {
                String[] descriptionAndDate = taskDetails[1].split(" - ", 2);
                if (descriptionAndDate.length > 0) {
                    taskDescriptionArea.setText(descriptionAndDate[0]); // Set the task description
                }
                if (descriptionAndDate.length > 1) {
                    String dueDateStr = descriptionAndDate[1]; // Extract the due date string
                    dueDatePicker.setValue(LocalDate.parse(dueDateStr)); // Set the due date
                }
            }
        }
    }


    @FXML
    private void handleSave() {
        String taskName = taskNameField.getText();
        String taskDescription = taskDescriptionArea.getText();
        String dueDate = dueDatePicker.getValue() != null ? dueDatePicker.getValue().toString() : "";

        if (taskName.trim().isEmpty()) {
            showErrorDialog("Task name cannot be empty.");
            return;
        }

        // Format task details with task name on the first line and description/date on the second line
        String taskDetails = taskName + "\n" + taskDescription + " - " + dueDate;

        if (initialTask != null) {
            mainController.updateTask(initialTask, taskDetails);
        } else {
            mainController.addTask(taskDetails);
        }

        // Close the window
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    private void showErrorDialog(String message) {
        // Add your custom error dialog implementation here
        System.err.println(message);
    }

    @FXML
    private void handleCancel() {
        // Close the window without saving
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
