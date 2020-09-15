package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik implements Pomerljiv {
	private int x;
	private int y;

	public Tacka(int novoX, int novoY) {
		x = novoX;
		y = novoY;
	}

	public Tacka(int x, int y, String boja) {
		super(boja);
		this.x = x;
		this.y = y;
	}

	public Tacka(int xTacka, int yTacka, Color boja) {
		this(xTacka, yTacka);
		setBoju(boja);
	}

	public int getX() {
		return x;
	}

	public void setX(int novoX) {
		x = novoX;
	}

	public int getY() {
		return y;
	}

	public void setY(int novoY) {
		y = novoY;
	}

	public void pomeriZa(int novoX, int novoY) {
		x = x + novoX;
		y = y + novoY;
	}

	public void pomeriNa(int novoX, int novoY) {
		x = novoX;
		y = novoY;
	}

	public double udaljenost(Tacka druga) {
		int rx = x - druga.getX();
		int ry = y - druga.getY();
		double rezultat = Math.sqrt(rx * rx + ry * ry);
		return rezultat;

	}

	public String toString() {
		String ispis = "(" + x + "," + y + ")";
		return ispis;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Tacka) {
			Tacka prosledjena = (Tacka) obj;
			if (this.x == prosledjena.getX() && this.y == prosledjena.getY()
					&& this.getBoju().equals(prosledjena.getBoju())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	@Override
	public void crtajSe(Graphics g) {
		g.setColor(this.getBoju());
		g.drawLine(x - 1, y - 1, x + 1, y + 1);
		g.drawLine(x - 1, y + 1, x + 1, y - 1);

		if (this.isSelektovan()) {
			this.selektovan(g);
		}

	}

	@Override
	public int compareTo(Object arg0) {
		if (arg0 instanceof Tacka) {
			Tacka prosledjena = (Tacka) arg0;
			return (int) (this.udaljenost(new Tacka(0, 0)) - prosledjena.udaljenost(new Tacka(0, 0)));
		} else {
			return 0;
		}
	}

	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x - 3, y - 3, 6, 6);
	}

	@Override
	public boolean sadrzi(int x, int y) {
		Tacka klik = new Tacka(x, y);
		if (this.udaljenost(klik) <= 3) {
			return true;
		} else {
			return false;
		}
	}
}
