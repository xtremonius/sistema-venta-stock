package Logica;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import Presentacion.FrmMenuPrincipal;
import Presentacion.FrmVentas;

public class FrmMenuPrincipalController {
	
	private FrmMenuPrincipal mimenu;
	
	public FrmMenuPrincipalController() {
		this.mimenu = new FrmMenuPrincipal();
		this.mimenu.getSalir().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
			
		});
		this.mimenu.getGenerar_venta().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				generar_ventaactionPerformed(e);
			}
		});
		this.mimenu.getCliente().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaCliente(e);
				
			}
			
		});
		this.mimenu.getProducto().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaProducto(e);
				
			}
			
		});
		this.mimenu.getVendedor().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaVendedor(e);
				
			}
			
		});
		this.mimenu.getReportes_ventas().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaReportes(e);
				
			}
			
		});
		this.mimenu.getAyuda().addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaAyuda(e);
				
			}
			
		});
	
		
	}
	
	private void mostrarVentanaAyuda(ActionEvent e) {
		FrmAyudaController vfa = new FrmAyudaController();
		CentrarVentana(vfa.getVentana());
		InhabilitarOpcion(mimenu.getAyuda());
		
		vfa.getVentana().addInternalFrameListener(new InternalFrameListener () {
			public void internalFrameClosed(InternalFrameEvent e) {
				HabilitarOpcion(mimenu.getAyuda());
				
			}
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

	
		

			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	private void mostrarVentanaReportes(ActionEvent e) {
		FrmReportesVentasController vfr = new FrmReportesVentasController();
		CentrarVentana(vfr.getVentana());
		InhabilitarOpcion(mimenu.getReportes_ventas());
		
		vfr.getVentana().addInternalFrameListener(new InternalFrameListener () {
			public void internalFrameClosed(InternalFrameEvent e) {
				HabilitarOpcion(mimenu.getReportes_ventas());
				
			}
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

	
		

			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	private void mostrarVentanaVendedor(ActionEvent e) {
		FrmVendedoresController vfv = new FrmVendedoresController();
		CentrarVentana(vfv.getVentana());
		InhabilitarOpcion(mimenu.getVendedor());
		
		vfv.getVentana().addInternalFrameListener(new InternalFrameListener () {
			public void internalFrameClosed(InternalFrameEvent e) {
				HabilitarOpcion(mimenu.getVendedor());
				
			}
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

	
		

			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	private void mostrarVentanaProducto(ActionEvent e) {
		FrmProductosController vfp = new FrmProductosController();
		CentrarVentana(vfp.getVentana());
		InhabilitarOpcion(mimenu.getProducto());
		
		vfp.getVentana().addInternalFrameListener(new InternalFrameListener () {
			public void internalFrameClosed(InternalFrameEvent e) {
				HabilitarOpcion(mimenu.getProducto());
				
			}
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

	
		

			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	

	
	private void mostrarVentanaCliente(ActionEvent e) {
		FrmClientesController vfc = new FrmClientesController();
		CentrarVentana(vfc.getVentana());
		InhabilitarOpcion(mimenu.getCliente());
		
		vfc.getVentana().addInternalFrameListener(new InternalFrameListener () {
			public void internalFrameClosed(InternalFrameEvent e) {
				HabilitarOpcion(mimenu.getCliente());
				
			}
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

	
		

			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	private void generar_ventaactionPerformed(ActionEvent e) {
		FrmVentasController vfc = new FrmVentasController();
		//FrmVentas vf = new FrmVentas();
		CentrarVentana(vfc.getVentana());
		InhabilitarOpcion(mimenu.generar_venta);

		vfc.getVentana().addInternalFrameListener(new InternalFrameListener(){
			public void internalFrameClosed(InternalFrameEvent e) {
				HabilitarOpcion(mimenu.generar_venta);
			}

			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameIconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeiconified(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameActivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void internalFrameDeactivated(InternalFrameEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
	
	private void HabilitarOpcion(JMenuItem item) {
		item.setEnabled(true);
	}
	
	private void InhabilitarOpcion(JMenuItem item) {
		item.setEnabled(false);
	}
	

	
	
    private void  CentrarVentana(JInternalFrame frame){
        this.mimenu.VentanaPrincipal.add(frame);
        Dimension dimension=this.mimenu.VentanaPrincipal.getSize();
        Dimension Dframe=frame.getSize();
        frame.setLocation((dimension.width -Dframe.width)/2,(dimension.height-Dframe.height)/2);
        frame.show();
        
    }






	





}
