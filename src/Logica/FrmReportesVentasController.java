package Logica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JInternalFrame;

import Presentacion.FrmClientes;
import Presentacion.FrmProductos;
import Presentacion.FrmReportesVentas;
import Presentacion.FrmVendedores;
import Presentacion.FrmVentas;

public class FrmReportesVentasController {
	
	private FrmReportesVentas ventanaRVentas;

	public FrmReportesVentasController() {
		
		this.ventanaRVentas = new FrmReportesVentas();
		
	}
	
	
	
	public FrmReportesVentas getVentana() {
		
		return this.ventanaRVentas;
	}


}
