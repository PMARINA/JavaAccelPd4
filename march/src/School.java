
/**
 * Created by gracielaelia on 2/18/16.
 */
public class School {
	private int numStudents;
	private int numTeachers;
	private int studentCapacity;
	private Student[] students;
	private Teacher[] teachers;

	/**
	 * @param name
	 *            - the name of the school
	 * @param location
	 *            - the location of the school
	 * @param studentCapacity
	 *            - the student capacity of the school
	 */
	public School(String name, String location, int studentCapacity) {
		this.studentCapacity = studentCapacity;
		students = new Student[studentCapacity];
		teachers = new Teacher[studentCapacity / 30];
		numStudents = 0;
		numTeachers = 0;
	}

	/**
	 * Adds the student object to the school
	 * 
	 * @param student
	 *            - the student object being added to the school
	 */
	public void addStudent(Student student) {
		if (numStudents < studentCapacity) {
			students[numStudents++] = student;
		}
	}

	/**
	 * Adds the teacher object to the school
	 * 
	 * @param teacher
	 *            - the teacher object being added to the school
	 */
	public void addTeacher(Teacher teacher) {
		if (numTeachers < studentCapacity / 30) {
			teachers[numTeachers++] = teacher;
		}
	}

	/**
	 * Returns a formatted list of all students
	 * 
	 * @return - a string containing all the students' names
	 */
	public String getAllStudentNames() {
		StringBuilder a = new StringBuilder();
		for (int i = 0; i < numStudents; i++) {
			a.append(students[i].getName() + "\n");
		}
		return a.toString();
	}

	/**
	 * Returns all the information of the students, as a string
	 * 
	 * @return - all the students' information in a <i>long</i> string
	 */
	public String getAllStuInfo() {
		// name, age, gap, grade and classes
		StringBuilder a = new StringBuilder();
		for (Student s : students) {
			a.append(s.getAllInfo());
		}
		return a.toString();
	}

	/**
	 * Returns a list of all students, organized by teacher
	 * 
	 * @return - a list of all the students' names, organized based on teacher
	 */
	public String getAllTeacherStudentsName() {
		StringBuilder sb = new StringBuilder();
		this.refreshStudents();
		for (int i = 0; i < numTeachers; i++) {
			sb.append(teachers[i].getAllStudents());
		}
		sb.append("\n");
		return sb.toString();
	}

	/**
	 * Returns the student object given the name, if the object exist
	 * 
	 * @param name
	 *            - the name of the student
	 * @return the first occurrence of the student object, if found. Otherwise,
	 *         returns null
	 */
	public Student getStudent(String name) {
		for (int i = 0; i < numStudents; i++) {
			if (students[i].getName().equals(name))
				return students[i];
		}
		return null;
	}

	/**
	 * Refreshes the list of students under every teacher by getting all the
	 * courses and the teachers, and checking whether or not the teacher has the
	 * student already. If so, then do nothing, else add to the student to the
	 * teacher
	 */
	private void refreshStudents() {
		for (int i = 0; i < numStudents; i++) {
			Course[] courses = students[i].getCourseObjects();
			for (int b = 0; b < students[i].getNumCourses(); b++) {
				Course thisCourse = courses[b];
				if (thisCourse != null) {
					Teacher thisTeacher = thisCourse.getTeacher();
					if (!(thisTeacher.hasStudent(students[i])))
						thisTeacher.addStudent(students[i]);
				}
			}
		}

	}
}
