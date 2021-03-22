package operations;
/*
 * class containing student name and list of 5 preferences
 */
public class Student {

	public String name;
	public String[] preference = new String[5];
	public String allocation;

	/**
	 * method to create student object
	 * @param name
	 * @param pref
	 * @param allocation
	 */
	public void createStudent(String name, String pref, String allocation) {
		this.name = name;
		this.preference = pref.split(",");
		this.allocation = allocation;
	}

	/**
	 * method to allocate course to student
	 * @param courseName
	 */
	public void allocateCourse(String courseName) {
		this.allocation = courseName;
	}

}