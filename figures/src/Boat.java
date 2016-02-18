import java.util.ArrayList;
/*
 * Use the Picture class as a model to implement a new class Boat to draw a basic boat. Implement this class in the Picture project. Create an object of the class Boat, take a screen shot and attached it to this post. Attach the class Boat also.
 * @author PMARINA
 * @version Feb 10, 2016
 */
public class Boat {
	public ArrayList<Object>  boatComponents;
	/**
	 * Blah Blah Blah
	 * @params param1 does this
	 * @returns returns stuff
	 * @throws noInputError no input given by the user
	 */
	public Boat(){
		//Make a boat
	}
	public void draw(){
		Square ocean = new Square();
		ocean.changeSize(500);
		ocean.moveHorizontal(-310);
		ocean.changeColor("blue");
		ocean.makeVisible();
		boatComponents = new ArrayList<Object>();
		Square part1 = new Square();
		part1.changeSize(450);
		part1.moveHorizontal(-280);
		part1.makeVisible();
		boatComponents.add(part1);
		//Square part2 = new Square();
		//part2.changeSize(100);
		//part2.moveHorizontal(-50);
		//part2.makeVisible();
		//boatComponents.add(part2);
		Triangle lInverter = new Triangle();
		lInverter.moveVertical(-20);
		lInverter.moveHorizontal(-180);
		lInverter.changeColor("blue");
		lInverter.makeVisible();
		Triangle rInverter = new Triangle();
		rInverter.moveVertical(-20);
		rInverter.moveHorizontal(270);
		rInverter.changeColor("blue");
		rInverter.makeVisible();
		Square smokeStack = new Square();
		smokeStack.moveHorizontal(100);
		smokeStack.changeSize(50);
		smokeStack.moveVertical(-50);
		smokeStack.moveHorizontal(-115);
		smokeStack.changeColor("black");
		smokeStack.makeVisible();
		Square smokeStackFixer = new Square();
		smokeStackFixer.changeColor("white");
		smokeStackFixer.moveVertical(-60);
		smokeStackFixer.makeVisible();
		Square rectangleMaker = new Square();
		rectangleMaker.changeSize(500);
		rectangleMaker.moveHorizontal(-310);
		rectangleMaker.changeColor("blue");
		rectangleMaker.moveVertical(50);
		rectangleMaker.makeVisible();
		Triangle smoke = new Triangle();
		smoke.changeColor("black");
		smoke.moveVertical(-130);
		smoke.moveHorizontal(230);
		smoke.changeSize(50,300);
		smoke.makeVisible();
		Triangle smokeFixer = new Triangle();
		smokeFixer.changeColor("white");
		smokeFixer.moveVertical(-130);
		smokeFixer.moveHorizontal(235);
		smokeFixer.changeSize(50, 300);
		smokeFixer.makeVisible();
	}
}
