package period4;

/**
 * Created by gracielaelia on 2/18/16.
 */
public class Teacher {
    private String degree;
    private String name;
    private int experience;

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
}
