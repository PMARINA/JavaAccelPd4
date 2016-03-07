import java.util.ArrayList;

/**
 * Created by gracielaelia on 2/18/16.
 */
public class Teacher {
    private String degree;
    private String name;
    private int experience;
    private ArrayList<Student> students = new ArrayList<Student>();

    public Teacher(String degree, String name) {
        this.degree = degree;
        this.name = name;
        this.experience = 0;
    }

    public Teacher(String degree, String name, int experience) {
        this.degree = degree;
        this.name = name;
        this.experience = experience;
    }

    public void incrementExperience() {
        experience++;
    }
    public void addStudent(Student s){
    	students.add(s);
    }
    public String getAllStudents(){
    	StringBuilder a = new StringBuilder();
    	a.append(this.name + "'s Students:\n");
    	for(Student s : students)
    		a.append("\t" + s.getName() + "\n");
    	return a.toString();
    }

	public boolean hasStudent(Student student) {
		return students.contains(student);
	}
}
