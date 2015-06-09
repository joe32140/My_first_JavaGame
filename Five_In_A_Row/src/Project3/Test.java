package Project3;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;


public class Test extends Frame{

	private static final long serialVersionUID = 1L;
	pad pad1 = new pad();
	public Test() {
		super("My Game");
		setLayout(null);
		setSize(720, 750);
		setBackground(Color.gray);
		add(pad1);
		pad1.setBounds(30, 40, 660, 690);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	    setVisible(true);
	    setResizable(false);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

}
