import java.awt.Font;
/* This writes a scrolling banner across the screen
 * 
 * @author: PMARINA
 * 
 * @Version: 12/8/2015
 */
public class PM_SongLyrics { 

    public static void main(String[] args) { 
        StdDraw.setCanvasSize(1000,1000);
        StdDraw.setScale(0,100);
        String s = args[0];
        int speed = Integer.parseInt(args[1]);

        // set the font
        Font f = new Font("Arial", Font.BOLD, 30);
        StdDraw.setFont(f);
        StdDraw.setPenColor(StdDraw.WHITE);

        for (double i = 0.0; true; i += 1) {
            StdDraw.clear(StdDraw.BLACK);
            StdDraw.text((i % 100),       50, s);
            StdDraw.text((i % 100) -100, 50, s);
            StdDraw.text((i % 100) + 100, 50, s);
            StdDraw.show(speed);
        }

    }

}
