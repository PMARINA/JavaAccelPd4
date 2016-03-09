/**
 * School Application Period 4
 * 
 * Classwork:
 * 
 * 
 * a. The Student ADT:
 * 
 * i. init “classes” array to constant numCourses = 8
 * 
 * ii. create a new instance field, courseCount
 * 
 * Implement the following methods:
 * 
 * i. public void addCourse(Course aCourse):
 * 
 * ii. public String getAllInfo(), it should return name, age, gap, grade and a
 * list of all classes.
 * 
 * iii. public String getCourses(), it returns all courses names.
 * 
 * 
 * c. The Course ADT:
 * 
 * i. Overload constructor so subject, teacher and period are the input
 * arguments.
 * 
 * 
 * d. The School ADT:
 * 
 * i. Implement the method public String getAllStudentNames(). It should return
 * all the students names.
 * 
 * ii. Implement the method public String getAllStuInfo(). It should return
 * name, age, gap, grade and classes for all students.
 * 
 * 
 * main:
 * 
 * a. Create a new class, (the driver) MySchool
 * 
 * b. Copy the main method from School and remove it.
 * 
 * c. Create 3 or 4 more Course objects with your own information.
 * 
 * d. Create 2 or 3 more Teacher objects with your own information.
 * 
 * e. Create 5 or 6 more Student objects with your own information.
 * 
 * f. Add courses to at least 2 students.
 * 
 * g. Add all students to PHS.
 * 
 * h. Add all teachers to PHS.
 * 
 * i. Add 2 courses to 4 students.
 * 
 * j. Add the 4 students to a teacher.
 * 
 * k. Print all students names from the teacher above. l. Print all PHS students
 * names.
 * 
 * 
 * 
 * 
 * Homework:
 * 
 * Documentation for each method in each ADT. Include at least one comment line
 * describing the purpose of the method.
 * 
 * Make all the instance fields private.
 * 
 * Implement the following methods: getAllTeachersName()
 * 
 * 
 * Note: classes instance field should have a better name. Bad name choice.
 * 
 * 
 * 
 * @author PMARINA
 * @version 2/9/16
 */
public class SchoolDriver {
	public static void main(String args[]) {
		// Create the school
		School PHS = new School("PHS", "151 Moore Street Princeton NJ 08540", 1500);
		// Create the various students
		Student matt = new Student("Matt Danielson", 16, 2.73, 11);
		Student amanda = new Student("Amanda Rubin", 16, 2.73, 11);
		Student will = new Student("Will Christianson", 16, 2.73, 11);
		Student john = new Student("John Deer", 16, 2.73, 11);
		Student trumpy = new Student("Donald Trump", 16, 0.01, 11);
		Student putin = new Student("Vladimir Putin", 16, 3.3, 11);
		// Create the different teachers
		Teacher mrselia = new Teacher("Ph.D", "Graciela Elia", 18);
		Teacher msbray = new Teacher("Ph.D", "Lorraine Bray", 12);
		Teacher mrLoughran = new Teacher("Masters", "Robert Loughran", 8);
		Teacher msmuca = new Teacher("Masters", "Greta Muca", 8);
		// Create the courses
		Course java = new Course("Java", mrselia, 4);
		@SuppressWarnings("unused")
		Course math = new Course("PreCalc Acc", msbray, 3);
		Course music = new Course("Orchestra", mrLoughran, 5);
		Course english = new Course("English", msmuca, 8);
		// Add the students to the school
		PHS.addStudent(will);
		PHS.addStudent(john);
		PHS.addStudent(putin);
		PHS.addStudent(amanda);
		PHS.addStudent(trumpy);
		PHS.addStudent(matt);
		PHS.addTeacher(mrselia);
		PHS.addTeacher(mrLoughran);
		PHS.addTeacher(msmuca);
		PHS.addTeacher(msbray);
		// Add courses to putin
		putin.addCourse(java);
		putin.addCourse(music);
		// Add courses to trumpy
		trumpy.addCourse(java);
		trumpy.addCourse(music);
		trumpy.addCourse(english);
		// add courses to matt
		matt.addCourse(java);
		matt.addCourse(english);
		matt.addCourse(music);
		// add courses to will
		will.addCourse(english);
		will.addCourse(music);
		will.removeCourse(music);
		// Add students to mrs elia. Completely unnecessary
		mrselia.addStudent(will);
		mrselia.addStudent(putin);
		mrselia.addStudent(trumpy);
		mrselia.addStudent(john);
		// Print requested info
		System.out.println(PHS.getAllTeacherStudentsName());
		System.out.println("Students of PHS\n" + PHS.getAllStudentNames());
	}
}
