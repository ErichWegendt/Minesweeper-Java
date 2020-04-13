package Projekt;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyPanel2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton but;
	private TextField tf;
	private String C;
    private JLabel l1;
    private JButton but2;
	private boolean lenyomott;
    private HighScores h;
	
	public MyPanel2() {
	    h=new HighScores();  //a frame lenti reszeben levo gomdokat tarolom ebben a panelben
		lenyomott=false;
		setLayout(new GridLayout());
		tf = new TextField();
		but = new JButton("Mentes");
		l1=new JLabel("A jatek vegen kerem irja be a nevet: ");
        but2=new JButton("Get HighScores");
		add(l1);
		add(tf);
		add(but);
		add(but2);
	
		C=new String();
		but.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				setNev(tf.getText());
				tf.setText("");
                lenyomott=true;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		but2.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent arg0) {
						JFrame ff=new JFrame();
						JOptionPane.showMessageDialog(ff, "A jelenlegi High Score: "+h.getHighScore());
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
			
				});
	}

	public String getNev() {
		return C;
	}
	public void setNev(String C)
	{
	   this.C=C;
	}
	public boolean getLenyomott()
	{
		return lenyomott;
	}
	public void setlenyomott(boolean a)
	{
		lenyomott=a;
	}
}
