import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Driver {
	final static Color bgColor = new Color(184, 216, 186);
	final static double winHeight = 300;
	final static double winLength = 1000;
	final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	final static double screenWidth = screenSize.getWidth();
	final static double screenHeight = screenSize.getHeight();
	private static final String encrypt = "c:/users/pmarina/documents/github/!Null/img/encrypt.jpg";
	private static final String decrypt = "c:/users/pmarina/documents/github/!Null/img/decrypt.jpg";
	private static final String RSA = "c:/users/pmarina/documents/github/!Null/img/RSA.jpg";
	private static final String AES = "c:/users/pmarina/documents/github/!Null/img/AES.png";

	public static void main(String[] args) {
		final JFrame screen = init();
		ActionListener encryptAction = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				encrypt(screen);
			}
		};
		ActionListener decryptAction = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				decrypt(screen);
			}
		};
		button(encrypt, encryptAction, "Encryption", screen, 0, 0, 500, 1000);
		button(decrypt, decryptAction, "Decryption", screen, 500, 0, 500, 1000);
		screen.revalidate();
	}

	private static void encrypt(JFrame screen) {
		screen.dispose();
		screen.setVisible(false);
		screen = init();
		final JFrame screen1 = screen;
		ActionListener RSAAction = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rSA(screen1);
			}
		};
		ActionListener AESAction = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aES(screen1);
			}
		};
		button(RSA, RSAAction, "RSA", screen, 0, 0, 500, 1000);
		button(AES, AESAction, "AES", screen, 500, 0, 500, 1000);
		screen.revalidate();
	}

	private static void decrypt(JFrame screen) {
		screen.dispose();
		screen = init();
		JFrame screen1 = screen;
		ActionListener RSAAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				decryptRSA(screen1);
			}
		};
		ActionListener AESAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				decryptAES(screen1);
			}
		};
		button(RSA, RSAAction, "RSA", screen, 0, 0, 500, 1000);
		button(AES, AESAction, "AES", screen, 500, 0, 500, 1000);
	}

	private static void rSA(JFrame screen) {
		screen.dispose();
		final JFrame screen1 = screen = init();
		JTextField inputField = new JTextField("    Input    ");
		JPanel a = new JPanel();
		a.add(inputField);
		JButton x = new JButton("submit");
		ActionListener l = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String c = inputField.getText();
				String[] code = RSACode.encrypt(c);
				rSAdisplay(screen1, code);
			}
		};
		x.addActionListener(l);
		a.add(x);
		screen.add(a);
		screen.revalidate();
	}

	private static void rSAdisplayOutput(JFrame screen, String out) {
		screen.dispose();
		screen = init();
		JButton mess = new JButton("Copy Message");
		JPanel m = new JPanel();
		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String myString = out;
				StringSelection stringSelection = new StringSelection(myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		};
		mess.addActionListener(l);
		m.add(mess);
		screen.add(m);
	}

	private static void aES(JFrame screen) {
		screen.dispose();
		final JFrame screen1 = screen = init();
		JTextField inputField = new JTextField("Message");
		JTextField pdField = new JTextField("Password");
		JPanel a = new JPanel();
		a.add(inputField);
		a.add(pdField);
		JButton x = new JButton("Submit");
		ActionListener l = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String b = inputField.getText();
				String c = pdField.getText();
				aESoutput(AESCode.encryptMessage(b, c), screen1);
			}
		};
		x.addActionListener(l);
		a.add(x);
		screen.add(a);
		screen.revalidate();
	}

	/**
	 * @param string
	 * @param screen
	 * @param i
	 * @param j
	 */
	@SuppressWarnings("unused")
	private static void text(String text, JPanel screen, int x, int y, int xend, int yend) {
		JLabel t = new JLabel(text);
		t.setBounds(x, y, xend - x, yend - y);
		t.setFont(new Font("Serif", Font.PLAIN, 36));
		screen.add(t);
		t.revalidate();
		screen.revalidate();
	}

	private static JFrame init() {
		JFrame screen = new JFrame();
		screen.setLayout(new GridLayout());
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Get the screen's dimensions

		// Height and length of the window created by my program.
		screen.setBounds(new Rectangle((int) (screenWidth / 2 - winLength / 2),
				(int) (screenHeight / 2 - winHeight / 2), (int) winLength, (int) winHeight));
		screen.setBackground(bgColor);
		screen.setVisible(true);
		screen.setResizable(false);
		String ls = "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=";
		String rs = "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-";
		screen.setTitle("\\" + ls + "__PMARINA Encryption__" + rs + "/");
		return screen;
	}

	public static JPanel button(String path, ActionListener act, String text, JFrame screen, int x, int y, int xend,
			int yend) {
		JPanel myp = new JPanel();
		JButton x1 = new JButton(text, new ImageIcon(path));
		x1.addActionListener(act);
		x1.setBounds(new Rectangle(x, y, xend - x, yend - y));
		myp.add(x1);
		myp.revalidate();
		screen.add(myp);
		screen.revalidate();
		return myp;
	}

	private static void rSAdisplay(JFrame screen, String[] code) {
		screen.dispose();
		screen = init();
		JPanel screem = new JPanel();
		JButton messbut = new JButton("copy message");
		JButton k1 = new JButton("copy value of key1");
		JButton k2 = new JButton("copy value of key2");
		JButton k3 = new JButton("copy value of key3");
		messbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String myString = code[3];
				StringSelection stringSelection = new StringSelection(myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		k1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String myString = code[0];
				StringSelection stringSelection = new StringSelection(myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		k2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String myString = code[1];
				StringSelection stringSelection = new StringSelection(myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		k3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String myString = code[2];
				StringSelection stringSelection = new StringSelection(myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		screem.add(messbut);
		screem.add(k1);
		screem.add(k2);
		screem.add(k3);
		screen.add(screem);
		screen.revalidate();
	}

	private static void aESoutput(String encryptMessage, JFrame screen) {
		screen.dispose();
		screen = init();
		JPanel myp = new JPanel();
		JButton x = new JButton("Copy Encrypted Message");
		x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String myString = encryptMessage;
				StringSelection stringSelection = new StringSelection(myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		});
		myp.add(x);
		screen.add(myp);
		screen.revalidate();
	}

	private static void decryptRSA(JFrame screen) {
		screen.dispose();
		screen = init();
		JFrame screen1 = screen;
		JPanel screem = new JPanel();
		JTextField mess = new JTextField("Encoded Message");
		JTextField n = new JTextField("Private Key");
		JTextField d = new JTextField("Public Key");
		JTextField ea = new JTextField("Exponent");
		JButton x = new JButton("submit");
		ActionListener xa = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m = mess.getText();
				String prk = n.getText();
				String puk = d.getText();
				String plk = ea.getText();
				rSAdisplayOutput(screen1, RSACode.decrypt(new String[] { prk, puk, plk, m }));
			}
		};
		x.addActionListener(xa);
		screem.add(mess);
		screem.add(n);
		screem.add(d);
		screem.add(ea);
		screem.add(x);
		screen.add(screem);
		screen.revalidate();
	}

	private static void decryptAES(JFrame screen) {
		screen.dispose();
		screen = init();
		JPanel screem = new JPanel();
		final JFrame screen1 = screen;
		JTextField s = new JTextField("Message");
		JTextField a = new JTextField("Password");
		JButton x = new JButton("submit");
		ActionListener l = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				decryptAESOutput(AESCode.decryptMessagage(s.getText(), a.getText()), screen1);
			}
		};
		x.addActionListener(l);
		screem.add(s);
		screem.add(a);
		screem.add(x);
		screen.add(screem);
		screen.revalidate();
	}

	private static void decryptAESOutput(String decryptMessage, JFrame screen) {
		screen.dispose();
		screen = init();
		JPanel m = new JPanel();
		JButton copy = new JButton("Copy Decrypted Message");
		ActionListener l = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String myString = decryptMessage;
				StringSelection stringSelection = new StringSelection(myString);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}
		};
		copy.addActionListener(l);
		m.add(copy);
		screen.add(m);
		screen.revalidate();
	}
}
