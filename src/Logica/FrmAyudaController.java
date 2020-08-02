package Logica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JInternalFrame;

import Presentacion.FrmAyuda;
import Presentacion.FrmClientes;
import Presentacion.FrmProductos;
import Presentacion.FrmVendedores;
import Presentacion.FrmVentas;

public class FrmAyudaController {
	
	private FrmAyuda ventanaAyuda;

	public FrmAyudaController() {
		
		this.ventanaAyuda = new FrmAyuda();
		
	}
	
	
	
	public FrmAyuda getVentana() {
		
		return this.ventanaAyuda;
	}


}
