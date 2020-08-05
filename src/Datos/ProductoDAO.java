package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements Crud {

	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	private Producto miProducto;
	
	
	public ProductoDAO() {
		this.con = null;
		this.pstm = null;
		this.rs = null;
		this.miProducto = null;
	}
	
	@Override
	public List listar() {
		List<Producto> lista = new ArrayList<>();
		String sql = "SELECT * FROM producto";
		
		try {
		    con = Conexion.getConexion();  
		    pstm = con.prepareStatement(sql);
		    rs = pstm.executeQuery();
		    while(rs.next()) {
		    	Producto p = new Producto();
		    	p.setId(rs.getInt(1));
		    	p.setNom(rs.getString(2));
		    	p.setPrecio(rs.getFloat(3));
		    	p.setStock(rs.getInt(4));
		    	p.setEstado(rs.getNString(5));
		    	lista.add(p);
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
		String sql = "INSERT INTO producto (nombres, precio, stock, estado) VALUES (?, ?, ?, ?)";
		
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
	public int actualizar(Object[] o) {
		int r = 0;
		String sql = "UPDATE producto SET nombres= ?, precio= ?, stock= ?, estado= ? where idproducto=?";
		
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
		
		String sql = "DELETE FROM producto where idproducto=?";
		
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
