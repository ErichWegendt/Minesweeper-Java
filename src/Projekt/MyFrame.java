package Projekt;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MyFrame extends JFrame {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private Container cont;
	private GMatrix gm;
	private MyPanel p;
	private Szal sz;
	private MyPanel2 p2;
	private boolean bezart;
    private FListener fl;
	public MyFrame() {
		bezart = false;

		setLayout(new BorderLayout()); // letrehozom a Laoyutot,egy containert is amibe beleraok a gombmatrixot
		cont = new Container();
		cont.setLayout(new GridLayout(20, 20));
		gm = new GMatrix(20, cont);
		gm.listener();
		gm.berak();
		add(cont, BorderLayout.CENTER);

		p = new MyPanel(gm);
		add(p, BorderLayout.NORTH);
		setVisible(true);
		p2 = new MyPanel2();
		add(p2, BorderLayout.SOUTH);
		setSize(1000, 1000);
		fl=new FListener(this,false);
		fl.ad();
		sz = new Szal(gm, p, p2,fl);
		sz.start();
	
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // beallitom a frame alapveto tulajdonsagait

  
	}

	public boolean getBezart() {
		return bezart;
	}
	
	public void setBezart(boolean a)
	{
	    bezart=a;
	}
}
