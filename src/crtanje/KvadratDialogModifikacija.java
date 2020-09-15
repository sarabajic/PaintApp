package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oblici.Kvadrat;
import oblici.Tacka;

public class KvadratDialogModifikacija  extends JDialog {
	public int xGoreLevo, yGoreLevo, duzinaStranice;
	Kvadrat k1;
	public JTextField txtXGoreLevo;
	public JTextField txtYGoreLevo;
	public JTextField txtDuzinaStranice;
	public JButton btnBojaStranice;
	public JButton btnBojaUnutrasnjosti;

	public Kvadrat getK1() {
		return k1;
	}
	
	public JButton getBtnBojaUnutrasnjosti() {
		return btnBojaUnutrasnjosti;
	}

	public JButton getBtnBojaStranice() {
		return btnBojaStranice;
	}

	public JTextField getTxtDuzinaStranice() {
		return txtDuzinaStranice;
	}

	public JTextField getTxtYGoreLevo() {
		return txtYGoreLevo;
	}

	public JTextField getTxtXGoreLevo() {
		return txtXGoreLevo;
	}

	public KvadratDialogModifikacija() {
		setResizable(false);
		setModal(true);
		setTitle("Modifikacija kvadrata");
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					xGoreLevo = Integer.parseInt(txtXGoreLevo.getText());
					yGoreLevo = Integer.parseInt(txtYGoreLevo.getText());
					duzinaStranice = Integer.parseInt(txtDuzinaStranice.getText());

					if (xGoreLevo <= 0 || yGoreLevo <= 0 || duzinaStranice <= 0) {
						JOptionPane.showMessageDialog(null, "Greška, brojevi moraju biti pozitivni!");
					} else {
						k1 = new Kvadrat(new Tacka(xGoreLevo, yGoreLevo), duzinaStranice,
								btnBojaStranice.getBackground(), btnBojaUnutrasnjosti.getBackground());
						setVisible(false);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Greška, nije unet broj!");
				}
			}
		});
		pnlKomande.add(btnPotvrdi);
		
		JPanel pnlGlavni = new JPanel();
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_pnlGlavni.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlGlavni.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		
		JLabel lblXKoordinataGoreLevo = new JLabel("X koordinata gore levo:");
		GridBagConstraints gbc_lblXKoordinataGoreLevo = new GridBagConstraints();
		gbc_lblXKoordinataGoreLevo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblXKoordinataGoreLevo.insets = new Insets(0, 0, 5, 5);
		gbc_lblXKoordinataGoreLevo.gridx = 3;
		gbc_lblXKoordinataGoreLevo.gridy = 1;
		pnlGlavni.add(lblXKoordinataGoreLevo, gbc_lblXKoordinataGoreLevo);
		
		txtXGoreLevo = new JTextField();
		GridBagConstraints gbc_txtXGoreLevo = new GridBagConstraints();
		gbc_txtXGoreLevo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXGoreLevo.insets = new Insets(0, 0, 5, 0);
		gbc_txtXGoreLevo.gridx = 4;
		gbc_txtXGoreLevo.gridy = 1;
		pnlGlavni.add(txtXGoreLevo, gbc_txtXGoreLevo);
		txtXGoreLevo.setColumns(10);
		
		JLabel lblYKoordinataGoreLevo = new JLabel("Y koordinata gore levo:");
		GridBagConstraints gbc_lblYKoordinataGoreLevo = new GridBagConstraints();
		gbc_lblYKoordinataGoreLevo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblYKoordinataGoreLevo.insets = new Insets(0, 0, 5, 5);
		gbc_lblYKoordinataGoreLevo.gridx = 3;
		gbc_lblYKoordinataGoreLevo.gridy = 2;
		pnlGlavni.add(lblYKoordinataGoreLevo, gbc_lblYKoordinataGoreLevo);
		
		txtYGoreLevo = new JTextField();
		GridBagConstraints gbc_txtYGoreLevo = new GridBagConstraints();
		gbc_txtYGoreLevo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYGoreLevo.insets = new Insets(0, 0, 5, 0);
		gbc_txtYGoreLevo.gridx = 4;
		gbc_txtYGoreLevo.gridy = 2;
		pnlGlavni.add(txtYGoreLevo, gbc_txtYGoreLevo);
		txtYGoreLevo.setColumns(10);
		
		JLabel lblDuzinaStranice = new JLabel("Du\u017Eina stranice:");
		GridBagConstraints gbc_lblDuzinaStranice = new GridBagConstraints();
		gbc_lblDuzinaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDuzinaStranice.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuzinaStranice.gridx = 3;
		gbc_lblDuzinaStranice.gridy = 3;
		pnlGlavni.add(lblDuzinaStranice, gbc_lblDuzinaStranice);
		
		txtDuzinaStranice = new JTextField();
		GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
		gbc_txtDuzinaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDuzinaStranice.insets = new Insets(0, 0, 5, 0);
		gbc_txtDuzinaStranice.gridx = 4;
		gbc_txtDuzinaStranice.gridy = 3;
		pnlGlavni.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
		txtDuzinaStranice.setColumns(10);
		
		JLabel lblBojaStranice = new JLabel("Boja stranice:");
		GridBagConstraints gbc_lblBojaStranice = new GridBagConstraints();
		gbc_lblBojaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBojaStranice.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaStranice.gridx = 3;
		gbc_lblBojaStranice.gridy = 4;
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
		gbc_btnBojaStranice.gridx = 4;
		gbc_btnBojaStranice.gridy = 4;
		pnlGlavni.add(btnBojaStranice, gbc_btnBojaStranice);
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutra\u0161njosti:");
		GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
		gbc_lblBojaUnutrasnjosti.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaUnutrasnjosti.gridx = 3;
		gbc_lblBojaUnutrasnjosti.gridy = 5;
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
		gbc_btnBojaUnutrasnjosti.gridx = 4;
		gbc_btnBojaUnutrasnjosti.gridy = 5;
		pnlGlavni.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
	}
}
