package period4;

/**
 * This is a student.
 */
public class Student {
    School school;
    Course[] classes;
    String name;
    int age;
    double gpa;
    int grade;

    public Student(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age, double gpa, int grade) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void incrementGrade() {
        grade++;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        } else {
            return this.name.equals(((Student) obj).name);
        }
    }
}
