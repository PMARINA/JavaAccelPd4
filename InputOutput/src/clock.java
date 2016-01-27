import java.util.Date; import java.awt.Window;
/**
 * Write a description of class PM_Clock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 
public class PM_Clock
{
    public void PM_Clock(){
        Window.setAlwaysOnTop(true);
    }
    public static void main(String[] args){
        new PM_Clock();
        while(true){
            StdDraw.clear();
            Date date = new Date();
            StdDraw.text(0.5,0.5, date.toString());
            StdDraw.show(60);
        }
    }
}
*/
public class clock{
    int a = 1;
}