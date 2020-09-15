package stek;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import oblici.Kvadrat;
import oblici.Tacka;

public class StekDijalog extends JDialog {
	public int x;
	public int y;
	public int duzinaStranice;
	public String bojaStranice;
	public String bojaUnutrasnjosti;
	
	Kvadrat kv=null;
	private JTextField txtXKoordinateTacke;
	private JTextField txtYKoordinateTacke;
	private JTextField txtDuzinaStranice;
	
	public StekDijalog() {
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		setTitle("Luka Sari\u0107 IT40-2016");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JPanel pnlGlavni = new JPanel();
		getContentPane().add(pnlGlavni, BorderLayout.CENTER);
		GridBagLayout gbl_pnlGlavni = new GridBagLayout();
		gbl_pnlGlavni.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_pnlGlavni.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_pnlGlavni.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlGlavni.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlGlavni.setLayout(gbl_pnlGlavni);
		
		JPanel pnlKomande = new JPanel();
		getContentPane().add(pnlKomande, BorderLayout.SOUTH);
		
		JComboBox cbxBojaStranice = new JComboBox();
		cbxBojaStranice.setModel(new DefaultComboBoxModel(new String[] {"Crna", "Bela", "Zuta", "Plava", "Zelena", "Ljubicasta", "Crvena", "Braon"}));
		GridBagConstraints gbc_cbxBojaStranice = new GridBagConstraints();
		gbc_cbxBojaStranice.insets = new Insets(0, 0, 5, 0);
		gbc_cbxBojaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxBojaStranice.gridx = 3;
		gbc_cbxBojaStranice.gridy = 4;
		pnlGlavni.add(cbxBojaStranice, gbc_cbxBojaStranice);
		
		JComboBox cbxBojaUnutrasnjosti = new JComboBox();
		cbxBojaUnutrasnjosti.setModel(new DefaultComboBoxModel(new String[] {"Crna", "Bela", "Zuta", "Plava", "Zelena", "Ljubicasta", "Crvena", "Braon"}));
		GridBagConstraints gbc_cbxBojaUnutrasnjosti = new GridBagConstraints();
		gbc_cbxBojaUnutrasnjosti.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxBojaUnutrasnjosti.gridx = 3;
		gbc_cbxBojaUnutrasnjosti.gridy = 5;
		pnlGlavni.add(cbxBojaUnutrasnjosti, gbc_cbxBojaUnutrasnjosti);
		
		JButton btnSacuvaj = new JButton("Sa\u010Duvaj");
		btnSacuvaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					x = Integer.parseInt(txtXKoordinateTacke.getText());
					y = Integer.parseInt(txtYKoordinateTacke.getText());
					duzinaStranice = Integer.parseInt(txtDuzinaStranice.getText());
					bojaStranice = (String)cbxBojaStranice.getSelectedItem();
					bojaUnutrasnjosti = (String)cbxBojaUnutrasnjosti.getSelectedItem();
					
					if(x <= 0 || y <= 0 || duzinaStranice<= 0){
						System.out.println("Greska! broj mora biti pozitivan");
						JOptionPane.showMessageDialog(null, "Greska! broj mora biti pozitivan");
					}else{
						kv = new Kvadrat(new Tacka(Integer.parseInt(txtXKoordinateTacke.getText()), Integer.parseInt(txtYKoordinateTacke.getText())), Integer.parseInt(txtDuzinaStranice.getText()),bojaStranice,bojaUnutrasnjosti);
						setVisible(false);
					}

				}catch(Exception greskaPriUnosu){ 
					System.out.println("Greska pri unosu! nije unet broj");
					JOptionPane.showMessageDialog(null, "Greska pri unosu! nije unet broj");
				}
			}
		});
		pnlKomande.add(btnSacuvaj);
		
		JLabel lblXKoordinateTacke = new JLabel("X koordinate ta\u010Dke:");
		GridBagConstraints gbc_lblXKoordinateTacke = new GridBagConstraints();
		gbc_lblXKoordinateTacke.anchor = GridBagConstraints.EAST;
		gbc_lblXKoordinateTacke.insets = new Insets(0, 0, 5, 5);
		gbc_lblXKoordinateTacke.fill = GridBagConstraints.VERTICAL;
		gbc_lblXKoordinateTacke.gridx = 2;
		gbc_lblXKoordinateTacke.gridy = 1;
		pnlGlavni.add(lblXKoordinateTacke, gbc_lblXKoordinateTacke);
		
		txtXKoordinateTacke = new JTextField();
		GridBagConstraints gbc_txtXKoordinateTacke = new GridBagConstraints();
		gbc_txtXKoordinateTacke.insets = new Insets(0, 0, 5, 0);
		gbc_txtXKoordinateTacke.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtXKoordinateTacke.gridx = 3;
		gbc_txtXKoordinateTacke.gridy = 1;
		pnlGlavni.add(txtXKoordinateTacke, gbc_txtXKoordinateTacke);
		txtXKoordinateTacke.setColumns(10);
		
		JLabel lblYKoordinateTacke = new JLabel("Y koordinate ta\u010Dke:");
		GridBagConstraints gbc_lblYKoordinateTacke = new GridBagConstraints();
		gbc_lblYKoordinateTacke.anchor = GridBagConstraints.EAST;
		gbc_lblYKoordinateTacke.fill = GridBagConstraints.VERTICAL;
		gbc_lblYKoordinateTacke.insets = new Insets(0, 0, 5, 5);
		gbc_lblYKoordinateTacke.gridx = 2;
		gbc_lblYKoordinateTacke.gridy = 2;
		pnlGlavni.add(lblYKoordinateTacke, gbc_lblYKoordinateTacke);
		
		txtYKoordinateTacke = new JTextField();
		GridBagConstraints gbc_txtYKoordinateTacke = new GridBagConstraints();
		gbc_txtYKoordinateTacke.insets = new Insets(0, 0, 5, 0);
		gbc_txtYKoordinateTacke.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtYKoordinateTacke.gridx = 3;
		gbc_txtYKoordinateTacke.gridy = 2;
		pnlGlavni.add(txtYKoordinateTacke, gbc_txtYKoordinateTacke);
		txtYKoordinateTacke.setColumns(10);
		
		JLabel lblDuzinaStranice = new JLabel("Du\u017Eina stranice:");
		GridBagConstraints gbc_lblDuzinaStranice = new GridBagConstraints();
		gbc_lblDuzinaStranice.anchor = GridBagConstraints.EAST;
		gbc_lblDuzinaStranice.fill = GridBagConstraints.VERTICAL;
		gbc_lblDuzinaStranice.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuzinaStranice.gridx = 2;
		gbc_lblDuzinaStranice.gridy = 3;
		pnlGlavni.add(lblDuzinaStranice, gbc_lblDuzinaStranice);
		
		txtDuzinaStranice = new JTextField();
		GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
		gbc_txtDuzinaStranice.insets = new Insets(0, 0, 5, 0);
		gbc_txtDuzinaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDuzinaStranice.gridx = 3;
		gbc_txtDuzinaStranice.gridy = 3;
		pnlGlavni.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
		txtDuzinaStranice.setColumns(10);
		
		JLabel lblBojaStranice = new JLabel("Boja stranice:");
		GridBagConstraints gbc_lblBojaStranice = new GridBagConstraints();
		gbc_lblBojaStranice.anchor = GridBagConstraints.EAST;
		gbc_lblBojaStranice.fill = GridBagConstraints.VERTICAL;
		gbc_lblBojaStranice.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaStranice.gridx = 2;
		gbc_lblBojaStranice.gridy = 4;
		pnlGlavni.add(lblBojaStranice, gbc_lblBojaStranice);
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutra\u0161njosti:");
		GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
		gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.EAST;
		gbc_lblBojaUnutrasnjosti.fill = GridBagConstraints.VERTICAL;
		gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaUnutrasnjosti.gridx = 2;
		gbc_lblBojaUnutrasnjosti.gridy = 5;
		pnlGlavni.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
	}

	public Kvadrat getKv() {
		return kv;
	}

}
