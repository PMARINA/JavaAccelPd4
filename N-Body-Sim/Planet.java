/**
 * A body in space which moves around in orbit in space by calculating the forces between itself and other NBodies.
 * @author Kees Luijendijk
 */
public class Planet {
    private final static double deltaT = 2.5e5;
    private static final double G = 6.67e-11;
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double m;
    private String name;

    /**
     * Getter Methods for Name, x, y, vx, vy, and mass values.
     */
    /**
     * @return The name of the planet
     */
    public String getName() {
        return name;
    }
    /**
     * @return The x value of the planet
     */
    public double getX() {
        return x;
    }
    /**
     * @return The y value of the planet
     */
    public double getY() {
        return y;
    }
    /**
     * @return The vx value of the planet
     */
    public double getVx() {
        return vx;
    }
    /**
     * @return The xvy value of the planet
     */
    public double getVy() {
        return vy;
    }
    /**
     * @return The mass of the planet
     */
    public double getMass() {
        return m;
    }

    /**
     * The constructor for an NBody Object
     * @param x the starting x position
     * @param y the starting y position
     * @param vx the starting x velocity
     * @param vy the starting y velocity
     * @param m the mass
     * @param name the name of the picture file where the planet is located.
     */
    public Planet(double x,double y,double vx,double vy,double m,String name) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.m = m;
        this.name = name;
    }

    /**
     * Calculates the forces between two bodies and moves this once.
     * @param OtherBody The other body for calculations.
     */
    public void forceCalc(Planet OtherBody){
        double distanceSqr = Math.pow(OtherBody.getX()-this.x,2) + Math.pow(OtherBody.getY()-this.y,2);
        double force = G * this.m * OtherBody.getMass() / distanceSqr;
        double forcex = force*(OtherBody.getX()-this.x)/Math.sqrt(distanceSqr);
        double forcey = force*(OtherBody.getY()-this.y)/Math.sqrt(distanceSqr);
        double ax = forcex/this.m;
        double ay = forcey/this.m;
        this.vx += deltaT * ax;
        this.vy += deltaT * ay;
    }

    /**
     * Moves body based on the updated forces.
     */
    public void update(){
        this.x += deltaT*this.vx;
        this.y += deltaT*this.vy;
    }

    /**
     * Draws the body.
     */
    public void drawBody(){
        StdDraw.picture(x,y,name);
    }
}
