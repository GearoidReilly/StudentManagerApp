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
		//Create header text
		Text headerText = new Text("Welcome to the Student Manager \n Select one of the options below");
		
		//Create grid pane to hold items in the scene
		GridPane mainGridPane = new GridPane();
		//Set padding on the scene
		mainGridPane.setPadding(new Insets(10, 10, 10, 10));
		//Set spacing between objects on the main grid pane
		mainGridPane.setHgap(10);
		mainGridPane.setVgap(10);
		//Set the content to align at the centre
		mainGridPane.setAlignment(Pos.CENTER);
		
		//Adds content to the mainGridPane
		mainGridPane.add(headerText, 0, 0);
		
		//Adds values to the mainStage
		mainScene = new Scene(mainGridPane, 600, 600);
		
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
