package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import oblici.Krug;
import oblici.Kvadrat;
import oblici.Linija;
import oblici.Oblik;
import oblici.Pravougaonik;
import oblici.Tacka;
import oblici.Trougao;

public class Crtanje extends JFrame {
	Stack<Oblik> stekOblika = new Stack<Oblik>();
	public JButton btnOdabranoDugme;
	public int xTacka, yTacka, klik = 0, selektovaniIndex;
	public Oblik selektovan;

	public Crtanje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sara Bajic IT75-2016");
		getContentPane().setLayout(new BorderLayout(0, 0));

		PanelCrtanje pnlCrtanje = new PanelCrtanje();
		pnlCrtanje.setBackground(Color.WHITE);
		getContentPane().add(pnlCrtanje, BorderLayout.CENTER);

		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.WEST);
		pnlKomande.setLayout(new BoxLayout(pnlKomande, BoxLayout.Y_AXIS));

		JButton btnTacka = new JButton("Ta\u010Dka");
		btnTacka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnOdabranoDugme = btnTacka;
			}
		});
		btnTacka.setMaximumSize(new Dimension(120, 25));
		btnTacka.setMinimumSize(new Dimension(120, 25));
		btnTacka.setPreferredSize(new Dimension(120, 25));
		pnlKomande.add(btnTacka);

		JButton btnLinija = new JButton("Linija");
		btnLinija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnOdabranoDugme = btnLinija;
			}
		});
		btnLinija.setMaximumSize(new Dimension(120, 25));
		btnLinija.setMinimumSize(new Dimension(120, 25));
		btnLinija.setPreferredSize(new Dimension(120, 25));
		pnlKomande.add(btnLinija);

		JButton btnPravougaonik = new JButton("Pravougaonik");
		btnPravougaonik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnOdabranoDugme = btnPravougaonik;
			}
		});
		btnPravougaonik.setMaximumSize(new Dimension(120, 25));
		btnPravougaonik.setMinimumSize(new Dimension(120, 25));
		btnPravougaonik.setPreferredSize(new Dimension(120, 25));
		pnlKomande.add(btnPravougaonik);

		JButton btnKvadrat = new JButton("Kvadrat");
		btnKvadrat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnOdabranoDugme = btnKvadrat;
			}
		});
		btnKvadrat.setMaximumSize(new Dimension(120, 25));
		btnKvadrat.setMinimumSize(new Dimension(120, 25));
		btnKvadrat.setPreferredSize(new Dimension(120, 25));
		pnlKomande.add(btnKvadrat);

		JButton btnKrug = new JButton("Krug");
		btnKrug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnOdabranoDugme = btnKrug;
			}
		});
		btnKrug.setMaximumSize(new Dimension(120, 25));
		btnKrug.setMinimumSize(new Dimension(120, 25));
		btnKrug.setPreferredSize(new Dimension(120, 25));
		pnlKomande.add(btnKrug);

		JButton btnTrougao = new JButton("Trougao");
		btnTrougao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnOdabranoDugme = btnTrougao;
			}
		});
		btnTrougao.setPreferredSize(new Dimension(120, 25));
		btnTrougao.setMinimumSize(new Dimension(120, 25));
		btnTrougao.setMaximumSize(new Dimension(120, 25));
		pnlKomande.add(btnTrougao);

		JSeparator separatorDrugi = new JSeparator();
		pnlKomande.add(separatorDrugi);

		JLabel lblStranica = new JLabel("Stranica");
		lblStranica.setAlignmentY(Component.TOP_ALIGNMENT);
		pnlKomande.add(lblStranica);

		JButton btnBojaStranice = new JButton("");
		btnBojaStranice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser biracBojeStranice = new JColorChooser();
				Color izabranaBojaStranice = biracBojeStranice.showDialog(null, "Izaberite željenu boju", Color.BLACK);
				btnBojaStranice.setBackground(izabranaBojaStranice);
			}
		});
		btnBojaStranice.setMaximumSize(new Dimension(120, 25));
		btnBojaStranice.setMinimumSize(new Dimension(120, 25));
		btnBojaStranice.setPreferredSize(new Dimension(120, 25));
		btnBojaStranice.setBackground(Color.BLACK);
		pnlKomande.add(btnBojaStranice);

		JLabel lblUnutrasnjost = new JLabel("Unutrasnjost");
		pnlKomande.add(lblUnutrasnjost);

		JButton btnBojaUnutrasnjosti = new JButton("");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser biracBojeUnutrasnjosti = new JColorChooser();
				Color izabranaBojaUnutrasnjosti = biracBojeUnutrasnjosti.showDialog(null, "Izaberite željenu boju: ",
						Color.WHITE);
				btnBojaUnutrasnjosti.setBackground(izabranaBojaUnutrasnjosti);
			}
		});
		btnBojaUnutrasnjosti.setMaximumSize(new Dimension(120, 25));
		btnBojaUnutrasnjosti.setMinimumSize(new Dimension(120, 25));
		btnBojaUnutrasnjosti.setPreferredSize(new Dimension(120, 25));
		btnBojaUnutrasnjosti.setBackground(Color.WHITE);
		pnlKomande.add(btnBojaUnutrasnjosti);

		JSeparator separatorPrvi = new JSeparator();
		pnlKomande.add(separatorPrvi);

		JButton btnSelektuj = new JButton("Selektuj");
		btnSelektuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOdabranoDugme = btnSelektuj;
			}
		});
		btnSelektuj.setMaximumSize(new Dimension(120, 25));
		btnSelektuj.setMinimumSize(new Dimension(120, 25));
		btnSelektuj.setPreferredSize(new Dimension(120, 25));
		pnlKomande.add(btnSelektuj);

		JButton btnModifikuj = new JButton("Modifikuj");
		btnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selektovan instanceof Tacka) {
					TackaDialogModifikacija td = new TackaDialogModifikacija();
					td.getTxtX().setText(Integer.toString(((Tacka) selektovan).getX()));
					td.getTxtY().setText(Integer.toString(((Tacka) selektovan).getY()));
					td.getBtnBoja().setBackground(((Tacka) selektovan).getBoju());
					td.setSize(245, 175);
					td.setLocationRelativeTo(null);
					td.setVisible(true);
					Tacka t1 = td.getT1();
					if (t1 != null) {
						stekOblika.remove(selektovan);
						pnlCrtanje.obrisiOblik(selektovan);
						pnlCrtanje.dodajOblik(t1);
						stekOblika.push(t1);
					}

				} else if (selektovan instanceof Linija) {
					LinijaDialogModifikacija ld = new LinijaDialogModifikacija();
					ld.getTxtXKoordinataPocetneTacke()
							.setText(Integer.toString(((Linija) selektovan).getPocetna().getX()));
					ld.getTxtYKoordinataPocetneTacke()
							.setText(Integer.toString(((Linija) selektovan).getPocetna().getY()));
					ld.getTxtXKoordinataKrajnjeTacke()
							.setText(Integer.toString(((Linija) selektovan).getKrajnja().getX()));
					ld.getTxtYKoordinataKrajnjeTacke()
							.setText(Integer.toString(((Linija) selektovan).getKrajnja().getY()));
					ld.getBtnBojaLinije().setBackground((((Linija) selektovan).getBoju()));

					ld.setSize(330, 230);
					ld.setLocationRelativeTo(null);
					ld.setVisible(true);
					Linija l1 = ld.getL1();
					if (l1 != null) {
						stekOblika.removeElement(selektovan);
						pnlCrtanje.obrisiOblik(selektovan);
						pnlCrtanje.dodajOblik(l1);
						stekOblika.push(l1);
					}
				} else if (selektovan instanceof Pravougaonik) {
					PravougaonikDialogModifikacija pd = new PravougaonikDialogModifikacija();
					pd.getTxtXGoreLevo().setText(Integer.toString(((Pravougaonik) selektovan).getGoreLevo().getX()));
					pd.getTxtYGoreLevo().setText(Integer.toString(((Pravougaonik) selektovan).getGoreLevo().getY()));
					pd.getTxtVisina().setText(Integer.toString(((Pravougaonik) selektovan).getDuzinaStranice()));
					pd.getTxtSirina().setText(Integer.toString(((Pravougaonik) selektovan).getSirina()));
					pd.getBtnBojaStranice().setBackground(((Pravougaonik) selektovan).getBoju());
					pd.getBtnBojaUnutrasnjosti().setBackground(((Pravougaonik) selektovan).getBojaUnu());
					pd.setSize(330, 250);
					pd.setLocationRelativeTo(null);
					pd.setVisible(true);
					Pravougaonik p1 = pd.getP1();
					if (p1 != null) {
						stekOblika.removeElement(selektovan);
						pnlCrtanje.obrisiOblik(selektovan);
						pnlCrtanje.dodajOblik(p1);
						stekOblika.push(p1);
					}
				} else if (selektovan instanceof Kvadrat) {
					KvadratDialogModifikacija kd = new KvadratDialogModifikacija();
					kd.getTxtXGoreLevo().setText(Integer.toString(((Kvadrat) selektovan).getGoreLevo().getX()));
					kd.getTxtYGoreLevo().setText(Integer.toString(((Kvadrat) selektovan).getGoreLevo().getY()));
					kd.getTxtDuzinaStranice().setText(Integer.toString(((Kvadrat) selektovan).getDuzinaStranice()));
					kd.getBtnBojaStranice().setBackground(((Kvadrat) selektovan).getBoju());
					kd.getBtnBojaUnutrasnjosti().setBackground(((Kvadrat) selektovan).getBojaUnu());
					kd.setSize(330, 230);
					kd.setLocationRelativeTo(null);
					kd.setVisible(true);
					Kvadrat k1 = kd.getK1();
					if (k1 != null) {
						stekOblika.removeElement(selektovan);
						pnlCrtanje.obrisiOblik(selektovan);
						pnlCrtanje.dodajOblik(k1);
						stekOblika.push(k1);
					}
				} else if (selektovan instanceof Krug) {
					KrugDialogModifikacija kd = new KrugDialogModifikacija();
					kd.getTxtPoluprecnik().setText(Integer.toString(((Krug) selektovan).getPoluprecnik()));
					kd.getTxtXCentar().setText(Integer.toString(((Krug) selektovan).getCentar().getX()));
					kd.getTxtYCentar().setText(Integer.toString(((Krug) selektovan).getCentar().getY()));
					kd.getBtnBojaStranice().setBackground(((Krug) selektovan).getBoju());
					kd.getBtnBojaUnutrasnjosti().setBackground(((Krug) selektovan).getBojaUnu());
					kd.setSize(350, 240);
					kd.setLocationRelativeTo(null);
					kd.setVisible(true);
					Krug kr1 = kd.getKr1();
					if (kr1 != null) {
						stekOblika.removeElement(selektovan);
						pnlCrtanje.obrisiOblik(selektovan);
						pnlCrtanje.dodajOblik(kr1);
						stekOblika.push(kr1);
					}
				} else if (selektovan instanceof Trougao) {
					TrougaoDialogModifikacija td = new TrougaoDialogModifikacija();
					td.getTxtXt().setText(Integer.toString(((Trougao) selektovan).getT().getX()));
					td.getTxtYt().setText(Integer.toString(((Trougao) selektovan).getT().getY()));
					td.getTxtDuzinaStranice().setText(Integer.toString(((Trougao) selektovan).getDuzinaStranice()));
					td.getBtnBojaStranice().setBackground(((Trougao) selektovan).getBoju());
					td.getBtnBojaUnutrasnjosti().setBackground(((Trougao) selektovan).getBojaUnu());
					td.setSize(350,240);
					td.setLocationRelativeTo(null);
					td.setVisible(true);
					Trougao tr1 = td.getTr1();
					if (tr1 != null) {
						stekOblika.removeElement(selektovan);
						pnlCrtanje.obrisiOblik(selektovan);
						pnlCrtanje.dodajOblik(tr1);
						stekOblika.push(tr1);
					}
				}
			}
		});
		btnModifikuj.setEnabled(false);
		btnModifikuj.setMaximumSize(new Dimension(120, 25));
		btnModifikuj.setMinimumSize(new Dimension(120, 25));
		btnModifikuj.setPreferredSize(new Dimension(120, 25));
		pnlKomande.add(btnModifikuj);

		JButton btnObrisi = new JButton("Obrisi");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Brisanje brisanje = new Brisanje();
				brisanje.setSize(330, 90);
				brisanje.setLocationRelativeTo(null);
				brisanje.setVisible(true);

				if (brisanje.getFlag() == 1) {
					stekOblika.remove(selektovan);
					pnlCrtanje.obrisiOblik(selektovan);
					repaint();
				} else {
					brisanje.setVisible(false);
				}
				btnModifikuj.setEnabled(false);
				btnObrisi.setEnabled(false);
			}
		});
		btnObrisi.setEnabled(false);
		btnObrisi.setMaximumSize(new Dimension(120, 25));
		btnObrisi.setMinimumSize(new Dimension(120, 25));
		btnObrisi.setPreferredSize(new Dimension(120, 25));
		pnlKomande.add(btnObrisi);

		pnlCrtanje.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (btnOdabranoDugme == btnTacka) {
					xTacka = e.getX();
					yTacka = e.getY();
					Tacka t1 = new Tacka(xTacka, yTacka, btnBojaStranice.getBackground());
					pnlCrtanje.dodajOblik(t1);
					stekOblika.push(t1);
				} else if (btnOdabranoDugme == btnLinija) {
					if (klik == 0) {
						xTacka = e.getX();
						yTacka = e.getY();
						klik++;
					} else {
						int xTackaKrajnja = e.getX();
						int yTackaKrajnja = e.getY();
						Linija l1 = new Linija(new Tacka(xTacka, yTacka), new Tacka(xTackaKrajnja, yTackaKrajnja),
								btnBojaStranice.getBackground());
						pnlCrtanje.dodajOblik(l1);
						stekOblika.push(l1);
						klik = 0;
					}
				} else if (btnOdabranoDugme == btnPravougaonik) {
					xTacka = e.getX();
					yTacka = e.getY();
					PravougaonikDialogCrtanje pd = new PravougaonikDialogCrtanje();
					pd.setSize(220, 140);
					pd.setLocationRelativeTo(null);
					pd.setVisible(true);
					Pravougaonik p1 = new Pravougaonik(new Tacka(xTacka, yTacka), pd.getVisina(), pd.getSirina(),
							btnBojaStranice.getBackground(), btnBojaUnutrasnjosti.getBackground());
					pnlCrtanje.dodajOblik(p1);
					stekOblika.push(p1);
				} else if (btnOdabranoDugme == btnKvadrat) {
					xTacka = e.getX();
					yTacka = e.getY();
					KvadratDialogCrtanje kd = new KvadratDialogCrtanje();
					kd.setSize(270, 135);
					kd.setLocationRelativeTo(null);
					kd.setVisible(true);
					Kvadrat kv1 = new Kvadrat(new Tacka(xTacka, yTacka), kd.getDuzinaStranice(),
							btnBojaStranice.getBackground(), btnBojaUnutrasnjosti.getBackground());
					pnlCrtanje.dodajOblik(kv1);
					stekOblika.push(kv1);
				} else if (btnOdabranoDugme == btnKrug) {
					xTacka = e.getX();
					yTacka = e.getY();
					KrugDialogCrtanje kd = new KrugDialogCrtanje();
					kd.setSize(270, 135);
					kd.setLocationRelativeTo(null);
					kd.setVisible(true);
					Krug kr1 = new Krug(new Tacka(xTacka, yTacka), kd.getPoluprecnik(), btnBojaStranice.getBackground(),
							btnBojaUnutrasnjosti.getBackground());
					pnlCrtanje.dodajOblik(kr1);
					stekOblika.push(kr1);
				} else if (btnOdabranoDugme == btnTrougao) {
					xTacka = e.getX();
					yTacka = e.getY();
					TrougaoDialogCrtanje td = new TrougaoDialogCrtanje();
					td.setSize(270, 135);
					td.setLocationRelativeTo(null); // fixira dialog
					td.setVisible(true);
					Trougao tr1 = new Trougao(new Tacka(xTacka, yTacka), td.getDuzinaStranice(), btnBojaStranice.getBackground(), btnBojaUnutrasnjosti.getBackground());
					pnlCrtanje.dodajOblik(tr1);
					stekOblika.push(tr1);
				} else if (btnOdabranoDugme == btnSelektuj) {
					btnModifikuj.setEnabled(false);
					btnObrisi.setEnabled(false);

					if (selektovan != null) {
						selektovan.setSelektovan(false);
						repaint();
					}
					
					xTacka = e.getX();
					yTacka = e.getY();

					for (int i = stekOblika.size() - 1; i >= 0; i--) {
						if (stekOblika.elementAt(i).sadrzi(xTacka, yTacka)) {
							selektovan = stekOblika.elementAt(i);
							selektovan.setSelektovan(true);
							btnModifikuj.setEnabled(true);
							btnObrisi.setEnabled(true);
							repaint();
							return;
						}
					}
				}
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crtanje frmCrtanje = new Crtanje();
					frmCrtanje.setVisible(true);
					frmCrtanje.setSize(700, 460);
					frmCrtanje.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
