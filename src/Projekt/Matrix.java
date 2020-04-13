package Projekt;

import java.util.Random;

public class Matrix {
	private int x[][];
	private Random rand;
	private int aknaszam;
	private int maxakna;
	private int nagysag;
  
	public Matrix(int nagysag, int maxakna) { // letrrehozom a matrixot melyben a gombmatrixhoz tartozo adatokat tarolom
		this.nagysag = nagysag;
		this.maxakna = maxakna;
		aknaszam = 0;
		rand = new Random();
		x = new int[nagysag][nagysag];
		while (aknaszam < maxakna) // a 20X20-as mezon max 60 akna lehet
		{
			for (int i = 0; i < nagysag && aknaszam < maxakna; i++) {
				for (int j = 0; j < nagysag && aknaszam < maxakna; j++) {
					int k = rand.nextInt(8);
					x[i][j] = 0;
					if (k == 3 && x[i][j] != -1) {
						x[i][j] = -1;
						aknaszam++;
					}
				}
			}
		}

		int szomsz = 0;
		for (int i = 0; i < nagysag; i++) { // meghatarozom ugy a matrixot hogy az aknakat es a szomszedsagban levo
											// aknak szamat jelleze
			for (int j = 0; j < nagysag; j++) {
				szomsz = 0;
				if (x[i][j] != -1) {
					if ((i - 1 >= 0) && (j - 1) >= 0) {
						if (x[i - 1][j - 1] == -1)
							szomsz++;
					}
					if ((i - 1) >= 0) {
						if (x[i - 1][j] == -1)
							szomsz++;
					}
					if (((i - 1) >= 0) && ((j + 1) < nagysag)) {
						if (x[i - 1][j + 1] == -1)
							szomsz++;
					}
					if ((j - 1) >= 0) {
						if (x[i][j - 1] == -1)
							szomsz++;
					}

					if ((j + 1) < nagysag) {
						if (x[i][j + 1] == -1)
							szomsz++;
					}
					if (((i + 1) < nagysag) && ((j - 1) >= 0)) {
						if (x[i + 1][j - 1] == -1)
							szomsz++;
					}
					if ((i + 1) < nagysag) {
						if (x[i + 1][j] == -1)
							szomsz++;
					}
					if (((j + 1) < nagysag) && ((i + 1) < nagysag)) {
						if (x[i + 1][j + 1] == -1)
							szomsz++;
					}
					x[i][j] = szomsz;
				}

			}
		}
	}
   //kiiro metodus
	public void kiir() {
		for (int i = 0; i < nagysag; i++) {
			for (int j = 0; j < nagysag; j++) {
				System.out.print(x[i][j]);
				System.out.print("  ");
			}
			System.out.println("");
		}
		System.out.println(aknaszam);
	}
   //getter setterek
	public int getij(int i, int j) {
		return x[i][j];
	}

	public void setij(int i, int j, int ertek) {
		x[i][j] = ertek;
	}
	public int getMaxakna()
	{
		return maxakna;
	}
}
