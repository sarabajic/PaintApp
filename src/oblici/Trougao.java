package oblici;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import oblici.Linija;
import oblici.Tacka;

public class Trougao extends PovrsinskiOblik implements Pomerljiv {
	private Tacka teziste,tacka1,tacka2,tacka3;
	private Linija linija1,linija2,linija3;
	float h ;
	
	int duzinaStranice;
	public int getDuzinaStranice() {
		return duzinaStranice;
	}

	public void setDuzinaStranice(int duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}

	public Tacka getT() {
		return teziste;
	}

	public void setT(Tacka t) {
		this.teziste = t;
	}



	Polygon p;
	
	
	public Trougao() {
		
	}

	public Trougao(Tacka teziste, int duzinaStranice){
		this.teziste = teziste;
		this.duzinaStranice = duzinaStranice;
		
		h = (float) (duzinaStranice * Math.sqrt(3) / 2);
		tacka1 = new Tacka(teziste.getX() - duzinaStranice/2, (int)(teziste.getY() + h/3));
		tacka2 = new Tacka(teziste.getX() + duzinaStranice/2, (int)(teziste.getY() + h/3));
		tacka3 = new Tacka(teziste.getX(), (int)(teziste.getY() - 2 * h/3));
		
		linija1 = new Linija(tacka1,tacka2);
		linija2 = new Linija(tacka2,tacka3);
		linija3 = new Linija(tacka3,tacka1);
	}
	
	public Trougao(Tacka teziste, int duzinaStranice, Color background , Color background2){
		this(teziste, duzinaStranice);
		setBoju(background);
		setBojaUnu(background2);
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void pomeriZa(int x, int y) {
		teziste.pomeriZa(x,y);
	}

	@Override
	public void pomeriNa(int x, int y) {
		teziste.pomeriNa(x, y);
	}

	@Override
	public double povrsina() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double obim() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void popuni(Graphics g) {
		g.setColor(getBojaUnu());
		int x[] = new int[3];
		int y[] = new int[3];
		x[0]=tacka1.getX(); x[1]=tacka2.getX(); x[2]=tacka3.getX();
		y[0]=tacka1.getY(); y[1]=tacka2.getY(); y[2]=tacka3.getY()+2;
		int n = 3;
		p = new Polygon(x, y, n);
		
		g.fillPolygon(p);
	}

	@Override
	public void crtajSe(Graphics g) {
		g.setColor(getBoju());

		g.drawLine(tacka1.getX(), tacka1.getY(), tacka2.getX(), tacka2.getY());
		g.drawLine(tacka2.getX(), tacka2.getY(), tacka3.getX(), tacka3.getY());
		g.drawLine(tacka3.getX(), tacka3.getY(), tacka1.getX(), tacka1.getY());
		
		if (isSelektovan())
			selektovan(g);
		
		popuni(g);
	}

	@Override
	public boolean sadrzi(int x, int y) {
		if(p.contains(x,y))
			return true;
		return false;
	}

	@Override
	public void selektovan(Graphics g) {
		tacka1.selektovan(g);
		tacka2.selektovan(g);
		tacka3.selektovan(g);
		
	}

		public String toString() {
			return "(" + this.tacka1.getX()+ "," + this.tacka3.getX() + ")";
		}
}
