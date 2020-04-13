package Projekt;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Szal extends Thread {

	private GMatrix g;
	private MyPanel p;
	private long kezdido;
	private long most;
	private long mp;
	private long perc;
	private MyPanel2 p2;
	private JFrame jf;
	private HighScores h;
	private FListener f;
    //konstruktor
	public Szal(GMatrix g, MyPanel p, MyPanel2 p2, FListener f) {
		this.g = g;
		this.p = p;
		this.p2 = p2;
		this.f = f;
		h = new HighScores();
	}

	public void run() {
		kezdido = p.getKezd();
		most = System.currentTimeMillis();

		while (f.isLenyomott() == false) {

			while (f.isLenyomott() == false) {
		
				if (p.getUjrakezd() == true) {
					kezdido = most;
					p.setUjrakezd(false);
				}
				
				String x = Integer.toString(g.getPontszam());
				
				p.l1setT("Pontszam: " + x);        // beallitom a pontszamot es az idot
				most = System.currentTimeMillis();
		

				mp = (most - kezdido) / 1000;
				if (mp > 60) {
					perc = mp / 60;
					mp = mp % 60;
				}
				String C = Long.toString(perc);
				String D = Long.toString(mp);
				C = C + " : " + D;
				p.l2settT("Ido: " + C);
				if (g.getVesztett() == true || g.getNyert() == true) {
					break;
				}
				p.repaint();
				if (f.isLenyomott() == true) {
					break;
				}
			}

			while (g.getVesztett() == true || g.getNyert() == true) {
				if (f.isLenyomott() == true) {
					break;
				}
                             //ha valaki nyert megvarom meg a neven be nincs irva es  le ninc smentve a pontszamval
				if (g.getVesztett() == true) {
					jf = new JFrame();
					JFrame jf2 = new JFrame();
					JOptionPane.showMessageDialog(jf, "You Lost");
				
					while (p2.getLenyomott() == false) {
						System.out.print("");
						if (f.isLenyomott() == true) {
								
							break;
						}

					}

					String S = p2.getNev() + " " + Integer.toString(g.getPontszam());
					h.beir(S);
					h.kiveszelso(g.getPontszam());
					if (h.getNhs() == true) {
						JOptionPane.showMessageDialog(jf2, "New HighScore");
					}
					h.setNhs(false);
					
					
					g.ujrakezd();
					kezdido = System.currentTimeMillis();
					
					p2.setlenyomott(false);
					
			
					if (perc > 0) {
						perc = 0;
					}
					
				}
                    //kulon le van targyalva ha valaki nyert vagy vesztett
				if (g.getNyert() == true) {
					String S;
					jf = new JFrame();
					JFrame jf2 = new JFrame();
					JOptionPane.showMessageDialog(jf, "You won");
					while (p2.getLenyomott() == false) {
						System.out.println("");
						if (f.isLenyomott() == true) {
							break;
						}
						if(p2.getLenyomott()==true)
						{
							break;
						}

					}
					S = p2.getNev() + " " + Integer.toString(g.getPontszam());
					h.beir(S);
					h.kiveszelso(g.getPontszam());
					if (h.getNhs() == true) {
						JOptionPane.showMessageDialog(jf2, "New HighScore");
					}
					h.setNhs(false);
					
					g.ujrakezd();
					kezdido = System.currentTimeMillis();
					
					p2.setlenyomott(false);
				
					if (perc > 0) {
						perc = 0;
					}
				}
             
			}

		}
	
	}



}
