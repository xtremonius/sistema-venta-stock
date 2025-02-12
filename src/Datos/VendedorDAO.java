package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

public class VendedorDAO implements Crud {

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
	
	
	public Vendedor ValidarVendedor(String user, String password) {
		
		try {
			String pass = DigestUtils.sha1Hex(password); 
			con = Conexion.getConexion();
			String sql = "SELECT * FROM vendedor WHERE User=? and Password=?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, user);
			pstm.setString(2, pass);
			rs = pstm.executeQuery();
			miVendedor = new Vendedor();
			
			
			rs.next();
			
			miVendedor.setId(rs.getInt(1));
			miVendedor.setDni(rs.getString(2));
			miVendedor.setNom(rs.getString(3));
			miVendedor.setTel(rs.getString(4));
			miVendedor.setEstado(rs.getString(5));
			miVendedor.setUser(rs.getString(6));
			miVendedor.setPass(rs.getNString(7));

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


	@Override
	public List listar() {
		List<Vendedor> lista = new ArrayList<>();
		String sql = "SELECT * FROM vendedor";
		
		try {
		    con = Conexion.getConexion();  
		    pstm = con.prepareStatement(sql);
		    rs = pstm.executeQuery();
		    while(rs.next()) {
		    	Vendedor c = new Vendedor();
		    	c.setId(rs.getInt(1));
		    	c.setDni(rs.getString(2));
		    	c.setNom(rs.getString(3));
		    	c.setTel(rs.getString(4));
		    	c.setEstado(rs.getNString(5));
		    	c.setUser(rs.getNString(6));
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
	public int add(Object[] o) {
		int r = 0;
		String sql = "INSERT INTO vendedor (Dni, Nombres, Telefono, Estado, User) VALUES (?, ?, ?, ?, ?)";
		
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
	public int actualizar(Object[] o) {
		int r = 0;
		String sql = "UPDATE vendedor SET dni= ?, nombres= ?, telefono= ?, estado= ? where idvendedor=?";
		
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
		
		String sql = "DELETE FROM vendedor where idvendedor=?";
		
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
