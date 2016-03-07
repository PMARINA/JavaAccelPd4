public class SchoolDriver {
	public static void main(String args[]){
        School PHS = new School("PHS", "151 Moore Street Princeton NJ 08540", 1500);
        Student matt = new Student("Matt Danielson", 16, 2.73, 11);
        Student amanda = new Student("Amanda Rubin", 16, 2.73, 11);
        Student will = new Student("Will Christianson", 16, 2.73, 11);
        Student john = new Student("John Deer", 16, 2.73, 11);
        Student trumpy = new Student("Donald Trup", 16, 0.01, 11);
        Student putin = new Student("Vladimir Putin", 16, 3.3, 11);
        Teacher mrselia = new Teacher("Ph.D", "Graciela Elia", 18);
        Teacher msbray = new Teacher("Ph.D", "Lorraine Bray", 12);
        Teacher mrLoughran = new Teacher("Masters", "Robert Loughran", 8);
        Teacher msmuca = new Teacher("Masters", "Greta Muca", 8);
        Course java = new Course("Java", mrselia, 4);
        Course math = new Course("PreCalc Acc", msbray, 3);
        Course music = new Course("Orchestra", mrLoughran, 5);
        Course english = new Course("English", msmuca, 8);
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
        putin.addCourse(java);
        putin.addCourse(music);
        trumpy.addCourse(java);
        trumpy.addCourse(music);
        trumpy.addCourse(english);
        matt.addCourse(java);
        matt.addCourse(english);
        matt.addCourse(music);
        will.addCourse(english);
        will.addCourse(music);
        mrselia.addStudent(will);
        mrselia.addStudent(putin);
        mrselia.addStudent(trumpy);
        mrselia.addStudent(john);
        
        System.out.println(PHS.getAllTeacherStudentsName());
        System.out.println("Students of PHS\n" + PHS.getAllStudentNames());
	}
}
