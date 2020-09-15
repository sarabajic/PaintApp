package stek;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import oblici.Kvadrat;

public class Stek extends JFrame{
	DefaultListModel<String> dlm = new DefaultListModel<String>();
	Stack <Kvadrat> stekKvadrata = new Stack<Kvadrat>();
	Kvadrat kv = new Kvadrat();
	
	JPanel panel = new JPanel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stek frmStek = new Stek();
					frmStek.setSize(700,500);
					frmStek.setVisible(true);
					frmStek.setLocationRelativeTo(null);
				} catch (Exception frmStek) {
					frmStek.printStackTrace();
				}
			}
		});
	}
	
	public Stek() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sara Bajic IT75-2016");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlGlavni = new JPanel();
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[]{222, 1, 0};
		gbl_pnlGlavni.rowHeights = new int[]{1, 0};
		gbl_pnlGlavni.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.NORTH);
		
		JButton btnDodajNaStek = new JButton("Dodavanje kvadrata na stek");
		btnDodajNaStek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StekDijalog dg = new StekDijalog();
				dg.setLocationRelativeTo(null);
				dg.setSize(450, 310);
				dg.setVisible(true);
				Kvadrat kv = dg.getKv();
			
				if(kv != null)
				{
					dlm.add(0, kv.toString());
				}
			}
		});
		pnlKomande.add(btnDodajNaStek);
		
		JList listaKvadrata = new JList();
		GridBagConstraints gbc_listaKvadrata = new GridBagConstraints();
		gbc_listaKvadrata.insets = new Insets(0, 0, 0, 5);
		gbc_listaKvadrata.fill = GridBagConstraints.BOTH;
		gbc_listaKvadrata.gridx = 0;
		gbc_listaKvadrata.gridy = 0;
		pnlGlavni.add(listaKvadrata, gbc_listaKvadrata);
		listaKvadrata.setModel(dlm);
		
		JButton btnObrisiSaSteka = new JButton("Obri\u0161i kvadrat sa steka");
		btnObrisiSaSteka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listaKvadrata.getModel().getSize()  == 0)
				{
					JOptionPane.showMessageDialog(null, "Stek je prazan!");	
				}
				else 
				{
					dlm.removeElementAt(0);
				}
			}
		});
		pnlKomande.add(btnObrisiSaSteka);
	}


}
