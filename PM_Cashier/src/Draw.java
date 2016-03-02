import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * [PROMPT]
 * @author PMARINA
 * @version Feb 25, 2016
 */
public class Draw {
	public static JFrame initScreen(int size) {
		JFrame x = new JFrame("Mrs. Elia's Store");
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setUndecorated(true);
		sizeScreen(size, x);
		x.setResizable(false);
		x.setAlwaysOnTop(true);
		x.setLocation(0, 0);
		return x;
	}

	public static void initScreen(JFrame x) {
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setUndecorated(true);
		x.setResizable(false);
		x.setAlwaysOnTop(true);
		x.setLocation(0, 0);
	}

	public static void sizeScreen(int size, Object y) {
		JFrame x = (JFrame) y;
		if (size == 0) {
			x.setExtendedState(JFrame.NORMAL);//
			Toolkit a = new Toolkit(); // TODO Check is normal is supported for
										// this computer...
			System.out.println(a.isFrameStateSupported(JFrame.NORMAL));

			// x.setSize(300, 50);
			// x.pack();
		} else {
			x.setExtendedState(JFrame.MAXIMIZED_BOTH);//
			// x.setSize(1000, 1000);
		}
		x.setAlwaysOnTop(true);
		x.setUndecorated(true);
		x.setVisible(true);
		// initScreen(x);
	}

	public static ArrayList<Object> mainMenu() {
		ArrayList<Object> items = new ArrayList<Object>();
		JFrame x = initScreen(0);
		Container cp = x.getContentPane();
		LayoutManager lm = new FlowLayout();
		cp.setLayout(lm);
		JButton purchase = new JButton("Purchase");
		JButton restocking = new JButton("Restocking");
		JButton settings = new JButton("Settings");
		cp.add(purchase);
		cp.add(restocking);
		cp.add(settings);
		x.setVisible(true);
		items.add(x);
		items.add(purchase);
		items.add(restocking);
		items.add(settings);
		purchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.purchase();
			}
		});
		restocking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.restocking();
			}
		});
		settings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.settings();
			}
		});
		return items;
	}
}
