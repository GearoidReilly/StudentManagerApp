package ie.gmit.studentmanager;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.time.*;

//Runner class now inherits from JavaFx Application class
public class Runner extends Application{

	//Student Manager variable
	StudentManager sm = new StudentManager();
	//Scene variables
	Scene mainScene;
	Scene addStudentScene;
	//Insets variable
	Insets borderPadding = new Insets(10, 10, 10, 10);
	
	//Overrides start function in application
	@Override
	public void start(Stage primaryStage) throws Exception{
		//Create secondary stage
		Stage secondaryStage = new Stage();
				
		/* Main Scene features */
		//Create header text
		Text headerText = new Text("Welcome to the Student Manager. \n Select one of the options below:");
		//Create output text
		TextArea outputText = new TextArea();
		
		//Create grid pane to hold items in the scene
		GridPane mainGridPane = new GridPane();
		//Set padding on the scene
		mainGridPane.setPadding(borderPadding);
		//Set spacing between objects on the main grid pane
		mainGridPane.setHgap(30);
		mainGridPane.setVgap(30);
		
		/* Add student functionality */
		//Create addButton
		Button addButton = new Button("Add Student");
		//Add functionality to button to open secondary stage
		addButton.setOnAction(event -> secondaryStage.show());
		
		/* Delete student functionality */
		//Create deleteButton
		Button deleteButton = new Button("Delete Student");
		//Create delete Label
		Label deleteLabel = new Label("Enter Student Id:");
		//Create deleteText
		TextField deleteText = new TextField();
		//Add functionality to button to delete student
		deleteButton.setOnAction(event ->{
			//Get value in delete student
			String deleteId = deleteText.getText().toString();
			
			//Check if deleteId is empty
			if(deleteId.isEmpty()) {
				//Inform the user they need to enter an id
				outputText.setText("Please enter a student id to delete.");
			}
			else {
				//Boolean to delete student
				Boolean result = sm.deleteStudent(deleteId);
				
				//If the deletion was successful
				if(result) {
					//Informs the user the student was deleted
					outputText.setText("Successfully deleted student: " + deleteId + ".");
				}
				else {
					//Informs user that the student couldn't be deleted
					outputText.setText("Student couldn't be deleted.");
				}
			}
		});
		
		/* Search by Id functionality */
		//Create searchByIdButton
		Button searchByIdButton = new Button("Search By Student Id");
		//Create searchById Label
		Label searchByIdLabel = new Label("Enter Student Id:");
		//Create searchByIdText
		TextField searchByIdText = new TextField();
		
		/* Search by First Name functionality */
		//Create searchByNameButton
		Button searchByNameButton = new Button("Search By First Name");
		//Create searchByName Label
		Label searchByNameLabel = new Label("Enter First Name:");
		//Create searchByNameText
		TextField searchByNameText = new TextField();
		
		/* Show total functionality */
		//Create showTotalButton
		Button showTotalButton = new Button("Show total Students");
		
		/* Quit functionality */
		//Create quitButton
		Button quitButton = new Button("Quit Student Manager");
		//Add functionality to quit Student Manager
		quitButton.setOnAction(event ->{
			primaryStage.close();
			secondaryStage.close();
		});
		
		//Adds content to the mainGridPane
		mainGridPane.add(headerText, 0, 0);
		mainGridPane.add(addButton, 0, 1);
		mainGridPane.add(deleteButton, 0, 2);
		mainGridPane.add(deleteLabel, 1, 2);
		mainGridPane.add(deleteText, 2, 2);
		mainGridPane.add(searchByIdButton, 0, 3);
		mainGridPane.add(searchByIdLabel, 1, 3);
		mainGridPane.add(searchByIdText, 2, 3);
		mainGridPane.add(searchByNameButton, 0, 4);
		mainGridPane.add(searchByNameLabel, 1, 4);
		mainGridPane.add(searchByNameText, 2, 4);
		mainGridPane.add(showTotalButton, 0, 5);
		mainGridPane.add(quitButton, 0, 6);
		mainGridPane.add(outputText, 0, 7, 3, 1);
		
		//Adds values to the mainStage
		mainScene = new Scene(mainGridPane, 700, 600);
		
		//Set the title to primary stage
		primaryStage.setTitle("Student Manager");
		//Set the mainScene to the primary stage
		primaryStage.setScene(mainScene);
		//Shows the primary stage
		primaryStage.show();
		
		
		/* Add Student Scene Features */
		//Create header text
		Text secondHeaderText = new Text("Enter student details");
		//Create output text
		TextArea secondOutputText = new TextArea();
		//Create Labels
		Label sidLabel = new Label("Enter Student Id:");
		Label fnameLabel = new Label("Enter First Name:");
		Label lnameLabel = new Label("Enter Last Name:");
		Label dobLabel = new Label("Enter date of birth:");
		//Create Input fields
		TextField sidText = new TextField();
		TextField fnameText = new TextField();
		TextField lnameText = new TextField();
		DatePicker dobPicker = new DatePicker();
		//Create submit button
		Button addStudentButton = new Button("Add student");
		
		//Create second grid pane to hold items in the scene
		GridPane studentGridPane = new GridPane();
		//Set Padding
		studentGridPane.setPadding(borderPadding);
		//Set spacing between content
		studentGridPane.setHgap(10);
		studentGridPane.setVgap(10);
		
		/* Add student page functionality */
		addStudentButton.setOnAction(event ->{
			//Store temporary values for cleaner validation
			String sidValue = sidText.getText().toString();
			String fnameValue = fnameText.getText().toString();
			String lnameValue = lnameText.getText().toString();
			LocalDate dobValue = dobPicker.getValue();
			//Error text value
			String errorText = "";
			
			
			//Check sidValue to make sure it isn't empty and there the student id doesn't already exist
			if(sidValue.isEmpty()) {
				//Add to the errorText
				errorText += "Please enter a student id. \n";
			}else {
				//Check if a student with that id exists already
				Student checkStudent = sm.getStudentById(sidValue);
				
				if(checkStudent != null) {
					//Inform the user that student id already exists
					errorText += "Student id already exists. \n";
				}
			}
			
			//Check if First name is empty
			if(fnameValue.isEmpty()) {
				//Add to error text
				errorText += "Please enter a First Name. \n";
			}
			
			//Check if Second name is empty
			if(lnameValue.isEmpty()) {
				//Add to error text
				errorText += "Please enter a Last Name. \n";
			}
			
			//Check if a date has been added
			if(dobValue == null) {
				errorText += "Please enter a date. \n";
			}
			
			//Check if the error message is not empty
			if(errorText.length() > 0) {
				//Print the error message
				secondOutputText.setText(errorText);
			}else {
				//Create new student and add it to the student manager
				Student newStudent = new Student(sidValue, fnameValue, lnameValue, dobValue);
				sm.addStudent(newStudent);
				
				//Tell the user the student was added successfully
				secondOutputText.setText("Student added successfully.");
				
				//Clear TextFields
				sidText.clear();
				fnameText.clear();
				lnameText.clear();
				dobPicker.setValue(null);
			}
		});
		
		//Add content to the student grid pane
		studentGridPane.add(secondHeaderText, 0, 0);
		studentGridPane.add(sidLabel, 0, 1);
		studentGridPane.add(sidText, 1, 1);
		studentGridPane.add(fnameLabel, 0, 2);
		studentGridPane.add(fnameText, 1, 2);
		studentGridPane.add(lnameLabel, 0, 3);
		studentGridPane.add(lnameText, 1, 3);
		studentGridPane.add(dobLabel, 0, 4);
		studentGridPane.add(dobPicker, 1, 4);
		studentGridPane.add(addStudentButton, 0, 5);
		studentGridPane.add(secondOutputText, 0, 6, 2, 1);
		
		//Add values to add student stage
		addStudentScene = new Scene(studentGridPane, 500, 500);
		//Assign scene to secondary stage
		secondaryStage.setScene(addStudentScene);
		
	}
	
	public static void main(String[] args) {
		//Launches the application
		launch(args);
	}

}
