package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Krug extends PovrsinskiOblik implements Pomerljiv{
	private Tacka centar;
	private int poluprecnik;
	
	public Krug() {
		
	}
	
	public Krug(Tacka centar, int poluprecnik) {
		this.centar = centar;
		this.poluprecnik = poluprecnik;
	}
		
	public Krug(Tacka centar, int poluprecnik, String boja) {
		this(centar, poluprecnik);
		setBoja(boja);
	}
	
	public Krug(Tacka centar, int poluprecnik, String boja, String bojaUnutrasnjosti) {
		this(centar, poluprecnik);
		setBoja(boja);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public Krug(Tacka tacka, int poluprecnik, Color background, Color background2) {
		this(tacka, poluprecnik);
		setBoju(background);
		setBojaUnu(background2);
	}

	public Tacka getCentar() {
		return centar;
	}
	
	public void setCentar(Tacka centar) {
		this.centar = centar;
	}
	
	public int getPoluprecnik() {
		return poluprecnik;
	}
	
	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}
	
	public void pomeriNa(int novoX, int novoY) {
		centar.pomeriNa(novoX, novoY);
	}

	public void pomeriZa(int novoX, int novoY) {
		centar.pomeriZa(novoX, novoY);
	}
	
	public double obim() {
		double obim;
		obim = 2*poluprecnik*Math.PI;
		return obim;
	}
	
	public double povrsina() {
		return poluprecnik*poluprecnik*Math.PI;
	}

	@Override
	public void crtajSe(Graphics g) {
		g.setColor(this.getBoju());
		g.drawOval(centar.getX()-poluprecnik,
					centar.getY()-poluprecnik,
					2*poluprecnik,
					2*poluprecnik);
		popuni(g);
		if (this.isSelektovan()) {
			this.selektovan(g);
		}
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Krug) {
			Krug prosledjen = (Krug)o;
			return this.poluprecnik - prosledjen.poluprecnik;
		} else {
			return 0;
		}
	}

	@Override
	public void popuni(Graphics g) {
		g.setColor(this.getBojaUnu());
		g.fillOval(centar.getX()-poluprecnik+1,
					centar.getY()-poluprecnik+1,
					2*poluprecnik-1,
					2*poluprecnik-1);
	}

	@Override
	public boolean sadrzi(int x, int y) {
		Tacka klik = new Tacka(x, y);
		if (centar.udaljenost(klik)<= poluprecnik) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void selektovan(Graphics g) {
		centar.selektovan(g);
		Tacka levo = new Tacka(centar.getX() - poluprecnik, centar.getY());
		Tacka desno = new Tacka(centar.getX() + poluprecnik, centar.getY());
		Tacka gore = new Tacka(centar.getX(), centar.getY() - poluprecnik);
		Tacka dole = new Tacka(centar.getX(), centar.getY() + poluprecnik);
		
		levo.selektovan(g);
		desno.selektovan(g);
		gore.selektovan(g);
		dole.selektovan(g);
	}
	
}
