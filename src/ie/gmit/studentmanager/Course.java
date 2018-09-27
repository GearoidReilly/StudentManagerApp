package ie.gmit.studentmanager;

public class Course {
	//Instance variables
	private String courseCode;	//course code
	private String courseName;	//course name
	
	//Constructor
	public Course(String courseCode, String courseName) {
		this.courseCode = courseCode;
		this.courseName = courseName;
	}

	/**
	 * Gets this course's code
	 * @return courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * Sets a course code to this course
	 * @param courseCode New courseCode
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Gets this course's name
	 * @return courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * Sets a course name to this course
	 * @param courseName New courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
