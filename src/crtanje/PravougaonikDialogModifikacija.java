package crtanje;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import oblici.Pravougaonik;
import oblici.Tacka;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PravougaonikDialogModifikacija extends JDialog {
	public int xGoreLevo, yGoreLevo, visina, sirina;
	Pravougaonik p1;
	public JTextField txtXGoreLevo;
	public JTextField txtYGoreLevo;
	public JTextField txtVisina;
	public JTextField txtSirina;
	public JButton btnBojaStranice;
	public JButton btnBojaUnutrasnjosti;

	public Pravougaonik getP1() {
		return p1;
	}
	
	public JButton getBtnBojaStranice() {
		return btnBojaStranice;
	}

	public JButton getBtnBojaUnutrasnjosti() {
		return btnBojaUnutrasnjosti;
	}
	
	public JTextField getTxtXGoreLevo() {
		return txtXGoreLevo;
	}

	public JTextField getTxtYGoreLevo() {
		return txtYGoreLevo;
	}

	public JTextField getTxtSirina() {
		return txtSirina;
	}

	public JTextField getTxtVisina() {
		return txtVisina;
	}

	public PravougaonikDialogModifikacija() {
		setTitle("Modifikacija pravougaonika");
		setResizable(false);
		setModal(true);
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					xGoreLevo = Integer.parseInt(txtXGoreLevo.getText());
					yGoreLevo = Integer.parseInt(txtYGoreLevo.getText());
					visina = Integer.parseInt(txtVisina.getText());
					sirina = Integer.parseInt(txtSirina.getText());

					if (xGoreLevo <= 0 || yGoreLevo <= 0 || visina <= 0 || sirina <= 0) {
						JOptionPane.showMessageDialog(null, "Gre�ka, brojevi moraju biti pozitivni!");
					} else {
						p1 = new Pravougaonik(new Tacka(xGoreLevo, yGoreLevo), visina, sirina,
								btnBojaStranice.getBackground(), btnBojaUnutrasnjosti.getBackground());
						setVisible(false);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Gre�ka, nije unet broj!");
				}
			}
		});
		pnlKomande.add(btnPotvrdi);
		
		JPanel pnlGlavni = new JPanel();
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlGlavni.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlGlavni.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		
		JLabel lblXKoordinataTackeGoreLevo = new JLabel("X koordinata ta\u010Dke gore levo:");
		GridBagConstraints gbc_lblXKoordinataTackeGoreLevo = new GridBagConstraints();
		gbc_lblXKoordinataTackeGoreLevo.anchor = GridBagConstraints.EAST;
		gbc_lblXKoordinataTackeGoreLevo.insets = new Insets(0, 0, 5, 5);
		gbc_lblXKoordinataTackeGoreLevo.gridx = 2;
		gbc_lblXKoordinataTackeGoreLevo.gridy = 1;
		pnlGlavni.add(lblXKoordinataTackeGoreLevo, gbc_lblXKoordinataTackeGoreLevo);
		
		txtXGoreLevo = new JTextField();
		GridBagConstraints gbc_txtXGoreLevo = new GridBagConstraints();
		gbc_txtXGoreLevo.insets = new Insets(0, 0, 5, 0);
		gbc_txtXGoreLevo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXGoreLevo.gridx = 3;
		gbc_txtXGoreLevo.gridy = 1;
		pnlGlavni.add(txtXGoreLevo, gbc_txtXGoreLevo);
		txtXGoreLevo.setColumns(10);
		
		JLabel lblYKoordinataTackeGoreLevo = new JLabel("Y koordinata ta\u010Dke gore levo:");
		GridBagConstraints gbc_lblYKoordinataTackeGoreLevo = new GridBagConstraints();
		gbc_lblYKoordinataTackeGoreLevo.anchor = GridBagConstraints.EAST;
		gbc_lblYKoordinataTackeGoreLevo.insets = new Insets(0, 0, 5, 5);
		gbc_lblYKoordinataTackeGoreLevo.gridx = 2;
		gbc_lblYKoordinataTackeGoreLevo.gridy = 2;
		pnlGlavni.add(lblYKoordinataTackeGoreLevo, gbc_lblYKoordinataTackeGoreLevo);
		
		txtYGoreLevo = new JTextField();
		GridBagConstraints gbc_txtYGoreLevo = new GridBagConstraints();
		gbc_txtYGoreLevo.insets = new Insets(0, 0, 5, 0);
		gbc_txtYGoreLevo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYGoreLevo.gridx = 3;
		gbc_txtYGoreLevo.gridy = 2;
		pnlGlavni.add(txtYGoreLevo, gbc_txtYGoreLevo);
		txtYGoreLevo.setColumns(10);
		
		JLabel lblVisina = new JLabel("Visina:");
		GridBagConstraints gbc_lblVisina = new GridBagConstraints();
		gbc_lblVisina.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblVisina.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisina.gridx = 2;
		gbc_lblVisina.gridy = 3;
		pnlGlavni.add(lblVisina, gbc_lblVisina);
		
		txtVisina = new JTextField();
		GridBagConstraints gbc_txtVisina = new GridBagConstraints();
		gbc_txtVisina.insets = new Insets(0, 0, 5, 0);
		gbc_txtVisina.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVisina.gridx = 3;
		gbc_txtVisina.gridy = 3;
		pnlGlavni.add(txtVisina, gbc_txtVisina);
		txtVisina.setColumns(10);
		
		JLabel lblSirina = new JLabel("\u0160irina:");
		GridBagConstraints gbc_lblSirina = new GridBagConstraints();
		gbc_lblSirina.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSirina.insets = new Insets(0, 0, 5, 5);
		gbc_lblSirina.gridx = 2;
		gbc_lblSirina.gridy = 4;
		pnlGlavni.add(lblSirina, gbc_lblSirina);
		
		txtSirina = new JTextField();
		GridBagConstraints gbc_txtSirina = new GridBagConstraints();
		gbc_txtSirina.insets = new Insets(0, 0, 5, 0);
		gbc_txtSirina.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSirina.gridx = 3;
		gbc_txtSirina.gridy = 4;
		pnlGlavni.add(txtSirina, gbc_txtSirina);
		txtSirina.setColumns(10);
		
		JLabel lblBojaStranice = new JLabel("Boja stranice:");
		GridBagConstraints gbc_lblBojaStranice = new GridBagConstraints();
		gbc_lblBojaStranice.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBojaStranice.gridx = 2;
		gbc_lblBojaStranice.gridy = 5;
		pnlGlavni.add(lblBojaStranice, gbc_lblBojaStranice);
		
		btnBojaStranice = new JButton("");
		btnBojaStranice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		JColorChooser biracBoje = new JColorChooser();
				Color izborBoje =biracBoje.showDialog(null, "Izaberite boju za unutrasnjost", Color.BLACK);
				btnBojaStranice.setBackground(izborBoje);
			}
		});
		GridBagConstraints gbc_btnBojaStranice = new GridBagConstraints();
		gbc_btnBojaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBojaStranice.insets = new Insets(0, 0, 5, 0);
		gbc_btnBojaStranice.gridx = 3;
		gbc_btnBojaStranice.gridy = 5;
		pnlGlavni.add(btnBojaStranice, gbc_btnBojaStranice);
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutra\u0161njosti:");
		GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
		gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaUnutrasnjosti.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBojaUnutrasnjosti.gridx = 2;
		gbc_lblBojaUnutrasnjosti.gridy = 6;
		pnlGlavni.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		
		btnBojaUnutrasnjosti = new JButton("");
		btnBojaUnutrasnjosti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		JColorChooser biracBoje = new JColorChooser();
				Color izborBoje =biracBoje.showDialog(null, "Izaberite boju za unutrasnjost", Color.BLACK);
				btnBojaUnutrasnjosti.setBackground(izborBoje);
			}
		});
		GridBagConstraints gbc_btnBojaUnutrasnjosti = new GridBagConstraints();
		gbc_btnBojaUnutrasnjosti.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBojaUnutrasnjosti.gridx = 3;
		gbc_btnBojaUnutrasnjosti.gridy = 6;
		pnlGlavni.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
	}

}
