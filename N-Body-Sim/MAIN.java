/**
 * An N-Body Simulation of our solar system with the sun in the middle, and the planets Earth, Mars, Mercury, and Venus orbiting around it.
 * Date and images gotten from ftp://ftp.cs.princeton.edu/pub/cs126/Planet/
 * @author Kees Luijendijk
 */
public class MAIN {
    public static void main(String [] args){
        final double R = 2.50e+11;
        StdDraw.setXscale(-R,R);
        StdDraw.setYscale(-R,R);
        Planet earth = new Planet(1.4960e+11,0.0000e+00,0.0000e+00,2.9800e+04,5.9740e+24,"earth.gif");
        Planet mars = new Planet(2.2790e+11,0.0000e+00,0.0000e+00,2.4100e+04,6.4190e+23,"mars.gif");
        Planet mercury = new Planet(5.7900e+10,0.0000e+00,0.0000e+00,4.7900e+04,3.3020e+23,"mercury.gif");
        Planet sun = new Planet(0.0000e+00,0.0000e+00,0.0000e+00,0.0000e+00,1.9890e+30,"sun.gif");
        Planet venus = new Planet(1.0820e+11,0.0000e+00,0.0000e+00,3.5000e+04,4.8690e+24,"venus.gif");
        Planet[] planets = {sun,mercury,venus,earth,mars};
        while(true){
            StdDraw.clear();
            StdDraw.picture(0,0,"starfield.jpg");
            for(Planet p:planets){
                for(Planet i:planets){
                    if(!p.getName().equalsIgnoreCase(i.getName())){
                        p.forceCalc(i);
                    }
                }
            }
            for(Planet i:planets){
                i.update();
                i.drawBody();
            }
            StdDraw.show(15);
            try { Thread.sleep(15); }
            catch (InterruptedException e) { System.out.println("Error sleeping"); }
        }
    }
}
