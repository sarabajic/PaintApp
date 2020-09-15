package crtanje;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import oblici.Oblik;

public class PanelCrtanje extends JPanel {
	ArrayList<Oblik> listaOblika = new ArrayList<Oblik>();

	public void dodajOblik(Oblik o) {
		listaOblika.add(o);
		repaint();
	}

	public void obrisiOblik(Oblik o) {
		listaOblika.remove(o);
		repaint();
	}

	public void paint(Graphics g) {
		super.paintComponent(g); //iz nadredjene klase 
		for (Oblik o : listaOblika) {
			o.crtajSe(g);
		}
	}
}
