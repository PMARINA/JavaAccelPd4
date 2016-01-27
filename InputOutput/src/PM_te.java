
/**
 * Write a description of class PM_te here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PM_te
{
    public static void main(String[] args){
        double sum = 0;
        for (double d = 0; d < 10;) {
            d += 0.1;
            sum += sum + d;
        }
    }
}
