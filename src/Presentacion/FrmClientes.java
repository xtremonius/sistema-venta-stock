package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class FrmClientes extends JInternalFrame {
	
	private Border border;
	private JLabel vdni;
	private JLabel vnombres;
	private JLabel vdireccion;
	private JLabel vestado;
	private JButton btnagregar;
	private JButton btnactualizar;
	private JButton btneliminar;
	private JButton btnnuevo;
	private JComboBox comestado;
	private JTextField txtdni;
	private JTextField txtnombre;
	private JTextField txtdireccion;
	private JScrollPane scrolltabla;
	private JTable tabla;
	private DefaultTableModel datos;
	
	public FrmClientes() {
		//border=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		border = BorderFactory.createLineBorder(Color.black);
		pack();
		setResizable(true);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Clientes");
        setSize(800, 400);
        
        
        JPanel pNorte = _crearPNorte();
        add(pNorte, BorderLayout.NORTH);
        
        JPanel pCentro = _crearPCentro();
        add(pCentro, BorderLayout.CENTER);
        
        /*JPanel pSur = _crearPSur();
        add(pSur, BorderLayout.SOUTH);*/
        
        
     	try {
			setMaximum(true);
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        setVisible(true);
	}
	
	
	private JPanel _crearPSur() {
		JPanel p = new JPanel();
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		p.setBorder(titleBoder);
		//tfooter = new JLabel("Desarrollado por Alejandro Aquino ® 2020        Version 1.0");
		//p.add(tfooter);
		
		return p;
	}
	

	private JPanel _crearPCentro() {
		
		JPanel p = new JPanel(new BorderLayout());
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border);
		p.setBorder(titleBoder);
		//p.add(new JLabel("Holaaa"));
		//p.add(new JTextField(10));
		//p.setBorder(BorderFactory.createEtchedBorder());
		datos = new DefaultTableModel(new Object [][] {}, new String [] {"ID", "DNI", "NOMBRES", "DIRECCION", "ESTADO"}) {
			
			public boolean isCellEditable(int filas, int columnas) {
				if(columnas == 5) {
					return true;
				}else {
					return false;
				}
			}
		};
		
		tabla = new JTable();
		
		//tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.getTableHeader().setReorderingAllowed(false);
		//TableColumnModel columnModel = tabla.getColumnModel();
		
		/*columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(50);
		columnModel.getColumn(2).setPreferredWidth(50);
		columnModel.getColumn(3).setPreferredWidth(50);*/
		//columnModel.getColumn(4).setPreferredWidth(50);
		
		tabla.setModel(datos);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setSelectionBackground(Color.cyan);
		/*
		 * ancho de columnas
		 * */
		tabla.getColumnModel().getColumn(0).setMinWidth(35);
		tabla.getColumnModel().getColumn(0).setPreferredWidth(35);
		tabla.getColumnModel().getColumn(0).setMaxWidth(35);
		tabla.getColumnModel().getColumn(0).setResizable(false);
		
		tabla.getColumnModel().getColumn(1).setMinWidth(70);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(70);
		tabla.getColumnModel().getColumn(1).setMaxWidth(70);
		tabla.getColumnModel().getColumn(1).setResizable(false);
		/*
		tabla.getColumnModel().getColumn(2).setMinWidth(35);
		tabla.getColumnModel().getColumn(2).setPreferredWidth(35);
		tabla.getColumnModel().getColumn(2).setMaxWidth(35);
		tabla.getColumnModel().getColumn(2).setResizable(false);
	/
		tabla.getColumnModel().getColumn(3).setMinWidth(35);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(35);
		tabla.getColumnModel().getColumn(3).setMaxWidth(35);
		tabla.getColumnModel().getColumn(3).setResizable(false);
		*/
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
		
		
		this.setTxtnombre(new JTextField(20));
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getTxtnombre(), constraints);
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
		
		

		this.setVdni(new JLabel("DNI: "));
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getVdni(), constraints);
		constraints.weighty = 0.0;
		
		
	
		this.setTxtdni(new JTextField(20));
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getTxtdni(), constraints);
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
		
		
		
		this.setVdireccion(new JLabel("Dirección: "));
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getVdireccion(), constraints);
		constraints.weighty = 0.0;
		
		
	
		this.setTxtdireccion(new JTextField(20));
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weighty = 1.0;
		x.add(this.getTxtdireccion(), constraints);
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




	public JLabel getVdni() {
		return vdni;
	}




	public void setVdni(JLabel vdni) {
		this.vdni = vdni;
	}




	public JLabel getVnombres() {
		return vnombres;
	}




	public void setVnombres(JLabel vnombres) {
		this.vnombres = vnombres;
	}




	public JLabel getVdireccion() {
		return vdireccion;
	}




	public void setVdireccion(JLabel vdireccion) {
		this.vdireccion = vdireccion;
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




	public JTextField getTxtdni() {
		return txtdni;
	}




	public void setTxtdni(JTextField txtdni) {
		this.txtdni = txtdni;
	}
	





	public JTextField getTxtnombre() {
		return txtnombre;
	}




	public void setTxtnombre(JTextField txtnombre) {
		this.txtnombre = txtnombre;
	}




	public JTextField getTxtdireccion() {
		return txtdireccion;
	}




	public void setTxtdireccion(JTextField txtdireccion) {
		this.txtdireccion = txtdireccion;
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
