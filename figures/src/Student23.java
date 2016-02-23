/**
 * Implement a class Student. For the purpose of this exercise, a student has a
 * name and a total quiz score. Supply an appropriate constructor and methods
 * getname(), addQuiz(int score), getTotalScore(), and getAverageScore(). To
 * compute the latter, you also need to store the number of quizzes that the
 * student took.
 * 
 * @author PMARINA
 * @version Feb 23, 2016
 */
public class Student23 {
	private String name; // The name of the student.
	private double average = 0; // The average score the student
	private int quizzes = 0;
	private double total = 0;

	/**
	 * This is the only constructor of the student object
	 * 
	 * @param name
	 *            - the name of the student
	 */
	public Student23(String name) {
		this.name = name;
	}

	/**
	 * A getter for the student's name
	 * 
	 * @return - the name of the student
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * A mutator for the name of the student
	 * 
	 * @param name
	 *            - the new name of the student
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Adds a new quiz to the "gradebook"
	 * 
	 * @param score
	 *            - the score the student achieved on the quiz
	 */
	public void addQuiz(int score) {
		this.quizzes += 1;
		this.total += score;
		this.average = ((score / this.quizzes)) + ((this.average * (this.quizzes - 1)) / this.quizzes);
	}

	/**
	 * An accessor for the total score of the student
	 * 
	 * @return the total score of the student
	 */
	public double getTotalScore() {
		return this.total;
	}

	/**
	 * @return - the average score the student attained through all of his/her
	 *         quizzes.
	 */
	public double getAverageScore() {
		return this.average;
	}
}
