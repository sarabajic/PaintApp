package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Kvadrat {
	private int sirina;

	public int getSirina() {
		return sirina;
	}

	public void setSirina(int sirina) {
		this.sirina = sirina;
	}

	public Pravougaonik() {

	}

	public Pravougaonik(Tacka goreLevo, int visina, int sirina) {
		super(goreLevo, visina);
		this.sirina = sirina;
	}

	public Pravougaonik(Tacka goreLevo, int visina, int sirina, String boja) {
		this(goreLevo, visina, sirina);
		this.setBoja(boja);
	}
	
	public Pravougaonik(Tacka goreLevo, int visina, int sirina, String boja, String bojaUnutrasnjosti) {
		this(goreLevo, visina, sirina);
		this.setBoja(boja);
		this.setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}

	public Pravougaonik(Tacka tacka, int visina, int sirina, Color background, Color background2) {
		this(tacka, visina,sirina);
		setBoju(background);
		setBojaUnu(background2);
	}

	public double obim() {
		double obim;
		obim = 2*sirina + 2*this.getSirina();
		return obim;
	}
	
	public double povrsina() {
		return sirina*this.getSirina();
	}
	
	public String toString()
	{
		String ispis = "Tacka gore levo= " + goreLevo + " sirina= " + this.getSirina() + " visina= " + sirina;
		return ispis;
	}
	
	public Linija dijagonala() {
		Linija dijagonala = new Linija(goreLevo, new Tacka(goreLevo.getX() + sirina,goreLevo.getY() + duzinaStranice));
		return dijagonala;
	}
	
	public void crtajSe(Graphics g) {
		g.setColor(this.getBoju());
		g.drawRect(goreLevo.getX(), 
					goreLevo.getY(), sirina, duzinaStranice);
		popuni(g);
		if (this.isSelektovan()) {
			this.selektovan(g);
		}
	}
	
	public int compareTo(Object o) {
		if (o instanceof Pravougaonik) {
			Pravougaonik prosledjen = (Pravougaonik)o;
			return (int) (this.povrsina() - prosledjen.povrsina());
		} else {
			return 0;
		}
	}
	
	public void popuni(Graphics g) {
		g.setColor(this.getBojaUnu());
		g.fillRect(getGoreLevo().getX()+1, 
				getGoreLevo().getY()+1, sirina-1, duzinaStranice-1);
	}
	
	@Override
	public boolean sadrzi(int x, int y) {
		if (goreLevo.getX() <= x  && x <= (goreLevo.getX() + getSirina())
				&& goreLevo.getY() <= y && y <= (goreLevo.getY() + sirina)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		dijagonala().sredinaLinije().selektovan(g);
		new Linija(goreLevo, new Tacka(goreLevo.getX()+sirina, goreLevo.getY())).selektovan(g);
		new Linija(goreLevo, new Tacka(goreLevo.getX(), goreLevo.getY()+duzinaStranice)).selektovan(g);
		new Linija(new Tacka(goreLevo.getX()+sirina, goreLevo.getY()), dijagonala().getKrajnja()).selektovan(g);
		new Linija(new Tacka(goreLevo.getX(), goreLevo.getY()+duzinaStranice), dijagonala().getKrajnja()).selektovan(g);
	}

}
