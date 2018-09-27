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
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
}
