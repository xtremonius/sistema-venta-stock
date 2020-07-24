package Datos;

public class Vendedor {
	
	private int id;
	private String dni;
	private String nom;
	private String tel;
	private String estado;
	private String user;
	private String pass;
	
	
	public Vendedor() {
		
	}
	
	
	
	public Vendedor(int id, String dni, String nom, String tel, String estado, String user, String pass) {
		this.id = id;
		this.dni = dni;
		this.nom = nom;
		this.tel = tel;
		this.estado = estado;
		this.user = user;
		this.pass = pass;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getDni() {
		return dni;
	}
	
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	public String getNom() {
		return nom;
	}
	
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public String getTel() {
		return tel;
	}
	
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	public String getEstado() {
		return estado;
	}
	
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public String getUser() {
		return user;
	}
	
	
	public void setUser(String user) {
		this.user = user;
	}
	
	
	

}
