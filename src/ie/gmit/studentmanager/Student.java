package ie.gmit.studentmanager;

import java.util.*;			//import for date object

public class Student {
	//Instance variables
	private String firstName;	//student first name
	private String lastName;	//student last name
	private int age;			//student age
	private Date dob;			//student date of birth
	private Address address;	//student address
	private Course course;		//student course;
	
	//Constructor
	public Student(String fname, String lname, Date dob, int age) {
		this.firstName = fname;
		this.lastName = lname;
		this.dob = dob;
		this.age = age;
	}
	
	//Getter/Setter methods
	/**
	 * Gets the student's first name
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the student's first name
	 * @param firstName Student first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the student's last name
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the student's last name
	 * @param lastName Student last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the student's age
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Sets the student's age
	 * @param age Student age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Gets the student's date of birth
	 * @return dob
	 */
	public Date getDob() {
		return dob;
	}
	
	/**
	 * Sets the student's date of birth
	 * @param dob Student date of birth
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	/**
	 * Gets the student's address
	 * @return address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Sets the student's address
	 * @param address Student address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * Gets the student's course
	 * @return course
	 */
	public Course getCourse() {
		return course;
	}
	
	/**
	 * Sets the student's course
	 * @param course Student course
	 */
	public void setCourse(Course course) {
		this.course = course;
	}
}
