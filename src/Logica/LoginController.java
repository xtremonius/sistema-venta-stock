package Logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Datos.Vendedor;
import Datos.VendedorDAO;
import Presentacion.FrmLogin;
import Presentacion.FrmMenuPrincipal;

public class LoginController implements ActionListener {
	
	private VendedorDAO dao;
	private Vendedor ven;
	private FrmLogin flogin;
	

	
	/*
	public LoginController(FrmLogin v) {
		this.flogin = v;
		this.flogin.btnlogin.addActionListener(this);
		
	}*/
	
	public LoginController() {
		this.dao = new VendedorDAO();
		this.ven = new Vendedor();
		this.flogin = new FrmLogin();
		this.flogin.btnlogin.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//JOptionPane.showMessageDialog(null, "Hola Mundo!!!");
		//this.flogin.dispose();
		//FrmMenuPrincipal menuprincipal = new FrmMenuPrincipal();
		String login = flogin.txtlogin.getText();
		char [] arrayPass = flogin.txtpassword.getPassword();
		String pass = new String(arrayPass);
		
		if(login.isEmpty() || (pass.isEmpty())) {
			JOptionPane.showMessageDialog(null, "Por favor complete los datos.", "", JOptionPane.INFORMATION_MESSAGE);
			flogin.txtlogin.setText("");
			flogin.txtpassword.setText("");
			flogin.txtlogin.requestFocus();
		}
		this.BuscarUsuario(pass, login);
	}
	
	private void BuscarUsuario(String pas, String log) {
		
		//String pass = new String(arrayPass);
		this.ven= dao.ValidarVendedor(pas, log);

		
		if(ven == null) {
			JOptionPane.showMessageDialog(null, "Credenciales incorrectas, volver a intentar.", "", JOptionPane.ERROR_MESSAGE);
			flogin.txtlogin.setText("");
			flogin.txtpassword.setText("");
			flogin.txtlogin.requestFocus();
		}else {
			this.flogin.dispose();
			JOptionPane.showMessageDialog(null, "Bienvenido: "+ven.getNom(), "", JOptionPane.INFORMATION_MESSAGE);
			FrmMenuPrincipal menuprincipal = new FrmMenuPrincipal();
		}
		
		
	}
	

}
