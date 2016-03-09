import java.util.ArrayList;

/**
 * Created by gracielaelia on 2/18/16, additions made by PMARINA
 */
public class Teacher {
	private String degree;
	private int experience;
	private String name;
	private ArrayList<Student> students = new ArrayList<Student>();

	/**
	 * @param degree
	 *            - the degree the teacher has attained in the course of his/her
	 *            studies
	 * @param name
	 *            - the name of the teacher
	 */
	public Teacher(String degree, String name) {
		this.degree = degree;
		this.name = name;
		this.experience = 0;
	}

	/**
	 * @param degree
	 *            - the degree attained by the teacher in the course of his/her
	 *            studies
	 * @param name
	 *            - the name of the teacher
	 * @param experience
	 *            - the teaching experience the teacher has (in years)
	 */
	public Teacher(String degree, String name, int experience) {
		this.degree = degree;
		this.name = name;
		this.experience = experience;
	}

	/**
	 * Adds the student to the teacher
	 * 
	 * @param s
	 *            - the new student being added to the teacher
	 */
	public void addStudent(Student s) {
		students.add(s);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object c) {
		boolean output = false;
		try {
			Teacher t = (Teacher) c;
			output = this.degree.equals(t.degree) && this.experience == t.experience && this.name.equals(t.name)
					&& this.students.equals(t.students);
		} catch (ClassCastException e) {
			System.out.println("The object provided is not a teacher");
		}
		return output;
	}

	/**
	 * Returns all the students' names in a formatted list
	 * 
	 * @return - all the students of the teacher, as a string
	 */
	public String getAllStudents() {
		StringBuilder a = new StringBuilder();
		a.append(this.name + "'s Students:\n");
		for (Student s : students)
			a.append("\t" + s.getName() + "\n");
		return a.toString();
	}

	/**
	 * Checks whether or not the teacher object has the student. Note that
	 * school.refresh() must be called before this can be accurately called
	 * 
	 * @param student
	 *            - the student object being searched for
	 * @return - whether or not the teacher has the student
	 */
	public boolean hasStudent(Student student) {
		return students.contains(student);
	}

	/**
	 * Increases the number of years that the teacher has been teaching
	 */
	public void incrementExperience() {
		experience++;
	}
}
