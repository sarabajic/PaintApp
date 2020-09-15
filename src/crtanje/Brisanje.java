package crtanje;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Brisanje extends JDialog {
	public int flag = 0;

	public int getFlag() {
		return flag;
	}

	public Brisanje() {
		setTitle("Brisanje");
		setResizable(false);
		setModal(true);

		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);

		JButton btnDa = new JButton("DA");
		btnDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flag = 1;
	 	 		setVisible(false);
			}
		});
		pnlKomande.add(btnDa);

		JButton btnNe = new JButton("NE");
		btnNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag = 2;
				setVisible(false);
			}
		});
		pnlKomande.add(btnNe);

		JPanel pnlGlavni = new JPanel();
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);

		JLabel lbleliteLiDa = new JLabel("\u017Delite li da obri\u0161ete ovaj element?");
		pnlGlavni.add(lbleliteLiDa);
	}
}
