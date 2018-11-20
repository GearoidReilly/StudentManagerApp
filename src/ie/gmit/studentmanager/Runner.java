package ie.gmit.studentmanager;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.time.*;
import java.util.*;
import java.io.*;

//Runner class now inherits from JavaFx Application class
public class Runner extends Application implements Serializable{

	//SerialVersionUID to maintain serialization integrity
	private static final long serialVersionUID = 1L;
	//Student Manager variable
	StudentManager sm = new StudentManager();
	//Scene variables
	Scene mainScene;
	Scene addStudentScene;
	//Insets variable
	Insets borderPadding = new Insets(10, 10, 10, 10);
	
	//Overrides start function in application
	@Override
	public void start(Stage primaryStage){
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
		
		/* Load database functionality */
		//Create loadDBButton
		Button loadDBButton = new Button("Load DB");
		//Create dbPathText text field
		TextField dbPathText = new TextField();
		//Prompt user to enter database path to load
		dbPathText.setPromptText("Enter Database Path");
		//Add functionality to loadDBButton
		loadDBButton.setOnAction(e -> {
			//If the database path text is empty
			if (dbPathText.getText().trim().equals("")) {
				//Tell the user to enter a path
				outputText.appendText("Please enter path to DB\n");
			} else {
				//Load the database from student manager
				sm = sm.loadDB(dbPathText.getText());
				//If the student manager is null
				if (sm == null) {
					//Tell the user there is no valid database path
					outputText.setText("ERROR: DB path " + dbPathText.getText() + " does not exist\n");
					//Prompt user to enter a database path
					outputText.appendText("Please check DB path and try again");
					//Clear the dbPathText
					dbPathText.clear();
				} else {
					//Inform the user the database was loaded successfully
					outputText.setText("DB loaded successfully from " + dbPathText.getText());
					//Clear the database path text
					dbPathText.clear();
				}
			}
		});
		
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
					//Clear the deleteText text field
					deleteText.clear();
				}
				else {
					//Informs user that the student couldn't be deleted
					outputText.setText("Student couldn't be deleted.");
					//Clear the deleteText text field
					deleteText.clear();
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
		//Add functionality to button to search for a student
		searchByIdButton.setOnAction(event ->{
			//Get value from text field
			String searchId = searchByIdText.getText().toString();
			
			//Check if the string is empty
			if(searchId.isEmpty()) {
				//Inform the user they need to enter an id
				outputText.setText("Please enter a student id to search.");
			}
			else {
				//Find a student with the searchId
				Student searchStudent = sm.getStudentById(searchId);
				
				//If we found a student
				if(searchStudent != null) {
					//Calculate the age of the found student
					//Better to do this now taking a loaded database into account
					searchStudent.setAge(searchStudent.calculateAge(searchStudent.getDob()));
					//String to contain student details
					String resultsText = "";
					
					//Add info to results text
					resultsText += "Student found: \n";
					resultsText += "Student ID: " + searchStudent.getStudentId() + "\n";
					resultsText += "First Name: " + searchStudent.getFirstName() + "\n";
					resultsText += "Last Name " + searchStudent.getLastName() + "\n";
					resultsText += "Date of Birth: " + searchStudent.getDob() + "\n";
					resultsText += "Age: " + searchStudent.getAge() + "\n";
					
					//Set the results text to the outputText area
					outputText.setText(resultsText);
					//Clear the searchById text field
					searchByIdText.clear();
				}
				else {
					//Inform user no student was found
					outputText.setText("No student found.");
				}
			}
		});
		
		/* Search by First Name functionality */
		//Create searchByNameButton
		Button searchByNameButton = new Button("Search By First Name");
		//Create searchByName Label
		Label searchByNameLabel = new Label("Enter First Name:");
		//Create searchByNameText
		TextField searchByNameText = new TextField();
		//Add functionality to button to search students by First name
		searchByNameButton.setOnAction(event -> {
			//Get value from text field
			String searchName = searchByNameText.getText().toString();
			
			//Check if the string is empty
			if(searchName.isEmpty()) {
				//Inform the user they need to enter a First Name
				outputText.setText("Please enter a student first name to search.");
			}
			else {
				//Results list
				List<Student> resultsList = sm.getStudentsByFirstName(searchName);
				
				//Check if there are any results
				if(resultsList != null) {
					//Inform the user how many students were found
					outputText.setText("Found " + resultsList.size() + " students with the name " + searchName + ".");
					//Clear the searchByName text
					searchByNameText.clear();
				}
				else {
					//Inform the user no students were found
					outputText.setText("No students found.");
					//Clear the searchByName text
					searchByNameText.clear();
				}
			}
		});
		
		/* Show total functionality */
		//Create showTotalButton
		Button showTotalButton = new Button("Show total Students");
		//Add functionality to button to show the total number of students
		showTotalButton.setOnAction(event ->{
			//Value to store the number of students
			int totalStudents = sm.findTotalStudents();
			
			//Display total number of students
			outputText.setText("Total number of students: " + totalStudents);
		});
		
		/* Save database functionality */
		//Create saveDBButton
		Button saveDBButton = new Button("Save DB");
		//Add functionality to saveDBButton
		saveDBButton.setOnAction(e -> {
			//Attempt to save the database
			try {
				//Create a new Object output stream containing a new file output stream
				//The file in the file stream will store the database
	    		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("studentsDB.ser"));
	    		//Write the student manager to the object output stream
	    		out.writeObject(sm);
	    		//Close the object output stream
	    		out.close();
	    		//Inform the user the database was saved successfully
	    		outputText.setText("Student Database Saved");
	    	}
			//If there is an error saving the database
			catch (Exception exception) {
				//Print the error to the console
	    		System.out.print("[Error] Cannont save DB. Cause: ");
	    		exception.printStackTrace();
	    		//Inform the user that there was an error saving the database
	    		outputText.setText("ERROR: Failed to save Students DB!");
	    	}
		});
		
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
		mainGridPane.add(loadDBButton, 0, 1);
		mainGridPane.add(dbPathText, 2, 1);
		mainGridPane.add(addButton, 0, 2);
		mainGridPane.add(deleteButton, 0, 3);
		mainGridPane.add(deleteLabel, 1, 3);
		mainGridPane.add(deleteText, 2, 3);
		mainGridPane.add(searchByIdButton, 0, 4);
		mainGridPane.add(searchByIdLabel, 1, 4);
		mainGridPane.add(searchByIdText, 2, 4);
		mainGridPane.add(searchByNameButton, 0, 5);
		mainGridPane.add(searchByNameLabel, 1, 5);
		mainGridPane.add(searchByNameText, 2, 5);
		mainGridPane.add(showTotalButton, 0, 6);
		mainGridPane.add(saveDBButton, 0, 7);
		mainGridPane.add(quitButton, 0, 8);
		mainGridPane.add(outputText, 0, 9, 3, 1);
		
		//Adds values to the mainStage
		mainScene = new Scene(mainGridPane, 1000, 800);
		
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
		Label dobLabel = new Label("Enter Date of Birth:");
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
		//Set stage title to secondary stage
		secondaryStage.setTitle("Add Student");
		
	}
	
	public static void main(String[] args) {
		//Launches the application
		launch(args);
	}

}
