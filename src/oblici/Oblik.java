package oblici;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Comparable{
	private String boja;
	private Color bojaa = Color.BLACK;
	private boolean selektovan;
	
	public boolean isSelektovan() {
		return selektovan;
	}
	
	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
	
	public static Color pronadjiBoju(String string) {
		switch(string) {
		case "bela":
			return Color.WHITE;
		case "crvena":
			return Color.RED;
		case "plava":
			return Color.BLUE;
		case "zuta":
			return Color.YELLOW;
		case "zelena":
			return Color.GREEN;
		default:
			return Color.BLACK;
		}
		
		
	}
	
	public Oblik() {
		
	}
	
	public Oblik(String boja) {
		this.boja = boja;
	}

	public String getBoja() {
		return boja;
	}
	
	public void setBoja(String boja) {
		this.boja = boja;
	}
	
	public Color getBoju() {
		return bojaa;
	}

	public void setBoju(Color boja) {
		this.bojaa = boja;
	}
	
	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x, int y);


}
