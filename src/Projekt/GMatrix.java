package Projekt;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GMatrix {
	private Gomb x[][];
	private int nagysag;
	private Container f;
	private Matrix z;
	private int pontszam;
	private boolean nyert, vesztett;
    //getter setterek
	
	public Container getF() {
		return f;
	}

	public void setF(Container f) {
		this.f = f;
	}

	public Gomb[][] getX() {
		return x;
	}

	public void setX(Gomb[][] x) {
		this.x = x;
	}

	public int getNagysag() {
		return nagysag;
	}

	public void setNagysag(int nagysag) {
		this.nagysag = nagysag;
	}

	public Matrix getZ() {
		return z;
	}

	public void setZ(Matrix z) {
		this.z = z;
	}
//konstruktor
	public GMatrix(int nagysag, Container f) {
		this.f = f;
		this.nagysag = nagysag;
		z = new Matrix(nagysag,60);
		pontszam = 0;
		nyert = false;
		vesztett = false;
		// letrehozom a gombmatrixot
		x = new Gomb[nagysag][nagysag];
		for (int i = 0; i < nagysag; i++) {
			for (int j = 0; j < nagysag; j++) {
				x[i][j] = new Gomb(i, j, z.getij(i, j));
			}
		}

	}
//gombmatrix osszes elemenek megfeleltetem a megfelelo listenert
	public void listener() {
		for (int i = 0; i < nagysag; i++) {
			for (int j = 0; j < nagysag; j++) {
				int a = i;
				int b = j;
				x[a][b].addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						int k = x[a][b].getErtek();
						String C = Integer.toString(k);
						if ((k != -1) && (k != 0) && vesztett == false && nyert == false) {
							x[a][b].setText(C);
							x[a][b].setLatott(1);
							pontszam++;
							
							if (pontszam == nagysag*nagysag - z.getMaxakna() && vesztett == false && nyert == false) {
								nyert = true;
							}

						} else if (k == 0 && vesztett == false && nyert == false) {
							fill(a, b);
							if (pontszam == nagysag*nagysag - z.getMaxakna() && vesztett == false && nyert == false) {
								nyert = true;
							}
						
						
						}
						if (pontszam == nagysag - z.getMaxakna()) {
							nyert = true;
						}

						if (k == -1) {
							akna();
							vesztett = true;
						}

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
		}
	}

	public void berak() { // a metodus berakja a gombmatrixot a megfelelo containerbe
		for (int i = 0; i < nagysag; i++) {
			for (int j = 0; j < nagysag; j++) {
				f.add(x[i][j]);
			}
		}
	}

	public void kivesz() { // a metodus kiveszi a gombmatrixot a megfelelo containerbol
		for (int i = 0; i < nagysag; i++) {
			for (int j = 0; j < nagysag; j++) {
				f.remove(x[i][j]);
			}
		}
	}

	public void fill(int i, int j) { // a fill alprogrammal lathatova teszem az osszes nullast meg szomszedait ha
		pontszam++; // 0-ra lett kattintva
		x[i][j].setText("0");
		x[i][j].setLatott(1);
		if ((i - 1) >= 0 && (j - 1) >= 0) {
			if (x[i - 1][j - 1].getErtek() == 0 && x[i - 1][j - 1].getLatott() == 0) {
				x[i - 1][j - 1].setText("0");
				x[i - 1][j - 1].setLatott(1);
				fill(i - 1, j - 1);

			} else if (x[i - 1][j - 1].getErtek() > 0 && x[i - 1][j - 1].getLatott() == 0) {
				String C = Integer.toString(x[i - 1][j - 1].getErtek());
				x[i - 1][j - 1].setText(C);
				x[i - 1][j - 1].setLatott(1);
				pontszam++;
			}
		}
		if ((i - 1) >= 0) {
			if (x[i - 1][j].getErtek() == 0 && x[i - 1][j].getLatott() == 0) {
				x[i - 1][j].setText("0");
				x[i - 1][j].setLatott(1);
				fill(i - 1, j);

			} else if (x[i - 1][j].getErtek() > 0 && x[i - 1][j].getLatott() == 0) {
				String C = Integer.toString(x[i - 1][j].getErtek());
				x[i - 1][j].setText(C);
				x[i - 1][j].setLatott(1);
				pontszam++;
			}
		}

		if ((i - 1) >= 0 && (j + 1) < nagysag) {
			if (x[i - 1][j + 1].getErtek() == 0 && x[i - 1][j + 1].getLatott() == 0) {
				x[i - 1][j + 1].setText("0");
				x[i - 1][j + 1].setLatott(1);
				fill(i - 1, j + 1);

			} else if (x[i - 1][j + 1].getErtek() > 0 && x[i - 1][j + 1].getLatott() == 0) {
				String C = Integer.toString(x[i - 1][j + 1].getErtek());
				x[i - 1][j + 1].setText(C);
				x[i - 1][j + 1].setLatott(1);
				pontszam++;
			}
		}

		if ((j + 1) < nagysag) {
			if (x[i][j + 1].getErtek() == 0 && x[i][j + 1].getLatott() == 0) {
				x[i][j + 1].setText("0");
				x[i][j + 1].setLatott(1);
				fill(i, j + 1);

			} else if (x[i][j + 1].getErtek() > 0 && x[i][j + 1].getLatott() == 0) {
				String C = Integer.toString(x[i][j + 1].getErtek());
				x[i][j + 1].setText(C);
				x[i][j + 1].setLatott(1);
				pontszam++;
			}
		}

		if ((j - 1) >= 0) {
			if (x[i][j - 1].getErtek() == 0 && x[i][j - 1].getLatott() == 0) {
				x[i][j - 1].setText("0");
				x[i][j - 1].setLatott(1);
				fill(i, j - 1);

			} else if (x[i][j - 1].getErtek() > 0 && x[i][j - 1].getLatott() == 0) {
				String C = Integer.toString(x[i][j - 1].getErtek());
				x[i][j - 1].setText(C);
				x[i][j - 1].setLatott(1);
				pontszam++;
			}
		}

		if ((i + 1) < nagysag && (j + 1) < nagysag) {
			if (x[i + 1][j + 1].getErtek() == 0 && x[i + 1][j + 1].getLatott() == 0) {
				x[i + 1][j + 1].setText("0");
				x[i + 1][j + 1].setLatott(1);
				fill(i + 1, j + 1);
			} else if (x[i + 1][j + 1].getErtek() > 0 && x[i + 1][j + 1].getLatott() == 0) {
				String C = Integer.toString(x[i + 1][j + 1].getErtek());
				x[i + 1][j + 1].setText(C);
				x[i + 1][j + 1].setLatott(1);
				pontszam++;
			}
		}

		if ((i + 1) < nagysag) {
			if (x[i + 1][j].getErtek() == 0 && x[i + 1][j].getLatott() == 0) {
				x[i + 1][j].setText("0");
				x[i + 1][j].setLatott(1);
				fill(i + 1, j);
			} else if (x[i + 1][j].getErtek() > 0 && x[i + 1][j].getLatott() == 0) {
				String C = Integer.toString(x[i + 1][j].getErtek());
				x[i + 1][j].setText(C);
				x[i + 1][j].setLatott(1);
				pontszam++;
			}
		}

		if ((i + 1) < nagysag && (j - 1) >= 0) {
			if (x[i + 1][j - 1].getErtek() == 0 && x[i + 1][j - 1].getLatott() == 0) {
				x[i + 1][j - 1].setText("0");
				x[i + 1][j - 1].setLatott(1);
				fill(i + 1, j - 1);
			} else if (x[i + 1][j - 1].getErtek() > 0 && x[i + 1][j - 1].getLatott() == 0) {
				String C = Integer.toString(x[i + 1][j - 1].getErtek());
				x[i + 1][j - 1].setText(C);
				x[i + 1][j - 1].setLatott(1);
				pontszam++;
			}

		}

	}

	void akna() // ha aknara lett lepve az osszes aknat lathatova teszem
	{
		for (int i = 0; i < nagysag; i++) {
			for (int j = 0; j < nagysag; j++) {
				if (x[i][j].getErtek() == -1) {
					x[i][j].setText("X");
					x[i][j].setLatott(1);
				}
			}
		}
	}

	public int getPontszam() {
		return pontszam;
	}

	public void setPontszam(int pt) {
		pontszam = pt;
	}

	public void ujrakezd() {
		Matrix m; // a reset gomb lenyomasara atalakitja a tablat
		m = new Matrix(nagysag, 60);
		for (int i = 0; i < nagysag; i++) {
			for (int j = 0; j < nagysag; j++) {
				x[i][j].setText("");
				x[i][j].setErtek(m.getij(i, j));
				x[i][j].setLatott(0);
			}
		}
		pontszam = 0;
		nyert = false;
		vesztett = false;
	}

	public void kiir() {
		z.kiir();
	}

	public boolean getNyert() {
		return nyert;
	}

	public boolean getVesztett() {
		return vesztett;
	}

	public void setVesztett(boolean a) {
		vesztett = a;
	}

	public void setNyert(boolean a) {
		nyert = a;
	}
	public GMatrix getG()
	{
	  return this;
	 
	}
}
