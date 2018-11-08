package ie.gmit.studentmanager;

import java.util.*;

public class StudentManager {
	//Static variables will be the same value for all instances of a class
	//Final variables cannot be changed, operates like constant variables
	//private static final int INITIAL_CAPACITY = 10;	//Sets the capacity of the Student manager
	
	//Instance variables
	List<Student> students;	//list of students
	
	//Constructor
	public StudentManager() {
		//Create an empty student Array list
		students = new ArrayList<Student>(); 
	}
	
	//Methods
	/**
	 * Adds a student to the Student Manager
	 * @param student to add
	 */
	public boolean addStudent(Student student) {
		try {
			//Adds student to the students list
			return students.add(student);
		}
		//If there's an error
		catch(Exception error) {
			//Print the error
			error.printStackTrace();
			
			//Return false
			return false;
		}
		
	}
	
	/**
	 * Deletes a student from the Student Manager
	 * @param studentID of Student to delete
	 */
	public boolean deleteStudent(String deleteId) {
		//Gets a student by their studentId
		Student student = getStudentById(deleteId);
		
		//If student isn't null
		if(student != null) {
			//We found a student, delete it
			return students.remove(student);
		}
		else {
			//Otherwise return false
			return false;
		}
	}
	
	/**
	 * Searches student(s) by their first name
	 * @param studentName
	 * @return
	 */
	public List<Student> getStudentsByFirstName(String firstName) {
		//Create a new array list to hold students with the same name
		List<Student> sameNames = new ArrayList<Student>();
		
		//Loops over students array list
		for(Student student: students) {
			//If there is a student that matches the input
			if(student.getFirstName().equalsIgnoreCase(firstName)) {
				//add them to the list
				sameNames.add(student);
			}
		}
		
		//If sameNames is greater than 0
		if(sameNames.size() > 0) {
			//Students with the same name were found: Return sameNames
			return sameNames;
		}
		//Return null: We couldn't find any students
		return null;
	}
	
	/**
	 * Gets a student by id to match input
	 * @param inputID
	 * @return student with matching studentID
	 */
	public Student getStudentById(String inputID) {
		//Loop over array list
		for(Student student: students) {
			//if there's a student that matches the input StudentId
			if(student.getStudentId().equals(inputID)) {
				//Return that student
				return student;
			}
		}
		//Otherwise return null
		return null;
	}
	/**
	 * Finds the total number of students
	 * @return total number of students
	 */
	public int findTotalStudents() {
		//Return the number of elements in students
		return students.size();
	}
}
