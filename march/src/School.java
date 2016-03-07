

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

    public String getAllStudentNames(){
    	StringBuilder a = new StringBuilder();
    	for(int i = 0; i<numStudents; i++){
    		a.append(students[i].getName() + "\n");
    	}
		return a.toString();
    }
    public String getAllStuInfo(){
    	//name, age, gap, grade and classes
    	StringBuilder a = new StringBuilder();
    	for(Student s : students){
    		a.append(s.getAllInfo());
    	}
		return a.toString();
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

	public String getAllTeacherStudentsName() {
		StringBuilder sb = new StringBuilder();
		this.refreshStudents();
		for(int i = 0; i<numTeachers; i++){
			sb.append(teachers[i].getAllStudents());
		}
		sb.append("\n");
		return sb.toString();
	}

	private void refreshStudents() {
		for(int i = 0; i<numStudents; i++){
			Course[] courses = students[i].getCourseObjects();
			for(int b = 0; b<students[i].getNumCourses();b++){
				Course thisCourse = courses[b];
				if(thisCourse != null){
					Teacher thisTeacher = thisCourse.getTeacher();
					if(!(thisTeacher.hasStudent(students[i])))
						thisTeacher.addStudent(students[i]);
				}
			}
		}
		
	}
}
