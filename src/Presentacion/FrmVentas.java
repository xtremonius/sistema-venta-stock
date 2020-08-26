package Presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FrmVentas extends JInternalFrame {
	
	private Border border;
	private JLabel vnomserie;
	private JLabel vcodcliente;
	private JLabel vcodproducto;
	private JLabel vprecio;
	private JLabel vcantidad;
	private JLabel vcliente;
	private JLabel vproducto;
	private JLabel vstock;
	private JLabel vvendedor;
	private JLabel vtotalpagar;
	private JTextField txtnomserie;
	private JTextField txtcodcliente;
	private JTextField txtcodproducto;
	private JTextField txtprecio;
	private JTextField txtcantidad;
	private JTextField txtcliente;
	private JTextField txtproducto;
	private JTextField txtstock;
	private JTextField txtvendedor;
	private JTextField txttotalpagar;
	private JScrollPane scrolltabla;
	private JTable tabla;
	private DefaultTableModel datos;
	
	
	public FrmVentas() {
		pack();
		setResizable(true);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Ventas");
        
        setSize(800, 400);
        
        JPanel pNorte = _crearPNorte();
        add(pNorte, BorderLayout.NORTH);
        
      
        
     	try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        setVisible(true);
	}
	
	
	
	
	private JPanel _crearPCentro() {
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p.add(new JLabel("Holaaa"));
		p.add(new JTextField(10));
		p.setBorder(BorderFactory.createEtchedBorder());
		
		
		
		//JPanel x = new JPanel(new GridBagLayout());
		//GridBagConstraints constraints = new GridBagConstraints();
		
		
		//TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		//x.setBorder(titleBoder);
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

		
		return p; 
		
		
		
	}


	private JPanel _crearPNorte() {
		
		//JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel x = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(4,0,5,25);
		
		
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		x.setBorder(titleBoder);
		
		this.setVnomserie(new JLabel("NRO SERIE: "));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getVnomserie(), constraints);
		constraints.weighty = 0.0;
		
		
		this.setTxtnomserie(new JTextField(20));
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getTxtnomserie(), constraints);
		constraints.weighty = 0.0;
		
		
		
		
		return x;
		
		
		
	}


	public Border getBorder() {
		return border;
	}




	public void setBorder(Border border) {
		this.border = border;
	}




	public JLabel getVnomserie() {
		return vnomserie;
	}




	public void setVnomserie(JLabel vnomserie) {
		this.vnomserie = vnomserie;
	}




	public JLabel getVcodcliente() {
		return vcodcliente;
	}




	public void setVcodcliente(JLabel vcodcliente) {
		this.vcodcliente = vcodcliente;
	}




	public JLabel getVcodproducto() {
		return vcodproducto;
	}




	public void setVcodproducto(JLabel vcodproducto) {
		this.vcodproducto = vcodproducto;
	}




	public JLabel getVprecio() {
		return vprecio;
	}




	public void setVprecio(JLabel vprecio) {
		this.vprecio = vprecio;
	}




	public JLabel getVcantidad() {
		return vcantidad;
	}




	public void setVcantidad(JLabel vcantidad) {
		this.vcantidad = vcantidad;
	}




	public JLabel getVcliente() {
		return vcliente;
	}




	public void setVcliente(JLabel vcliente) {
		this.vcliente = vcliente;
	}




	public JLabel getVproducto() {
		return vproducto;
	}




	public void setVproducto(JLabel vproducto) {
		this.vproducto = vproducto;
	}




	public JLabel getVstock() {
		return vstock;
	}




	public void setVstock(JLabel vstock) {
		this.vstock = vstock;
	}




	public JLabel getVvendedor() {
		return vvendedor;
	}




	public void setVvendedor(JLabel vvendedor) {
		this.vvendedor = vvendedor;
	}




	public JLabel getVtotalpagar() {
		return vtotalpagar;
	}




	public void setVtotalpagar(JLabel vtotalpagar) {
		this.vtotalpagar = vtotalpagar;
	}




	public JTextField getTxtnomserie() {
		return txtnomserie;
	}




	public void setTxtnomserie(JTextField txtnomserie) {
		this.txtnomserie = txtnomserie;
	}




	public JTextField getTxtcodcliente() {
		return txtcodcliente;
	}




	public void setTxtcodcliente(JTextField txtcodcliente) {
		this.txtcodcliente = txtcodcliente;
	}




	public JTextField getTxtcodproducto() {
		return txtcodproducto;
	}




	public void setTxtcodproducto(JTextField txtcodproducto) {
		this.txtcodproducto = txtcodproducto;
	}




	public JTextField getTxtprecio() {
		return txtprecio;
	}




	public void setTxtprecio(JTextField txtprecio) {
		this.txtprecio = txtprecio;
	}




	public JTextField getTxtcantidad() {
		return txtcantidad;
	}




	public void setTxtcantidad(JTextField txtcantidad) {
		this.txtcantidad = txtcantidad;
	}




	public JTextField getTxtcliente() {
		return txtcliente;
	}




	public void setTxtcliente(JTextField txtcliente) {
		this.txtcliente = txtcliente;
	}




	public JTextField getTxtproducto() {
		return txtproducto;
	}




	public void setTxtproducto(JTextField txtproducto) {
		this.txtproducto = txtproducto;
	}




	public JTextField getTxtstock() {
		return txtstock;
	}




	public void setTxtstock(JTextField txtstock) {
		this.txtstock = txtstock;
	}




	public JTextField getTxtvendedor() {
		return txtvendedor;
	}




	public void setTxtvendedor(JTextField txtvendedor) {
		this.txtvendedor = txtvendedor;
	}




	public JTextField getTxttotalpagar() {
		return txttotalpagar;
	}




	public void setTxttotalpagar(JTextField txttotalpagar) {
		this.txttotalpagar = txttotalpagar;
	}




	public JScrollPane getScrolltabla() {
		return scrolltabla;
	}




	public void setScrolltabla(JScrollPane scrolltabla) {
		this.scrolltabla = scrolltabla;
	}




	public JTable getTabla() {
		return tabla;
	}




	public void setTabla(JTable tabla) {
		this.tabla = tabla;
	}




	public DefaultTableModel getDatos() {
		return datos;
	}




	public void setDatos(DefaultTableModel datos) {
		this.datos = datos;
	}





}
