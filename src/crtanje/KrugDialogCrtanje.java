package crtanje;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KrugDialogCrtanje extends JDialog {
	public int poluprecnik;
	private JTextField txtPoluprecnik;
	
	public KrugDialogCrtanje() {
		setResizable(false);
		setModal(true);
		setTitle("Crtanje kruga");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);
		
		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					poluprecnik = Integer.parseInt(txtPoluprecnik.getText());
					System.out.println(poluprecnik);
					if (poluprecnik <= 0) {
						JOptionPane.showMessageDialog(null,"Poluprecnik ne može da bude negativan!");
					} else {
						setVisible(false);
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,"Greška u unosu, nije unet broj!");
				}
			}
		});
		pnlKomande.add(btnPotvrdi);
		
		JPanel pnlGlavni = new JPanel();
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		
		JLabel lblPoluprecnik = new JLabel("Polupre\u010Dnik:");
		pnlGlavni.add(lblPoluprecnik);
		
		txtPoluprecnik = new JTextField();
		pnlGlavni.add(txtPoluprecnik);
		txtPoluprecnik.setColumns(10);
	}
	
	public int getPoluprecnik() {
		return poluprecnik;
	}
}
