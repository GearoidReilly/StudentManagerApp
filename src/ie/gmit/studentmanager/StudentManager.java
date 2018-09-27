package ie.gmit.studentmanager;

public class StudentManager {
	//Static variables will be the same value for all instances of a class
	//Final variables cannot be changed, operates like constant variables
	private static final int INITIAL_CAPACITY = 10;	//Sets the capacity of the Student manager
	//Instance variables
	private Student[] students = null;				//array of students
	
	//Constructor
	public StudentManager() {
		students = new Student[INITIAL_CAPACITY];
	}
	
	//Methods
	/**
	 * Adds a student to the Student Manager
	 * @param student
	 * @return
	 */
	public boolean addStudent(Student student) {
		return false;
	}
	
	/**
	 * Deletes a student from the Student Manager
	 * @param studentId
	 * @return
	 */
	public boolean deleteStudent(String studentId) {
		return false;
	}
	
	/**
	 * Searches student(s) by their first name
	 * @param studentId
	 * @return
	 */
	public Student[] getStudentById(String studentId) {
		return null;
	}
	
	/**
	 * Finds the total number of students
	 * @return
	 */
	public int findTotalStudents() {
		return -1;
	}
}
