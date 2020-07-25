package Presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;


import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FrmLogin extends JFrame{
	
	private JLabel vlogin;
	private JLabel vpassword;
	public JPasswordField txtpassword;
	public JTextField txtlogin;
	public JButton btnlogin;
	private Border border;
	private JLabel logo;

	
	public FrmLogin() {
		
		super("Login");
		//Container content = getContentPane();
		//content.setLayout(new BorderLayout());
		border=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		JPanel pNorte = _crearPNorte();
		add(pNorte, BorderLayout.NORTH);
		
		
		JPanel pCentro = _crearPCentro();
		add(pCentro, BorderLayout.CENTER);
		
		
		JPanel pSur = _crearPSur();
		add(pSur, BorderLayout.SOUTH);
		
		
		
		
	
		setBounds(0,0,300,300);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	private JPanel _crearPCentro() {
		
		//JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel x = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		x.setBorder(titleBoder);
		
		vlogin = new JLabel("Login");
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(vlogin, constraints);
		constraints.weighty = 0.0;
		
		
		txtlogin = new JTextField(10);
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		txtlogin.setText("emp01");
		x.add(txtlogin, constraints);
		constraints.weighty = 0.0;
		
		
		vpassword = new JLabel("Password");
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(vpassword, constraints);
		constraints.weighty = 0.0;
		
		
		txtpassword = new JPasswordField(10);
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		txtpassword.setText("12345678");
		x.add(txtpassword, constraints);
		constraints.weighty = 0.0;
		
		
		
		
		
		
		/*
		vpassword = new JLabel("Password");
		o.add(vpassword);
		txtpassword = new JPasswordField(8);
		o.add(txtpassword);
		
		p.add(o);*/

		
		return x;
		
		
		
	}
	
	
	private JPanel _crearPNorte() {
		
		//JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p = new JPanel();
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		p.setBorder(titleBoder);
		
		logo = new JLabel();
		
		
		logo.setIcon(new ImageIcon(getClass().getResource("/Files/login.png")));
		p.add(logo);

		
		return p;
		
		
	}
	
	
	private JPanel _crearPSur() {
		
		//JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel p = new JPanel();
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		p.setBorder(titleBoder);
		btnlogin = new JButton("Login");
		p.add(btnlogin);
		
		return p;
		
		
		
	}
	
	

	
	

}






