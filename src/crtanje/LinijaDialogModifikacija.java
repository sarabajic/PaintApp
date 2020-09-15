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

import oblici.Linija;
import oblici.Tacka;

public class LinijaDialogModifikacija extends JDialog {
	public int xPocetna, yPocetna, xKrajnja, yKrajnja;
	public Linija l1;
	public JTextField txtXKoordinataPocetneTacke;
	public JTextField txtYKoordinataPocetneTacke;
	public JTextField txtXKoordinataKrajnjeTacke;
	public JTextField txtYKoordinataKrajnjeTacke;
	public JButton btnBojaLinije;

	public Linija getL1() {
		return l1;
	}

	public JTextField getTxtXKoordinataPocetneTacke() {
		return txtXKoordinataPocetneTacke;
	}

	public JTextField getTxtYKoordinataPocetneTacke() {
		return txtYKoordinataPocetneTacke;
	}

	public JTextField getTxtXKoordinataKrajnjeTacke() {
		return txtXKoordinataKrajnjeTacke;
	}

	public JTextField getTxtYKoordinataKrajnjeTacke() {
		return txtYKoordinataKrajnjeTacke;
	}

	public JButton getBtnBojaLinije() {
		return btnBojaLinije;
	}

	public LinijaDialogModifikacija() {
		setTitle("Modifikacija linije");
		setModal(true);
		setResizable(false);
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				xPocetna=Integer.parseInt(txtXKoordinataPocetneTacke.getText());
				yPocetna=Integer.parseInt(txtYKoordinataPocetneTacke.getText());
				xKrajnja=Integer.parseInt(txtYKoordinataKrajnjeTacke.getText());
				yKrajnja=Integer.parseInt(txtYKoordinataKrajnjeTacke.getText());
				
				if (xPocetna<=0 || yPocetna<=0 || xKrajnja<=0 || yKrajnja<=0)
				{
					JOptionPane.showMessageDialog(null, "Greška, broj je negativan!");
				}
				else {
					l1=new Linija (new Tacka (xPocetna,yPocetna), new Tacka (xKrajnja,yKrajnja), btnBojaLinije.getBackground());
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
		gbl_pnlGlavni.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlGlavni.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlGlavni.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		
		JLabel lblXKoordinataPocetneTacke = new JLabel("X koordinata po\u010Detne ta\u010Dke:");
		GridBagConstraints gbc_lblXKoordinataPocetneTacke = new GridBagConstraints();
		gbc_lblXKoordinataPocetneTacke.anchor = GridBagConstraints.EAST;
		gbc_lblXKoordinataPocetneTacke.insets = new Insets(0, 0, 5, 5);
		gbc_lblXKoordinataPocetneTacke.gridx = 2;
		gbc_lblXKoordinataPocetneTacke.gridy = 1;
		pnlGlavni.add(lblXKoordinataPocetneTacke, gbc_lblXKoordinataPocetneTacke);
		
		txtXKoordinataPocetneTacke = new JTextField();
		GridBagConstraints gbc_txtXKoordinataPocetneTacke = new GridBagConstraints();
		gbc_txtXKoordinataPocetneTacke.insets = new Insets(0, 0, 5, 0);
		gbc_txtXKoordinataPocetneTacke.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXKoordinataPocetneTacke.gridx = 3;
		gbc_txtXKoordinataPocetneTacke.gridy = 1;
		pnlGlavni.add(txtXKoordinataPocetneTacke, gbc_txtXKoordinataPocetneTacke);
		txtXKoordinataPocetneTacke.setColumns(10);
		
		JLabel lblYKoordinataPocetneTacke = new JLabel("Y koordinata po\u010Detne ta\u010Dke:");
		GridBagConstraints gbc_lblYKoordinataPocetneTacke = new GridBagConstraints();
		gbc_lblYKoordinataPocetneTacke.anchor = GridBagConstraints.EAST;
		gbc_lblYKoordinataPocetneTacke.insets = new Insets(0, 0, 5, 5);
		gbc_lblYKoordinataPocetneTacke.gridx = 2;
		gbc_lblYKoordinataPocetneTacke.gridy = 2;
		pnlGlavni.add(lblYKoordinataPocetneTacke, gbc_lblYKoordinataPocetneTacke);
		
		txtYKoordinataPocetneTacke = new JTextField();
		GridBagConstraints gbc_txtYKoordinataPocetneTacke = new GridBagConstraints();
		gbc_txtYKoordinataPocetneTacke.insets = new Insets(0, 0, 5, 0);
		gbc_txtYKoordinataPocetneTacke.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYKoordinataPocetneTacke.gridx = 3;
		gbc_txtYKoordinataPocetneTacke.gridy = 2;
		pnlGlavni.add(txtYKoordinataPocetneTacke, gbc_txtYKoordinataPocetneTacke);
		txtYKoordinataPocetneTacke.setColumns(10);
		
		JLabel lblXKoordinataKrajnjeTacke = new JLabel("X koordinata krajnje ta\u010Dke:");
		GridBagConstraints gbc_lblXKoordinataKrajnjeTacke = new GridBagConstraints();
		gbc_lblXKoordinataKrajnjeTacke.anchor = GridBagConstraints.EAST;
		gbc_lblXKoordinataKrajnjeTacke.insets = new Insets(0, 0, 5, 5);
		gbc_lblXKoordinataKrajnjeTacke.gridx = 2;
		gbc_lblXKoordinataKrajnjeTacke.gridy = 3;
		pnlGlavni.add(lblXKoordinataKrajnjeTacke, gbc_lblXKoordinataKrajnjeTacke);
		
		txtXKoordinataKrajnjeTacke = new JTextField();
		GridBagConstraints gbc_txtXKoordinataKrajnjeTacke = new GridBagConstraints();
		gbc_txtXKoordinataKrajnjeTacke.insets = new Insets(0, 0, 5, 0);
		gbc_txtXKoordinataKrajnjeTacke.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXKoordinataKrajnjeTacke.gridx = 3;
		gbc_txtXKoordinataKrajnjeTacke.gridy = 3;
		pnlGlavni.add(txtXKoordinataKrajnjeTacke, gbc_txtXKoordinataKrajnjeTacke);
		txtXKoordinataKrajnjeTacke.setColumns(10);
		
		JLabel lblYKoordinataKrajnjeTacke = new JLabel("Y koordinata krajnje ta\u010Dke:");
		GridBagConstraints gbc_lblYKoordinataKrajnjeTacke = new GridBagConstraints();
		gbc_lblYKoordinataKrajnjeTacke.anchor = GridBagConstraints.EAST;
		gbc_lblYKoordinataKrajnjeTacke.insets = new Insets(0, 0, 5, 5);
		gbc_lblYKoordinataKrajnjeTacke.gridx = 2;
		gbc_lblYKoordinataKrajnjeTacke.gridy = 4;
		pnlGlavni.add(lblYKoordinataKrajnjeTacke, gbc_lblYKoordinataKrajnjeTacke);
		
		txtYKoordinataKrajnjeTacke = new JTextField();
		GridBagConstraints gbc_txtYKoordinataKrajnjeTacke = new GridBagConstraints();
		gbc_txtYKoordinataKrajnjeTacke.insets = new Insets(0, 0, 5, 0);
		gbc_txtYKoordinataKrajnjeTacke.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYKoordinataKrajnjeTacke.gridx = 3;
		gbc_txtYKoordinataKrajnjeTacke.gridy = 4;
		pnlGlavni.add(txtYKoordinataKrajnjeTacke, gbc_txtYKoordinataKrajnjeTacke);
		txtYKoordinataKrajnjeTacke.setColumns(10);
		
		JLabel lblBojaLinije = new JLabel("Boja linije:");
		GridBagConstraints gbc_lblBojaLinije = new GridBagConstraints();
		gbc_lblBojaLinije.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaLinije.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBojaLinije.gridx = 2;
		gbc_lblBojaLinije.gridy = 5;
		pnlGlavni.add(lblBojaLinije, gbc_lblBojaLinije);
		
		btnBojaLinije = new JButton("");
		btnBojaLinije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JColorChooser biracBoje= new JColorChooser();
				Color izborBoje = biracBoje.showDialog(null,"Izaberite boju unutrasnjosti", Color.BLACK);
				btnBojaLinije.setBackground(izborBoje);
			}
		});
		GridBagConstraints gbc_btnBojaLinije = new GridBagConstraints();
		gbc_btnBojaLinije.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBojaLinije.gridx = 3;
		gbc_btnBojaLinije.gridy = 5;
		pnlGlavni.add(btnBojaLinije, gbc_btnBojaLinije);
	}

}
