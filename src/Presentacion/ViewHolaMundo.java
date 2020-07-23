package Presentacion;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ViewHolaMundo extends JFrame{
	
	private JLabel label1;

	public ViewHolaMundo(String msj) {
		setLayout(null);
		this.label1 = new JLabel(msj);
		this.label1.setBounds(0, 0, 300, 30);
		add(this.label1);
		setBounds(0,0,300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

}
