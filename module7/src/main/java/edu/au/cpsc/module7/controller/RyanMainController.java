package edu.au.cpsc.module7.controller;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RyanMainController implements Initializable {

    private static final Logger LOGGER = Logger.getLogger(RyanMainController.class.getName());

    @FXML
    private MenuItem newMenuItem;
    @FXML
    private MenuItem saveMenuItem;
    @FXML
    private MenuItem exitMenuItem;
    @FXML
    private MenuItem addTaskMenuItem;
    @FXML
    private MenuItem editTaskMenuItem;
    @FXML
    private MenuItem deleteTaskMenuItem;
    @FXML
    private Button addTaskButton;
    @FXML
    private Button editTaskButton;
    @FXML
    private Button deleteTaskButton;
    @FXML
    private ListView<String> taskListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handleLoad();

        taskListView.getSelectionModel().clearSelection();

        taskListView.setCellFactory(lv -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {

                    String[] parts = item.split(" - ");
                    if (parts.length >= 2) {

                        setText(parts[0] + "\n" + parts[1]);
                    } else {
                        setText(item);
                    }
                }
            }
        });
    }

    @FXML
    private void handleNew() {
        taskListView.getItems().clear();
    }

    @FXML
    private void handleSave() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"))) {
            for (String task : taskListView.getItems()) {
                writer.write(task.replace("\n", "\\n"));
                writer.newLine();
            }
            LOGGER.info("Tasks saved successfully.");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to save tasks", e);
        }
    }

    @FXML
    private void handleLoad() {
        taskListView.getItems().clear();
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                taskListView.getItems().add(line.replace("\\n", "\n"));
            }
            LOGGER.info("Tasks loaded successfully.");
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load tasks", e);
        }
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleAddTask() {
        LOGGER.info("Add Task button pressed.");
        openTaskDetailWindow(null);
    }

    @FXML
    private void handleEditTask() {
        String selectedTask = taskListView.getSelectionModel().getSelectedItem();
        if (selectedTask != null) {
            openTaskDetailWindow(selectedTask);
        }
    }

    @FXML
    private void handleDeleteTask() {
        int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            taskListView.getItems().remove(selectedIndex);
        }
    }

    private void openTaskDetailWindow(String task) {
        try {
            LOGGER.info("Opening Task Detail Window.");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/au/cpsc/module7/TaskDetail.fxml"));
            Parent parent = fxmlLoader.load();

            TaskDetailController controller = fxmlLoader.getController();
            if (controller != null) {
                controller.setTask(task);
                controller.setMainController(this);
                LOGGER.info("TaskDetailController initialized.");

                Stage stage = new Stage();
                stage.setTitle("Task Detail Data");
                stage.setScene(new Scene(parent));
                stage.setWidth(600);
                stage.setHeight(400);
                stage.show();
            } else {
                LOGGER.log(Level.SEVERE, "Failed to get TaskDetailController");
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to open task detail window", e);
        }
    }

    public void addTask(String task) {
        if (task != null && !task.isEmpty()) {
            taskListView.getItems().add(task);
        }
    }

    public void updateTask(String oldTask, String newTask) {
        int index = taskListView.getItems().indexOf(oldTask);
        if (index >= 0) {
            taskListView.getItems().set(index, newTask);
        }
    }
}
