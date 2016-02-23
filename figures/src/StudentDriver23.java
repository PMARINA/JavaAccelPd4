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
public class StudentDriver23 {

	/**
	 * A driver for the student23 object.
	 * 
	 * @param args
	 *            - Has no use
	 */
	public static void main(String[] args) {
		Student23 bobert = new Student23("Boberto");
		bobert.addQuiz(40);
		bobert.addQuiz(100);
		bobert.addQuiz(83);
		System.out.println(bobert.getName() + " has an average of: " + bobert.getAverageScore()
				+ "% and a total score of: " + bobert.getTotalScore() + "%.");
	}
}
