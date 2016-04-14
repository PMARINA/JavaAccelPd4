/**
 * @author PMARINA
 * @version Apr 13, 2016
 */

public class BallDriver {
	public static void main(String[] args) {
		Ball milosevic = new Ball(10, 80, 0.001);
		while(milosevic.isMoving()){//milosevic.isMoving()
			milosevic.update();
			milosevic.drawToScreen();
		}
	}
}
