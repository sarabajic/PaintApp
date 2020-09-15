package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends PovrsinskiOblik implements Pomerljiv{
	protected Tacka goreLevo;
	protected int duzinaStranice;
	
	public int getDuzinaStranice() {
		return duzinaStranice;
	}

	public void setDuzinaStranice(int duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}

	public Kvadrat () {
		
	}
	
	public Kvadrat(Tacka goreLevo, int sirina) {
		this.goreLevo = goreLevo;
		this.duzinaStranice = sirina;
	}
	
	public Kvadrat(Tacka goreLevo, int sirina, String boja) {
		this(goreLevo, sirina);
		setBoja(boja);
	}
	
	public Kvadrat(Tacka goreLevo, int sirina, String boja, String bojaUnutrasnjosti) {
		this(goreLevo, sirina);
		setBoja(boja);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}
	
	public Kvadrat(Tacka tacka, int duzinaStranice, Color background, Color background2) {
		this(tacka, duzinaStranice);
		setBoju(background);
		setBojaUnu(background2);
	}

	public Tacka getGoreLevo() {
		return goreLevo;
	}
	
	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}
	
	public void pomeriNa(int novoX, int novoY) {
		goreLevo.pomeriNa(novoX, novoY);
	}

	public void pomeriZa(int novoX, int novoY) {
		goreLevo.pomeriZa(novoX, novoY);
	}
	
	public double obim() {
		double obim;
		obim = 4*duzinaStranice;
		return obim;
	}
	
	public double povrsina() {
		return duzinaStranice*duzinaStranice;
	}
	
	public Linija dijagonala() {
		Linija dijagonala = new Linija(goreLevo, new Tacka(goreLevo.getX() + duzinaStranice,goreLevo.getY() + duzinaStranice));
		return dijagonala;
	}
	
	public Tacka centar() {
		return this.dijagonala().sredinaLinije();
	}

	@Override
	public void crtajSe(Graphics g) {
		g.setColor(this.getBoju());
		g.drawRect(getGoreLevo().getX(), 
					getGoreLevo().getY(), duzinaStranice, duzinaStranice);
		popuni(g);
		if (this.isSelektovan()) {
			this.selektovan(g);
		}
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Kvadrat) {
			Kvadrat prosledjen = (Kvadrat)o;
			return this.duzinaStranice - prosledjen.duzinaStranice;
		} else {
			return 0;
		}
	}

	@Override
	public void popuni(Graphics g) {
		g.setColor(this.getBojaUnu());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, duzinaStranice-1, duzinaStranice-1);
	}
	
	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		dijagonala().sredinaLinije().selektovan(g);
		new Linija(goreLevo, new Tacka(goreLevo.getX()+duzinaStranice, goreLevo.getY())).selektovan(g);
		new Linija(goreLevo, new Tacka(goreLevo.getX(), goreLevo.getY()+duzinaStranice)).selektovan(g);
		new Linija(new Tacka(goreLevo.getX()+duzinaStranice, goreLevo.getY()), dijagonala().getKrajnja()).selektovan(g);
		new Linija(new Tacka(goreLevo.getX(), goreLevo.getY()+duzinaStranice), dijagonala().getKrajnja()).selektovan(g);
	}

	@Override
	public boolean sadrzi(int x, int y) {
		if (goreLevo.getX() <= x  && x <= (goreLevo.getX() + duzinaStranice)
				&& goreLevo.getY() <= y && y <= (goreLevo.getY() + duzinaStranice)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Tacka gore levo=("+goreLevo.getX()+","+goreLevo.getY()+"), stranica="+duzinaStranice + ", boja konture: \"" + getBoja() + "\", boja unutrasnjosti: \"" + getBojaUnutrasnjosti() + "\"";
	}

}
