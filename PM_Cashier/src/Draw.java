import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Rectangle;
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
	public static JFrame initScreen(int size){
		JFrame x = new JFrame("Mrs. Elia's Store");
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setUndecorated(true);
		sizeScreen(size, x);
		x.setResizable(false);
		x.setAlwaysOnTop(true);
		x.setLocation(0, 0);
		return x;
	}
	public static void sizeScreen(int size, Object y){
		JFrame x = (JFrame) y;
		x.pack();
		if(size == 0)x.setBounds(0, 0, 300, 50);
		else{
			x.setBounds(0,0,1000, 1000);
		}
		x.setVisible(true);
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
		purchase.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Main.purchase();
			}
		});
		restocking.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Main.restocking();
			}
		});
		settings.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Main.settings();
			}
		});
		return items;
	}
}
