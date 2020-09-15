package crtanje;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrougaoDialogCrtanje extends JDialog {
	private JTextField txtDuzinaStranice;
	public int duzinaStranice;

	public TrougaoDialogCrtanje() {
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Crtanje trougla");

		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					duzinaStranice = Integer.parseInt(txtDuzinaStranice.getText());
					if (duzinaStranice <= 0) {
						JOptionPane.showMessageDialog(null, "Duzina stranice mora biti pozitivna!");
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
		gbl_pnlGlavni.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlGlavni.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnlGlavni.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlGlavni.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		pnlGlavni.setLayout(gbl_pnlGlavni);

		JLabel lblUnesiteDuzinuStranice = new JLabel("Unesite du\u017Einu stranice:");
		GridBagConstraints gbc_lblUnesiteDuzinuStranice = new GridBagConstraints();
		gbc_lblUnesiteDuzinuStranice.insets = new Insets(0, 0, 0, 5);
		gbc_lblUnesiteDuzinuStranice.anchor = GridBagConstraints.EAST;
		gbc_lblUnesiteDuzinuStranice.gridx = 2;
		gbc_lblUnesiteDuzinuStranice.gridy = 1;
		pnlGlavni.add(lblUnesiteDuzinuStranice, gbc_lblUnesiteDuzinuStranice);

		txtDuzinaStranice = new JTextField();
		GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
		gbc_txtDuzinaStranice.fill = GridBagConstraints.BOTH;
		gbc_txtDuzinaStranice.gridx = 3;
		gbc_txtDuzinaStranice.gridy = 1;
		pnlGlavni.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
		txtDuzinaStranice.setColumns(10);
	}

	public int getDuzinaStranice() {
		return duzinaStranice;
	}
}
