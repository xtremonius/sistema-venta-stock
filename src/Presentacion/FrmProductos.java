package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FrmProductos extends JInternalFrame {
	
	private Border border;
	private JLabel vnombres;
	private JLabel vprecio;
	private JLabel vstock;
	private JLabel vestado;
	private JButton btnagregar;
	private JButton btnactualizar;
	private JButton btneliminar;
	private JButton btnnuevo;
	private JComboBox comestado;
	private JTextField txtnombres;
	private JTextField precio;
	private JTextField txtstock;
	private JTextField txtestado;
	private JScrollPane scrolltabla;
	private JTable tabla;
	private DefaultTableModel datos;
	
	public FrmProductos() {
		border = BorderFactory.createLineBorder(Color.black);
		pack();
		setResizable(true);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Productos");
        
        setSize(800, 400);
        
        JPanel pNorte = _crearPNorte();
        add(pNorte, BorderLayout.NORTH);
        
        JPanel pCentro = _crearPCentro();
        add(pCentro, BorderLayout.CENTER);
        
     	try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        setVisible(true);
	}
	
	
	
	
	private JPanel _crearPCentro() {
		
		JPanel p = new JPanel(new BorderLayout());
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		p.setBorder(titleBoder);

		datos = new DefaultTableModel(new Object [][] {}, new String [] {"ID", "NOMBRES", "PRECIO", "STOCK", "ESTADO"}) {
			
			public boolean isCellEditable(int filas, int columnas) {
				if(columnas == 5) {
					return true;
				}else {
					return false;
				}
			}
		};
		
		tabla = new JTable();
		
		tabla.getTableHeader().setReorderingAllowed(false);
		tabla.setModel(datos);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setSelectionBackground(Color.pink);
		
	
		/*
		 * ancho de columnas
		 * */
		tabla.getColumnModel().getColumn(0).setMinWidth(50);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(0).setMaxWidth(50);
		tabla.getColumnModel().getColumn(0).setResizable(false);
		
		tabla.getColumnModel().getColumn(2).setMinWidth(70);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(70);
		tabla.getColumnModel().getColumn(2).setMaxWidth(70);
		tabla.getColumnModel().getColumn(2).setResizable(false);
		
		tabla.getColumnModel().getColumn(3).setMinWidth(70);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(70);
		tabla.getColumnModel().getColumn(3).setMaxWidth(70);
		tabla.getColumnModel().getColumn(3).setResizable(false);

		tabla.getColumnModel().getColumn(4).setMinWidth(50);
		tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
		tabla.getColumnModel().getColumn(4).setMaxWidth(50);
		tabla.getColumnModel().getColumn(4).setResizable(false);
		tabla.setFillsViewportHeight(true);
		scrolltabla = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrolltabla.setViewportView(tabla);
		
		
		p.add(scrolltabla);
		
		
	
		
		return p; 
		
	}


	private JPanel _crearPNorte() {
		
		//JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel x = new JPanel(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(4,0,5,25);
		
		
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		x.setBorder(titleBoder);
		
		this.setVnombres(new JLabel("Nombres: "));
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getVnombres(), constraints);
		constraints.weighty = 0.0;
		
		
		this.setTxtnombres(new JTextField(20));
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getTxtnombres(), constraints);
		constraints.weighty = 0.0;
		
		
		
		this.setBtnagregar(new JButton("Agregar"));
		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weighty = 1.0;
		x.add(this.getBtnagregar(), constraints);
		constraints.weighty = 0.0;
		
		

		this.setVprecio(new JLabel("Precio: "));
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getVprecio(), constraints);
		constraints.weighty = 0.0;
		
		
	
		this.setPrecio(new JTextField(20));
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getPrecio(), constraints);
		constraints.weighty = 0.0;

		
		this.setBtnactualizar(new JButton("Actualizar"));
		constraints.gridx = 2;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weighty = 1.0;
		x.add(this.getBtnactualizar(), constraints);
		constraints.weighty = 0.0;
		
		
		
		this.setVstock(new JLabel("Stock: "));
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getVstock(), constraints);
		constraints.weighty = 0.0;
		
		
	
		this.setTxtstock(new JTextField(20));
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getTxtstock(), constraints);
		constraints.weighty = 0.0;
		
	
		
		this.setBtneliminar(new JButton("Eliminar"));
		constraints.gridx = 2;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weighty = 1.0;
		x.add(this.getBtneliminar(), constraints);
		constraints.weighty = 0.0;
		
		
		
		this.setVestado(new JLabel("Estado: "));
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getVestado(), constraints);
		constraints.weighty = 0.0;
		
		
	
		this.setComestado(new JComboBox());
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		this.getComestado().addItem("SELECCIONAR");
		this.getComestado().addItem("1");
		this.getComestado().addItem("0");
		x.add(this.getComestado(), constraints);
		constraints.weighty = 0.0;
		
		
		
		this.setBtnnuevo(new JButton("Nuevo"));
		constraints.gridx = 2;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weighty = 1.0;
		x.add(this.getBtnnuevo(), constraints);
		constraints.weighty = 0.0;
		
		
		
		/*
		vpassword = new JLabel("Password");
		o.add(vpassword);
		txtpassword = new JPasswordField(8);
		o.add(txtpassword);
		
		p.add(o);*/

		
		return x;
		
		
		
	}




	public Border getBorder() {
		return border;
	}




	public void setBorder(Border border) {
		this.border = border;
	}




	public JLabel getVnombres() {
		return vnombres;
	}




	public void setVnombres(JLabel vnombres) {
		this.vnombres = vnombres;
	}




	public JLabel getVprecio() {
		return vprecio;
	}




	public void setVprecio(JLabel vprecio) {
		this.vprecio = vprecio;
	}




	public JLabel getVstock() {
		return vstock;
	}




	public void setVstock(JLabel vstock) {
		this.vstock = vstock;
	}




	public JLabel getVestado() {
		return vestado;
	}




	public void setVestado(JLabel vestado) {
		this.vestado = vestado;
	}




	public JButton getBtnagregar() {
		return btnagregar;
	}




	public void setBtnagregar(JButton btnagregar) {
		this.btnagregar = btnagregar;
	}




	public JButton getBtnactualizar() {
		return btnactualizar;
	}




	public void setBtnactualizar(JButton btnactualizar) {
		this.btnactualizar = btnactualizar;
	}




	public JButton getBtneliminar() {
		return btneliminar;
	}




	public void setBtneliminar(JButton btneliminar) {
		this.btneliminar = btneliminar;
	}




	public JButton getBtnnuevo() {
		return btnnuevo;
	}




	public void setBtnnuevo(JButton btnnuevo) {
		this.btnnuevo = btnnuevo;
	}




	public JComboBox getComestado() {
		return comestado;
	}




	public void setComestado(JComboBox comestado) {
		this.comestado = comestado;
	}




	public JTextField getTxtnombres() {
		return txtnombres;
	}




	public void setTxtnombres(JTextField txtnombres) {
		this.txtnombres = txtnombres;
	}




	public JTextField getPrecio() {
		return precio;
	}




	public void setPrecio(JTextField precio) {
		this.precio = precio;
	}




	public JTextField getTxtstock() {
		return txtstock;
	}




	public void setTxtstock(JTextField txtstock) {
		this.txtstock = txtstock;
	}




	public JTextField getTxtestado() {
		return txtestado;
	}




	public void setTxtestado(JTextField txtestado) {
		this.txtestado = txtestado;
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
