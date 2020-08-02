package Datos;

import java.util.List;

public interface Crud {
	
	public List listar();
	public int add(Object [] o);
	public int actualizar(Object [] o);
	public void eliminar(int id);

}
