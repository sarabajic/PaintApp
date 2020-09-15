package oblici;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Crtez extends JPanel{
	public static void main(String[] args) {
		JFrame prozor = new JFrame();
		Crtez crtez = new Crtez();
		prozor.getContentPane().add(crtez);
		prozor.setSize(600, 400);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prozor.setTitle("Vidi prozor...");
		prozor.setVisible(true);
	}
	
	public void paint(Graphics g) {
		
	}

}
