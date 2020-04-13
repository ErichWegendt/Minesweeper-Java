package Projekt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class HighScores {
	//private File f;
	private boolean nhs;
//	private String h;
   
	public HighScores() {
//		f = new File("HighScores.txt");
		nhs=false;
	
	}

     //a beir metodus beir egy adott high scoret a fileba
	public void beir(String a) {
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter("HighScores.txt", true));
			br.write(a);
			br.newLine();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Nem tudok a fileal dolgozni");
		}
	}
  //megszamolja hany  high score vavn a fileban
	public int megszamol() {
		int n = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("HighScores.txt"));
			while (br.readLine() != null) {
				n++;
			}
			br.close();
			return n;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File hiba");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO hiba");
		}
		return n;
	}
//rendezem a highscoreokat es ellenorzom hogy az adott pontszam highscore-e
	public void kiveszelso(int pontszam) {
		int n = megszamol();
		int[] x;
		String[] S, S3;
		String S2;

		x = new int[n];
		S = new String[n];
		try {
			BufferedReader br = new BufferedReader(new FileReader("HighScores.txt"));
			S2 = br.readLine();
			int i = 0;
			while (S2 != null) {
				S3 = S2.split(" ");
				S[i] = S3[0];
				x[i] = Integer.parseInt(S3[1]);
				i++;
				S2 = br.readLine();
			}

			for (i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (x[i] < x[j]) {
						int s = x[i];
						x[i] = x[j];
						x[j] = s;
						String S11;
						S11 = S[i];
						S[i] = S[j];
						S[j] = S11;
					}

				}
			}
			if (pontszam >= x[0]) {
				nhs = true;
			}
			
			String Ujstring=new String();
			for (i = 0; i < n; i++) {
		       Ujstring=Ujstring+x[i] + " " + S[i]+"\n";
			}
			//h=Ujstring;

			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File hiba");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO hiba");
		}

	}

	public boolean getNhs() {
		return nhs;
	}

	public void setNhs(boolean a) {
		nhs = a;
	}
    
	//megadja az osszes High Scoret
	  public String getHighScore()
	  {
			int n = megszamol();
			int[] x;
			String[] S, S3;
			String S2;

			x = new int[n];
			S = new String[n];
			try {
				BufferedReader br = new BufferedReader(new FileReader("HighScores.txt"));
				S2 = br.readLine();
				int i = 0;
				while (S2 != null) {
					S3 = S2.split(" ");
					S[i] = S3[0];
					x[i] = Integer.parseInt(S3[1]);
					i++;
					S2 = br.readLine();
				}

				for (i = 0; i < n; i++) {
					for (int j = i + 1; j < n; j++) {
						if (x[i] < x[j]) {
							int s = x[i];
							x[i] = x[j];
							x[j] = s;
							String S11;
							S11 = S[i];
							S[i] = S[j];
							S[j] = S11;
						}

					}
				}
				String Ujstring=new String();
				for (i = 0; i < n; i++) {
			       Ujstring=Ujstring+x[i] + " " + S[i]+"\n";
				}
			
				br.close();
				return Ujstring;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File hiba");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IO hiba");
			}  
			return "0";
	  }
}

