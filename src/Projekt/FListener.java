package Projekt;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//ebben az osztalyban targyalom hogy a frame be volt-e zarva is a neki megfelelo listener

public class FListener {

	private MyFrame f;
	private boolean lenyomott;

	public FListener(MyFrame f, boolean lenyomott) {
		super();
		this.f = f;
		this.lenyomott = lenyomott;
	}

	public void ad() {
		f.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				lenyomott=true;
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
	}

	public boolean isLenyomott() {
		return lenyomott;
	}

	public void setLenyomott(boolean lenyomott) {
		this.lenyomott = lenyomott;
	}
}
