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

import oblici.Tacka;

public class TackaDialogModifikacija extends JDialog {
	public int xTacke, yTacke;
	public Tacka t1;
	public JTextField txtXKoordinata;
	public JTextField txtYKoordinata;
	public JButton btnBoja;

	public Tacka getT1() {
		return t1;
	}
	
	public JTextField getTxtX() {
		return txtXKoordinata;
	}

	public JTextField getTxtY() {
		return txtYKoordinata;
	}

	public JButton getBtnBoja() {
		return btnBoja;
	}

	public void setTxtXKoordinata(JTextField txtXKoordinata) {
		this.txtXKoordinata = txtXKoordinata;
	}

	public void setTxtY(JTextField txtYKoordinata) {
		this.txtYKoordinata = txtYKoordinata;
	}

	public void setBtnBoja(JButton btnBoja) {
		this.btnBoja = btnBoja;
	}

	public TackaDialogModifikacija() {
		setTitle("Modifikacija ta\u010Dke");
		setModal(true);
		setResizable(false);
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					xTacke = Integer.parseInt(txtXKoordinata.getText());
					yTacke = Integer.parseInt(txtYKoordinata.getText());
					if (xTacke <= 0 || yTacke <= 0) {
						JOptionPane.showMessageDialog(null, "Koordinate moraju biti pozitivne!");
					} else {
						t1 = new Tacka(xTacke, yTacke, btnBoja.getBackground());
						setVisible(false);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Greška pri unosu, nije unet broj!");
				}
			}
		});
		pnlKomande.add(btnPotvrdi);
		
		JPanel pnlGlavni = new JPanel();
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlGlavni.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlGlavni.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		
		JLabel lblXKoordinata = new JLabel("X koordinata:");
		GridBagConstraints gbc_lblXKoordinata = new GridBagConstraints();
		gbc_lblXKoordinata.anchor = GridBagConstraints.EAST;
		gbc_lblXKoordinata.insets = new Insets(0, 0, 5, 5);
		gbc_lblXKoordinata.gridx = 2;
		gbc_lblXKoordinata.gridy = 1;
		pnlGlavni.add(lblXKoordinata, gbc_lblXKoordinata);
		
		txtXKoordinata = new JTextField();
		GridBagConstraints gbc_txtXKoordinata = new GridBagConstraints();
		gbc_txtXKoordinata.anchor = GridBagConstraints.NORTH;
		gbc_txtXKoordinata.insets = new Insets(0, 0, 5, 0);
		gbc_txtXKoordinata.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXKoordinata.gridx = 3;
		gbc_txtXKoordinata.gridy = 1;
		pnlGlavni.add(txtXKoordinata, gbc_txtXKoordinata);
		txtXKoordinata.setColumns(10);
		
		JLabel lblYKoordinata = new JLabel("Y koordinata:");
		GridBagConstraints gbc_lblYKoordinata = new GridBagConstraints();
		gbc_lblYKoordinata.anchor = GridBagConstraints.EAST;
		gbc_lblYKoordinata.insets = new Insets(0, 0, 5, 5);
		gbc_lblYKoordinata.gridx = 2;
		gbc_lblYKoordinata.gridy = 2;
		pnlGlavni.add(lblYKoordinata, gbc_lblYKoordinata);
		
		txtYKoordinata = new JTextField();
		GridBagConstraints gbc_txtYKoordinata = new GridBagConstraints();
		gbc_txtYKoordinata.insets = new Insets(0, 0, 5, 0);
		gbc_txtYKoordinata.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYKoordinata.gridx = 3;
		gbc_txtYKoordinata.gridy = 2;
		pnlGlavni.add(txtYKoordinata, gbc_txtYKoordinata);
		txtYKoordinata.setColumns(10);
		
		JLabel lblBojaStranice = new JLabel("Boja stranice:");
		GridBagConstraints gbc_lblBojaStranice = new GridBagConstraints();
		gbc_lblBojaStranice.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBojaStranice.gridx = 2;
		gbc_lblBojaStranice.gridy = 3;
		pnlGlavni.add(lblBojaStranice, gbc_lblBojaStranice);
		
		btnBoja = new JButton("");
		btnBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		JColorChooser biracBoje = new JColorChooser();
				Color izborBoje =biracBoje.showDialog(null, "Izaberite boju za unutrasnjost", Color.BLACK);
				btnBoja.setBackground(izborBoje);
			}
		});
		GridBagConstraints gbc_btnBoja = new GridBagConstraints();
		gbc_btnBoja.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBoja.gridx = 3;
		gbc_btnBoja.gridy = 3;
		pnlGlavni.add(btnBoja, gbc_btnBoja);
	}
}
