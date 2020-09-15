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

public class KvadratDialogCrtanje extends JDialog  {
	public int duzinaStranice;
	private JTextField txtDuzinaStranice;

	public KvadratDialogCrtanje() {
		setTitle("Crtanje kvadrata");
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					duzinaStranice = Integer.parseInt(txtDuzinaStranice.getText());
					if (duzinaStranice <= 0) {
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
		gbl_pnlGlavni.columnWidths = new int[]{115, 92, 116, 0, 0};
		gbl_pnlGlavni.rowHeights = new int[]{22, 0, 0};
		gbl_pnlGlavni.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		
		JLabel lblDuzinaStranice = new JLabel("Du\u017Eina stranice:");
		GridBagConstraints gbc_lblDuzinaStranice = new GridBagConstraints();
		gbc_lblDuzinaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblDuzinaStranice.insets = new Insets(0, 0, 0, 5);
		gbc_lblDuzinaStranice.gridx = 1;
		gbc_lblDuzinaStranice.gridy = 1;
		pnlGlavni.add(lblDuzinaStranice, gbc_lblDuzinaStranice);
		
		txtDuzinaStranice = new JTextField();
		GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
		gbc_txtDuzinaStranice.insets = new Insets(0, 0, 0, 5);
		gbc_txtDuzinaStranice.fill = GridBagConstraints.BOTH;
		gbc_txtDuzinaStranice.gridx = 2;
		gbc_txtDuzinaStranice.gridy = 1;
		pnlGlavni.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
		txtDuzinaStranice.setColumns(10);
	}

	public int getDuzinaStranice() {
		return duzinaStranice;
	}
}
