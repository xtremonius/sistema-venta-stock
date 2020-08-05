package Logica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import Datos.Vendedor;
import Datos.VendedorDAO;
import Presentacion.FrmProductos;
import Presentacion.FrmVendedores;
import Presentacion.FrmVentas;

public class FrmVendedoresController {
	
	private FrmVendedores ventanaVendedores;
	private VendedorDAO dao;
	private Vendedor vend;
	private DefaultTableModel modelo;
	private int id;
	

	public FrmVendedoresController() {
		
		this.ventanaVendedores = new FrmVendedores();
		this.dao = new VendedorDAO();
		this.vend = new Vendedor();
		this.modelo = new DefaultTableModel();
		listar();
		ventanaVendedores.getBtnagregar().setEnabled(false);
		ventanaVendedores.getBtneliminar().setEnabled(false);
		ventanaVendedores.getBtnactualizar().setEnabled(false);
		
		ventanaVendedores.getBtnagregar().addActionListener(new ActionListener() {

	
			public void actionPerformed(ActionEvent e) {
					agregar();
					limpiarTabla();
					listar();
				
			}
			
			
		});
		ventanaVendedores.getBtnactualizar().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
					actualizar();
					limpiarTabla();
					listar();

			}
			
			
		});
		ventanaVendedores.getTabla().addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				tablaMouseClicked(e);
			}
			
		});
		ventanaVendedores.getBtneliminar().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				eliminar();
				limpiarTabla();
				listar();
				
			}
			
			
		});
		ventanaVendedores.getBtnnuevo().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				nuevo();
				
			}
			
			
		});
		
		
	}
	
	
	private void agregar() {
		int opcion;
		String dni;
		String nom;
		String tel;
		String es;
		String usr;
		
		dni = ventanaVendedores.getTxtdni().getText();
		nom = ventanaVendedores.getTxtnombre().getText();
		tel = ventanaVendedores.getTxttelefono().getText();
		es = ventanaVendedores.getComestado().getSelectedItem().toString();
		usr = ventanaVendedores.getTxtuser().getText();
		
		
		if(dni.isEmpty() || nom.isEmpty() || tel.isEmpty() || es.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor complete los datos.", "", JOptionPane.INFORMATION_MESSAGE);
			nuevo();
		}else {
		
			Object [] ob = new Object[5];
			ob [0] = dni;
			ob [1] = nom;
			ob [2] = tel;
			ob [3] = es;
			ob [4] = usr;
			opcion = JOptionPane.showConfirmDialog(null, "Realmente quiere agregar un cliente al Sistema?", "", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
				dao.add(ob);
				ventanaVendedores.getBtnagregar().setEnabled(false);
				ventanaVendedores.getTxtnombre().setText("");
				ventanaVendedores.getTxttelefono().setText("");
				ventanaVendedores.getTxtdni().setText("");
				ventanaVendedores.getComestado().setSelectedItem("SELECCIONAR");
				ventanaVendedores.getTxtuser().setText("");
				ventanaVendedores.getTxtnombre().requestFocus();
			}
		}
		
	}
	
	private void actualizar() {
		int fila;
		int opcion;
		String dni;
		String nom;
		String tel;
		String es;
		String usr;
		
		fila = ventanaVendedores.getTabla().getSelectedRow();
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.", "",JOptionPane.INFORMATION_MESSAGE);
		}else {
			
			dni = ventanaVendedores.getTxtdni().getText();
			nom = ventanaVendedores.getTxtnombre().getText();
			tel = ventanaVendedores.getTxttelefono().getText();
			es = ventanaVendedores.getComestado().getSelectedItem().toString();
			Object [] obj = new Object[5];
			obj [0] = dni;
			obj [1] = nom;
			obj [2] = tel;
			obj [3] = es;
			obj [4] = id;
			opcion = JOptionPane.showConfirmDialog(null, "Realmente quiere modificar el cliente: "+ventanaVendedores.getTabla().getValueAt(fila, 2).toString(), "", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
				dao.actualizar(obj);
				ventanaVendedores.getBtneliminar().setEnabled(false);
				ventanaVendedores.getBtnactualizar().setEnabled(false);
			}
			
			
		}
	}
	
	private void eliminar() {
		int fila;
		int opcion;
		
		fila = ventanaVendedores.getTabla().getSelectedRow();
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.", "",JOptionPane.INFORMATION_MESSAGE);
		}else {
			opcion = JOptionPane.showConfirmDialog(null, "Realmente quiere borrar el cliente: "+ventanaVendedores.getTabla().getValueAt(fila, 2).toString(), "", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
				dao.eliminar(id);
				ventanaVendedores.getBtneliminar().setEnabled(false);
				ventanaVendedores.getBtnactualizar().setEnabled(false);
				ventanaVendedores.getTxtnombre().setText("");
				ventanaVendedores.getTxttelefono().setText("");
				ventanaVendedores.getTxtdni().setText("");
				ventanaVendedores.getComestado().setSelectedItem("SELECCIONAR");
				ventanaVendedores.getTxtnombre().requestFocus();
			}
		}
	}
	
	private void nuevo() {
		ventanaVendedores.getBtnagregar().setEnabled(true);
		ventanaVendedores.getTxtnombre().setText("");
		ventanaVendedores.getTxttelefono().setText("");
		ventanaVendedores.getTxtdni().setText("");
		ventanaVendedores.getTxtuser().setText("");
		ventanaVendedores.getComestado().setSelectedItem("SELECCIONAR");
		ventanaVendedores.getTxtnombre().requestFocus();
		ventanaVendedores.getBtneliminar().setEnabled(false);
		ventanaVendedores.getBtnactualizar().setEnabled(false);
		
		
		
	}
		
	
	
	
	
	public FrmVendedores getVentana() {
		
		return this.ventanaVendedores;
	}
	
	private void limpiarTabla() {
		for(int i = 0; i < modelo.getRowCount(); i++) {
			modelo.removeRow(i);
			i = i-1;
		}
	}
	
	private void listar() {
		List<Vendedor> lista = dao.listar();
		modelo = (DefaultTableModel) ventanaVendedores.getTabla().getModel();
		Object [] ob = new Object [6];
		
		for(int i = 0; i < lista.size(); i++) {
			ob [0] = lista.get(i).getId();
			ob [1] = lista.get(i).getDni();
			ob [2] = lista.get(i).getNom();
			ob [3] = lista.get(i).getTel();
			ob [4] = lista.get(i).getEstado();
			ob [5] = lista.get(i).getUser();
			modelo.addRow(ob);
			
		}
		ventanaVendedores.setDatos(modelo);
		
	}
	
	private void tablaMouseClicked(MouseEvent e) {
		int fila;
		String dni;
		String nom;
		String tel;
		String es;
		String usr;
		
		fila = ventanaVendedores.getTabla().getSelectedRow();
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.", "",JOptionPane.INFORMATION_MESSAGE);
		}else {
			id = Integer.parseInt(ventanaVendedores.getTabla().getValueAt(fila, 0).toString());
			dni = ventanaVendedores.getTabla().getValueAt(fila, 1).toString();
			nom = ventanaVendedores.getTabla().getValueAt(fila, 2).toString();
			tel = ventanaVendedores.getTabla().getValueAt(fila, 3).toString();
			es = ventanaVendedores.getTabla().getValueAt(fila, 4).toString();
			usr = ventanaVendedores.getTabla().getValueAt(fila, 5).toString();
			
		
			ventanaVendedores.getTxtdni().setText(dni);
			ventanaVendedores.getTxtnombre().setText(nom);
			ventanaVendedores.getTxttelefono().setText(tel);
			ventanaVendedores.getComestado().setSelectedItem(es);
			ventanaVendedores.getTxtuser().setText(usr);
			ventanaVendedores.getBtnactualizar().setEnabled(true);
			ventanaVendedores.getBtneliminar().setEnabled(true);
			ventanaVendedores.getBtnagregar().setEnabled(false);
		}
	}




}
