import java.io.IOException;

import java.util.ArrayList;

import javax.swing.JFrame;

/*
 * [PROMPT]
 * @author PMARINA
 * @version Feb 9, 2016
 */
public class Main {
	public static ArrayList<Object> items;
	public static void main(String[] args) throws IOException {
		mainMenu();
	}

	public static void mainMenu() {
		items = Draw.mainMenu();
		
	}
	public static void purchase(){
		Draw.sizeScreen(1,items.get(0));
		Draw.sizeScreen(0,items.get(0));
	}

	public static void restocking() {
		Draw.sizeScreen(1,items.get(0));
		try{Thread.sleep(1000);}
		catch(InterruptedException e){ e.printStackTrace();}
		Draw.sizeScreen(0,items.get(0));
	}

	public static void settings() {
		Draw.sizeScreen(1,items.get(0));
		Draw.sizeScreen(0,items.get(0));
	}
}