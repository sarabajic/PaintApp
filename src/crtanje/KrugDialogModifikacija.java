package crtanje;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import oblici.Krug;
import oblici.Tacka;

public class KrugDialogModifikacija  extends JDialog {
	Crtanje crt = new Crtanje();
	public JButton btnBojaStranice;
	public JButton btnBojaUnutrasnjosti;
	public int xCentar, yCentar, poluprecnik;
	Krug kr1;
	private JTextField txtXCentar;
	private JTextField txtYCentar;
	private JTextField txtPoluprecnik;
	
	public JTextField getTxtXCentar() {
		return txtXCentar;
	}

	public JTextField getTxtYCentar() {
		return txtYCentar;
	}

	public JTextField getTxtPoluprecnik() {
		return txtPoluprecnik;
	}

	public JButton getBtnBojaStranice() {
		return btnBojaStranice;
	}

	public JButton getBtnBojaUnutrasnjosti() {
		return btnBojaUnutrasnjosti;
	}

	public KrugDialogModifikacija() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Modifikacija kruga");
		setResizable(false);
		setModal(true);
		System.out.println();
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					xCentar = Integer.parseInt(txtXCentar.getText());
					yCentar = Integer.parseInt(txtYCentar.getText());
					poluprecnik = Integer.parseInt(txtPoluprecnik.getText());

					if (xCentar <= 0 || yCentar <= 0 || poluprecnik <= 0) {
						JOptionPane.showMessageDialog(null, "Greška, brojevi moraju biti pozitivni!");
					} else {
						kr1 = new Krug(new Tacka(xCentar, yCentar), poluprecnik,
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
		gbl_pnlGlavni.columnWidths = new int[]{102, 118, 116, 0};
		gbl_pnlGlavni.rowHeights = new int[]{22, 0, 0, 0, 0, 0, 0};
		gbl_pnlGlavni.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		
		JLabel lblXCentar = new JLabel("X Koordinata centra:");
		GridBagConstraints gbc_lblXCentar = new GridBagConstraints();
		gbc_lblXCentar.anchor = GridBagConstraints.WEST;
		gbc_lblXCentar.insets = new Insets(0, 0, 5, 5);
		gbc_lblXCentar.gridx = 1;
		gbc_lblXCentar.gridy = 1;
		pnlGlavni.add(lblXCentar, gbc_lblXCentar);
		
		txtXCentar = new JTextField();
		txtXCentar.setPreferredSize(new Dimension(100, 22));
		txtXCentar.setMinimumSize(new Dimension(100, 22));
		GridBagConstraints gbc_txtXCentar = new GridBagConstraints();
		gbc_txtXCentar.fill = GridBagConstraints.BOTH;
		gbc_txtXCentar.insets = new Insets(0, 0, 5, 0);
		gbc_txtXCentar.gridx = 2;
		gbc_txtXCentar.gridy = 1;
		pnlGlavni.add(txtXCentar, gbc_txtXCentar);
		txtXCentar.setColumns(10);
		
		JLabel lblYCentra = new JLabel("Y Koordinata centra:");
		GridBagConstraints gbc_lblYCentra = new GridBagConstraints();
		gbc_lblYCentra.anchor = GridBagConstraints.EAST;
		gbc_lblYCentra.insets = new Insets(0, 0, 5, 5);
		gbc_lblYCentra.gridx = 1;
		gbc_lblYCentra.gridy = 2;
		pnlGlavni.add(lblYCentra, gbc_lblYCentra);
		
		txtYCentar = new JTextField();
		txtYCentar.setMinimumSize(new Dimension(100, 22));
		txtYCentar.setPreferredSize(new Dimension(100, 22));
		GridBagConstraints gbc_txtYCentar = new GridBagConstraints();
		gbc_txtYCentar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYCentar.insets = new Insets(0, 0, 5, 0);
		gbc_txtYCentar.gridx = 2;
		gbc_txtYCentar.gridy = 2;
		pnlGlavni.add(txtYCentar, gbc_txtYCentar);
		txtYCentar.setColumns(10);
		
		JLabel lblPoluprecnik = new JLabel("Polupre\u010Dnik:");
		GridBagConstraints gbc_lblPoluprecnik = new GridBagConstraints();
		gbc_lblPoluprecnik.anchor = GridBagConstraints.EAST;
		gbc_lblPoluprecnik.insets = new Insets(0, 0, 5, 5);
		gbc_lblPoluprecnik.gridx = 1;
		gbc_lblPoluprecnik.gridy = 3;
		pnlGlavni.add(lblPoluprecnik, gbc_lblPoluprecnik);
		
		txtPoluprecnik = new JTextField();
		txtPoluprecnik.setPreferredSize(new Dimension(100, 22));
		txtPoluprecnik.setMinimumSize(new Dimension(100, 22));
		GridBagConstraints gbc_txtPoluprecnik = new GridBagConstraints();
		gbc_txtPoluprecnik.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPoluprecnik.insets = new Insets(0, 0, 5, 0);
		gbc_txtPoluprecnik.gridx = 2;
		gbc_txtPoluprecnik.gridy = 3;
		pnlGlavni.add(txtPoluprecnik, gbc_txtPoluprecnik);
		txtPoluprecnik.setColumns(10);
		
		JLabel lblBojaStranice = new JLabel("Boja stranice:");
		GridBagConstraints gbc_lblBojaStranice = new GridBagConstraints();
		gbc_lblBojaStranice.anchor = GridBagConstraints.EAST;
		gbc_lblBojaStranice.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaStranice.gridx = 1;
		gbc_lblBojaStranice.gridy = 4;
		pnlGlavni.add(lblBojaStranice, gbc_lblBojaStranice);
		
		btnBojaStranice = new JButton("");
		btnBojaStranice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		JColorChooser biracBoje = new JColorChooser();
				Color izborBoje =biracBoje.showDialog(null, "Izaberite boju za unutrasnjost", Color.BLACK);
				btnBojaUnutrasnjosti.setBackground(izborBoje);
			}
		});
		GridBagConstraints gbc_btnBojaStranice = new GridBagConstraints();
		gbc_btnBojaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBojaStranice.insets = new Insets(0, 0, 5, 0);
		gbc_btnBojaStranice.gridx = 2;
		gbc_btnBojaStranice.gridy = 4;
		pnlGlavni.add(btnBojaStranice, gbc_btnBojaStranice);
		
		JLabel lblBojaUnutranjosti = new JLabel("Boja unutra\u0161njosti:");
		GridBagConstraints gbc_lblBojaUnutranjosti = new GridBagConstraints();
		gbc_lblBojaUnutranjosti.anchor = GridBagConstraints.EAST;
		gbc_lblBojaUnutranjosti.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaUnutranjosti.gridx = 1;
		gbc_lblBojaUnutranjosti.gridy = 5;
		pnlGlavni.add(lblBojaUnutranjosti, gbc_lblBojaUnutranjosti);
		
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
		gbc_btnBojaUnutrasnjosti.gridx = 2;
		gbc_btnBojaUnutrasnjosti.gridy = 5;
		pnlGlavni.add(btnBojaUnutrasnjosti, gbc_btnBojaUnutrasnjosti);
	}
	
	public Krug getKr1() {
		return kr1;
	}
}
