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
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
	
	private JLabel tfooter;
	private JLabel vpassword;
	private JPasswordField txtpassword;
	private JTextField txtlogin;
	private JButton btnlogin;
	private Border border;
	private JLabel logo;
	private JMenuBar barra;
	private JMenu menu;
	private JMenu ventas;
	private JMenu mantenimiento;
	private JMenu reportes;
	private JMenuItem ayuda;
	public JMenuItem generar_venta;
	public JMenuItem cliente;
	private JMenuItem producto;
	private JMenuItem vendedor;
	public JMenuItem salir;
	private JMenuItem reportes_ventas;
	public JFrame pCentro;
	public JDesktopPane VentanaPrincipal;
	

	
	public FrmMenuPrincipal() {
		
		super("Sistema Punto de Venta/Stock");
		//Container content = getContentPane();
		//content.setLayout(new BorderLayout());
		VentanaPrincipal = new JDesktopPane();
		border=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		
		JPanel pNorte = _crearPNorte();
		add(pNorte, BorderLayout.NORTH);
		
		//pCentro = new JFrame();
		//pCentro = _crearPCentro();
		
		//pCentro = new JPanel();
		//pCentro = _crearPCentro();
		//add(pCentro, BorderLayout.CENTER); 
		add(VentanaPrincipal, BorderLayout.CENTER);
		
		
		JPanel pSur = _crearPSur();
		add(pSur, BorderLayout.SOUTH);
		
		
		
		
	
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
		/*
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
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    //JPanel p = new JPanel();
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		p.setBorder(titleBoder);
		
		//logo = new JLabel();
		
		barra = new JMenuBar();
		barra.setOpaque(false);
		menu = new JMenu("Menú");
		ventas = new JMenu("Ventas");
		mantenimiento = new JMenu("Mantenimiento");
		reportes = new JMenu("Reportes");
		
		
		salir = new JMenuItem("Salir", new ImageIcon(getClass().getResource("/Files/salir.png")));
		//salir.setIcon(new ImageIcon(getClass().getResource("/Files/salir.png")));
		ayuda = new JMenuItem("Ayuda", new ImageIcon(getClass().getResource("/Files/ayuda.png")));
		generar_venta = new JMenuItem("Generar Venta", new ImageIcon(getClass().getResource("/Files/generar_venta.png")));
		cliente = new JMenuItem("Clientes",  new ImageIcon(getClass().getResource("/Files/clientes.png")));
		producto = new JMenuItem("Productos",  new ImageIcon(getClass().getResource("/Files/productos.png")));
		vendedor = new JMenuItem("Vendedores",  new ImageIcon(getClass().getResource("/Files/vendedores.png")));
		reportes_ventas = new JMenuItem("Reporte de Ventas",  new ImageIcon(getClass().getResource("/Files/reportes_ventas.png")));
	
		menu.setIcon(new ImageIcon(getClass().getResource("/Files/menu.png")));
		menu.add(ayuda);
		menu.add(salir);
		ventas.setIcon(new ImageIcon(getClass().getResource("/Files/ventas.png")));
		ventas.add(generar_venta);
		mantenimiento.setIcon(new ImageIcon(getClass().getResource("/Files/mantenimiento.png")));
		mantenimiento.add(cliente);
		mantenimiento.add(producto);
		mantenimiento.add(vendedor);
		reportes.setIcon(new ImageIcon(getClass().getResource("/Files/reportes.png")));
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
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		//JPanel p = new JPanel();
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		p.setBorder(titleBoder);
		tfooter = new JLabel("Desarrollado por Alejandro Aquino ® 2020        Version 1.0");
		p.add(tfooter);
		
		return p;
		
		
		
	}


	public JLabel getTfooter() {
		return tfooter;
	}


	public void setTfooter(JLabel tfooter) {
		this.tfooter = tfooter;
	}


	public JLabel getVpassword() {
		return vpassword;
	}


	public void setVpassword(JLabel vpassword) {
		this.vpassword = vpassword;
	}


	public JPasswordField getTxtpassword() {
		return txtpassword;
	}


	public void setTxtpassword(JPasswordField txtpassword) {
		this.txtpassword = txtpassword;
	}


	public JTextField getTxtlogin() {
		return txtlogin;
	}


	public void setTxtlogin(JTextField txtlogin) {
		this.txtlogin = txtlogin;
	}


	public JButton getBtnlogin() {
		return btnlogin;
	}


	public void setBtnlogin(JButton btnlogin) {
		this.btnlogin = btnlogin;
	}


	public Border getBorder() {
		return border;
	}


	public void setBorder(Border border) {
		this.border = border;
	}


	public JLabel getLogo() {
		return logo;
	}


	public void setLogo(JLabel logo) {
		this.logo = logo;
	}


	public JMenuBar getBarra() {
		return barra;
	}


	public void setBarra(JMenuBar barra) {
		this.barra = barra;
	}


	public JMenu getMenu() {
		return menu;
	}


	public void setMenu(JMenu menu) {
		this.menu = menu;
	}


	public JMenu getVentas() {
		return ventas;
	}


	public void setVentas(JMenu ventas) {
		this.ventas = ventas;
	}


	public JMenu getMantenimiento() {
		return mantenimiento;
	}


	public void setMantenimiento(JMenu mantenimiento) {
		this.mantenimiento = mantenimiento;
	}


	public JMenu getReportes() {
		return reportes;
	}


	public void setReportes(JMenu reportes) {
		this.reportes = reportes;
	}


	public JMenuItem getAyuda() {
		return ayuda;
	}


	public void setAyuda(JMenuItem ayuda) {
		this.ayuda = ayuda;
	}


	public JMenuItem getGenerar_venta() {
		return generar_venta;
	}


	public void setGenerar_venta(JMenuItem generar_venta) {
		this.generar_venta = generar_venta;
	}


	public JMenuItem getCliente() {
		return cliente;
	}


	public void setCliente(JMenuItem cliente) {
		this.cliente = cliente;
	}


	public JMenuItem getProducto() {
		return producto;
	}


	public void setProducto(JMenuItem producto) {
		this.producto = producto;
	}


	public JMenuItem getVendedor() {
		return vendedor;
	}


	public void setVendedor(JMenuItem vendedor) {
		this.vendedor = vendedor;
	}


	public JMenuItem getSalir() {
		return salir;
	}


	public void setSalir(JMenuItem salir) {
		this.salir = salir;
	}


	public JMenuItem getReportes_ventas() {
		return reportes_ventas;
	}


	public void setReportes_ventas(JMenuItem reportes_ventas) {
		this.reportes_ventas = reportes_ventas;
	}


	public JFrame getpCentro() {
		return pCentro;
	}


	public void setpCentro(JFrame pCentro) {
		this.pCentro = pCentro;
	}


	public JDesktopPane getVentanaPrincipal() {
		return VentanaPrincipal;
	}


	public void setVentanaPrincipal(JDesktopPane ventanaPrincipal) {
		VentanaPrincipal = ventanaPrincipal;
	}
	
	

	
	

}






