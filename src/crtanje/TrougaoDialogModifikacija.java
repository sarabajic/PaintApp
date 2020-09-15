package crtanje;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import oblici.Tacka;
import oblici.Trougao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrougaoDialogModifikacija extends JDialog {
	public JTextField txtXt;
	public JTextField txtYt;
	public JTextField txtDuzinaStranice;
	public JButton btnBojaStranice;	
	public JButton btnBojaUnutrasnjosti;
	public int xTacka,yTacka,duzinaStranice;
	Trougao tr1;
	
	public Trougao getTr1() {
		return tr1;
	}
	public JButton getBtnBojaStranice() {
		return btnBojaStranice;
	}
	public JButton getBtnBojaUnutrasnjosti() {
		return btnBojaUnutrasnjosti;
	}
	
	public JTextField getTxtXt() {
		return txtXt;
	}
	public JTextField getTxtYt() {
		return txtYt;
	}
	public JTextField getTxtDuzinaStranice() {
		return txtDuzinaStranice;
	}

	public TrougaoDialogModifikacija() {
		setResizable(false);
		setModal(true);
		setTitle("Modifikacija trougla");
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					xTacka = Integer.parseInt(txtXt.getText());
					yTacka = Integer.parseInt(txtYt.getText());
					duzinaStranice = Integer.parseInt(txtDuzinaStranice.getText());
					if(xTacka <= 0 || yTacka <=0 || duzinaStranice <=0) {
						JOptionPane.showMessageDialog(null, "Greska,uneti brojevi moraju biti pozitivni");
					} else {
						tr1 = new Trougao(new Tacka(xTacka, yTacka), duzinaStranice, btnBojaStranice.getBackground(),
								btnBojaUnutrasnjosti.getBackground());					
						setVisible(false);
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Niste uneli broj!");
				}
			}
		});
		pnlKomande.add(btnOk);
		
		JPanel pnlGlavni = new JPanel();
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlGlavni.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlGlavni.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		
		JLabel lblUnesiteXKoordinatu = new JLabel("Unesite X koordinatu tezista:");
		GridBagConstraints gbc_lblUnesiteXKoordinatu = new GridBagConstraints();
		gbc_lblUnesiteXKoordinatu.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnesiteXKoordinatu.gridx = 1;
		gbc_lblUnesiteXKoordinatu.gridy = 1;
		pnlGlavni.add(lblUnesiteXKoordinatu, gbc_lblUnesiteXKoordinatu);
		
		txtXt = new JTextField();
		GridBagConstraints gbc_txtXt = new GridBagConstraints();
		gbc_txtXt.insets = new Insets(0, 0, 5, 0);
		gbc_txtXt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXt.gridx = 4;
		gbc_txtXt.gridy = 1;
		pnlGlavni.add(txtXt, gbc_txtXt);
		txtXt.setColumns(10);
		
		JLabel lblUnesiteYKoordinate = new JLabel("Unesite Y koordinate tezista:");
		GridBagConstraints gbc_lblUnesiteYKoordinate = new GridBagConstraints();
		gbc_lblUnesiteYKoordinate.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnesiteYKoordinate.gridx = 1;
		gbc_lblUnesiteYKoordinate.gridy = 2;
		pnlGlavni.add(lblUnesiteYKoordinate, gbc_lblUnesiteYKoordinate);
		
		txtYt = new JTextField();
		GridBagConstraints gbc_txtYt = new GridBagConstraints();
		gbc_txtYt.insets = new Insets(0, 0, 5, 0);
		gbc_txtYt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYt.gridx = 4;
		gbc_txtYt.gridy = 2;
		pnlGlavni.add(txtYt, gbc_txtYt);
		txtYt.setColumns(10);
		
		JLabel lblUnesiteDuzinuStranice = new JLabel("Unesite duzinu stranice:");
		GridBagConstraints gbc_lblUnesiteDuzinuStranice = new GridBagConstraints();
		gbc_lblUnesiteDuzinuStranice.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnesiteDuzinuStranice.gridx = 1;
		gbc_lblUnesiteDuzinuStranice.gridy = 3;
		pnlGlavni.add(lblUnesiteDuzinuStranice, gbc_lblUnesiteDuzinuStranice);
		
		txtDuzinaStranice = new JTextField();
		GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
		gbc_txtDuzinaStranice.anchor = GridBagConstraints.NORTH;
		gbc_txtDuzinaStranice.insets = new Insets(0, 0, 5, 0);
		gbc_txtDuzinaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDuzinaStranice.gridx = 4;
		gbc_txtDuzinaStranice.gridy = 3;
		pnlGlavni.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
		txtDuzinaStranice.setColumns(10);
		
		JLabel lblOdaberiteBojuStranice = new JLabel("Odaberite boju stranice:");
		GridBagConstraints gbc_lblOdaberiteBojuStranice = new GridBagConstraints();
		gbc_lblOdaberiteBojuStranice.insets = new Insets(0, 0, 5, 5);
		gbc_lblOdaberiteBojuStranice.gridx = 1;
		gbc_lblOdaberiteBojuStranice.gridy = 4;
		pnlGlavni.add(lblOdaberiteBojuStranice, gbc_lblOdaberiteBojuStranice);
		
		btnBojaStranice = new JButton("");
		btnBojaStranice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser biracBoje= new JColorChooser();
				Color izborBoje = biracBoje.showDialog(null,"Izaberite boju stranice",Color.BLACK);
				btnBojaStranice.setBackground(izborBoje);
			}
		});
		GridBagConstraints gbc_btnBojaStranice = new GridBagConstraints();
		gbc_btnBojaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBojaStranice.insets = new Insets(0, 0, 5, 0);
		gbc_btnBojaStranice.gridx = 4;
		gbc_btnBojaStranice.gridy = 4;
		pnlGlavni.add(btnBojaStranice, gbc_btnBojaStranice);
		
		JLabel lblOdaberiteBojuUnutrasnjosti = new JLabel("Odaberite boju unutrasnjosti:");
		GridBagConstraints gbc_lblOdaberiteBojuUnutrasnjosti = new GridBagConstraints();
		gbc_lblOdaberiteBojuUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_lblOdaberiteBojuUnutrasnjosti.gridx = 1;
		gbc_lblOdaberiteBojuUnutrasnjosti.gridy = 5;
		pnlGlavni.add(lblOdaberiteBojuUnutrasnjosti, gbc_lblOdaberiteBojuUnutrasnjosti);
		
		btnBojaUnutrasnjosti = new JButton("");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser biracBoje= new JColorChooser();
				Color izborBoje = biracBoje.showDialog(null,"Izaberite boju unutrasnjosti",Color.BLACK);
				btnBojaUnutrasnjosti.setBackground(izborBoje);
			}
		});
		GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
		gbc_btnBojaUnutrasnjosti.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBojaUnutrasnjosti.anchor = GridBagConstraints.NORTH;
		gbc_btnBojaUnutrasnjosti.gridx = 4;
		gbc_btnBojaUnutrasnjosti.gridy = 5;
		pnlGlavni.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
	}
}