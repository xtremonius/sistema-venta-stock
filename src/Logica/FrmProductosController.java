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

import Datos.Producto;
import Datos.ProductoDAO;
import Datos.Vendedor;
import Presentacion.FrmProductos;


public class FrmProductosController {
	
	private FrmProductos ventanaProductos;
	private Producto prod;
	private ProductoDAO dao;
	private DefaultTableModel modelo;
	private int id;

	public FrmProductosController() {
		
		this.ventanaProductos = new FrmProductos();
		this.dao = new ProductoDAO();
		this.prod = new Producto();
		listar();
		ventanaProductos.getBtnagregar().setEnabled(false);
		ventanaProductos.getBtneliminar().setEnabled(false);
		ventanaProductos.getBtnactualizar().setEnabled(false);
		
		ventanaProductos.getBtnagregar().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
					agregar();
					limpiarTabla();
					listar();
				
			}
			
			
		});
		ventanaProductos.getBtnactualizar().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
					actualizar();
					limpiarTabla();
					listar();

			}
			
			
		});
		ventanaProductos.getTabla().addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				tablaMouseClicked(e);
			}
			
		});
		ventanaProductos.getBtneliminar().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				eliminar();
				limpiarTabla();
				listar();
				
			}
			
			
		});
		ventanaProductos.getBtnnuevo().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				nuevo();
				
			}
			
			
		});
		
		
	}
	
	private void agregar() {
		int opcion;
		String nom;
		float pre;
		int stock;
		String es;
		String prec;
		String stk;
		
		nom = ventanaProductos.getTxtnombres().getText();
		prec = ventanaProductos.getPrecio().getText();
		stk = ventanaProductos.getTxtstock().getText();
		es = ventanaProductos.getComestado().getSelectedItem().toString();
	
		
		
		if(nom.isEmpty() || prec.isEmpty() || stk.isEmpty() || es.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor complete los datos.", "", JOptionPane.INFORMATION_MESSAGE);
			nuevo();
		}else {
			pre = Float.parseFloat(ventanaProductos.getPrecio().getText());
			stock = Integer.parseInt(ventanaProductos.getTxtstock().getText());
		
			Object [] ob = new Object[5];
			ob [0] = nom;
			ob [1] = pre;
			ob [2] = stock;
			ob [3] = es;
			opcion = JOptionPane.showConfirmDialog(null, "Realmente quiere agregar un producto al Sistema?", "", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
				dao.add(ob);
				ventanaProductos.getBtnagregar().setEnabled(false);
				ventanaProductos.getTxtnombres().setText("");
				ventanaProductos.getPrecio().setText("");
				ventanaProductos.getTxtstock().setText("");
				ventanaProductos.getComestado().setSelectedItem("SELECCIONAR");
				ventanaProductos.getTxtnombres().requestFocus();
			}
		}
		
	}
	
	private void actualizar() {
		int fila;		
		int opcion;
		String nom;
		float pre;
		int stock;
		String es;
		String precio_format;
		
		fila = ventanaProductos.getTabla().getSelectedRow();
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.", "",JOptionPane.INFORMATION_MESSAGE);
		}else {
			
			nom = ventanaProductos.getTxtnombres().getText();
			precio_format = ventanaProductos.getPrecio().getText();
			precio_format = precio_format.substring(2);
			pre = Float.parseFloat(precio_format);
			stock = Integer.parseInt(ventanaProductos.getTxtstock().getText());
			es = ventanaProductos.getComestado().getSelectedItem().toString();
			Object [] obj = new Object[5];
			obj [0] = nom;
			obj [1] = pre;
			obj [2] = stock;
			obj [3] = es;
			obj [4] = id;
			opcion = JOptionPane.showConfirmDialog(null, "Realmente quiere modificar el producto: "+ventanaProductos.getTabla().getValueAt(fila, 1).toString(), "", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
				dao.actualizar(obj);
				ventanaProductos.getBtneliminar().setEnabled(false);
				ventanaProductos.getBtnactualizar().setEnabled(false);
			}
			
			
		}
	}
	
	private void eliminar() {
		int fila;
		int opcion;
		
		fila = ventanaProductos.getTabla().getSelectedRow();
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.", "",JOptionPane.INFORMATION_MESSAGE);
		}else {
			opcion = JOptionPane.showConfirmDialog(null, "Realmente quiere borrar el producto: "+ventanaProductos.getTabla().getValueAt(fila, 1).toString(), "", JOptionPane.YES_NO_OPTION);
			if(opcion == 0) {
				dao.eliminar(id);
				ventanaProductos.getBtneliminar().setEnabled(false);
				ventanaProductos.getBtnactualizar().setEnabled(false);
				ventanaProductos.getTxtnombres().setText("");
				ventanaProductos.getPrecio().setText("");
				ventanaProductos.getTxtstock().setText("");
				ventanaProductos.getComestado().setSelectedItem("SELECCIONAR");
				ventanaProductos.getTxtnombres().requestFocus();
			}
		}
	}
	
	private void nuevo() {
		ventanaProductos.getBtnagregar().setEnabled(true);
		ventanaProductos.getTxtnombres().setText("");
		ventanaProductos.getPrecio().setText("");
		ventanaProductos.getTxtstock().setText("");
		ventanaProductos.getComestado().setSelectedItem("SELECCIONAR");
		ventanaProductos.getTxtnombres().requestFocus();
		ventanaProductos.getBtneliminar().setEnabled(false);
		ventanaProductos.getBtnactualizar().setEnabled(false);
		
		
		
	}
	
	
	
	public FrmProductos getVentana() {
		
		return this.ventanaProductos;
	}
	
	
	private void limpiarTabla() {
		for(int i = 0; i < modelo.getRowCount(); i++) {
			modelo.removeRow(i);
			i = i-1;
		}
	}
	
	
	
	private void listar() {
		List<Producto> lista = dao.listar();
		modelo = (DefaultTableModel) ventanaProductos.getTabla().getModel();
		Object [] ob = new Object [6];
		
		for(int i = 0; i < lista.size(); i++) {
			ob [0] = lista.get(i).getId();
			ob [1] = lista.get(i).getNom();
			ob [2] = "$ "+lista.get(i).getPrecio();
			ob [3] = lista.get(i).getStock();
			ob [4] = lista.get(i).getEstado();
			modelo.addRow(ob);
			
		}
		ventanaProductos.setDatos(modelo);
		
	}
	
	
	
	private void tablaMouseClicked(MouseEvent e) {
		int fila;
		String nom;
		String pre;
		String stock;
		String es;
		
		fila = ventanaProductos.getTabla().getSelectedRow();
		if(fila == -1) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla.", "",JOptionPane.INFORMATION_MESSAGE);
		}else {
			id = Integer.parseInt(ventanaProductos.getTabla().getValueAt(fila, 0).toString());
			nom = ventanaProductos.getTabla().getValueAt(fila, 1).toString();
			pre = ventanaProductos.getTabla().getValueAt(fila, 2).toString();
			stock = ventanaProductos.getTabla().getValueAt(fila, 3).toString();
			es = ventanaProductos.getTabla().getValueAt(fila, 4).toString();
			
		
			ventanaProductos.getTxtnombres().setText(nom);
			ventanaProductos.getPrecio().setText(pre);
			ventanaProductos.getTxtstock().setText(stock);
			ventanaProductos.getComestado().setSelectedItem(es);
			ventanaProductos.getBtnactualizar().setEnabled(true);
			ventanaProductos.getBtneliminar().setEnabled(true);
			ventanaProductos.getBtnagregar().setEnabled(false);
		}
	}


}
