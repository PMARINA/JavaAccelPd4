package period4;

/**
 * Created by gracielaelia on 2/18/16.
 */
public class Course {

    private int period;
    private int maxSize;
    private String subject;
    Teacher teacher;

    public Course(String subject, int maxSize, int period) {
        this.subject = subject;
        this.maxSize = maxSize;
        this.period = period;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getPeriod() {
        return period;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getSubject() {
        return subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
