package Projekt;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	/**
	* 
	*/
	//private GMatrix g;
	private JButton but;
	private static final long serialVersionUID = 1L;
	private JLabel l1, l2;
	private long kezd;
	private boolean ujrakezd;

	public MyPanel(GMatrix g) {  //berakom a panelbe a megfelelo gombokat
		//this.g=g.getG();
		l1 = new JLabel("Points: " + g.getPontszam());
		add(l1);
		but = new JButton("Reset");
		add(but, BorderLayout.NORTH);
		kezd = System.currentTimeMillis();
		ujrakezd = false;
		but.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				g.ujrakezd();
				ujrakezd = true;
				kezd = System.currentTimeMillis();
			}
		});
		l2 = new JLabel("Time:");
		add(l2);
	
	}

	public void l1setT(String x) {
		l1.setText(x);
	}

	public void l2settT(String x) {
		l2.setText(x);
	}

	public long getKezd() {
		return kezd;
	}

	public boolean getUjrakezd() {
		return ujrakezd;
	}

	public void setUjrakezd(boolean a) {
		ujrakezd = a;
	}
}
