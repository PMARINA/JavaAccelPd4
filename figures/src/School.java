package period4;

/**
 * Created by gracielaelia on 2/18/16.
 */
public class School {
    private String name;
    private String locations;
    private Student[] students;
    private Teacher[] teachers;
    private int studentCapacity;
    private int numStudents;
    private int numTeachers;

    public School(String name, String locations, int studentCapacity) {
        this.name = name;
        this.locations = locations;
        this.studentCapacity = studentCapacity;
        students = new Student[studentCapacity];
        teachers = new Teacher[studentCapacity/30];
        numStudents = 0;
        numTeachers = 0;
    }


    public void addStudent(Student student) {
        if (numStudents < studentCapacity) {
            students[numStudents++] = student;
        }
    }

    public void addTeacher(Teacher teacher) {
        if (numTeachers < studentCapacity/30) {
            teachers[numTeachers++] = teacher;
        }
    }

    public Student getStudent(String name) {
        for (int i = 0; i < numStudents; i++) {
            if (students[i].getName().equals(name)) return students[i];
        }
        return null;
    }

    public static void main(String[] args) {
        School PHS = new School("PHS", "151 Moore Street Princeton NJ 08540", 1500);
        Student matt = new Student("Matt Danielson", 16, 2.73, 11);
        Teacher mrselia = new Teacher("Ph.D", "Graciela Elia", 18);
        Course java = new Course("Java", 30, 4);
        PHS.addStudent(matt);
        PHS.addTeacher(mrselia);
    }

}
