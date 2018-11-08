package ie.gmit.studentmanager;

import java.util.*;

public class Menu {
	private Scanner userInput;			//Menu user input
	private StudentManager sm;			//Student manager
	private boolean keepRunning;	//Bool to keep the menu runner
	
	//Menu Constructor
	public Menu() {
		//Create a new scanner object to take input
		userInput = new Scanner(System.in);
		//Create a student Manager object
		sm = new StudentManager();
		//Set keepRunning to true
		keepRunning = true;
	}
	/**
	 * Starts the student manager which displays options to the user
	 */
	public void start() {
		//Introduce the user to the student manager
		System.out.println("Welcome to the Student Manager.");
		
		//While the menu is running
		while(keepRunning) {
			//Shows the options to the user
			showOptions();
			
			//Convert userInput to int
			int userMenuOption = userInput.nextInt();
			
			//Select a menu option based on input
			selectOption(userMenuOption);
			//Tell user to pres enter to continue
			pressEnterKeyToContinue();
		}
	}
	
	/**
	 * Shows the options to the user
	 */
	private void showOptions() {
		//Prints out lines to the console giving options to the user
		System.out.println("List of options:");
		System.out.println("(1) Add a Student");
		System.out.println("(2) Delete a Student");
		System.out.println("(3) Search for a Student by ID");
		System.out.println("(4) Search for Students by First Name");
		System.out.println("(5) Show total number of Students");
		System.out.println("(6) Quit");
		System.out.println("Select an option [1-6]>");
	}
	
	/**
	 * Select a menu option based on user input
	 * @param inputOption Option to select
	 */
	private void selectOption(int inputOption) {
		if(inputOption == 1) {
			//Opens the addMenu
			addMenu();
		}
		else if(inputOption == 2) {
			//Opens the deleteMenu
			deleteMenu();
		}
		else if(inputOption == 3) {
			//Opens the searchByIdMenu
			searchByIdMenu();
		}
		else if(inputOption == 4) {
			//Open the searchByNameMenu
			searchByNameMenu();
		}
		else if(inputOption == 5) {
			//Open the searchTotalMenu
			showTotalMenu();
		}
		else if(inputOption == 6) {
			//Quits from the menu
			//Inform the user the menu manager is closing
			System.out.println("Quitting Student Manager...");
			
			//Menu is no longer running
			keepRunning = false;
			
			//Close the scanner
			//userInput.close();
		}
		else {
			System.out.println("Invalid input, please enter a number between 1 - 6");
		}
	}
	
	/**
	 * Opens the input to add a student
	 */
	private void addMenu() {
		//Prompt the user to enter a student id
		System.out.println("Enter Student id:");
		String sid = userInput.next();
		
		//Prompt the user to enter a first name
		System.out.println("Enter Student first name:");
		String fname = userInput.next();
		
		//Prompt the user to enter a last name
		System.out.println("Enter Student last name:");
		String lname = userInput.next();
		
		//Creates a new date
		Date dob = new Date();
		
		//Create a new Student object taking user defined variables
		Student newStudent = new Student(sid, fname, lname, dob);
		//Adds the student to the sm students list
		boolean result = sm.addStudent(newStudent);
		
		if(result) {
			//Inform the user that a new student has been added
			System.out.println("Student " + sid + " added.");
		}else {
			//Tell the user that the student couldn't be added
			System.out.println("We were unable to add the student.");
		}
	}
	
	/**
	 * Opens the input to delete a student
	 */
	private void deleteMenu() {
		//Prompt the user to enter a student id
		System.out.println("Enter Student id:");
		String sid = userInput.next();
		
		//Variable to check result for deleting student
		boolean result = sm.deleteStudent(sid);
		
		//Check if we got a result
		if(result) {
			//Tell the user the student was deleted
			System.out.println("Deleted student " + sid);
		}
		else {
			//Tell the user that there was no student to delete
			System.out.println("Unable to delete student.");
		}
	}
	
	/**
	 * Opens the input to search a student by their id
	 */
	private void searchByIdMenu() {
		//Prompt the user to enter a student id
		System.out.println("Enter Student id:");
		String sid = userInput.next();
		
		//Create a boolean variable to check for a student id
		Student searchResult = sm.getStudentById(sid);
		
		//Check if we found a searchResult
		if(searchResult != null) {
			//Return the student Id again to the user saying we found it
			//More functionality will be added later...maybe
			System.out.println("Student " + searchResult.getStudentId() + " found!");
			//Print student details
			System.out.println("Student ID: " + searchResult.getStudentId());
			System.out.println("Student ID: " + searchResult.getFirstName());
			System.out.println("Student ID: " + searchResult.getLastName());
		}
		else {
			//Tell the user no student id was found
			System.out.println("No StudentId found.");
		}
	}
	
	/**
	 * Opens the input to search students by the first name
	 */
	private void searchByNameMenu() {
		//Prompt user to input a student name
		System.out.println("Input student name:");
		String sName = userInput.next();
		
		//Student list variable for storing the search result
		List<Student> foundStudents = sm.getStudentsByFirstName(sName);
		
		//Check if we found any students with the same name
		if(foundStudents != null) {
			//Return the list of found students
			System.out.println("Found " + foundStudents.size() + " students with the name " + sName + "!");
			System.out.println(foundStudents);
		}
		else {
			//Tell the user no students were found with that name
			System.out.println("No students found.");
		}
	}
	
	/**
	 * Opens the input to show the total number of students
	 */
	private void showTotalMenu() {
		//Prints a line and returning the total number students
		System.out.println("Total students: " + sm.findTotalStudents());
	}
	
	/**
	 * Prompts user to press the enter key before continuing
	 */
    private void pressEnterKeyToContinue() { 
           System.out.println("\nPress Enter key to continue...\n");
           try {
               System.in.read();
           } catch(Exception e) {
        	   e.printStackTrace();
           }  
    }
}
