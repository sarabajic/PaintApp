package oblici;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik{
	private String bojaUnutrasnjosti = "bela";
	private Color bojaUnu = Color.WHITE;

	public Color getBojaUnu() {
		return bojaUnu;
	}

	public void setBojaUnu(Color bojaUnu) {
		this.bojaUnu = bojaUnu;
	}

	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}
	
	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	
	public abstract double povrsina();
	public abstract double obim();
	public abstract void popuni(Graphics g);


}
