package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class VendedorDAO {

	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	private Vendedor miVendedor;
	
	public VendedorDAO() {
		this.con = null;
		this.pstm = null;
		this.rs = null;
		this.miVendedor = null;
		
	}
	
	
	public Vendedor ValidarVendedor(String dni, String user) {
		
		try {
			con = Conexion.getConexion();
			String sql = "SELECT * FROM vendedor WHERE dni=? and User=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dni);
			pstm.setString(2, user);
			rs = pstm.executeQuery();
			miVendedor = new Vendedor();
			
			
			rs.next();
			
			miVendedor.setId(rs.getInt(1));
			miVendedor.setDni(rs.getString(2));
			miVendedor.setNom(rs.getString(3));
			miVendedor.setTel(rs.getString(4));
			miVendedor.setEstado(rs.getString(5));
			miVendedor.setUser(rs.getString(6));

		}
		catch(Exception ex){/*
			ex.printStackTrace();
			throw new RuntimeException(ex);*/
			//JOptionPane.showConfirmDialog(null, ex);
            return null;
			
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				
				
			}
			catch(Exception ex){
				ex.printStackTrace();
				throw new RuntimeException(ex);
				
			}
		}


		return miVendedor;
	}
	
	
}
