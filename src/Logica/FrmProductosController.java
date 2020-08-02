package Logica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JInternalFrame;

import Presentacion.FrmClientes;
import Presentacion.FrmProductos;
import Presentacion.FrmVentas;

public class FrmProductosController {
	
	private FrmProductos ventanaProductos;

	public FrmProductosController() {
		
		this.ventanaProductos = new FrmProductos();
		
	}
	
	
	
	public FrmProductos getVentana() {
		
		return this.ventanaProductos;
	}


}
