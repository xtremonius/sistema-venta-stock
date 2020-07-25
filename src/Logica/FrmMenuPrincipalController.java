package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Presentacion.FrmMenuPrincipal;

public class FrmMenuPrincipalController implements ActionListener {
	
	private FrmMenuPrincipal mimenu;
	
	public FrmMenuPrincipalController() {
		this.mimenu = new FrmMenuPrincipal();
		this.mimenu.salir.addActionListener(this);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		System.exit(0);
		
	}

}
