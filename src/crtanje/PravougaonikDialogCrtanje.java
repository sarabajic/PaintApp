package crtanje;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PravougaonikDialogCrtanje extends JDialog {
	public int visina, sirina;
	private JTextField txtVisina;
	private JTextField txtSirina;

	public PravougaonikDialogCrtanje() {
		setModal(true);
		setResizable(false);
		setTitle("Crtanje pravougaonika");
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					visina = Integer.parseInt(txtVisina.getText());
					sirina = Integer.parseInt(txtSirina.getText());
					if (visina <= 0 || sirina <= 0) {
						JOptionPane.showMessageDialog(null, "Dužina stranice mora biti pozitivna!");
					} else {
						setVisible(false);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Mora se uneti broj!");
				}
			}
		});
		pnlKomande.add(btnPotvrdi);
		
		JPanel pnlGlavni = new JPanel();
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlGlavni.rowHeights = new int[]{0, 0, 0, 0};
		gbl_pnlGlavni.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		
		JLabel lblVisina = new JLabel("Visina:");
		GridBagConstraints gbc_lblVisina = new GridBagConstraints();
		gbc_lblVisina.anchor = GridBagConstraints.EAST;
		gbc_lblVisina.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisina.gridx = 2;
		gbc_lblVisina.gridy = 1;
		pnlGlavni.add(lblVisina, gbc_lblVisina);
		
		txtVisina = new JTextField();
		GridBagConstraints gbc_txtVisina = new GridBagConstraints();
		gbc_txtVisina.insets = new Insets(0, 0, 5, 0);
		gbc_txtVisina.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtVisina.gridx = 3;
		gbc_txtVisina.gridy = 1;
		pnlGlavni.add(txtVisina, gbc_txtVisina);
		txtVisina.setColumns(10);
		
		JLabel lblSirina = new JLabel("\u0160irina:");
		GridBagConstraints gbc_lblSirina = new GridBagConstraints();
		gbc_lblSirina.anchor = GridBagConstraints.EAST;
		gbc_lblSirina.insets = new Insets(0, 0, 0, 5);
		gbc_lblSirina.gridx = 2;
		gbc_lblSirina.gridy = 2;
		pnlGlavni.add(lblSirina, gbc_lblSirina);
		
		txtSirina = new JTextField();
		GridBagConstraints gbc_txtSirina = new GridBagConstraints();
		gbc_txtSirina.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSirina.gridx = 3;
		gbc_txtSirina.gridy = 2;
		pnlGlavni.add(txtSirina, gbc_txtSirina);
		txtSirina.setColumns(10);
	}

	public int getVisina() {
		return visina;
	}

	public int getSirina() {
		return sirina;
	}

}
