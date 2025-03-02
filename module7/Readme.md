# Task Manager Lite

## Inspiration
The inspiration behind Task Manager Lite arose from the depths, due to my need for a simple and efficient task management application that helps me/anyone organize simple tasks and (hopefully) increase productivity!

## Vision
My vision was and is to create a lightweight, user-friendly task manager that allows users to easily create new task lists, add, edit, save, and delete important tasks while providing a visually appealing high contrast interface.
This is version 1.0.0 of my Task Manager Lite application. I will add to this over time to practice what javafx is able to create!
## Basic Functionality
- Menu with File and Edit, each having a drop down menu.
- Menu - "File" options include the function to make a new list, save the changes, and exit the program.
- Menu - "Edit" options include the function to add tasks, edit tasks, or delete a task.
- Add new tasks with name, description, and due date - In a separate window "Task Detail Data".
- Edit existing tasks.
- Save tasks to a file.
- Load tasks from a file.
- Delete tasks.

## How to Use
1. **File Menu**:
    - **New (Ctrl+N)**: Click "File" and select "New" to clear the current list and start a new one.
    - **Save (Ctrl+S)**: Click "File" and select "Save" to save your current tasks to a file.
    - **Exit (Ctrl+Q)**: Click "File" and select "Exit" to close the application.

2. **Edit Menu**:
    - **Add Task (Ctrl+A)**: Click "Edit" and select "Add Task" to open the task detail window and enter task details.
    - **Edit Task (Ctrl+E)**: Select a task from the list, then click "Edit" to modify the selected task.
    - **Delete Task (Ctrl+D)**: Select a task from the list, then click "Edit" and select "Delete Task" to remove the selected task.

3. **Main Window**:Opens automatically when program is launched, shows the list of tasks with user options to:
    - **Add Task**: Click the "Add" button to open the task detail window and enter task details.
    - **Edit Task**: Select a task from the list and click the "Edit" button to modify the selected task.
    - **Delete Task**: Select a task from the list and click the "Delete" button to remove the selected task.
    
4. **Task Detail Data Window**:  This secondary window opens automatically when the "Add" button or (Ctrl + A) are selected by the user, lets user create a task with:
	- **Task Name**: User text field to input the general name of the task at hand, for example: A trip to the grocery store can be named "Grocery"
	- **Description**: User text area  to input the details (enumerated or not) needed to be completed, for example: A trip to the grocery store you might need to buy a list " 1. Meat\n 2. Cheese\n ..."
	- **Due Date**: User date pick field, user can input their own due date in the field OR use the "calendar" icon/button directly to the right of the field to select a formatted due date (more reliable for data persistence)
    - **Save**: IMPORTANT - make sure you click "Save". When the user has input data into one of the fields, data in any of the three input fields will be accpeted, the save button at the bottom of "Task Detail Data" window will save the work, add it to the task list, and auto-closes the Task Detail Data window.
    - **Cancel**: When the user decides they do not need to add a task, in the Task Detail Data window, click on "cancel" to close the window and have only the main window with the list of tasks open.

4. **Task Management**:
    - **Save Tasks**: Click the "Save" menu item under "File" or use the keyboard shortcut (Ctrl+S) to save the added tasks to a file.
    - **Load Tasks**: Tasks are automatically loaded when the application starts.
    - **Add Task**: Click the "Add" button or use the "Add Task" menu item (Ctrl + A) to open the task detail window and enter task details.
5. **IMPORTANT**: Do not forget - when you click "Add" (Ctrl +A) and add a new task, or when you click to "edit" (Ctrl + E) a task, you must go to "File" then select "Save" (Ctrl + S) in order for the task list to be updated and remain in the list the next time you launch the app!


## Functionality Implemented vs. Under Construction
- **Implemented**: 
    - Task addition, editing, saving, and deletion.
    - Custom CSS styling.
    - Basic data persistence via text file.
- **Under Construction-To be added at later date**: 
    - Export task-list to .csv file.
    - Fine tuning CSS styling.
    - Implementing more robust user feedback by adding input validity fields for text input.
    - Implementing a better system for data persistence, rather than a text file.


## Screenshots

![Main Window](mainwindow.png)
![Task Detail Window](taskdetailwindow.png)




## Project Structure
The project follows a straightforward MVC-like pattern with controllers managing the interactions and the user interface defined in FXML files.

### Files and Directories
- `src/main/java/edu/au/cpsc/module7/`: Contains the main application file and controllers.
    - `RyanTaskManagerApplication.java`: The main application class that starts the JavaFX application.
    - `controller/`: Contains the controllers for handling UI interactions.
        - `RyanMainController.java`: Controller for the main view.
        - `TaskDetailController.java`: Controller for the task detail view.
- `src/main/resources/edu/au/cpsc/module7/`: Contains the FXML files and CSS stylesheets.
    - `Main-View.fxml`: Defines the layout of the main window.
    - `TaskDetail.fxml`: Defines the layout of the task detail window.
    - `main.css`: Stylesheet for the main window.
    - `detail.css`: Stylesheet for the task detail window.

## Requirements
- **Java**: JDK 11 or higher.
- **JavaFX**: JavaFX SDK 11 or higher.
- **Maven**: To build and manage dependencies.

## Building and Running the Application
1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/task-manager-lite.git
    cd task-manager-lite
    ```

2. **Build the project using Maven**:
    ```sh
    mvn clean install
    ```

3. **Run the application**:
    ```sh
    mvn javafx:run
    ```


