package ie.gmit.studentmanager;

import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;

//Runner class now inherits from JavaFx Application class
public class Runner extends Application{

	//Student Manager variable
	StudentManager sm = new StudentManager();
	//Scene variables
	Scene mainScene;
	Scene addStudentScene;
	
	//Overrides start function in application
	@Override
	public void start(Stage primaryStage) throws Exception{
		/* Main Scene features */
		//Create header text
		Text headerText = new Text("Welcome to the Student Manager \n Select one of the options below");
		//Create output text
		TextArea outputText = new TextArea();
		
		//Create grid pane to hold items in the scene
		GridPane mainGridPane = new GridPane();
		//Set padding on the scene
		mainGridPane.setPadding(new Insets(10, 10, 10, 10));
		//Set spacing between objects on the main grid pane
		mainGridPane.setHgap(30);
		mainGridPane.setVgap(30);
		
		/* Add student functionality */
		//Create addButton
		Button addButton = new Button("Add Student");
		
		/* Delete student functionality */
		//Create deleteButton
		Button deleteButton = new Button("Delete Student");
		//Create delete Label
		Label deleteLabel = new Label("Enter Student Id:");
		//Create deleteText
		TextField deleteText = new TextField();
		
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
		mainScene = new Scene(mainGridPane, 1000, 900);
		
		//Set the title to primary stage
		primaryStage.setTitle("Student Manager");
		//Set the mainScene to the primary stage
		primaryStage.setScene(mainScene);
		//Shows the primary stage
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		//Launches the application
		launch(args);
	}

}
