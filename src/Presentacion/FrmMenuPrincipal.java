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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class FrmMenuPrincipal extends JFrame{
	
	private JLabel vlogin;
	private JLabel vpassword;
	public JPasswordField txtpassword;
	public JTextField txtlogin;
	public JButton btnlogin;
	private Border border;
	private JLabel logo;
	private JMenuBar barra;
	private JMenu menu;
	private JMenu ventas;
	private JMenu mantenimiento;
	private JMenu reportes;
	private JMenuItem ayuda;
	private JMenuItem generar_venta;
	private JMenuItem cliente;
	private JMenuItem producto;
	private JMenuItem vendedor;
	private JMenuItem salir;
	private JMenuItem reportes_ventas;
	

	
	public FrmMenuPrincipal() {
		
		super("Sistema Punto de Venta/Stock");
		//Container content = getContentPane();
		//content.setLayout(new BorderLayout());
		border=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		JPanel pNorte = _crearPNorte();
		add(pNorte, BorderLayout.NORTH);
		
		/*
		JPanel pCentro = _crearPCentro();
		add(pCentro, BorderLayout.CENTER);
		
		
		JPanel pSur = _crearPSur();
		add(pSur, BorderLayout.SOUTH);*/
		
		
		
		
	
		setBounds(0,0,1024,768);
		setVisible(true);
		setLocationRelativeTo(null);
		//setResizable(false);
		setExtendedState(MAXIMIZED_BOTH);
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
		
		//logo = new JLabel();
		
		barra = new JMenuBar();
		menu = new JMenu("Men�");
		ventas = new JMenu("Ventas");
		mantenimiento = new JMenu("Mantenimiento");
		reportes = new JMenu("Reportes");
		
		salir = new JMenuItem("Salir");
		ayuda = new JMenuItem("Ayuda");
		generar_venta = new JMenuItem("Generar Venta");
		cliente = new JMenuItem("Cliente");
		producto = new JMenuItem("Producto");
		vendedor = new JMenuItem("Vendedor");
		reportes_ventas = new JMenuItem("Reporte de Ventas");
	
		
		menu.add(ayuda);
		menu.add(salir);
		ventas.add(generar_venta);
		mantenimiento.add(cliente);
		mantenimiento.add(producto);
		mantenimiento.add(vendedor);
		reportes.add(reportes_ventas);
		
		barra.add(menu);
		barra.add(ventas);
		barra.add(mantenimiento);
		barra.add(reportes);
		
		p.add(barra);
		//logo.setIcon(new ImageIcon(getClass().getResource("/Files/login.png")));
		//p.add(logo);

		
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






