
/**
 * Created by gracielaelia on 2/18/16., additions made by PMARINA
 * 
 * @author gracielaelia
 * @author PMARINA
 * @version 3/8/2016
 */
public class Course {

	// in the course
	private int currSize = 0; // The current number of students taking the class
	private int maxSize; // The maximum number of students who can be enrolled
	private int period; // The classperiod
	private String subject; // The subject of the class
	Teacher teacher; // The teacher object that teaches the class

	/**
	 * @param subject
	 *            - the subject of the course
	 * @param maxSize
	 *            - the maximum number of students in the course
	 * @param period
	 *            - The period during which the course occurs
	 */
	public Course(String subject, int maxSize, int period) {
		this.subject = subject;
		this.maxSize = maxSize;
		this.period = period;
	}

	/**
	 * @param subject
	 *            - the subject of the course
	 * @param teacher
	 *            - the teacher object who teaches the course
	 * @param period
	 *            - the period during which the course occurs
	 */
	public Course(String subject, Teacher teacher, int period) {
		this.period = period;
		this.teacher = teacher;
		this.subject = subject;
		this.maxSize = 30; // Assumes a default max size of 30 students
	}

	/**
	 * This method decrements the number of students taking the course
	 */
	public void decrement() {
		currSize--;
	}

	/*
	 * This is the equals method which overrides the standard object class's
	 * equals method
	 * 
	 * Takes an object and compares all attributes of the course class, wherever
	 * possible. If the given object cannot be casted as necessary, then it
	 * prints an error message
	 */
	@Override
	public boolean equals(Object d) {
		boolean output = false;
		try {
			Course c = (Course) d;
			output = this.subject.equals(c.subject) && this.teacher.equals(c.teacher) && this.period == c.period
					&& this.maxSize == c.maxSize;
		} catch (ClassCastException e) {
			System.out.println("The object being compared to is not a course!");
		}
		return output;
	}

	/**
	 * A getter for the size of the class
	 * 
	 * @return - the current size of the class
	 */
	public int getCurrSize() {
		return currSize;
	}

	/**	
	 * A getter for the maximum size of the course
	 * 
	 * @return - the maximum size of the course
	 */
	public int getMaxSize() {
		return maxSize;
	}

	/**
	 * A getter for the period when the class occurs
	 * 
	 * @return - the period during which the class occurs
	 */
	public int getPeriod() {
		return period;
	}

	/**
	 * A getter for the subject of the course
	 * 
	 * @return - the subject of the course
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @return - the teacher object teaching the course
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	/**
	 * Increments the number of students currntly taking the course
	 */
	public void increment(int size) {
		currSize += size;
	}

	/*
	 * Commented out because it should not be used public void setPeriod(int
	 * period) { this.period = period; }
	 */

	/**
	 * This method is only to be called for testing/debugging purposes, or if
	 * there is a substitute teacher. Note that this.equals(<i>the previous
	 * course</I>) will return false, as the teacher is different
	 * 
	 * @param teacher
	 *            - the new teacher object
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
