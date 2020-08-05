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

import Datos.Cliente;
import Datos.ClienteDAO;
import Presentacion.FrmClientes;


public class FrmClientesController {
	
	private FrmClientes ventanaClientes;
	private ClienteDAO dao;
	private Cliente clien;
	private DefaultTableModel modelo;
	private int id;

	public FrmClientesController() {
		
		this.ventanaClientes = new FrmClientes();
		this.dao = new ClienteDAO();
		this.clien = new Cliente();
		this.modelo = new DefaultTableModel();
		listar();
		ventanaClientes.getBtnagregar().setEnabled(false);
		ventanaClientes.getBtneliminar().setEnabled(false);
		ventanaClientes.getBtnactualizar().setEnabled(false);
		
		ventanaClientes.getBtnagregar().addActionListener(new ActionListener() {

	
			public void actionPerformed(ActionEvent e) {
					agregar();
					limpiarTabla();
					listar();
				
			}
			
			
		});
		ventanaClientes.getBtnactualizar().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
					actualizar();
					limpiarTabla();
					listar();

			}
			
			
		});
		ventanaClientes.getTabla().addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				tablaMouseClicked(e);
			}
			
		});
		ventanaClientes.getBtneliminar().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				eliminar();
				limpiarTabla();
				listar();
				
			}
			
			
		});
		ventanaClientes.getBtnnuevo().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				nuevo();
				
			}
			
			
		});
		
		
	}
	
	
	private void agregar() {
		int opcion;
		String dni;
		String nom;
		String dir;
		String es;
		
		dni = ventanaClientes.getTxtdni().getText();
		nom = ventanaClientes.getTxtnombre().getText();
		dir = ventanaClientes.getTxtdireccion().getText();
		es = ventanaClientes.getComestado().getSelectedItem().toString();
		
		if(dni.isEmpty() || nom.isEmpty() || dir.isEmpty() || es.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor complete los datos.", "", JOptionPane.INFORMATION_MESSAGE);
			nuevo();
		}else {
		
			Object [] ob = new Object[4];
			ob [0] = dni;
			ob [1] = nom;
			ob [2] = dir;
			ob [3] = es;
			opcion = JOptionPane.showConfirmDialog(null, "Realmente quiere agregar un cliente al Sistema?", "", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
				dao.add(ob);
				ventanaClientes.getBtnagregar().setEnabled(false);
				ventanaClientes.getTxtnombre().setText("");
				ventanaClientes.getTxtdireccion().setText("");
				ventanaClientes.getTxtdni().setText("");
				ventanaClientes.getComestado().setSelectedItem("SELECCIONAR");
				ventanaClientes.getTxtnombre().requestFocus();
			}
		}
		
	}
	
	private void actualizar() {
		int fila;
		int opcion;
		String dni;
		String nom;
		String dir;
		String es;
		
		fila = ventanaClientes.getTabla().getSelectedRow();
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.", "",JOptionPane.INFORMATION_MESSAGE);
		}else {
			
			dni = ventanaClientes.getTxtdni().getText();
			nom = ventanaClientes.getTxtnombre().getText();
			dir = ventanaClientes.getTxtdireccion().getText();
			es = ventanaClientes.getComestado().getSelectedItem().toString();
			Object [] obj = new Object[5];
			obj [0] = dni;
			obj [1] = nom;
			obj [2] = dir;
			obj [3] = es;
			obj [4] = id;
			opcion = JOptionPane.showConfirmDialog(null, "Realmente quiere modificar el cliente: "+ventanaClientes.getTabla().getValueAt(fila, 2).toString(), "", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
				dao.actualizar(obj);
				ventanaClientes.getBtneliminar().setEnabled(false);
				ventanaClientes.getBtnactualizar().setEnabled(false);
			}
			
			
		}
	}
	
	private void eliminar() {
		int fila;
		int opcion;
		
		fila = ventanaClientes.getTabla().getSelectedRow();
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.", "",JOptionPane.INFORMATION_MESSAGE);
		}else {
			opcion = JOptionPane.showConfirmDialog(null, "Realmente quiere borrar el cliente: "+ventanaClientes.getTabla().getValueAt(fila, 2).toString(), "", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
				dao.eliminar(id);
				ventanaClientes.getBtneliminar().setEnabled(false);
				ventanaClientes.getBtnactualizar().setEnabled(false);
				ventanaClientes.getTxtnombre().setText("");
				ventanaClientes.getTxtdireccion().setText("");
				ventanaClientes.getTxtdni().setText("");
				ventanaClientes.getComestado().setSelectedItem("SELECCIONAR");
				ventanaClientes.getTxtnombre().requestFocus();
			}
		}
	}
	
	private void nuevo() {
		ventanaClientes.getBtnagregar().setEnabled(true);
		ventanaClientes.getTxtnombre().setText("");
		ventanaClientes.getTxtdireccion().setText("");
		ventanaClientes.getTxtdni().setText("");
		ventanaClientes.getComestado().setSelectedItem("SELECCIONAR");
		ventanaClientes.getTxtnombre().requestFocus();
		ventanaClientes.getBtneliminar().setEnabled(false);
		ventanaClientes.getBtnactualizar().setEnabled(false);
		
		
		
	}
	
	
	public FrmClientes getVentana() {
		
		return this.ventanaClientes;
	}
	
	private void limpiarTabla() {
		for(int i = 0; i < modelo.getRowCount(); i++) {
			modelo.removeRow(i);
			i = i-1;
		}
	}
	
	private void listar() {
		List<Cliente> lista = dao.listar();
		modelo = (DefaultTableModel) ventanaClientes.getTabla().getModel();
		Object [] ob = new Object [5];
		
		for(int i = 0; i < lista.size(); i++) {
			ob [0] = lista.get(i).getIdCliente();
			ob [1] = lista.get(i).getDni();
			ob [2] = lista.get(i).getNombres();
			ob [3] = lista.get(i).getDireccion();
			ob [4] = lista.get(i).getEstado();
			modelo.addRow(ob);
			
		}
		ventanaClientes.setDatos(modelo);
		
	}
	
	private void tablaMouseClicked(MouseEvent e) {
		int fila;
		String dni;
		String nom;
		String dir;
		String es;
		
		fila = ventanaClientes.getTabla().getSelectedRow();
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.", "",JOptionPane.INFORMATION_MESSAGE);
		}else {
			id = Integer.parseInt(ventanaClientes.getTabla().getValueAt(fila, 0).toString());
			dni = ventanaClientes.getTabla().getValueAt(fila, 1).toString();
			nom = ventanaClientes.getTabla().getValueAt(fila, 2).toString();
			dir = ventanaClientes.getTabla().getValueAt(fila, 3).toString();
			es = ventanaClientes.getTabla().getValueAt(fila, 4).toString();
			
		
			ventanaClientes.getTxtdni().setText(dni);
			ventanaClientes.getTxtnombre().setText(nom);
			ventanaClientes.getTxtdireccion().setText(dir);
			ventanaClientes.getComestado().setSelectedItem(es);
			ventanaClientes.getBtnactualizar().setEnabled(true);
			ventanaClientes.getBtneliminar().setEnabled(true);
			ventanaClientes.getBtnagregar().setEnabled(false);
		}
	}


}
