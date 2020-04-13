package Projekt;



import javax.swing.JButton;

public class Gomb extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
     //a gombmatrix letrehozasahoz van ennek az osztalynak ertelme
	private int latott;
	private int i,j;
	private int ertek;
	
	public Gomb(int i,int j,int ertek)
	{  
		this.ertek=ertek;
		this.i=i;
		this.j=j;
	
        latott=0;
	}
	public void setLatott(int l)
	{
		latott=l;
	}
	public int getLatott()
	{
		return latott;
	}
	
	public int getErtek()
	{
		return ertek;
	}
	public void setErtek(int x)
	{
		ertek=x;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
	
}
