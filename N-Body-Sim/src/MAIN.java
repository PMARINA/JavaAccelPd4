/**
 * NBody Simulation :
 * 
 * In 1687 Sir Isaac Newton formulated the principles governing the the motion
 * of two particles under the influence of their mutual gravitational attraction
 * in his famous Principia. However, Newton was unable to solve the problem for
 * three particles. Indeed, in general, systems of three or more particles can
 * only be solved numerically. Your challenge is to write a program to simulate
 * the motion of N particles in the plane, mutually affected by gravitational
 * forces, and animate the results. Such methods are widely used in cosmology,
 * semiconductors, and fluid dynamics to study complex physical systems.
 * Scientists also apply the same techniques to other pairwise interactions
 * including Coulombic, Biot-Savart, and van der Waals.
 * 
 * 
 * @author PMARINA
 * @version really really late
 */
public class MAIN {
	public static void main(String[] args) {
		final double radiusOfWorld = 2.50e+11; // The radius of the world!
		StdDraw.setScale(-radiusOfWorld, radiusOfWorld);// set the world

		// hard coded in input
		Planet earth = new Planet(1.4960e+11, 0.0000e+00, 0.0000e+00, 2.9800e+04, 5.9740e+24, "earth.gif");
		Planet mars = new Planet(2.2790e+11, 0.0000e+00, 0.0000e+00, 2.4100e+04, 6.4190e+23, "mars.gif");
		Planet mercury = new Planet(5.7900e+10, 0.0000e+00, 0.0000e+00, 4.7900e+04, 3.3020e+23, "mercury.gif");
		Planet sun = new Planet(0.0000e+00, 0.0000e+00, 0.0000e+00, 0.0000e+00, 1.9890e+30, "sun.gif");
		Planet venus = new Planet(1.0820e+11, 0.0000e+00, 0.0000e+00, 3.5000e+04, 4.8690e+24, "venus.gif");
		Planet[] planets = { sun, mercury, venus, earth, mars };

		// actual sim
		while (true) {

			// iterate through planets
			for (Planet plan1 : planets) {
				for (Planet plan2 : planets) {
					// check whether or not the planets use the same file
					if (!plan1.getName().equalsIgnoreCase(plan2.getName())) {
						plan1.updatePos(plan2);
					}
				}
				// Update and draw
				plan1.timePlusPlus();
				plan1.drawToScreen();
			}
			for( Planet plan1:planets){
				System.out.println("x " + plan1.getX() + " y " + plan1.getY() + " vx " + plan1.getVx() + " vy " + plan1.getVy() + " " + plan1.getName() );
			}
			// Lets not make it a blur
			StdDraw.show(100);
			StdDraw.clear();
			StdDraw.picture(0, 0, "starfield.jpg");
		}
	}
}
