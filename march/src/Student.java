

/**
 * This is a student.
 */
public class Student {
    private School school;
    private String name;
    private final int COURSECOUNT = 8;
    private Course[] classes = new Course[COURSECOUNT];
    private int regCourse = 0;
    private int age;
    private double gpa;
    private int grade;

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
    public void addCourse(Course c){
    	if(regCourse<COURSECOUNT){
    		classes[regCourse] = c;
    		regCourse++;
    	}
    }
    public String getAllInfo(){
    	StringBuilder a = new StringBuilder();
    	a.append("Name: " + this.name + "\n");
    	a.append("Age: " + this.age + "\n");
    	a.append("GPA: " + this.gpa + "\n");
    	a.append("Grade: " + this.grade + "\n");
    	a.append(getCourses());
    	return a.toString();
    }
    
    public String getCourses(){
    	StringBuilder a = new StringBuilder();
    	a.append("Courses:\n");
    	for(int i = 0; i<this.regCourse; i++){
    		a.append("\t" + classes[i] + "\n");
    	}
    	a.append("\n");
    	return a.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        } else {
            return this.name.equals(((Student) obj).name);
        }
    }
    public Course[] getCourseObjects(){
    	return classes;
    }
    public int getNumCourses(){
    	return COURSECOUNT;
    }
}
