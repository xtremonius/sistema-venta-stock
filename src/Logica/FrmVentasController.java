package Logica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JInternalFrame;

import Presentacion.FrmVentas;

public class FrmVentasController {
	
	private FrmVentas ventanaVentas;

	public FrmVentasController() {
		
		this.ventanaVentas = new FrmVentas();
		
	}
	
	
	
	public FrmVentas getVentana() {
		
		return this.ventanaVentas;
	}


}
