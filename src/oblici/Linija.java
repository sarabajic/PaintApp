package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik implements Pomerljiv{
	private Tacka pocetna;
	private Tacka krajnja;
	
	public Linija() {
		
	}
	
	
	public Linija(Tacka pocetna, Tacka krajnja) {
		this.pocetna = pocetna;
		this.krajnja = krajnja;
	}
	
	public Linija(Tacka pocetna, Tacka krajnja, String boja) {
		super(boja);
		this.pocetna = pocetna;
		this.krajnja = krajnja;
	}

	public Linija(Tacka tacka, Tacka tacka2, Color background) {
		this(tacka,tacka2);
		setBoju(background);
	}


	public Tacka getPocetna() {
		return pocetna;
	}
	
	public void setPocetna(Tacka novaPocetna) {
		pocetna = novaPocetna;
	}
	
	public Tacka getKrajnja() {
		return krajnja;
	}
	
	public void setKrajnja(Tacka novaKrajnja) {
		krajnja = novaKrajnja;
	}
	
	public void pomeriNa(int novoX, int novoY) {
		int rx = novoX - pocetna.getX();
		int ry = novoY - pocetna.getY();
		pocetna.pomeriNa(novoX, novoY);
		krajnja.pomeriZa(rx, ry);
	}
	
	public void pomeriZa(int novoX, int novoY) {
		pocetna.pomeriZa(novoX, novoY);
		krajnja.pomeriZa(novoX, novoY);
	}
	
	public double duzina() {
		return pocetna.udaljenost(krajnja);
	}
	
	public String toString()
	{
		String ispis = pocetna.toString() + "->" + krajnja.toString();
		return ispis ;
	}
	
	public Tacka sredinaLinije() {
		int sx = (pocetna.getX() + krajnja.getX())/2;
		int sy = (pocetna.getY() + krajnja.getY())/2;
		Tacka sredina = new Tacka(sx, sy);
		return sredina;
	}


	@Override
	public void crtajSe(Graphics g) {
		g.setColor(this.getBoju());
		g.drawLine(pocetna.getX(), pocetna.getY(),
					krajnja.getX(), krajnja.getY());
		
		if (this.isSelektovan()) {
			this.selektovan(g);
		}
	}


	@Override
	public int compareTo(Object arg0) {
		if (arg0 instanceof Linija) {
			Linija prosledjena = (Linija)arg0;
			return (int) (this.duzina() - prosledjena.duzina());
		} else {
			return 0;
		}
	}
	
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		pocetna.selektovan(g);
		this.sredinaLinije().selektovan(g);
		krajnja.selektovan(g);
	}


	@Override
	public boolean sadrzi(int x, int y) {
		Tacka klik = new Tacka(x, y);
		double udaljenostPocetna = pocetna.udaljenost(klik);
		double udaljenostKrajnja = krajnja.udaljenost(klik);
		if (udaljenostPocetna + udaljenostKrajnja <= this.duzina() + 0.05) {
			return true;
		} else {
			return false;
		}
		
	}

}
