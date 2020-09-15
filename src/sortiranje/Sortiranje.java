package sortiranje;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import oblici.Kvadrat;
import stek.StekDijalog;

public class Sortiranje extends JFrame {
DefaultListModel<String> dlm = new DefaultListModel<String>();
	
	public Sortiranje() {
		
		ArrayList<Kvadrat> lista = new ArrayList<Kvadrat>();
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.NORTH);
		JButton btnDodaj = new JButton("Dodaj na stek");
		pnlKomande.add(btnDodaj);
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StekDijalog dg = new StekDijalog();
				dg.setLocationRelativeTo(null); //locira ga na sredinu da se ne pomera
				dg.setSize(450, 310);
				dg.setVisible(true);
				Kvadrat kv = dg.getKv();
			
				if(kv != null)
				{
					dlm.add(0, kv.toString());
				}
				
				lista.add(dg.getKv());
				Collections.sort(lista);
			}
		});
		
		JButton btnSortiraj = new JButton("Sortiraj");
		pnlKomande.add(btnSortiraj);
		
		JPanel pnlGlavni = new JPanel();
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[]{0, 0};
		gbl_pnlGlavni.rowHeights = new int[]{0, 0};
		gbl_pnlGlavni.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		
		JList listaKvadrata = new JList();
		GridBagConstraints gbc_listaKvadrata = new GridBagConstraints();
		gbc_listaKvadrata.fill = GridBagConstraints.BOTH;
		gbc_listaKvadrata.gridx = 0;
		gbc_listaKvadrata.gridy = 0;
		pnlGlavni.add(listaKvadrata, gbc_listaKvadrata);
		listaKvadrata.setModel(dlm);
		
		btnSortiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.removeAllElements();
				for(Kvadrat kv : lista)
				{
					dlm.addElement(kv.toString());
				}
			}
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sortiranje frameSort = new Sortiranje();
					frameSort.setSize(600, 300);
					frameSort.setLocationRelativeTo(null);
					frameSort.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
