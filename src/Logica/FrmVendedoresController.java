package Logica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JInternalFrame;

import Presentacion.FrmClientes;
import Presentacion.FrmProductos;
import Presentacion.FrmVendedores;
import Presentacion.FrmVentas;

public class FrmVendedoresController {
	
	private FrmVendedores ventanaVendedores;

	public FrmVendedoresController() {
		
		this.ventanaVendedores = new FrmVendedores();
		
	}
	
	
	
	public FrmVendedores getVentana() {
		
		return this.ventanaVendedores;
	}


}
