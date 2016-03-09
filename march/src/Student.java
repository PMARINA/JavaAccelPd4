
/**
 * This is a student.
 */
public class Student {
	private int age;
	private final int COURSECOUNT = 8;
	private Course[] classes = new Course[COURSECOUNT];
	private double gpa;
	private int grade;
	private String name;
	private int regCourse = 0;

	/**
	 * @param name
	 *            - the name of the student
	 */
	public Student(String name) {
		this.name = name;
	}

	/**
	 * @param name
	 *            - the name of the student
	 * @param age
	 *            - the age of teh student
	 * @param gpa
	 *            - the student's current gpa
	 * @param grade
	 *            - the current grade level of the student
	 */
	public Student(String name, int age, double gpa, int grade) {
		this.name = name;
		this.age = age;
		this.gpa = gpa;
		this.grade = grade;
	}

	/**
	 * Adds the course object to the student's list of courses. Note that the
	 * period must be free in order for the student to add the course. In
	 * addition, the student must not be taking too many courses
	 * 
	 * @param c
	 *            - the course being added to the student
	 */
	public void addCourse(Course c) {
		if (regCourse < COURSECOUNT) {
			if (classes[c.getPeriod() - 1] == null)
				if (c.getCurrSize() - 1 <= c.getMaxSize()) {
					classes[c.getPeriod() - 1] = c;
					c.increment();
				} else
					System.out.println("There are too many students!");
			else {
				System.out.println("The student has already enrolled in a course during this period.");
				regCourse++;
			}
		} else
			System.out.println("This student has the maximum number of courses. Please remove a course.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof String)) {
			return false;
		} else {
			return this.name.equals(((Student) obj).name);
		}
	}

	/**
	 * Returns all the information of the student in a formatted list
	 * 
	 * @return - all the information of the student
	 */
	public String getAllInfo() {
		StringBuilder a = new StringBuilder();
		a.append("Name: " + this.name + "\n");
		a.append("Age: " + this.age + "\n");
		a.append("GPA: " + this.gpa + "\n");
		a.append("Grade: " + this.grade + "\n");
		a.append(getCourses());
		return a.toString();
	}

	/**
	 * @return - returns an array of all the courses, including the null objects
	 */
	public Course[] getCourseObjects() {
		return classes;
	}

	/**
	 * @return - a string containing the list of the courses being taken by the
	 *         student object
	 */
	public String getCourses() {
		StringBuilder a = new StringBuilder();
		a.append("Courses:\n");
		for (int i = 0; i < this.regCourse; i++) {
			a.append("\t" + classes[i] + "\n");
		}
		a.append("\n");
		return a.toString();
	}

	/**
	 * @return - returns the name of the student
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return - Return the number of courses the student can take
	 */
	public int getNumCourses() {
		return COURSECOUNT;
	}

	/**
	 * Increase the student's grade
	 */
	public void incrementGrade() {
		grade++;
	}

	/**
	 * Removes the specified course from the student
	 * 
	 * @param c
	 *            - the course to be removed from the student
	 */
	public void removeCourse(Course c) {
		for (int i = 0; i < COURSECOUNT; i++) {
			if (!(classes[c.getPeriod() - 1] == null) && classes[c.getPeriod() - 1].equals(c)) {
				classes[c.getPeriod() - 1] = null;
				regCourse--;
				c.decrement();
			}
		}
	}

	/**
	 * @param age
	 *            - the new age of the student
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param gpa
	 *            - the new gpa of the student
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
