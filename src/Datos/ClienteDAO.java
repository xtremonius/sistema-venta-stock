package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.codec.digest.DigestUtils;

public class ClienteDAO implements Crud {

	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	private Cliente miCliente;
	
	public ClienteDAO() {
		this.con = null;
		this.pstm = null;
		this.rs = null;
		this.miCliente = null;
		
	}
	
	


	@Override
	public List listar() {
		List<Cliente> lista = new ArrayList<>();
		String sql = "SELECT * FROM cliente";
		
		try {
		    con = Conexion.getConexion();  
		    pstm = con.prepareStatement(sql);
		    rs = pstm.executeQuery();
		    while(rs.next()) {
		    	Cliente c = new Cliente();
		    	c.setIdCliente(rs.getInt(1));
		    	c.setDni(rs.getString(2));
		    	c.setNombres(rs.getString(3));
		    	c.setDireccion(rs.getString(4));
		    	c.setEstado(rs.getNString(5));
		    	lista.add(c);
		    }
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


		return lista;
	}

	@Override
	public int add(Object [] o) {
		int r = 0;
		String sql = "INSERT INTO cliente (Dni, Nombres, Direccion, Estado) VALUES (?, ?, ?, ?)";
		
		try {
		    con = Conexion.getConexion();  
		    pstm = con.prepareStatement(sql);
		    pstm.setObject(1, o[0]);
		    pstm.setObject(2, o[1]);
		    pstm.setObject(3, o[2]);
		    pstm.setObject(4, o[3]);
		    r = pstm.executeUpdate();
		    

		}
		catch(Exception ex){/*
			ex.printStackTrace();
			throw new RuntimeException(ex);*/
			//JOptionPane.showConfirmDialog(null, ex);
            return r;
			
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


		return r;
	
	}


	@Override
	public int actualizar(Object [] o) {
		int r = 0;
		String sql = "UPDATE cliente SET dni= ?, nombres= ?, direccion= ?, estado= ? where idcliente=?";
		
		try {
		    con = Conexion.getConexion();  
		    pstm = con.prepareStatement(sql);
		    pstm.setObject(1, o[0]);
		    pstm.setObject(2, o[1]);
		    pstm.setObject(3, o[2]);
		    pstm.setObject(4, o[3]);
		    pstm.setObject(5, o[4]);
		    r = pstm.executeUpdate();
		    

		}
		catch(Exception ex){/*
			ex.printStackTrace();
			throw new RuntimeException(ex);*/
			//JOptionPane.showConfirmDialog(null, ex);
            return r;
			
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
		
		return r;
	}


	@Override
	public void eliminar(int id) {
		
		String sql = "DELETE FROM cliente where idcliente=?";
		
		try {
		    con = Conexion.getConexion();  
		    pstm = con.prepareStatement(sql);
		    pstm.setInt(1, id);
		    pstm.executeUpdate();
		    

		}
		catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException(ex);
			
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
		
		//return r;
	}
	
	
}
